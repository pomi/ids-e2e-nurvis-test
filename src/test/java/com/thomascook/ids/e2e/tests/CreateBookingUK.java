package com.thomascook.ids.e2e.tests;

import com.thomascook.toscaAdapter.request.CustomerCountsType;
import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import com.thomascook.toscaBookAdapter.request.OTAPkgBookRQ;
import com.thomascook.toscaBookAdapter.request.UniqueIDType;
import com.thomascook.toscaBookAdapter.response.OTAPkgBookRS;
import com.thomascook.toscaCostAdapter.request.OTAPkgCostRQ;
import com.thomascook.toscaCostAdapter.request.ObjectFactory;
import com.thomascook.toscaCostAdapter.request.POSType;
import com.thomascook.toscaCostAdapter.request.SourceType;
import com.thomascook.toscaCostAdapter.response.OTAPkgCostRS;
import com.thomascook.toscaExtrasAdapter.request.*;
import com.thomascook.toscaExtrasAdapter.response.OTAPkgExtrasInfoRS;
import cucumber.api.DataTable;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.opentravel.ota._2003._05.request.*;
import org.opentravel.ota._2003._05.request.LocationType;
import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
        String solrRequest = createSolrRequestUK(10,29,departureAirport, destination, listOfMaps);
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

    /*public static HashMap<String, Object> checkSolrPackages(String endpoint, OTAPkgSearchRS otaPkgSearchRS, DataTable passengers) {
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
    }*/

    public static String createToscaAvailabilityRequestXML(OTAPkgAvailRQ toscaRequest) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaRequest,sw);
        return sw.toString();
    }

    public static OTAPkgAvailRS getToscaResponse(String endpoint, String toscaRequest) throws IOException, JAXBException {

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(new ByteArrayEntity(toscaRequest.getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgAvailRS toscaAvailabilityResponse = new OTAPkgAvailRS();
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgAvailRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                toscaAvailabilityResponse = (OTAPkgAvailRS) unmarshaller.unmarshal(instream);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return toscaAvailabilityResponse;
    }

    public static OTAPkgAvailRQ createToscaAvailabilityRequest(org.opentravel.ota._2003._05.response.HotelOfferType hotelOffer, DataTable passengers){
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

    public static OTAPkgExtrasInfoRQ createToscaExtrasRequest(OTAPkgAvailRQ toscaAvailabilityRequest, OTAPkgAvailRS toscaAvailabilityResponse, DataTable passengers) {
        com.thomascook.toscaExtrasAdapter.request.ObjectFactory factory = new com.thomascook.toscaExtrasAdapter.request.ObjectFactory();
        OTAPkgExtrasInfoRQ request = factory.createOTAPkgExtrasInfoRQ();
        com.thomascook.toscaExtrasAdapter.request.POSType posType = factory.createPOSType();
        request.setTarget("test");
        for(com.thomascook.toscaAdapter.request.SourceType source : toscaAvailabilityRequest.getPOS().getSource()){
            com.thomascook.toscaExtrasAdapter.request.SourceType sourceType = factory.createSourceType();
            sourceType.setAgentSine(source.getAgentDutyCode());
            sourceType.setISOCountry(source.getISOCountry());
            sourceType.setISOCurrency(source.getISOCurrency());
            sourceType.setAgentDutyCode(source.getAgentDutyCode());
            sourceType.setAgentSine(source.getAgentSine());

            com.thomascook.toscaExtrasAdapter.request.SourceType.RequestorID requestorID = factory.createSourceTypeRequestorID();
            requestorID.setID(source.getRequestorID().getID());
            requestorID.setType(source.getRequestorID().getType());

            sourceType.setRequestorID(requestorID);
            posType.getSource().add(sourceType);
        }
        request.setPOS(posType);
        PackageType packageType = factory.createPackageType();
        request.setPackageRequest(packageType);
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
        ItineraryItemRequestType itineraryItemRequestType = factory.createItineraryItemRequestType();
        packageType.getItineraryItems().getItineraryItem().add(itineraryItemRequestType);
        AccommodationSegmentRequestType accommodationSegmentRequestType = factory.createAccommodationSegmentRequestType();
        itineraryItemRequestType.setAccommodation(accommodationSegmentRequestType);

        AccommodationSegmentRequestType.RoomProfiles roomProfiles = factory.createAccommodationSegmentRequestTypeRoomProfiles();
        accommodationSegmentRequestType.setRoomProfiles(roomProfiles);
        AccommodationSegmentRequestType.MealPlans mealPlans = factory.createAccommodationSegmentRequestTypeMealPlans();
        accommodationSegmentRequestType.setMealPlans(mealPlans);

        OTAPkgExtrasInfoRQ.PassengerListItems passengerListItems = factory.createOTAPkgExtrasInfoRQPassengerListItems();
        request.setPassengerListItems(passengerListItems);

        List<Map<String,String>> listOfMaps = passengers.asMaps(String.class,String.class);
        int numberOfRooms = 1;
        int passengerRPH = 1;
        for(Map<String,String> map : listOfMaps){
            int numberOfAdults = Integer.parseInt(map.get("Adults"));
            int numberOfChildren = Integer.parseInt(map.get("Children"));
            int numberOfInfants = Integer.parseInt(map.get("Infants"));
            int numberOfPassengers = numberOfAdults + numberOfChildren;
            String roomTypeCode = "";
            String mealPlanCode = "";
            for(com.thomascook.toscaAdapter.response.ItineraryItemResponseType itineraryItemResponseType :
                    toscaAvailabilityResponse.getPackage().getItineraryItems().getItineraryItem()){
                if(itineraryItemResponseType.getAccommodation() != null){
                    for(com.thomascook.toscaAdapter.response.ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile roomProfileResponse :
                            itineraryItemResponseType.getAccommodation().getRoomProfiles().getRoomProfile()){
                        if(numberOfPassengers >= roomProfileResponse.getMinOccupancy() && numberOfPassengers <= roomProfileResponse.getMaxOccupancy()){
                            roomTypeCode = roomProfileResponse.getRoomTypeCode();
                            break;
                        }
                    }
                    for(com.thomascook.toscaAdapter.response.MealPlanType mealPlanType : itineraryItemResponseType.getAccommodation().getMealPlans().getMealPlan()){
                        if(mealPlanType.getListOfRoomRPH().size() == itineraryItemResponseType.getAccommodation().getRoomProfiles().getRoomProfile().size()){
                            mealPlanCode = mealPlanType.getCode();
                            break;
                        }
                    }
                    //assert !roomTypeCode.equals("") : "roomTypeCode is null";
                    //assert !mealPlanCode.equals("") : "mealPlanCode is null";

                }
            }
            //create rooms, passengers and meals
            com.thomascook.toscaExtrasAdapter.request.RoomProfileType roomProfile = factory.createRoomProfileType();
            roomProfile.setRoomTypeCode(roomTypeCode);
            roomProfile.setRPH(String.valueOf(numberOfRooms++));
            roomProfiles.getRoomProfile().add(roomProfile);
            //meal plan
            MealPlanType mealPlanType = factory.createMealPlanType();
            mealPlanType.setCode(mealPlanCode);
            mealPlanType.getListOfRoomRPH().add(roomProfile.getRPH());
            mealPlans.getMealPlan().add(mealPlanType);
            RoomProfileType.PassengerRPHs passengerRPHs = factory.createRoomProfileTypePassengerRPHs();
            roomProfile.setPassengerRPHs(passengerRPHs);
            for(int adults = 0; adults < numberOfAdults; adults++){
                PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
                passengerListItem.setQuantity(BigInteger.valueOf(1));
                passengerListItem.setCode("10");
                passengerListItem.setRPH(String.valueOf(passengerRPH++));
                passengerRPHs.getListOfPassengerRPH().add(passengerListItem.getRPH());
                passengerListItems.getPassengerListItem().add(passengerListItem);
            }
            for(int children = 0; children < numberOfChildren; children++){
                PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
                passengerListItem.setQuantity(BigInteger.valueOf(1));
                passengerListItem.setCode("8");
                passengerListItem.setRPH(String.valueOf(passengerRPH++));
                passengerRPHs.getListOfPassengerRPH().add(passengerListItem.getRPH());
                passengerListItems.getPassengerListItem().add(passengerListItem);
            }
            for(int infants = 0; infants < numberOfInfants; infants++){
                PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
                passengerListItem.setQuantity(BigInteger.valueOf(1));
                passengerListItem.setCode("7");
                passengerListItem.setRPH(String.valueOf(passengerRPH++));
                passengerRPHs.getListOfPassengerRPH().add(passengerListItem.getRPH());
                passengerListItems.getPassengerListItem().add(passengerListItem);
            }
        }
        return request;
    }

    public static OTAPkgExtrasInfoRS getToscaExtrasResponse(String extrasRequest, String endpoint) throws JAXBException, IOException {

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(new ByteArrayEntity(extrasRequest.getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgExtrasInfoRS toscaExtrasResponse = new OTAPkgExtrasInfoRS();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgExtrasInfoRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                toscaExtrasResponse = (OTAPkgExtrasInfoRS) unmarshaller.unmarshal(instream);
            } catch (JAXBException e) {
                e.printStackTrace();
            } finally {
                instream.close();
            }
        }
        return toscaExtrasResponse;
    }

    public static OTAPkgCostRQ createToscaCostRequest(OTAPkgExtrasInfoRS toscaExtrasResponse, OTAPkgExtrasInfoRQ toscaExtrasRequest) {
        ObjectFactory factory = new ObjectFactory();
        OTAPkgCostRQ toscaCostRequest = factory.createOTAPkgCostRQ();
        toscaCostRequest.setTarget("test");
        POSType posType = factory.createPOSType();
        for(com.thomascook.toscaExtrasAdapter.request.SourceType extrasSourceType : toscaExtrasRequest.getPOS().getSource()){
            SourceType sourceType = factory.createSourceType();
            //AgentDutyCode="5616" ISOCurrency="GBP" ISOCountry="UK" AgentSine="VTX">
            sourceType.setAgentDutyCode(extrasSourceType.getAgentDutyCode());
            sourceType.setISOCurrency(extrasSourceType.getISOCurrency());
            sourceType.setISOCountry(extrasSourceType.getISOCountry());
            sourceType.setAgentSine(extrasSourceType.getAgentSine());
            SourceType.RequestorID requestorID = factory.createSourceTypeRequestorID();
            requestorID.setID(extrasSourceType.getRequestorID().getID());
            requestorID.setType(extrasSourceType.getRequestorID().getType());
            sourceType.setRequestorID(requestorID);
            posType.getSource().add(sourceType);
        }
        toscaCostRequest.setPOS(posType);
        com.thomascook.toscaCostAdapter.request.PackageType packageType = factory.createPackageType();
        //<PackageRequest ID="UG6V45" ProductCode="LZS1" BrandCode="TCU1" PromotionCode="" TravelCode="MCOLGW6ALGWMCO:MCOLGW3AMCOLGW">
        packageType.setID(toscaExtrasRequest.getPackageRequest().getID());
        packageType.setProductCode(toscaExtrasRequest.getPackageRequest().getProductCode());
        packageType.setBrandCode(toscaExtrasRequest.getPackageRequest().getBrandCode());
        packageType.setTravelCode(toscaExtrasRequest.getPackageRequest().getTravelCode());
        toscaCostRequest.setPackageRequest(packageType);
        com.thomascook.toscaCostAdapter.request.PackageType.DateRange dateRange = factory.createPackageTypeDateRange();
        packageType.setDateRange(dateRange);
        dateRange.setDuration(toscaExtrasRequest.getPackageRequest().getDateRange().getDuration());
        dateRange.setStart(toscaExtrasRequest.getPackageRequest().getDateRange().getStart());
        com.thomascook.toscaCostAdapter.request.PackageType.ItineraryItems itineraryItems = factory.createPackageTypeItineraryItems();
        packageType.setItineraryItems(itineraryItems);
        for(ItineraryItemRequestType extrasItineraryItems : toscaExtrasRequest.getPackageRequest().getItineraryItems().getItineraryItem()){
            com.thomascook.toscaCostAdapter.request.ItineraryItemRequestType itineraryItemRequestType = factory.createItineraryItemRequestType();
            itineraryItems.getItineraryItem().add(itineraryItemRequestType);
            com.thomascook.toscaCostAdapter.request.AccommodationSegmentRequestType accommodation = factory.createAccommodationSegmentRequestType();
            itineraryItemRequestType.setAccommodation(accommodation);
            com.thomascook.toscaCostAdapter.request.AccommodationSegmentRequestType.RoomProfiles roomProfiles = factory.createAccommodationSegmentRequestTypeRoomProfiles();
            accommodation.setRoomProfiles(roomProfiles);
            for(RoomProfileType extrasRoomProfileType : extrasItineraryItems.getAccommodation().getRoomProfiles().getRoomProfile()){
                com.thomascook.toscaCostAdapter.request.RoomProfileType roomProfileType = factory.createRoomProfileType();
                roomProfiles.getRoomProfile().add(roomProfileType);
                roomProfileType.setRoomTypeCode(extrasRoomProfileType.getRoomTypeCode());
                roomProfileType.setRPH(extrasRoomProfileType.getRPH());
                com.thomascook.toscaCostAdapter.request.RoomProfileType.PassengerRPHs passengerRPHs = factory.createRoomProfileTypePassengerRPHs();
                for(String listOfPassengersRPHs : extrasRoomProfileType.getPassengerRPHs().getListOfPassengerRPH()) {
                    passengerRPHs.getListOfPassengerRPH().add(listOfPassengersRPHs);
                }
                roomProfileType.setPassengerRPHs(passengerRPHs);
            }
            com.thomascook.toscaCostAdapter.request.AccommodationSegmentRequestType.MealPlans mealPlans = factory.createAccommodationSegmentRequestTypeMealPlans();
            accommodation.setMealPlans(mealPlans);
            for(MealPlanType extrasMealPlanType :extrasItineraryItems.getAccommodation().getMealPlans().getMealPlan()){
                com.thomascook.toscaCostAdapter.request.MealPlanType mealPlanType = factory.createMealPlanType();
                mealPlanType.setCode(extrasMealPlanType.getCode());
                for(String roomRPH : extrasMealPlanType.getListOfRoomRPH()){
                    mealPlanType.getListOfRoomRPH().add(roomRPH);
                }
                mealPlans.getMealPlan().add(mealPlanType);
            }
        }
        OTAPkgCostRQ.PassengerListItems passengerListItems = factory.createOTAPkgCostRQPassengerListItems();
        toscaCostRequest.setPassengerListItems(passengerListItems);
        for(PkgPassengerListItem extrasPkgPassengerListItem : toscaExtrasRequest.getPassengerListItems().getPassengerListItem()){
            com.thomascook.toscaCostAdapter.request.PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
            //<PassengerListItem Quantity="1" Code="10" BirthDate="1986-01-01Z" RPH="1" />
            passengerListItem.setQuantity(extrasPkgPassengerListItem.getQuantity());
            passengerListItem.setCode(extrasPkgPassengerListItem.getCode());
            passengerListItem.setBirthDate(extrasPkgPassengerListItem.getBirthDate());
            passengerListItem.setRPH(extrasPkgPassengerListItem.getRPH());
            passengerListItems.getPassengerListItem().add(passengerListItem);
        }
        OTAPkgCostRQ.Extras extras = factory.createOTAPkgCostRQExtras();
        toscaCostRequest.setExtras(extras);
        ArrayList<String> listOfPassengersRPHs = new ArrayList<>();
        for(com.thomascook.toscaCostAdapter.request.PkgPassengerListItem pkgPassengerListItem : toscaCostRequest.getPassengerListItems().getPassengerListItem()){
            if(!pkgPassengerListItem.getCode().equals("7")) {
                listOfPassengersRPHs.add(pkgPassengerListItem.getRPH());
            }
        }
        for(OTAPkgExtrasInfoRS.ExtraGroups.ExtraGroup extraGroup : toscaExtrasResponse.getExtraGroups().getExtraGroup()){
            if(extraGroup.getRuleCode().equals("OneOf")){
                for(com.thomascook.toscaExtrasAdapter.response.ExtrasInfoType extrasInfoType : toscaExtrasResponse.getExtras().getExtra()){
                    if(extrasInfoType.getRPH().equals(extraGroup.getListOfExtrasRPH().get(0))){
                        com.thomascook.toscaCostAdapter.request.ExtrasType extrasType = factory.createExtrasType();
                        extrasType.setCode(extrasInfoType.getCode());
                        extrasType.setRPH(extrasInfoType.getRPH());
                        extrasType.setQuantity(1);
                        extrasType.getListOfPassengerRPH().addAll(listOfPassengersRPHs);
                        extras.getExtra().add(extrasType);
                    }
                }
            }
        }
        /*try {
            JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaCostAdapter.request");
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(toscaCostRequest, sw);
            System.out.println(sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/
        return toscaCostRequest;
    }

    public static String createToscaAvailabilityResponseXML(OTAPkgAvailRS toscaAvailabilityResponse) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaAdapter.response");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaAvailabilityResponse, sw);

        return sw.toString();
    }

    public static String createToscaExtrasRequestXML(OTAPkgExtrasInfoRQ toscaExtrasRequest) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaExtrasAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaExtrasRequest,sw);
        return sw.toString();
    }

    public static String createToscaCostRequestXML(OTAPkgCostRQ toscaCostRequest) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaCostAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaCostRequest, sw);
        return sw.toString();
    }

    public static OTAPkgCostRS getToscaCostResponse(String toscaCostRequestXML, String endpoint) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(new ByteArrayEntity(toscaCostRequestXML.getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgCostRS toscaCostResponse = new OTAPkgCostRS();
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgCostRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                toscaCostResponse = (OTAPkgCostRS) unmarshaller.unmarshal(instream);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return toscaCostResponse;
    }

    public static String createToscaCostResponseXML(OTAPkgCostRS toscaCostResponse) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaCostAdapter.response");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaCostResponse, sw);
        return sw.toString();
    }

    public static OTAPkgBookRQ createToscaBookRequest(OTAPkgCostRQ toscaCostRequest) throws DatatypeConfigurationException {
        com.thomascook.toscaBookAdapter.request.ObjectFactory factory = new com.thomascook.toscaBookAdapter.request.ObjectFactory();
        OTAPkgBookRQ toscaBookRequest = factory.createOTAPkgBookRQ();
        toscaBookRequest.setTarget("test");
        toscaBookRequest.setActionType(com.thomascook.toscaBookAdapter.request.TransactionActionType.HOLD);
        com.thomascook.toscaBookAdapter.request.POSType posType = factory.createPOSType();
        for(SourceType costSourceType : toscaCostRequest.getPOS().getSource()){
            com.thomascook.toscaBookAdapter.request.SourceType sourceType = factory.createSourceType();
            //AgentDutyCode="5616" ISOCurrency="GBP" ISOCountry="UK" AgentSine="VTX">
            sourceType.setAgentDutyCode(costSourceType.getAgentDutyCode());
            sourceType.setISOCurrency(costSourceType.getISOCurrency());
            sourceType.setISOCountry(costSourceType.getISOCountry());
            sourceType.setAgentSine(costSourceType.getAgentSine());
            com.thomascook.toscaBookAdapter.request.SourceType.RequestorID requestorID = factory.createSourceTypeRequestorID();
            requestorID.setID(costSourceType.getRequestorID().getID());
            requestorID.setType(costSourceType.getRequestorID().getType());
            sourceType.setRequestorID(requestorID);
            posType.getSource().add(sourceType);
        }
        toscaBookRequest.setPOS(posType);
        com.thomascook.toscaBookAdapter.request.PackageType packageType = factory.createPackageType();
        //<PackageRequest ID="UG6V45" ProductCode="LZS1" BrandCode="TCU1" PromotionCode="" TravelCode="MCOLGW6ALGWMCO:MCOLGW3AMCOLGW">
        packageType.setID(toscaCostRequest.getPackageRequest().getID());
        packageType.setProductCode(toscaCostRequest.getPackageRequest().getProductCode());
        packageType.setBrandCode(toscaCostRequest.getPackageRequest().getBrandCode());
        packageType.setTravelCode(toscaCostRequest.getPackageRequest().getTravelCode());
        toscaBookRequest.setPackageRequest(packageType);
        com.thomascook.toscaBookAdapter.request.PackageType.DateRange dateRange = factory.createPackageTypeDateRange();
        packageType.setDateRange(dateRange);
        dateRange.setDuration(toscaCostRequest.getPackageRequest().getDateRange().getDuration());
        dateRange.setStart(toscaCostRequest.getPackageRequest().getDateRange().getStart());
        com.thomascook.toscaBookAdapter.request.PackageType.ItineraryItems itineraryItems = factory.createPackageTypeItineraryItems();
        packageType.setItineraryItems(itineraryItems);
        for(com.thomascook.toscaCostAdapter.request.ItineraryItemRequestType costItineraryItems : toscaCostRequest.getPackageRequest().getItineraryItems().getItineraryItem()){
            com.thomascook.toscaBookAdapter.request.ItineraryItemRequestType itineraryItemRequestType = factory.createItineraryItemRequestType();
            itineraryItems.getItineraryItem().add(itineraryItemRequestType);
            com.thomascook.toscaBookAdapter.request.AccommodationSegmentRequestType accommodation = factory.createAccommodationSegmentRequestType();
            itineraryItemRequestType.setAccommodation(accommodation);
            com.thomascook.toscaBookAdapter.request.AccommodationSegmentRequestType.RoomProfiles roomProfiles = factory.createAccommodationSegmentRequestTypeRoomProfiles();
            accommodation.setRoomProfiles(roomProfiles);
            for(com.thomascook.toscaCostAdapter.request.RoomProfileType costRoomProfileType : costItineraryItems.getAccommodation().getRoomProfiles().getRoomProfile()){
                com.thomascook.toscaBookAdapter.request.RoomProfileType roomProfileType = factory.createRoomProfileType();
                roomProfiles.getRoomProfile().add(roomProfileType);
                roomProfileType.setRoomTypeCode(costRoomProfileType.getRoomTypeCode());
                roomProfileType.setRPH(costRoomProfileType.getRPH());
                com.thomascook.toscaBookAdapter.request.RoomProfileType.PassengerRPHs passengerRPHs = factory.createRoomProfileTypePassengerRPHs();
                for(String listOfPassengersRPHs : costRoomProfileType.getPassengerRPHs().getListOfPassengerRPH()) {
                    passengerRPHs.getListOfPassengerRPH().add(listOfPassengersRPHs);
                }
                roomProfileType.setPassengerRPHs(passengerRPHs);
            }
            com.thomascook.toscaBookAdapter.request.AccommodationSegmentRequestType.MealPlans mealPlans = factory.createAccommodationSegmentRequestTypeMealPlans();
            accommodation.setMealPlans(mealPlans);
            for(com.thomascook.toscaCostAdapter.request.MealPlanType extrasMealPlanType : costItineraryItems.getAccommodation().getMealPlans().getMealPlan()){
                com.thomascook.toscaBookAdapter.request.MealPlanType mealPlanType = factory.createMealPlanType();
                mealPlanType.setCode(extrasMealPlanType.getCode());
                for(String roomRPH : extrasMealPlanType.getListOfRoomRPH()){
                    mealPlanType.getListOfRoomRPH().add(roomRPH);
                }
                mealPlans.getMealPlan().add(mealPlanType);
            }
        }
        OTAPkgBookRQ.PassengerListItems passengerListItems = factory.createOTAPkgBookRQPassengerListItems();
        toscaBookRequest.setPassengerListItems(passengerListItems);
        boolean namePrefix = true;
        for(com.thomascook.toscaCostAdapter.request.PkgPassengerListItem extrasPkgPassengerListItem : toscaCostRequest.getPassengerListItems().getPassengerListItem()){
            com.thomascook.toscaBookAdapter.request.PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
            //<PassengerListItem Quantity="1" Code="10" BirthDate="1986-01-01Z" RPH="1" />
            passengerListItem.setQuantity(extrasPkgPassengerListItem.getQuantity());
            passengerListItem.setCode(extrasPkgPassengerListItem.getCode());
            passengerListItem.setBirthDate(extrasPkgPassengerListItem.getBirthDate());
            if(extrasPkgPassengerListItem.getRPH().equals("1")){
                passengerListItem.setRPH(extrasPkgPassengerListItem.getRPH());
                passengerListItem.setLeadCustomerInd(true);
                com.thomascook.toscaBookAdapter.request.PersonNameType personNameType = factory.createPersonNameType();
                passengerListItem.setName(personNameType);
                String lastName = generateAZSequence(true);
                personNameType.setSurname(lastName);
                String firstName = generateAZSequence(false);
                personNameType.getGivenName().add(firstName);
                //if person code = 10 set name prefix to Mr or Mrs
                if(extrasPkgPassengerListItem.getCode().equals("10")) {
                    if(namePrefix) {
                        personNameType.getNamePrefix().add("Mr");
                        namePrefix = false;
                    } else {
                        personNameType.getNamePrefix().add("Mrs");
                        namePrefix = true;
                    }
                }
                com.thomascook.toscaBookAdapter.request.ContactPersonType contactPersonType = factory.createContactPersonType();
                toscaBookRequest.setContactDetail(contactPersonType);
                com.thomascook.toscaBookAdapter.request.PersonNameType personNameTypeContactType = factory.createPersonNameType();
                personNameTypeContactType.getNamePrefix().addAll(personNameType.getNamePrefix());
                personNameTypeContactType.setSurname(lastName);
                personNameTypeContactType.getGivenName().addAll(personNameType.getGivenName());
                contactPersonType.setPersonName(personNameTypeContactType);
                com.thomascook.toscaBookAdapter.request.ContactPersonType.Telephone telephone = factory.createContactPersonTypeTelephone();
                telephone.setCountryAccessCode("+44");
                telephone.setAreaCityCode("0" + RandomStringUtils.randomNumeric(2,2));
                //add phone number
                telephone.setPhoneNumber(RandomStringUtils.randomNumeric(8,8));
                contactPersonType.getTelephone().add(telephone);
                com.thomascook.toscaBookAdapter.request.EmailType emailType = factory.createEmailType();
                emailType.setValue(firstName + "." + lastName + "@thomascookonline.com");
                contactPersonType.getEmail().add(emailType);
                com.thomascook.toscaBookAdapter.request.AddressInfoType addressInfoType = factory.createAddressInfoType();
                addressInfoType.getAddressLine().add("East");
                com.thomascook.toscaBookAdapter.request.AddressType.StreetNmbr streetNmbr = factory.createAddressTypeStreetNmbr();
                streetNmbr.setValue("16 The Piazza");
                addressInfoType.setStreetNmbr(streetNmbr);
                addressInfoType.setPostalCode("WC2E8HD");
                addressInfoType.setCityName("London");
                com.thomascook.toscaBookAdapter.request.CountryNameType countryNameType = factory.createCountryNameType();
                countryNameType.setCode("UK");
                countryNameType.setValue("UK");
                addressInfoType.setCountryName(countryNameType);
                contactPersonType.getAddress().add(addressInfoType);
            } else {
                passengerListItem.setRPH(extrasPkgPassengerListItem.getRPH());
                passengerListItem.setLeadCustomerInd(false);
                com.thomascook.toscaBookAdapter.request.PersonNameType personNameType = factory.createPersonNameType();
                passengerListItem.setName(personNameType);
                personNameType.setSurname(generateAZSequence(true));
                personNameType.getGivenName().add(generateAZSequence(false));
                //if person code = 10 set name prefix to Mr or Mrs
                if(extrasPkgPassengerListItem.getCode().equals("10")) {
                    if(namePrefix) {
                        personNameType.getNamePrefix().add("Mr");
                        namePrefix = false;
                    } else {
                        personNameType.getNamePrefix().add("Mrs");
                        namePrefix = true;
                    }
                }
                if(extrasPkgPassengerListItem.getCode().equals("8")){
                    personNameType.getNamePrefix().add("Child");
                    passengerListItem.setBirthDate(generateBirthDate(true));
                }
                if(extrasPkgPassengerListItem.getCode().equals("7")){
                    personNameType.getNamePrefix().add("Infant");
                    passengerListItem.setBirthDate(generateBirthDate(false));
                }
            }
            passengerListItems.getPassengerListItem().add(passengerListItem);
        }

        com.thomascook.toscaBookAdapter.request.PackageType.Extras extras = factory.createPackageTypeExtras();
        toscaBookRequest.getPackageRequest().setExtras(extras);
        for(com.thomascook.toscaCostAdapter.request.ExtrasType costExtrasType : toscaCostRequest.getExtras().getExtra()){
            com.thomascook.toscaBookAdapter.request.ExtrasType extrasType = factory.createExtrasType();
            //<Extra ListOfPassengerRPH="1 2" Quantity="1" Code="MEAL/IFM/MEAL/197295049/Y/F" RPH="38" />
            extrasType.setQuantity(costExtrasType.getQuantity());
            extrasType.setCode(costExtrasType.getCode());
            extrasType.setRPH(costExtrasType.getRPH());
            extrasType.getListOfPassengerRPH().addAll(costExtrasType.getListOfPassengerRPH());
            extras.getExtra().add(extrasType);
        }
        return toscaBookRequest;
    }

    public static String createToscaBookRequestXML(OTAPkgBookRQ toscaBookRequest) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaBookAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaBookRequest, sw);
        return sw.toString();
    }

    private static String generateAZSequence(boolean isLastName){
        String sequence;
        if(isLastName){
            sequence = RandomStringUtils.randomAlphabetic(new Random().nextInt(6)+6);
        }else {
            sequence = RandomStringUtils.randomAlphabetic(new Random().nextInt(3)+6);
        }
        return sequence;
    }

    private static XMLGregorianCalendar generateBirthDate(boolean child) throws DatatypeConfigurationException {
        int daysOfLife = 0;
        LocalDate localDate = LocalDate.now();
        LocalDate birthDate;
        if(child){
            daysOfLife = new Random().nextInt(365*16-1) + 365*2;
            birthDate = localDate.minus(daysOfLife,ChronoUnit.DAYS);
        }else{
            daysOfLife = new Random().nextInt(365*2-1);
            birthDate = localDate.minus(daysOfLife, ChronoUnit.DAYS);
        }

        //DatatypeFactory.newInstance().newXMLGregorianCalendar(birthDate.format(DateTimeFormatter.ISO_DATE));

        //GregorianCalendar gcal = GregorianCalendar.from(birthDate.atStartOfDay(ZoneId.ofOffset("UTC", ZoneOffset.UTC)));
        //XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(birthDate.format(DateTimeFormatter.ISO_DATE));
    }

    public static OTAPkgBookRS getToscaBookResponse(String toscaBookRequestXML, String endpoint) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(new ByteArrayEntity(toscaBookRequestXML.getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgBookRS toscaBookResponse = new OTAPkgBookRS();
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgBookRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                toscaBookResponse = (OTAPkgBookRS) unmarshaller.unmarshal(instream);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return toscaBookResponse;
    }

    public static String createToscaBookResponseXML(OTAPkgBookRS toscaBookResponse) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaBookAdapter.response");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaBookResponse, sw);
        return sw.toString();
    }

    public static OTAPkgBookRQ createToscaBookCommitRequest(OTAPkgBookRQ toscaBookRequest, OTAPkgBookRS toscaBookResponse) {
        com.thomascook.toscaBookAdapter.request.ObjectFactory factory = new com.thomascook.toscaBookAdapter.request.ObjectFactory();
        OTAPkgBookRQ toscaBookCommitRequest = factory.createOTAPkgBookRQ();
        toscaBookCommitRequest.setTarget("test");
        toscaBookCommitRequest.setActionType(com.thomascook.toscaBookAdapter.request.TransactionActionType.COMMIT);
        toscaBookCommitRequest.setPOS(toscaBookRequest.getPOS());
        toscaBookCommitRequest.setContactDetail(toscaBookRequest.getContactDetail());
        UniqueIDType uniqueIDType = factory.createUniqueIDType();
        uniqueIDType.setID(toscaBookResponse.getPackageReservation().getUniqueID().getID());
        uniqueIDType.setType(toscaBookResponse.getPackageReservation().getUniqueID().getType());
        toscaBookCommitRequest.setUniqueID(uniqueIDType);
        return toscaBookCommitRequest;
    }
}
