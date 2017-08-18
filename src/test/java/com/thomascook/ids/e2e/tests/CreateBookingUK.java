package com.thomascook.ids.e2e.tests;

import com.thomascook.toscaAdapter.request.CustomerCountsType;
import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import com.thomascook.toscaExtrasAdapter.request.*;
import cucumber.api.DataTable;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.opentravel.ota._2003._05.request.*;
import org.opentravel.ota._2003._05.request.LocationType;
import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CreateBookingUK {

    public static OTAPkgSearchRS getSOLRPackagesUK(String solr, String departureAirport, String destination, DataTable dataTable)
            throws IOException, JAXBException, DatatypeConfigurationException {
        //Assign data from dataTable
        List<Map<String,String>> listOfMaps = dataTable.asMaps(String.class, String.class);

        //solr request
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(solr);
        String solrRequest = createSolrRequestUK(0,9,departureAirport, destination, listOfMaps);
        post.setEntity(new ByteArrayEntity(solrRequest.getBytes("UTF-8")));
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
        //createSolrRSXML(otaPkgSearchRS);
        return otaPkgSearchRS;
    }

    static String createSolrRequestUK(int startIndex, int endIndex, String fromAirport, String destination, List<Map<String,String>> listOfMaps)
            throws JAXBException, DatatypeConfigurationException {
        org.opentravel.ota._2003._05.request.ObjectFactory factory = new org.opentravel.ota._2003._05.request.ObjectFactory();
        OTAPkgSearchRQ otaPkgSearchRQ = factory.createOTAPkgSearchRQ();

        FilterResultsType filterResultsType = factory.createFilterResultsType();
        filterResultsType.setStart(Integer.toString(startIndex));
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

        RoomStayCandidatesType roomStayCandidatesType = factory.createRoomStayCandidatesType();
        pkgSearchCriteriaType.getPkgCriterion().setRoomStayCandidates(roomStayCandidatesType);
        List<RoomStayCandidatesType.RoomStayCandidate> roomStayCandidates = new ArrayList<>();
        //set Room Stay Candidates
        for(Map<String,String> passengers : listOfMaps){
            String adults = passengers.get("Adults");
            String children = passengers.get("Children");
            String infants = passengers.get("Infants");

            assert !adults.isEmpty() : "Number of adults is not set.";
            assert !children.isEmpty() : "Number of children is not set";
            assert !infants.isEmpty() : "Number of infants is not set";

            RoomStayCandidatesType.RoomStayCandidate roomStayCandidate = factory.createRoomStayCandidatesTypeRoomStayCandidate();

            PkgGuestCountType guestCountType = factory.createPkgGuestCountType();
            List<PkgGuestCountType.GuestCount> guestCounts = new ArrayList();
            int numberOfAdults = Integer.parseInt(adults);
            if(numberOfAdults>0){
                PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
                guestCount.setAgeQualifyingCode("10");
                guestCount.setCount(numberOfAdults);
                guestCounts.add(guestCount);
            }
            int numberOfInfants = Integer.parseInt(infants);
            if(numberOfInfants>0){
                PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
                guestCount.setAgeQualifyingCode("7");
                guestCount.setCount(numberOfInfants);
                guestCounts.add(guestCount);
            }
            int numberOfChildren = Integer.parseInt(children);
            if(numberOfChildren>0){
                for(int i =0; i < numberOfChildren; i++){
                    PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
                    guestCount.setAgeQualifyingCode("8");
                    guestCount.setCount(numberOfInfants);
                    int age = 3 + (int)Math.round(Math.random()*14);
                    guestCount.setAge(age);
                    guestCounts.add(guestCount);
                }
            }
            /*PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
            guestCount.setAgeQualifyingCode("10");
            guestCount.setCount(Integer.valueOf(passengers.get("Adults")));*/
            guestCountType.setGuestCount(guestCounts);
            roomStayCandidate.setGuestCounts(guestCountType);
            roomStayCandidates.add(roomStayCandidate);
        }
        roomStayCandidatesType.setRoomStayCandidate(roomStayCandidates);

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
        //return "";
    }

    public static HashMap<String, Object> checkSolrPackages(String endpoint, OTAPkgSearchRS otaPkgSearchRS, DataTable passengers) {
        HashMap<String,Object> result = new HashMap<>();
        for(org.opentravel.ota._2003._05.response.HotelOfferType hotelOffer : otaPkgSearchRS.getHotelOffers().getHotelOffer()){
            try {
                OTAPkgAvailRQ toscaRequest = createToscaAvailabilityRequest(hotelOffer, passengers);
                OTAPkgAvailRS toscaResponse = checkToscaResponse(endpoint, toscaRequest);
                com.thomascook.toscaAdapter.response.SuccessType success = toscaResponse.getSuccess();
                com.thomascook.toscaAdapter.response.ErrorsType error = toscaResponse.getErrors();
                if(success != null) {
                    result.put("request", toscaRequest);
                    result.put("response", toscaResponse);
                    break;
                }
                //System.out.println(toscaRequest);
            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static OTAPkgAvailRS checkToscaResponse(String endpoint, OTAPkgAvailRQ toscaRequest) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaRequest,sw);

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(new ByteArrayEntity(sw.toString().getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgAvailRS toscaAvailabilityResponse = new OTAPkgAvailRS();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgAvailRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                toscaAvailabilityResponse = (OTAPkgAvailRS) unmarshaller.unmarshal(instream);
            } catch (JAXBException e) {
                e.printStackTrace();
            } finally {
                instream.close();
            }
        }
        return toscaAvailabilityResponse;
    }

    static OTAPkgAvailRQ createToscaAvailabilityRequest(org.opentravel.ota._2003._05.response.HotelOfferType hotelOffer, DataTable passengers){
        com.thomascook.toscaAdapter.request.ObjectFactory factory = new com.thomascook.toscaAdapter.request.ObjectFactory();
        OTAPkgAvailRQ request = factory.createOTAPkgAvailRQ();
        request.setReqRespVersion("BoardAndSeatUpgradesOnly");
        request.setTransactionIdentifier("Y");
        request.setTarget("test");
        com.thomascook.toscaAdapter.request.POSType pos = factory.createPOSType();
        com.thomascook.toscaAdapter.request.SourceType source = factory.createSourceType();
        source.setAgentDutyCode("5616");
        source.setISOCurrency("GBP");
        source.setISOCountry("UK");
        source.setAgentSine("VTX");
        com.thomascook.toscaAdapter.request.SourceType.RequestorID requestorID = factory.createSourceTypeRequestorID();
        requestorID.setID("J9375");
        requestorID.setType("4");
        source.setRequestorID(requestorID);
        request.setPOS(pos);
        request.getPOS().getSource().add(source);

        org.opentravel.ota._2003._05.response.BookingIDType bookingIDType = hotelOffer.getRooms().getRoom().get(0).getBookingID();
        request.setPackageRequest(factory.createOTAPkgAvailRQPackageRequest());
        for(org.opentravel.ota._2003._05.response.SolrFieldType field : bookingIDType.getField()){
            if(field.getName().equals("ID")) request.getPackageRequest().setID(field.getValue());
            if(field.getName().equals("TravelCode")) request.getPackageRequest().setTravelCode(field.getValue());
            if(field.getName().equals("ProductCode")) request.getPackageRequest().setProductCode(field.getValue());
            if(field.getName().equals("BrandCode")) request.getPackageRequest().setBrandCode(field.getValue());
        }
        request.getPackageRequest().setSearchDateRange(factory.createDateTimeSpanType());
        request.getPackageRequest().getSearchDateRange().setDuration("P" + hotelOffer.getPkgDuration() + "D");
        LocalDate localDate = hotelOffer.getStartDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        request.getPackageRequest().getSearchDateRange().setStart(localDate.format(formatter));

        request.setCustomerCounts(factory.createCustomerCountsType());
        CustomerCountsType.CustomerCount adults = factory.createCustomerCountsTypeCustomerCount();
        CustomerCountsType.CustomerCount children = factory.createCustomerCountsTypeCustomerCount();
        CustomerCountsType.CustomerCount infants = factory.createCustomerCountsTypeCustomerCount();

        adults.setCode("10");
        children.setCode("8");
        infants.setCode("7");

        List<Map<String,String>> listOfMaps = passengers.asMaps(String.class,String.class);
        int numberOfAdults = 0;
        int numberOfChildren = 0;
        int numberOfInfants = 0;
        for(Map<String,String> map : listOfMaps){
            numberOfAdults = numberOfAdults + Integer.parseInt(map.get("Adults"));
            numberOfChildren = numberOfChildren + Integer.parseInt(map.get("Children"));
            numberOfInfants = numberOfInfants + Integer.parseInt(map.get("Infants"));
        }
        adults.setQuantity(new BigInteger(String.valueOf(numberOfAdults)));
        children.setQuantity(new BigInteger(String.valueOf(numberOfChildren)));
        infants.setQuantity(new BigInteger(String.valueOf(numberOfInfants)));

        request.getCustomerCounts().getCustomerCount().add(adults);
        request.getCustomerCounts().getCustomerCount().add(infants);
        request.getCustomerCounts().getCustomerCount().add(children);

        /*JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request,sw);*/

        return request;
    }

    public static void createToscaExtrasRequest(OTAPkgAvailRQ toscaAvailabilityRequest, OTAPkgAvailRS toscaAvailabilityResponse, DataTable passengers) {
        com.thomascook.toscaExtrasAdapter.request.ObjectFactory factory = new com.thomascook.toscaExtrasAdapter.request.ObjectFactory();
        OTAPkgExtrasInfoRQ request = factory.createOTAPkgExtrasInfoRQ();
        com.thomascook.toscaExtrasAdapter.request.POSType posType = factory.createPOSType();
        for(com.thomascook.toscaAdapter.request.SourceType source : toscaAvailabilityRequest.getPOS().getSource()){
            com.thomascook.toscaExtrasAdapter.request.SourceType sourceType = factory.createSourceType();
            sourceType.setAgentSine(source.getAgentDutyCode());
            sourceType.setISOCountry(source.getISOCountry());
            sourceType.setISOCurrency(source.getISOCountry());
            sourceType.setAgentDutyCode(source.getAgentDutyCode());

            com.thomascook.toscaExtrasAdapter.request.SourceType.RequestorID requestorID = factory.createSourceTypeRequestorID();
            requestorID.setID(source.getRequestorID().getID());
            requestorID.setType(source.getRequestorID().getType());

            sourceType.setRequestorID(requestorID);
            posType.getSource().add(sourceType);
        }
        PackageType packageType = factory.createPackageType();
        packageType.setID(toscaAvailabilityResponse.getPackage().getID());
        packageType.setProductCode(toscaAvailabilityResponse.getPackage().getProductCode());
        packageType.setBrandCode(toscaAvailabilityResponse.getPackage().getBrandCode());
        packageType.setTravelCode(toscaAvailabilityResponse.getPackage().getTravelCode());
        PackageType.DateRange dateRange = factory.createPackageTypeDateRange();
        dateRange.setDuration(toscaAvailabilityResponse.getPackage().getDateRange().getDuration());
        dateRange.setStart(toscaAvailabilityResponse.getPackage().getDateRange().getStart());
        packageType.setDateRange(dateRange);
        PackageType.ItineraryItems itineraryItems = factory.createPackageTypeItineraryItems();
        packageType.setItineraryItems(itineraryItems);
        for(com.thomascook.toscaAdapter.response.ItineraryItemResponseType itineraryItemResponseType : toscaAvailabilityResponse.getPackage().getItineraryItems().getItineraryItem()){
            if(itineraryItemResponseType.getAccommodation() != null){
                ItineraryItemRequestType itineraryItemRequestType = factory.createItineraryItemRequestType();

                packageType.getItineraryItems().getItineraryItem().add(itineraryItemRequestType);
            }
        }

        request.setPackageRequest(packageType);
    }
}
