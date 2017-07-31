package com.thomascook.ids.e2e.tests;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.thomascook.nurvisAdapter.request.*;

import static org.junit.Assert.*;

import com.thomascook.nurvisAdapter.response.*;
import com.thomascook.ontour.*;
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
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by omm on 6/27/2017.
 */
public class CreateBooking {

    static String solr;
    static String nurvis;

    private void loadProperties(String region, String environment) throws IOException {
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
        post.setEntity(new ByteArrayEntity(createSolrRequest(0,9,fromAirport, destination, numberOfAdults).getBytes("UTF-8")));
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
        createSolrRSXML(otaPkgSearchRS);
        return otaPkgSearchRS;
    }

    static void createSolrRSXML(OTAPkgSearchRS otaPkgSearchRS) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("org.opentravel.ota._2003._05.response");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(otaPkgSearchRS,sw);
        //System.out.println(sw.toString());
    }

    static String createSolrRequest(int startInex, int endIndex, String fromAirport, String destination, int numberOfAdults) throws JAXBException, DatatypeConfigurationException {
        org.opentravel.ota._2003._05.request.ObjectFactory factory = new org.opentravel.ota._2003._05.request.ObjectFactory();
        OTAPkgSearchRQ otaPkgSearchRQ = factory.createOTAPkgSearchRQ();

        FilterResultsType filterResultsType = factory.createFilterResultsType();
        filterResultsType.setStart(Integer.toString(startInex));
        filterResultsType.setEnd(Integer.toString(endIndex));
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

    static String convertXMLDateToLocalDate(XMLGregorianCalendar xmlDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return LocalDate.of(xmlDate.getYear(),xmlDate.getMonth(),xmlDate.getDay()).format(formatter);
    }

    static String convertXMLTimeToHHMM(XMLGregorianCalendar xmlDate){
        SimpleDateFormat time = new SimpleDateFormat("HHmm");
        return time.format(xmlDate.toGregorianCalendar().getTime());
    }

    public static ReservationRequestTypeRequest createNurvisRequest(HotelOfferType packageHoliday) throws JAXBException, IOException {
        int segRef = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate today = LocalDate.now();
        today.format(formatter);
        com.thomascook.nurvisAdapter.request.ObjectFactory factory = new com.thomascook.nurvisAdapter.request.ObjectFactory();
        ReservationRequestTypeRequest request = factory.createReservationRequestTypeRequest();
        request.setAgent("000500");
        request.setEducBook("N");
        request.setUserCode("Neckermann");
        request.setMode("IMSQ");
        request.setLang("NL");
        request.setConfirm("Y");
        request.setSubType("PRICE");
        request.setType("BOOK");
        request.setTime(today.toString());
        request.setDate(today.toString());
        request.setUnit("001");
        request.setSTermId("707");
        request.setTo("NURVIS");
        request.setFrom("NECNL");
        request.setVersion("VD.1.0");

        //create Customer
        request.setFab(factory.createReservationFabTypeRequest());
        request.getFab().setCustomer(factory.createReservationCustomerTypeRequest());
        request.getFab().getCustomer().setCName("Dmitry");
        request.getFab().getCustomer().setCFirstName("Pilvinskiy");
        request.getFab().getCustomer().setCLanguage("H");
        request.getFab().getCustomer().setCStreet("Institutska 25");
        request.getFab().getCustomer().setCPOCode("12345");
        request.getFab().getCustomer().setCCity("Kyiv");
        request.getFab().getCustomer().setCEMailUser("d.pilvinskyiy");
        request.getFab().getCustomer().setCEMailDomain("thomascook.nl");
        request.getFab().getCustomer().setCTitle("Mr");

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

        //create flight
        request.getFab().getFat().add(factory.createReservationFatTypeRequest());
        ReservationFatTypeRequest fat1 = request.getFab().getFat().get(0);
        fat1.setDirection("H"); //OUTBOUND
        fat1.setSegRef(Integer.toString(segRef++));
        fat1.setServiceType("F");
        fat1.setStartDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getOutboundFlight().getDepartureTime()));
        fat1.setDuration(Integer.toString(packageHoliday.getPkgDuration()));
        fat1.setDep(packageHoliday.getFlights().getOutboundFlight().getDepartureAirport().getLocationCode());
        fat1.setArr(packageHoliday.getFlights().getOutboundFlight().getArrivalAirport().getLocationCode());
        fat1.setClazz(packageHoliday.getFlights().getOutboundFlight().getServiceClass());
        fat1.setCarrier(packageHoliday.getFlights().getOutboundFlight().getAirline());
        fat1.setFlightNr(packageHoliday.getFlights().getOutboundFlight().getFlightCode());
        fat1.setDepTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getOutboundFlight().getDepartureTime()));
        fat1.setArrTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getOutboundFlight().getArrivalTime()));
        fat1.setAdults("2");
        fat1.setPersons(factory.createReservationPersonsTypeRequest());
        fat1.getPersons().getIdRef().add("001");
        fat1.getPersons().getIdRef().add("002");
        fat1.getLeg().add(factory.createReservationLegTypeRequest());
        ReservationLegTypeRequest leg1 = fat1.getLeg().get(0);
        leg1.setDepDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getOutboundFlight().getDepartureTime()));
        leg1.setArrDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getOutboundFlight().getArrivalTime()));
        leg1.setDep(packageHoliday.getFlights().getOutboundFlight().getDepartureAirport().getLocationCode());
        leg1.setClazz(packageHoliday.getFlights().getOutboundFlight().getServiceClass());
        leg1.setArr(packageHoliday.getFlights().getOutboundFlight().getArrivalAirport().getLocationCode());
        leg1.setCarrier(packageHoliday.getFlights().getOutboundFlight().getAirline());
        leg1.setFlightNr(packageHoliday.getFlights().getOutboundFlight().getFlightCode());
        leg1.setDepTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getOutboundFlight().getDepartureTime()));
        leg1.setArrTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getOutboundFlight().getArrivalTime()));

        //create flight
        request.getFab().getFat().add(factory.createReservationFatTypeRequest());
        ReservationFatTypeRequest fat2 = request.getFab().getFat().get(1);
        fat2.setDirection("R"); //INBOUND
        fat2.setSegRef(Integer.toString(segRef++));
        fat2.setServiceType("F");
        fat2.setStartDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getInboundFlight().getDepartureTime()));
        fat2.setDep(packageHoliday.getFlights().getInboundFlight().getDepartureAirport().getLocationCode());
        fat2.setArr(packageHoliday.getFlights().getInboundFlight().getArrivalAirport().getLocationCode());
        fat2.setClazz(packageHoliday.getFlights().getInboundFlight().getServiceClass());
        fat2.setCarrier(packageHoliday.getFlights().getInboundFlight().getAirline());
        fat2.setFlightNr(packageHoliday.getFlights().getInboundFlight().getFlightCode());
        fat2.setDepTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getInboundFlight().getDepartureTime()));
        fat2.setArrTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getInboundFlight().getArrivalTime()));
        fat2.setAdults("2");
        fat2.setPersons(factory.createReservationPersonsTypeRequest());
        fat2.getPersons().getIdRef().add("001");
        fat2.getPersons().getIdRef().add("002");
        fat2.getLeg().add(factory.createReservationLegTypeRequest());
        ReservationLegTypeRequest leg2 = fat2.getLeg().get(0);
        leg2.setDepDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getInboundFlight().getDepartureTime()));
        leg2.setArrDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getInboundFlight().getArrivalTime()));
        leg2.setDep(packageHoliday.getFlights().getInboundFlight().getDepartureAirport().getLocationCode());
        leg2.setArr(packageHoliday.getFlights().getInboundFlight().getArrivalAirport().getLocationCode());
        leg2.setClazz(packageHoliday.getFlights().getInboundFlight().getServiceClass());
        leg2.setCarrier(packageHoliday.getFlights().getInboundFlight().getAirline());
        leg2.setFlightNr(packageHoliday.getFlights().getInboundFlight().getFlightCode());
        leg2.setDepTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getInboundFlight().getDepartureTime()));
        leg2.setArrTime(convertXMLTimeToHHMM(packageHoliday.getFlights().getInboundFlight().getArrivalTime()));

        //add Hotel from Solr
        request.getFab().getFah().add(factory.createReservationFahTypeRequest());
        request.getFab().getFah().get(0).setServiceType("H");
        request.getFab().getFah().get(0).setSegRef(Integer.toString(segRef++));
        request.getFab().getFah().get(0).setPersons(factory.createReservationPersonsTypeRequest());
        request.getFab().getFah().get(0).getPersons().getIdRef().add("001");
        request.getFab().getFah().get(0).getPersons().getIdRef().add("002");
        request.getFab().getFah().get(0).setStartDate(convertXMLDateToLocalDate(packageHoliday.getFlights().getOutboundFlight().getArrivalTime()));
        request.getFab().getFah().get(0).setDuration(Integer.toString(packageHoliday.getPkgDuration()));
        request.getFab().getFah().get(0).setProduct(packageHoliday.getRooms().getRoom().get(0).getRoomType().split("\\.")[0]);
        request.getFab().getFah().get(0).setRoom(packageHoliday.getRooms().getRoom().get(0).getRoomType().split("\\.")[1]);
        request.getFab().getFah().get(0).setMeal("AI");
        request.getFab().getFah().get(0).setAdults("2");

        return request;
    }

    public static ReservationResponseTypeResponse getNurvisInquiryResponse(ReservationRequestTypeRequest request) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.nurvisAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request,sw);

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://ppt.int-api.thomascook.com/nurvis-test/test/OT/NECN/NeckermannReisen");
        post.setEntity(new ByteArrayEntity(sw.toString().getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        ReservationResponseTypeResponse nurvisResponse = new ReservationResponseTypeResponse();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JAXBContext jc = JAXBContext.newInstance(ReservationResponseTypeResponse.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                nurvisResponse = (ReservationResponseTypeResponse) unmarshaller.unmarshal(instream);
            } finally {
                instream.close();
            }
        }
        return nurvisResponse;
    }

    public static ReservationResponseTypeResponse createNurvisBooking(ReservationRequestTypeRequest nurvisRequest, ReservationResponseTypeResponse nurvisResponse) throws JAXBException, IOException {
        nurvisRequest.getFab().setKey(nurvisResponse.getFab().getKey());
        nurvisRequest.setSubType("FIX");
        for(ReservationFatTypeRequest requestFat : nurvisRequest.getFab().getFat()){
            for(ReservationFatTypeResponse responseFat : nurvisResponse.getFab().getFat()){
                if(Objects.equals(requestFat.getSegRef(), responseFat.getSegRef())){
                    requestFat.setKey(responseFat.getKey());
                    requestFat.getLeg().get(0).setKey(responseFat.getLeg().get(0).getKey());
                    requestFat.getLeg().get(0).setExternal(responseFat.getLeg().get(0).getExternal());
                }
            }
        }
        nurvisRequest.getFab().getFah().get(0).setKey(nurvisResponse.getFab().getFah().get(0).getKey());

        JAXBContext context = JAXBContext.newInstance("com.thomascook.nurvisAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(nurvisRequest,sw);

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://ppt.int-api.thomascook.com/nurvis-test/test/OT/NECN/NeckermannReisen");
        post.setEntity(new ByteArrayEntity(sw.toString().getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        ReservationResponseTypeResponse nurvisBooking = new ReservationResponseTypeResponse();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JAXBContext jc = JAXBContext.newInstance(ReservationResponseTypeResponse.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                nurvisBooking = (ReservationResponseTypeResponse) unmarshaller.unmarshal(instream);
            } finally {
                instream.close();
            }
        }

        return nurvisBooking;
    }

    public static String generateOntourXML(ReservationResponseTypeResponse nurvisBooking) throws JAXBException {
        Shipment shipment = new Shipment();
        shipment.setIdentifier(1);
        shipment.setEmitter_code("03");
        shipment.setOffice_code(nurvisBooking.getFab().getDestination());
        shipment.setNumber_booking(1);
        shipment.setVersion("01.00.09");

        //Create booking
        shipment.setBooking(Arrays.asList(new Booking()));
        Booking booking = shipment.getBooking().get(0);
        booking.setStatus("A");
        booking.setLocalizer(nurvisBooking.getFab().getWarning().get(0).getText().split(" ")[1]);
        booking.setPnr_version(1);
        booking.setExt_pnr_version(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate today = LocalDate.now();

        booking.setDate(today.format(formatter));
        booking.setAmendment_date(today.format(formatter));
        booking.setExt_amendment_date(today.format(formatter));
        booking.setBeginning_date(nurvisBooking.getFab().getStartDate());
        booking.setEnd_date(nurvisBooking.getFab().getEndDate());
        booking.setDestination(nurvisBooking.getFab().getDestination());
        booking.setProduct_code(nurvisBooking.getFab().getSaison());
        booking.setTo_code(nurvisBooking.getFab().getTouroperator());
        booking.setBrand(nurvisBooking.getFab().getTOCode());
        booking.setBrand(nurvisBooking.getFab().getTOCodeVT());
        booking.setLatebooking("N");

        List<Pax> paxes = new ArrayList<>();
        for(ReservationFapTypeResponse fap : nurvisBooking.getFab().getFap()){
            Pax pax = new Pax();
            pax.setName(fap.getFirstName());
            pax.setSurname(fap.getName());
            pax.setAge(Integer.parseInt(fap.getAge()));
            pax.setSex(fap.getSex());
            pax.setIdentifier(Integer.parseInt(fap.getID()));
            pax.getBirth_date();
            pax.getLanguage();
            paxes.add(pax);
        }
        booking.setPax(paxes);

        List<Service> services = new ArrayList<>();
        booking.setService(services);
        for(ReservationFatTypeResponse fat : nurvisBooking.getFab().getFat()){
            if(fat.getServiceType().equals("F")) {
                Service service = new Service();
                service.setCode(fat.getCarrier() + fat.getFlightNr());
                service.setType("FL");
                service.setName(service.getCode());
                service.setOrder(Integer.parseInt(fat.getSegRef()));
                switch(fat.getDirection()){
                    case "H": service.setTransfer_type("IN");
                        break;
                    case "R": service.setTransfer_type("OUT");
                }
                service.setOrigin(fat.getDep());
                service.setDestination(fat.getArr());
                service.setCarrier_code(fat.getCarrier());
                service.setCarrier_flight_code(fat.getFlightNr());
                service.setIdentifier(fat.getCarrier() + fat.getFlightNr()+fat.getDep()+fat.getArr());
                service.setNumberofunits(Integer.parseInt(fat.getAdults()));

                List<Pax_service> pax_services = new ArrayList<>();
                service.setPax_service(pax_services);
                for(String person : fat.getPersons().getIdRef()){
                    Pax_service pax_service = new Pax_service();
                    List<Pax_service_assignment> pax_service_assignments = new ArrayList<>();
                    pax_service.setPax_service_assignment(pax_service_assignments);
                    Pax_service_assignment pax_service_assignment = new Pax_service_assignment();
                    pax_service_assignment.setPax_identifier(Integer.parseInt(person));
                    pax_service.getPax_service_assignment().add(pax_service_assignment);
                    service.getPax_service().add(pax_service);
                }
                booking.getService().add(service);
            }
        }

        for(ReservationFahTypeResponse fah : nurvisBooking.getFab().getFah()){
            Service service = new Service();
            if(fah.getServiceType().equals("H")){
                service.setCode(fah.getProduct());
                service.setType("RM");
                service.setName(fah.getProductName());
                service.setOrder(Integer.parseInt(fah.getSegRef()));
                service.setBeginning_date(fah.getStartDate());
                service.setBeginning_time("0000");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
                LocalDate endDate = LocalDate.parse(fah.getStartDate(),formatter2);
                endDate.plus(Integer.parseInt(fah.getDuration()),ChronoUnit.DAYS);
                endDate.format(formatter2);
                service.setEnd_date(endDate.toString());
                service.setEnd_time("0000");
                service.setAccomodation(fah.getRoom());
                service.setBoard(fah.getMeal());
                service.setShared_room_type("N");
                service.setStatus(fah.getStatus());
                service.setOccupancy(fah.getAdults());
                service.setNumberofunits(1);
                service.setTransfer_code("G");
                service.setExternal_service_flag("I");

                List<Pax_service> pax_services = new ArrayList<>();
                service.setPax_service(pax_services);
                for(String person : fah.getPersons().getIdRef()){
                    Pax_service pax_service = new Pax_service();
                    List<Pax_service_assignment> pax_service_assignments = new ArrayList<>();
                    pax_service.setPax_service_assignment(pax_service_assignments);
                    Pax_service_assignment pax_service_assignment = new Pax_service_assignment();
                    pax_service_assignment.setPax_identifier(Integer.parseInt(person));
                    pax_service.getPax_service_assignment().add(pax_service_assignment);
                    service.getPax_service().add(pax_service);
                }
                booking.getService().add(service);
            }
        }

        for(ReservationFacTypeResponse fac : nurvisBooking.getFab().getFac()){
            Service service = new Service();
            service.setCode(fac.getCode());
            service.setType("MI");
            if(fac.getServiceType().equals("I")) {
                service.setName("Insurance");
            }
            service.setOrder(Integer.parseInt(fac.getSegRef()));
            service.setBeginning_date(fac.getStartDate());
            service.setBeginning_time("0000");
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
            LocalDate endDate = LocalDate.parse(fac.getStartDate(),formatter2);
            endDate.plus(Integer.parseInt(fac.getDuration()),ChronoUnit.DAYS);
            endDate.format(formatter2);
            service.setEnd_date(endDate.toString());
            service.setEnd_time("0000");

            List<Pax_service> pax_services = new ArrayList<>();
            service.setPax_service(pax_services);
            for(String person : fac.getPersons().getIdRef()){
                Pax_service pax_service = new Pax_service();
                List<Pax_service_assignment> pax_service_assignments = new ArrayList<>();
                pax_service.setPax_service_assignment(pax_service_assignments);
                Pax_service_assignment pax_service_assignment = new Pax_service_assignment();
                pax_service_assignment.setPax_identifier(Integer.parseInt(person));
                pax_service.getPax_service_assignment().add(pax_service_assignment);
                service.getPax_service().add(pax_service);
            }
            booking.getService().add(service);
        }

        JAXBContext context = JAXBContext.newInstance(Shipment.class);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(shipment,sw);

        return sw.toString();
    }

    //ReservationRequestTypeRequest
    public static HashMap<String, Object> getValidPackage(OTAPkgSearchRS otaPkgSearchRS) throws JAXBException, IOException {
        //createNurvisRequest(otaPkgSearchRS.getHotelOffers().getHotelOffer().get(0));
        HashMap<String, Object> result = new HashMap<>();
        ReservationRequestTypeRequest request;
        ReservationResponseTypeResponse response;
        outerloop:
        for(HotelOfferType hotelOfferType : otaPkgSearchRS.getHotelOffers().getHotelOffer()){
            request = createNurvisRequest(hotelOfferType);
            response = getNurvisInquiryResponse(request);
            List<ReservationWarningTypeResponse> warnings = response.getFab().getWarning();
            for(ReservationWarningTypeResponse warning : warnings){
                if(warning.getText().equals("BOEKEN IS MOGELIJK")){
                    result.put("request", request);
                    result.put("response", response);
                    break outerloop;
                }
            }
        }
        return result;
    }

    public static void putOnTourXmlOnSftp(String onTourXML, String destinationAirport){
        try {
            JSch jsch = new JSch();

            String user = "ontour-stg";
            String host = "492565-srv29.eceit.net";
            int port = 22;
            String privateKey = "C:\\Users\\omm\\SFTP3.ppk";

            jsch.addIdentity(privateKey);
            System.out.println("identity added ");

            Session session = jsch.getSession(user, host, port);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            System.out.println("session created.");

            session.connect();
            System.out.println("session connected.....");

            Channel channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
            System.out.println("shell channel connected....");

            ChannelSftp c = (ChannelSftp) channel;

            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            //String fileName = "OBES_" + destinationAirport + "_" + date.getYear() + "_" + date.getMonth().getLong(ChronoField.MONTH_OF_YEAR) + "_" + date.getDayOfMonth() +
            //        "_" + date.getDayOfMonth() + "_" + date.getMonth().getLong(ChronoField.MONTH_OF_YEAR) + "_" + date.getYear() + time.getHour() + "_" +
            //        time.getMinute() + "_" + time.getSecond() + ".xml";

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_dd_MM_yyyy");
            LocalDate today = LocalDate.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH_mm_ss");
            LocalTime now = LocalTime.now();

            String fileName = "OBES_" + today.format(dateFormatter) + now.format(timeFormatter) + ".xml";

            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(onTourXML);
            fileWriter.flush();
            fileWriter.close();

            createZipFile(file, fileName);

            c.put(String.valueOf(new File(fileName + ".zip")), "/ontour-stg/export");
            c.exit();
            System.out.println("done");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static void createZipFile(File onTourXML, String fileName) throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName + ".zip");
        ZipOutputStream zos = new ZipOutputStream(fos);

        addToZipFile(onTourXML.getName(), zos);
        zos.close();
        fos.close();
    }

    public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

        System.out.println("Writing '" + fileName + "' to zip file");

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }
}
