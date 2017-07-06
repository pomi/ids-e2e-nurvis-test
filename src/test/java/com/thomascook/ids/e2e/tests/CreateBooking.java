package com.thomascook.ids.e2e.tests;

import com.thomascook.nurvisAdapter.request.*;
import static org.junit.Assert.*;

import com.thomascook.nurvisAdapter.response.ReservationResponseTypeResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.opentravel.ota._2003._05.request.*;
import org.opentravel.ota._2003._05.request.DepartureAirportListType;
import org.opentravel.ota._2003._05.request.FilterResultsType;
import org.opentravel.ota._2003._05.response.HotelOfferType;
import org.opentravel.ota._2003._05.request.LocationType;
import org.opentravel.ota._2003._05.request.PkgGuestCountType;
import org.opentravel.ota._2003._05.request.PkgSearchCriteriaType;
import org.opentravel.ota._2003._05.request.RoomStayCandidatesType;
import org.opentravel.ota._2003._05.response.*;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Created by omm on 6/27/2017.
 */
public class CreateBooking {

    static String solr;
    static String nurvis;
    static

    public void loadProperties(String region, String environment) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/config.properties"));
        Set<Object> keys = properties.keySet();
        solr = properties.getProperty(environment + "." + region + "." + "solr");
        nurvis = properties.getProperty(environment + "." + region + "." + "nurvis");
    }

    //private static final Logger LOGGER = Logger.getLogger( CreateBooking.class.getName() );

    public OTAPkgSearchRS getSOLRPackages(String fromAirport, String destination, int numberOfAdults) throws IOException, JAXBException, DatatypeConfigurationException {
        //load properties
        loadProperties(System.getenv("region"),System.getenv("env"));
        assertNotNull(solr);
        assertNotNull(nurvis);

        //solr request
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(solr);
        post.setEntity(new ByteArrayEntity(createSolrRequest(fromAirport, destination, numberOfAdults).getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgSearchRS otaPkgSearchRS = new OTAPkgSearchRS();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgSearchRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                otaPkgSearchRS = (OTAPkgSearchRS) unmarshaller.unmarshal(instream);
            } finally {
                instream.close();
            }
        }
        return otaPkgSearchRS;
        //createNurvisRequest();
    }

    static public String createSolrRequest(String fromAirport, String destination, int numberOfAdults) throws JAXBException, DatatypeConfigurationException {
        org.opentravel.ota._2003._05.request.ObjectFactory factory = new org.opentravel.ota._2003._05.request.ObjectFactory();
        OTAPkgSearchRQ otaPkgSearchRQ = factory.createOTAPkgSearchRQ();

        FilterResultsType filterResultsType = factory.createFilterResultsType();
        filterResultsType.setEnd("9");
        filterResultsType.setStart("0");
        otaPkgSearchRQ.setFilterResults(filterResultsType);

        PkgSearchCriteriaType pkgSearchCriteriaType = factory.createPkgSearchCriteriaType();
        pkgSearchCriteriaType.setPkgCriterion(factory.createPkgSearchCriteriaTypePkgCriterion());

        LocationType locationType = factory.createLocationType();
        List<LocationType> locationTypes = new ArrayList<>();
        locationType.setValue(fromAirport);
        locationTypes.add(locationType);
        DepartureAirportListType departureAirportListType = factory.createDepartureAirportListType();
        departureAirportListType.setDepartureAirport(locationTypes);

        pkgSearchCriteriaType.getPkgCriterion().setDepartureAirportList(departureAirportListType);

        otaPkgSearchRQ.setCriteria(pkgSearchCriteriaType);

        //Set StayDateRange
        pkgSearchCriteriaType.getPkgCriterion().setStayDateRange(new PkgSearchCriteriaType.PkgCriterion.StayDateRange());
        LocalDate startLocalDate = LocalDate.now();
        startLocalDate = startLocalDate.plus(30, ChronoUnit.DAYS);
        LocalDate endLocalDate = startLocalDate.plus(30, ChronoUnit.DAYS);
        pkgSearchCriteriaType.getPkgCriterion().getStayDateRange().setStart(DatatypeFactory.newInstance().newXMLGregorianCalendar(startLocalDate.toString()));
        pkgSearchCriteriaType.getPkgCriterion().getStayDateRange().setEnd(DatatypeFactory.newInstance().newXMLGregorianCalendar(endLocalDate.toString()));

        //set Destination categories
        pkgSearchCriteriaType.getPkgCriterion().setDestinationCategories(new PkgSearchCriteriaType.PkgCriterion.DestinationCategories());
        List<String> destinationCategory = new ArrayList<>();
        destinationCategory.add(destination);
        pkgSearchCriteriaType.getPkgCriterion().getDestinationCategories().setDestinationCategory(destinationCategory);

        //set Room Stay Candidates
        RoomStayCandidatesType roomStayCandidatesType = factory.createRoomStayCandidatesType();
        pkgSearchCriteriaType.getPkgCriterion().setRoomStayCandidates(roomStayCandidatesType);
        RoomStayCandidatesType.RoomStayCandidate roomStayCandidate = factory.createRoomStayCandidatesTypeRoomStayCandidate();
        PkgGuestCountType guestCountType = factory.createPkgGuestCountType();
        PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
        guestCount.setAgeQualifyingCode("10");
        guestCount.setCount(numberOfAdults);
        guestCountType.setGuestCount(Arrays.asList(guestCount));
        roomStayCandidate.setGuestCounts(guestCountType);
        roomStayCandidatesType.setRoomStayCandidate(Arrays.asList(roomStayCandidate));

        //create version
        otaPkgSearchRQ.setVersion(BigDecimal.valueOf(0.0));
        otaPkgSearchRQ.setSequenceNmbr(BigInteger.valueOf(0));

        //Create XML
        JAXBContext context = JAXBContext.newInstance("org.opentravel.ota._2003._05.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(otaPkgSearchRQ,sw);

        return sw.toString();
    }

    public static HotelOfferType checkPackageAvailability(OTAPkgSearchRS otaPkgSearchRS) throws JAXBException, IOException {
        HotelOfferType hotel = new HotelOfferType();

        for(HotelOfferType h : otaPkgSearchRS.getHotelOffers().getHotelOffer()){
            createNurvisRequest(h);
        }
        return hotel;
    }

    public static void createNurvisRequest(HotelOfferType packageHoliday) throws JAXBException, IOException {
        com.thomascook.nurvisAdapter.request.ObjectFactory factory = new com.thomascook.nurvisAdapter.request.ObjectFactory();
        ReservationRequestTypeRequest request = factory.createReservationRequestTypeRequest();
        request.setAgent("000500");
        request.setEducBook("Y");
        request.setUserCode("Neckermann");
        request.setMode("Prod");
        request.setLang("NL");
        request.setConfirm("Y");
        request.setSubType("PRICE");
        request.setType("BOOK");
        request.setTime("26062017");
        request.setDate("26062017");
        request.setUnit("001");
        request.setSTermId("707");
        request.setTo("NURVIS");
        request.setFrom("NECNL");
        request.setVersion("VD.1.0");

        //create Customer
        request.setFab(factory.createReservationFabTypeRequest());
        request.getFab().setCustomer(factory.createReservationCustomerTypeRequest());
        request.getFab().getCustomer().setCName("Doe");
        request.getFab().getCustomer().setCFirstName("John");
        request.getFab().getCustomer().setCLanguage("H");
        request.getFab().getCustomer().setCStreet("Strasse 1");
        request.getFab().getCustomer().setCPOCode("12345");
        request.getFab().getCustomer().setCCity("Stadt");
        request.getFab().getCustomer().setCEMailUser("finsupport");
        request.getFab().getCustomer().setCEMailDomain("thomascook.nl");

        //add booking data
        request.getFab().setSellAgent("NL4200");
        request.getFab().setTOCode("NVN");
        request.getFab().setCatalog("");

        //add person 1
        request.getFab().getFap().add(factory.createReservationFapTypeRequest());
        request.getFab().getFap().get(0).setAge("30");
        request.getFab().getFap().get(0).setID("001");
        request.getFab().getFap().get(0).setPersonType("2");
        request.getFab().getFap().get(0).setName("Doe");
        request.getFab().getFap().get(0).setFirstName("John");

        //add person 2
        request.getFab().getFap().add(factory.createReservationFapTypeRequest());
        request.getFab().getFap().get(1).setAge("30");
        request.getFab().getFap().get(1).setID("002");
        request.getFab().getFap().get(1).setPersonType("2");
        request.getFab().getFap().get(1).setName("Doe");
        request.getFab().getFap().get(1).setFirstName("John");

        //add Hotel from solr
        /*request.getFab().getFah().add(factory.createReservationFahTypeRequest());
        request.getFab().getFah().get(0).setServiceType("H");
        request.getFab().getFah().get(0).setSegRef("001");
        request.getFab().getFah().get(0).setPersons(factory.createReservationPersonsTypeRequest());
        request.getFab().getFah().get(0).getPersons().getIdRef().add("001");
        request.getFab().getFah().get(0).getPersons().getIdRef().add("002");
        request.getFab().getFah().get(0).setStartDate(packageHoliday.getDate().toString());
        request.getFab().getFah().get(0).setDuration(Integer.toString(packageHoliday.getPkgDuration()));
        request.getFab().getFah().get(0).setProduct(packageHoliday.getHotelCode());
        request.getFab().getFah().get(0).setRoom(packageHoliday.getRooms().getRoom().get(0).getRoomType());
        request.getFab().getFah().get(0).setMeal(packageHoliday.getM);
        request.getFab().getFah().get(0).setAdults("2");*/

        //add Hotel todo delete after creating solr
        request.getFab().getFah().add(factory.createReservationFahTypeRequest());
        request.getFab().getFah().get(0).setServiceType("H");
        request.getFab().getFah().get(0).setSegRef("001");
        request.getFab().getFah().get(0).setPersons(factory.createReservationPersonsTypeRequest());
        request.getFab().getFah().get(0).getPersons().getIdRef().add("001");
        request.getFab().getFah().get(0).getPersons().getIdRef().add("002");
        request.getFab().getFah().get(0).setStartDate("29072017");
        request.getFab().getFah().get(0).setDuration("7");
        request.getFab().getFah().get(0).setProduct("11785A");
        request.getFab().getFah().get(0).setRoom("2A");
        request.getFab().getFah().get(0).setMeal("LO");
        request.getFab().getFah().get(0).setAdults("2");

        //create flight
        request.getFab().getFat().add(factory.createReservationFatTypeRequest());
        ReservationFatTypeRequest fat1 = request.getFab().getFat().get(0);
        fat1.setDirection("H");
        fat1.setSegRef("002");
        fat1.setServiceType("F");
        fat1.setStartDate("29072017");
        fat1.setDuration("7");
        fat1.setDep("AMS");
        fat1.setArr("PMI");
        fat1.setClazz("2");
        fat1.setCarrier("HV");
        fat1.setFlightNr("5627");
        fat1.setDepTime("1310");
        fat1.setArrTime("1535");
        fat1.setProvider("HV");
        fat1.setAdults("2");
        fat1.setPersons(factory.createReservationPersonsTypeRequest());
        fat1.getPersons().getIdRef().add("001");
        fat1.getPersons().getIdRef().add("002");
        fat1.getLeg().add(factory.createReservationLegTypeRequest());
        ReservationLegTypeRequest leg1 = fat1.getLeg().get(0);
        leg1.setDepDate("29072017");
        leg1.setArrDate("29072017");
        leg1.setDep("AMS");
        leg1.setClazz("2");
        leg1.setArr("PMI");
        leg1.setCarrier("HV");
        leg1.setFlightNr("5627");
        leg1.setDepTime("1310");
        leg1.setArrTime("1535");

        //create flight
        request.getFab().getFat().add(factory.createReservationFatTypeRequest());
        ReservationFatTypeRequest fat2 = request.getFab().getFat().get(1);
        fat2.setDirection("R");
        fat2.setSegRef("003");
        fat2.setServiceType("F");
        fat2.setStartDate("05082017");
        fat2.setDep("PMI");
        fat2.setArr("AMS");
        fat2.setClazz("2");
        fat2.setCarrier("HV");
        fat2.setFlightNr("5628");
        fat2.setDepTime("2235");
        fat2.setArrTime("0105");
        fat2.setProvider("HV");
        fat2.setAdults("2");
        fat2.setPersons(factory.createReservationPersonsTypeRequest());
        fat2.getPersons().getIdRef().add("001");
        fat2.getPersons().getIdRef().add("002");
        fat2.getLeg().add(factory.createReservationLegTypeRequest());
        ReservationLegTypeRequest leg2 = fat2.getLeg().get(0);
        leg2.setDepDate("05082017");
        leg2.setArrDate("05082017");
        leg2.setDep("PMI");
        leg2.setClazz("2");
        leg2.setArr("AMS");
        leg2.setCarrier("HV");
        leg2.setFlightNr("5628");
        leg2.setDepTime("2235");
        leg2.setArrTime("0105");

        JAXBContext context = JAXBContext.newInstance("com.thomascook.nurvisAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request,sw);

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://int-api.thomascook.com/nurvis-prod/prod/OT/NECN/NeckermannReisen");
        post.setEntity(new ByteArrayEntity(sw.toString().getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        ReservationResponseTypeResponse nurvisResponse = new ReservationResponseTypeResponse();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JAXBContext jc = JAXBContext.newInstance(ReservationResponseTypeResponse.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                unmarshaller.setEventHandler(
                        new ValidationEventHandler() {
                            public boolean handleEvent(ValidationEvent event ) {
                                throw new RuntimeException(event.getMessage(),
                                        event.getLinkedException());
                            }
                        });
                nurvisResponse = (ReservationResponseTypeResponse) unmarshaller.unmarshal(instream);
            } finally {
                instream.close();
            }
        }
    }
}
