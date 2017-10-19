package com.thomascook.ids.e2e.tests;

import com.thomascook.ontour.*;
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
import com.thomascook.wrAdapter.request.CompanyNameType;
import com.thomascook.wrAdapter.request.DealType;
import com.thomascook.wrAdapter.request.FullRetailDownload;
import com.thomascook.wrAdapter.request.Passenger;
import com.thomascook.wrAdapter.response.FullRetailDownloadResponse;
import cucumber.api.DataTable;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CreateBookingUK {

    public static OTAPkgSearchRS getSOLRPackagesUK(String solr, String departureAirport, String destination, DataTable dataTable)
            throws IOException, JAXBException, DatatypeConfigurationException {
        //Assign data from dataTable
        List<Map<String, String>> listOfMaps = dataTable.asMaps(String.class, String.class);

        //solr request
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(solr);
        String solrRequest = createSolrRequestUK(departureAirport, destination, listOfMaps);
        post.setEntity(new ByteArrayEntity(solrRequest.getBytes("UTF-8")));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        OTAPkgSearchRS otaPkgSearchRS = new OTAPkgSearchRS();
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgSearchRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                otaPkgSearchRS = (OTAPkgSearchRS) unmarshaller.unmarshal(instream);
            }
        }
        //createSolrRSXML(otaPkgSearchRS);
        return otaPkgSearchRS;
    }

    private static String createSolrRequestUK(String fromAirport, String destination, List<Map<String, String>> listOfMaps)
            throws JAXBException, DatatypeConfigurationException {
        org.opentravel.ota._2003._05.request.ObjectFactory factory = new org.opentravel.ota._2003._05.request.ObjectFactory();
        OTAPkgSearchRQ otaPkgSearchRQ = factory.createOTAPkgSearchRQ();

        FilterResultsType filterResultsType = factory.createFilterResultsType();
        filterResultsType.setStart(Integer.toString(10));
        filterResultsType.setEnd(Integer.toString(29));
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
        for (Map<String, String> passengers : listOfMaps) {
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
            if (numberOfAdults > 0) {
                PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
                guestCount.setAgeQualifyingCode("10");
                guestCount.setCount(numberOfAdults);
                guestCounts.add(guestCount);
            }
            int numberOfInfants = Integer.parseInt(infants);
            if (numberOfInfants > 0) {
                PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
                guestCount.setAgeQualifyingCode("7");
                guestCount.setCount(numberOfInfants);
                guestCounts.add(guestCount);
            }
            int numberOfChildren = Integer.parseInt(children);
            if (numberOfChildren > 0) {
                for (int i = 0; i < numberOfChildren; i++) {
                    PkgGuestCountType.GuestCount guestCount = factory.createPkgGuestCountTypeGuestCount();
                    guestCount.setAgeQualifyingCode("8");
                    guestCount.setCount(numberOfInfants);
                    int age = 3 + (int) Math.round(Math.random() * 14);
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
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(otaPkgSearchRQ, sw);

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
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaRequest, sw);
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
            InputStream instream = entity.getContent();
            JAXBContext jc = JAXBContext.newInstance(OTAPkgAvailRS.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            toscaAvailabilityResponse = (OTAPkgAvailRS) unmarshaller.unmarshal(instream);
        }
        return toscaAvailabilityResponse;
    }

    public static OTAPkgAvailRQ createToscaAvailabilityRequest(org.opentravel.ota._2003._05.response.HotelOfferType hotelOffer, DataTable passengers) {
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
        for (org.opentravel.ota._2003._05.response.SolrFieldType field : bookingIDType.getField()) {
            if (field.getName().equals("ID")) request.getPackageRequest().setID(field.getValue());
            if (field.getName().equals("TravelCode")) request.getPackageRequest().setTravelCode(field.getValue());
            if (field.getName().equals("ProductCode")) request.getPackageRequest().setProductCode(field.getValue());
            if (field.getName().equals("BrandCode")) request.getPackageRequest().setBrandCode(field.getValue());
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

        List<Map<String, String>> listOfMaps = passengers.asMaps(String.class, String.class);
        int numberOfAdults = 0;
        int numberOfChildren = 0;
        int numberOfInfants = 0;
        for (Map<String, String> map : listOfMaps) {
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
        for (com.thomascook.toscaAdapter.request.SourceType source : toscaAvailabilityRequest.getPOS().getSource()) {
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

        List<Map<String, String>> listOfMaps = passengers.asMaps(String.class, String.class);
        int numberOfRooms = 1;
        int passengerRPH = 1;
        for (Map<String, String> map : listOfMaps) {
            int numberOfAdults = Integer.parseInt(map.get("Adults"));
            int numberOfChildren = Integer.parseInt(map.get("Children"));
            int numberOfInfants = Integer.parseInt(map.get("Infants"));
            int numberOfPassengers = numberOfAdults + numberOfChildren;
            String roomTypeCode = "";
            String mealPlanCode = "";
            for (com.thomascook.toscaAdapter.response.ItineraryItemResponseType itineraryItemResponseType :
                    toscaAvailabilityResponse.getPackage().getItineraryItems().getItineraryItem()) {
                if (itineraryItemResponseType.getAccommodation() != null) {
                    for (com.thomascook.toscaAdapter.response.ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile roomProfileResponse :
                            itineraryItemResponseType.getAccommodation().getRoomProfiles().getRoomProfile()) {
                        if (numberOfPassengers >= roomProfileResponse.getMinOccupancy() && numberOfPassengers <= roomProfileResponse.getMaxOccupancy()) {
                            roomTypeCode = roomProfileResponse.getRoomTypeCode();
                            break;
                        }
                    }
                    for (com.thomascook.toscaAdapter.response.MealPlanType mealPlanType : itineraryItemResponseType.getAccommodation().getMealPlans().getMealPlan()) {
                        if (mealPlanType.getListOfRoomRPH().size() == itineraryItemResponseType.getAccommodation().getRoomProfiles().getRoomProfile().size()) {
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
            for (int adults = 0; adults < numberOfAdults; adults++) {
                PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
                passengerListItem.setQuantity(BigInteger.valueOf(1));
                passengerListItem.setCode("10");
                passengerListItem.setRPH(String.valueOf(passengerRPH++));
                passengerRPHs.getListOfPassengerRPH().add(passengerListItem.getRPH());
                passengerListItems.getPassengerListItem().add(passengerListItem);
            }
            for (int children = 0; children < numberOfChildren; children++) {
                PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
                passengerListItem.setQuantity(BigInteger.valueOf(1));
                passengerListItem.setCode("8");
                passengerListItem.setRPH(String.valueOf(passengerRPH++));
                passengerRPHs.getListOfPassengerRPH().add(passengerListItem.getRPH());
                passengerListItems.getPassengerListItem().add(passengerListItem);
            }
            for (int infants = 0; infants < numberOfInfants; infants++) {
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
            try (InputStream instream = entity.getContent()) {
                JAXBContext jc = JAXBContext.newInstance(OTAPkgExtrasInfoRS.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                toscaExtrasResponse = (OTAPkgExtrasInfoRS) unmarshaller.unmarshal(instream);
            }
        }
        return toscaExtrasResponse;
    }

    public static OTAPkgCostRQ createToscaCostRequest(OTAPkgExtrasInfoRS toscaExtrasResponse, OTAPkgExtrasInfoRQ toscaExtrasRequest) {
        ObjectFactory factory = new ObjectFactory();
        OTAPkgCostRQ toscaCostRequest = factory.createOTAPkgCostRQ();
        toscaCostRequest.setTarget("test");
        POSType posType = factory.createPOSType();
        for (com.thomascook.toscaExtrasAdapter.request.SourceType extrasSourceType : toscaExtrasRequest.getPOS().getSource()) {
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
        for (ItineraryItemRequestType extrasItineraryItems : toscaExtrasRequest.getPackageRequest().getItineraryItems().getItineraryItem()) {
            com.thomascook.toscaCostAdapter.request.ItineraryItemRequestType itineraryItemRequestType = factory.createItineraryItemRequestType();
            itineraryItems.getItineraryItem().add(itineraryItemRequestType);
            com.thomascook.toscaCostAdapter.request.AccommodationSegmentRequestType accommodation = factory.createAccommodationSegmentRequestType();
            itineraryItemRequestType.setAccommodation(accommodation);
            com.thomascook.toscaCostAdapter.request.AccommodationSegmentRequestType.RoomProfiles roomProfiles = factory.createAccommodationSegmentRequestTypeRoomProfiles();
            accommodation.setRoomProfiles(roomProfiles);
            for (RoomProfileType extrasRoomProfileType : extrasItineraryItems.getAccommodation().getRoomProfiles().getRoomProfile()) {
                com.thomascook.toscaCostAdapter.request.RoomProfileType roomProfileType = factory.createRoomProfileType();
                roomProfiles.getRoomProfile().add(roomProfileType);
                roomProfileType.setRoomTypeCode(extrasRoomProfileType.getRoomTypeCode());
                roomProfileType.setRPH(extrasRoomProfileType.getRPH());
                com.thomascook.toscaCostAdapter.request.RoomProfileType.PassengerRPHs passengerRPHs = factory.createRoomProfileTypePassengerRPHs();
                for (String listOfPassengersRPHs : extrasRoomProfileType.getPassengerRPHs().getListOfPassengerRPH()) {
                    passengerRPHs.getListOfPassengerRPH().add(listOfPassengersRPHs);
                }
                roomProfileType.setPassengerRPHs(passengerRPHs);
            }
            com.thomascook.toscaCostAdapter.request.AccommodationSegmentRequestType.MealPlans mealPlans = factory.createAccommodationSegmentRequestTypeMealPlans();
            accommodation.setMealPlans(mealPlans);
            for (MealPlanType extrasMealPlanType : extrasItineraryItems.getAccommodation().getMealPlans().getMealPlan()) {
                com.thomascook.toscaCostAdapter.request.MealPlanType mealPlanType = factory.createMealPlanType();
                mealPlanType.setCode(extrasMealPlanType.getCode());
                for (String roomRPH : extrasMealPlanType.getListOfRoomRPH()) {
                    mealPlanType.getListOfRoomRPH().add(roomRPH);
                }
                mealPlans.getMealPlan().add(mealPlanType);
            }
        }
        OTAPkgCostRQ.PassengerListItems passengerListItems = factory.createOTAPkgCostRQPassengerListItems();
        toscaCostRequest.setPassengerListItems(passengerListItems);
        for (PkgPassengerListItem extrasPkgPassengerListItem : toscaExtrasRequest.getPassengerListItems().getPassengerListItem()) {
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
        for (com.thomascook.toscaCostAdapter.request.PkgPassengerListItem pkgPassengerListItem : toscaCostRequest.getPassengerListItems().getPassengerListItem()) {
            if (!pkgPassengerListItem.getCode().equals("7")) {
                listOfPassengersRPHs.add(pkgPassengerListItem.getRPH());
            }
        }
        //todo uncomment after extras fix
        /*for(OTAPkgExtrasInfoRS.ExtraGroups.ExtraGroup extraGroup : toscaExtrasResponse.getExtraGroups().getExtraGroup()){
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
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaExtrasRequest, sw);
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
        for (SourceType costSourceType : toscaCostRequest.getPOS().getSource()) {
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
        for (com.thomascook.toscaCostAdapter.request.ItineraryItemRequestType costItineraryItems : toscaCostRequest.getPackageRequest().getItineraryItems().getItineraryItem()) {
            com.thomascook.toscaBookAdapter.request.ItineraryItemRequestType itineraryItemRequestType = factory.createItineraryItemRequestType();
            itineraryItems.getItineraryItem().add(itineraryItemRequestType);
            com.thomascook.toscaBookAdapter.request.AccommodationSegmentRequestType accommodation = factory.createAccommodationSegmentRequestType();
            itineraryItemRequestType.setAccommodation(accommodation);
            com.thomascook.toscaBookAdapter.request.AccommodationSegmentRequestType.RoomProfiles roomProfiles = factory.createAccommodationSegmentRequestTypeRoomProfiles();
            accommodation.setRoomProfiles(roomProfiles);
            for (com.thomascook.toscaCostAdapter.request.RoomProfileType costRoomProfileType : costItineraryItems.getAccommodation().getRoomProfiles().getRoomProfile()) {
                com.thomascook.toscaBookAdapter.request.RoomProfileType roomProfileType = factory.createRoomProfileType();
                roomProfiles.getRoomProfile().add(roomProfileType);
                roomProfileType.setRoomTypeCode(costRoomProfileType.getRoomTypeCode());
                roomProfileType.setRPH(costRoomProfileType.getRPH());
                com.thomascook.toscaBookAdapter.request.RoomProfileType.PassengerRPHs passengerRPHs = factory.createRoomProfileTypePassengerRPHs();
                for (String listOfPassengersRPHs : costRoomProfileType.getPassengerRPHs().getListOfPassengerRPH()) {
                    passengerRPHs.getListOfPassengerRPH().add(listOfPassengersRPHs);
                }
                roomProfileType.setPassengerRPHs(passengerRPHs);
            }
            com.thomascook.toscaBookAdapter.request.AccommodationSegmentRequestType.MealPlans mealPlans = factory.createAccommodationSegmentRequestTypeMealPlans();
            accommodation.setMealPlans(mealPlans);
            for (com.thomascook.toscaCostAdapter.request.MealPlanType extrasMealPlanType : costItineraryItems.getAccommodation().getMealPlans().getMealPlan()) {
                com.thomascook.toscaBookAdapter.request.MealPlanType mealPlanType = factory.createMealPlanType();
                mealPlanType.setCode(extrasMealPlanType.getCode());
                for (String roomRPH : extrasMealPlanType.getListOfRoomRPH()) {
                    mealPlanType.getListOfRoomRPH().add(roomRPH);
                }
                mealPlans.getMealPlan().add(mealPlanType);
            }
        }
        OTAPkgBookRQ.PassengerListItems passengerListItems = factory.createOTAPkgBookRQPassengerListItems();
        toscaBookRequest.setPassengerListItems(passengerListItems);
        boolean namePrefix = true;
        for (com.thomascook.toscaCostAdapter.request.PkgPassengerListItem extrasPkgPassengerListItem : toscaCostRequest.getPassengerListItems().getPassengerListItem()) {
            com.thomascook.toscaBookAdapter.request.PkgPassengerListItem passengerListItem = factory.createPkgPassengerListItem();
            //<PassengerListItem Quantity="1" Code="10" BirthDate="1986-01-01Z" RPH="1" />
            passengerListItem.setQuantity(extrasPkgPassengerListItem.getQuantity());
            passengerListItem.setCode(extrasPkgPassengerListItem.getCode());
            passengerListItem.setBirthDate(extrasPkgPassengerListItem.getBirthDate());
            if (extrasPkgPassengerListItem.getRPH().equals("1")) {
                passengerListItem.setRPH(extrasPkgPassengerListItem.getRPH());
                passengerListItem.setLeadCustomerInd(true);
                com.thomascook.toscaBookAdapter.request.PersonNameType personNameType = factory.createPersonNameType();
                passengerListItem.setName(personNameType);
                String lastName = generateAZSequence("lastname");
                personNameType.setSurname(lastName);
                String firstName = generateAZSequence("firstname");
                personNameType.getGivenName().add(firstName);
                //if person code = 10 set name prefix to Mr or Mrs
                if (extrasPkgPassengerListItem.getCode().equals("10")) {
                    if (namePrefix) {
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
                telephone.setAreaCityCode("0" + RandomStringUtils.randomNumeric(2, 2));
                //add phone number
                telephone.setPhoneNumber(RandomStringUtils.randomNumeric(8, 8));
                contactPersonType.getTelephone().add(telephone);
                com.thomascook.toscaBookAdapter.request.EmailType emailType = factory.createEmailType();
                emailType.setValue(firstName + "." + lastName + "@thomascookonline.com");
                contactPersonType.getEmail().add(emailType);
                com.thomascook.toscaBookAdapter.request.AddressInfoType addressInfoType = factory.createAddressInfoType();
                addressInfoType.getAddressLine().add("East");
                addressInfoType.getAddressLine().add("The Piazza");
                com.thomascook.toscaBookAdapter.request.AddressType.StreetNmbr streetNmbr = factory.createAddressTypeStreetNmbr();
                streetNmbr.setValue("16");
                addressInfoType.setStreetNmbr(streetNmbr);
                addressInfoType.setPostalCode("WC2E8HD");
                addressInfoType.setCityName("London");
                com.thomascook.toscaBookAdapter.request.AddressType.BldgRoom bldgRoom = factory.createAddressTypeBldgRoom();
                bldgRoom.setValue("16");
                addressInfoType.getBldgRoom().add(bldgRoom);
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
                personNameType.setSurname(generateAZSequence("firstname"));
                personNameType.getGivenName().add(generateAZSequence("firstname"));
                //if person code = 10 set name prefix to Mr or Mrs
                if (extrasPkgPassengerListItem.getCode().equals("10")) {
                    if (namePrefix) {
                        personNameType.getNamePrefix().add("Mr");
                        namePrefix = false;
                    } else {
                        personNameType.getNamePrefix().add("Mrs");
                        namePrefix = true;
                    }
                }
                if(extrasPkgPassengerListItem.getCode().equals("8")){
                    //miss or master
                    personNameType.getNamePrefix().add(returnRandomKidsSalutation());
                    passengerListItem.setBirthDate(generateBirthDate(true));
                }
                if(extrasPkgPassengerListItem.getCode().equals("7")){
                    personNameType.getNamePrefix().add(returnRandomKidsSalutation());
                    passengerListItem.setBirthDate(generateBirthDate(false));
                }
            }
            passengerListItems.getPassengerListItem().add(passengerListItem);
        }

        com.thomascook.toscaBookAdapter.request.PackageType.Extras extras = factory.createPackageTypeExtras();
        toscaBookRequest.getPackageRequest().setExtras(extras);
        for (com.thomascook.toscaCostAdapter.request.ExtrasType costExtrasType : toscaCostRequest.getExtras().getExtra()) {
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

    private static String returnRandomKidsSalutation(){
        String salutation = "";
        Random r = new Random();
        if(r.nextInt(2) == 1){
            salutation = "Miss";
        } else {
            salutation = "Master";
        }
        return salutation;
    }

    public static String createToscaExtrasResponseXML(OTAPkgExtrasInfoRS toscaExtrasResponse) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaExtrasAdapter.response");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaExtrasResponse, sw);
        return sw.toString();
    }

    public static void createOnTourXML(OTAPkgBookRS toscaBookingResponse, OTAPkgBookRQ toscaBookingRequest, String bookingReference) throws JAXBException {
        Shipment shipment = new Shipment();
        shipment.setIdentifier(1);
        shipment.setEmitter_code("");
        shipment.setOffice_code("23");
        shipment.setNumber_booking(1);
        shipment.setVersion("01.00.09");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        shipment.setShipment_date(today.format(formatter));
        Booking booking = new Booking();
        shipment.setBooking(Arrays.asList(booking));
        booking.setStatus("A");
        booking.setLocalizer(bookingReference);
        booking.setPnr_version(1);
        booking.setExt_pnr_version(1);
        booking.setDate(today.format(formatter));
        booking.setAmendment_date(today.format(formatter));
        booking.setExt_amendment_date(today.format(formatter));
        String beginning_dateSTR = toscaBookingResponse.getPackageReservation().getPackage().getDateRange().getStart();
        String durationSTR = toscaBookingResponse.getPackageReservation().getPackage().getDateRange().getDuration();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate biginningDate = LocalDate.parse(beginning_dateSTR, inputFormatter);
        int duration = Integer.parseInt(durationSTR.replace("P", "").replace("D", ""));
        LocalDate endDate = biginningDate.plus(duration,ChronoUnit.DAYS);
        booking.setBeginning_date(biginningDate.format(outputFormatter));
        booking.setEnd_date(endDate.format(outputFormatter));
        booking.setProduct_code("S17");
        booking.setTo_code("TCUK");
        booking.setBrand("TCU1");
        booking.setBrochure_code("TGS1");
        booking.setLatebooking("N");
        booking.setDestination(toscaBookingResponse.getPackageReservation().getPackage().getTravelCode().substring(0,3));

        List<Pax> paxes = new ArrayList<>();
        for(com.thomascook.toscaBookAdapter.response.PkgPassengerListItem passengerListItem : toscaBookingResponse.getPackageReservation().getPassengerListItems().getPassengerListItem()){
            Pax pax = new Pax();
            pax.setName(passengerListItem.getName().getGivenName().get(0));
            pax.setSurname(passengerListItem.getName().getSurname());
            LocalDate birthDate;
            DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            if(Integer.parseInt(passengerListItem.getCode()) == 10){
                birthDate = LocalDate.now().minus(35, ChronoUnit.YEARS);
                pax.setAge(Period.between(birthDate,LocalDate.now()).getYears());
                pax.setBirth_date(birthDate.format(birthDateFormatter));
            }else{
                birthDate = passengerListItem.getBirthDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                pax.setBirth_date(birthDate.format(birthDateFormatter));
                pax.setAge(Period.between(birthDate,LocalDate.now()).getYears());
            }
            if(pax.getAge()<2){
                pax.setSex("I");
            } else if(pax.getAge()>2 && pax.getAge()<16){
                pax.setSex("C");
            }else{
                if (passengerListItem.getGender().equals("Female")){
                    pax.setSex("F");
                }else if(passengerListItem.getGender().equals("Male")){
                    pax.setSex("M");
                }
            }
            //pax.setSex(passengerListItem.getGender());
            pax.setJust_married("N");
            pax.setIdentifier(Integer.parseInt(passengerListItem.getRPH()));
            pax.setLanguage("");
            paxes.add(pax);
        }
        booking.setPax(paxes);

        List<Service> services = new ArrayList<>();
        booking.setService(services);
        int order = 1;
        for(com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType itineraryItemRequestType : toscaBookingResponse.getPackageReservation().getPackage().getItineraryItems().getItineraryItem()){
            if(!(itineraryItemRequestType.getFlight()==null)) {
                com.thomascook.toscaBookAdapter.response.PkgFlightSegmentType flightSegmentType = itineraryItemRequestType.getFlight();
                Service service = new Service();
                service.setCode(flightSegmentType.getOperatingAirline().getCode() + flightSegmentType.getOperatingAirline().getFlightNumber());
                service.setType("FL");
                service.setName(service.getCode());
                service.setOrder(order++);
                if(itineraryItemRequestType.getItinerarySequence().intValue()==1){
                    service.setTransfer_type("IN");
                }else{
                    service.setTransfer_type("OUT");
                }
                service.setOrigin(flightSegmentType.getDepartureAirport().getLocationCode());
                service.setDestination(flightSegmentType.getArrivalAirport().getLocationCode());
                service.setCarrier_code(flightSegmentType.getOperatingAirline().getCode());
                service.setCarrier_flight_code(flightSegmentType.getOperatingAirline().getFlightNumber());
                service.setIdentifier(flightSegmentType.getOperatingAirline().getCode() + flightSegmentType.getOperatingAirline().getFlightNumber()+
                        flightSegmentType.getDepartureAirport().getLocationCode()+flightSegmentType.getArrivalAirport().getLocationCode());
                service.setNumberofunits(booking.getPax().size());

                List<Pax_service> pax_services = new ArrayList<>();
                service.setPax_service(pax_services);
                for(Pax pax : booking.getPax()){
                    Pax_service pax_service = new Pax_service();
                    List<Pax_service_assignment> pax_service_assignments = new ArrayList<>();
                    pax_service.setPax_service_assignment(pax_service_assignments);
                    Pax_service_assignment pax_service_assignment = new Pax_service_assignment();
                    pax_service_assignment.setPax_identifier(pax.getIdentifier());
                    pax_service.getPax_service_assignment().add(pax_service_assignment);
                    service.getPax_service().add(pax_service);
                }
                booking.getService().add(service);
            }
        }
        for(com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType itineraryItemRequestType : toscaBookingResponse.getPackageReservation().getPackage().getItineraryItems().getItineraryItem()){
            if(!(itineraryItemRequestType.getAccommodation()==null)){
                com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType.Accommodation accommodation = itineraryItemRequestType.getAccommodation();
                int roomProfileIndex = 1;
                for(com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile roomProfile : accommodation.getRoomProfiles().getRoomProfile()) {
                    Service service = new Service();
                    service.setCode(accommodation.getIdentity().getHotelCode());
                    service.setType("RM");
                    service.setName(accommodation.getIdentity().getHotelName());
                    service.setOrder(order++);

                    LocalDate beginningDate = LocalDate.parse(accommodation.getDateRange().getStart(), inputFormatter);
                    service.setBeginning_date(beginningDate.format(outputFormatter));
                    service.setBeginning_time("0000");
                    LocalDate end_Date = LocalDate.parse(accommodation.getDateRange().getEnd(), inputFormatter);
                    service.setEnd_date(end_Date.format(outputFormatter));
                    service.setEnd_time("0000");
                    service.setAccomodation(roomProfile.getRoomTypeCode());
                    for(com.thomascook.toscaBookAdapter.response.MealPlanType mealPlanType: accommodation.getMealPlans().getMealPlan()){
                        if(mealPlanType.getListOfRoomRPH().contains(String.valueOf(roomProfileIndex))){
                            service.setBoard(mealPlanType.getCode());
                        }
                    }
                    service.setShared_room_type("N");
                    service.setStatus("OK");
                    service.setOccupancy(String.valueOf(roomProfile.getGuestCounts().getGuestCount().size()));
                    service.setNumberofunits(1);
                    service.setTransfer_code("G");
                    service.setExternal_service_flag("I");

                    List<Pax_service> pax_services = new ArrayList<>();
                    service.setPax_service(pax_services);

                    for (com.thomascook.toscaBookAdapter.request.ItineraryItemRequestType itineraryItemRequestTypePassengers : toscaBookingRequest.getPackageRequest().getItineraryItems().getItineraryItem()) {
                        if(!(itineraryItemRequestTypePassengers.getAccommodation()==null)){
                            for(com.thomascook.toscaBookAdapter.request.RoomProfileType roomProfileType : itineraryItemRequestTypePassengers.getAccommodation().getRoomProfiles().getRoomProfile()){
                                if(roomProfileType.getRoomTypeCode().equals(roomProfile.getRoomTypeCode()) && roomProfileType.getPassengerRPHs().getListOfPassengerRPH().size()==roomProfile.getGuestCounts().getGuestCount().size()){
                                    for(String serviceAssignment : roomProfileType.getPassengerRPHs().getListOfPassengerRPH()) {
                                        Pax_service pax_service = new Pax_service();
                                        List<Pax_service_assignment> pax_service_assignments = new ArrayList<>();
                                        pax_service.setPax_service_assignment(pax_service_assignments);
                                        Pax_service_assignment pax_service_assignment = new Pax_service_assignment();
                                        pax_service_assignment.setPax_identifier(Integer.parseInt(serviceAssignment));
                                        pax_service.getPax_service_assignment().add(pax_service_assignment);
                                        service.getPax_service().add(pax_service);
                                    }
                                }
                            }
                        }
                    }
                    roomProfileIndex++;
                    booking.getService().add(service);
                }
            }
        }
        JAXBContext context = JAXBContext.newInstance(Shipment.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(shipment, sw);
        System.out.println(sw);
    }

    public static String createToscaBookRequestXML(OTAPkgBookRQ toscaBookRequest) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com.thomascook.toscaBookAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(toscaBookRequest, sw);
        return sw.toString();
    }

    private static String generateAZSequence(String string){
        String sequence = "";
        if(string.equals("lastname")){
            sequence = RandomStringUtils.randomAlphabetic(new Random().nextInt(6)+6);
        }
        if(string.equals("firstname")){
            sequence = RandomStringUtils.randomAlphabetic(new Random().nextInt(3)+6);
        }
        if(string.equals("transactionId")){
            sequence = RandomStringUtils.randomAlphabetic(29);
        }
        return sequence;
    }

    private static XMLGregorianCalendar generateBirthDate(boolean child) throws DatatypeConfigurationException {
        int daysOfLife;
        LocalDate localDate = LocalDate.now();
        LocalDate birthDate;
        if (child) {
            daysOfLife = new Random().nextInt(365 * 16 - 1) + 365 * 2;
            birthDate = localDate.minus(daysOfLife, ChronoUnit.DAYS);
        } else {
            daysOfLife = new Random().nextInt(365 * 2 - 1);
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

    public static String createWebRioRequest(OTAPkgBookRQ toscaBookingRequest, OTAPkgBookRS toscaBookingResponse, org.opentravel.ota._2003._05.response.HotelOfferType hotelOffer, String bookingReference) throws JAXBException {
        com.thomascook.wrAdapter.request.ObjectFactory factory = new com.thomascook.wrAdapter.request.ObjectFactory();
        FullRetailDownload wrRequest = factory.createFullRetailDownload();
        wrRequest.setActionType(com.thomascook.wrAdapter.request.TransactionActionType.COMMIT);
        wrRequest.setRequestedCurrency("GBP");
        wrRequest.setExpectedGrossAmount(toscaBookingResponse.getPackageReservation().getInvoiceDetail().getGrossAmount().getAmount());
        wrRequest.setTarget("Test");
        wrRequest.setVersion(BigDecimal.valueOf(0.0));
        com.thomascook.wrAdapter.request.POSType pos = factory.createPOSType();
        wrRequest.setPOS(pos);
        wrRequest.setTransactionIdentifier(generateAZSequence("transactionId"));
        for(com.thomascook.toscaBookAdapter.request.SourceType sourceType :toscaBookingRequest.getPOS().getSource()){
            com.thomascook.wrAdapter.request.SourceType sourceTypeWR = factory.createSourceType();
            sourceTypeWR.setISOCountry(sourceType.getISOCountry());
            sourceTypeWR.setISOCurrency(sourceType.getISOCurrency());
            sourceTypeWR.setERSPUserID("100");
            pos.getSource().add(sourceTypeWR);
            com.thomascook.wrAdapter.request.SourceType.RequestorID requestorID = factory.createSourceTypeRequestorID();
            requestorID.setType("23");
            requestorID.setID(sourceType.getRequestorID().getID());
            requestorID.setMessagePassword("TCWEBHANDOFF");
            sourceTypeWR.setRequestorID(requestorID);
            CompanyNameType companyNameType = factory.createCompanyNameType();
            companyNameType.setCode("TC");
            companyNameType.setCodeContext("TC");
            requestorID.setCompanyName(companyNameType);
        }
        com.thomascook.wrAdapter.request.ContactPersonType contactPersonType = factory.createContactPersonType();
        wrRequest.setCustomerDetails(contactPersonType);
        contactPersonType.setEmailOptIn(false);
        contactPersonType.setSMSOptIn(false);
        com.thomascook.wrAdapter.request.PersonNameType personNameType = factory.createPersonNameType();
        contactPersonType.setPersonName(personNameType);
        for(String namePrefix : toscaBookingRequest.getContactDetail().getPersonName().getNamePrefix()){
            personNameType.getNamePrefix().add(namePrefix);
        }
        for(String givenName : toscaBookingRequest.getContactDetail().getPersonName().getGivenName()){
            personNameType.getGivenName().add(givenName);
        }
        personNameType.setSurname(toscaBookingRequest.getContactDetail().getPersonName().getSurname());
        for(com.thomascook.toscaBookAdapter.request.ContactPersonType.Telephone telephoneTosca : toscaBookingRequest.getContactDetail().getTelephone()){
            com.thomascook.wrAdapter.request.ContactPersonType.Telephone telephone = factory.createContactPersonTypeTelephone();
            telephone.setAreaCityCode(telephoneTosca.getAreaCityCode());
            telephone.setPhoneNumber(telephoneTosca.getPhoneNumber());
            telephone.setPhoneTechType(telephoneTosca.getPhoneTechType());
            telephone.setPhoneUseType(telephoneTosca.getPhoneUseType());
            contactPersonType.getTelephone().add(telephone);
        }
        for(com.thomascook.toscaBookAdapter.request.EmailType emailTypeTosca : toscaBookingRequest.getContactDetail().getEmail()){
            contactPersonType.getEmail().add(emailTypeTosca.getValue());
        }
        for(com.thomascook.toscaBookAdapter.request.AddressInfoType addressInfoTypeTosca : toscaBookingRequest.getContactDetail().getAddress()){
            com.thomascook.wrAdapter.request.AddressInfoType addressInfoType = factory.createAddressInfoType();
            addressInfoType.setCityName(addressInfoTypeTosca.getCityName());
            addressInfoType.setPostalCode(addressInfoTypeTosca.getPostalCode());
            for(com.thomascook.toscaBookAdapter.request.AddressType.BldgRoom bldgRoomTosca :addressInfoTypeTosca.getBldgRoom()){
                addressInfoType.getBldgRoom().add(bldgRoomTosca.getValue());
            }
            for(String addressLine : addressInfoTypeTosca.getAddressLine()){
                addressInfoType.getAddressLine().add(addressLine);
            }
            contactPersonType.getAddress().add(addressInfoType);
        }
        FullRetailDownload.PaymentDetails paymentDetails = factory.createFullRetailDownloadPaymentDetails();
        wrRequest.setPaymentDetails(paymentDetails);
        FullRetailDownload.PaymentDetails.PaymentDetail paymentDetail = factory.createFullRetailDownloadPaymentDetailsPaymentDetail();
        paymentDetails.getPaymentDetail().add(paymentDetail);
        com.thomascook.wrAdapter.request.PaymentCardType paymentCardType = factory.createPaymentCardType();
        paymentDetail.setPaymentCard(paymentCardType);
        paymentCardType.setCardCode("MC");
        paymentCardType.setCardNumber("2222222222222222");
        LocalDate localDate = LocalDate.now();
        LocalDate future = localDate.plus(1, ChronoUnit.YEARS);
        int year = future.getYear();
        paymentCardType.setExpireDate("02" + String.valueOf(year).substring(2,4));
        paymentCardType.setCardHolderName("test test");
        paymentCardType.setAddress(wrRequest.getCustomerDetails().getAddress().get(0));
        com.thomascook.wrAdapter.request.PaymentDetailType.PaymentAmount paymentAmount = factory.createPaymentDetailTypePaymentAmount();
        paymentDetail.getPaymentAmount().add(paymentAmount);
        paymentAmount.setAmount(wrRequest.getExpectedGrossAmount());
        paymentAmount.setApprovalCode("12345");
        paymentAmount.setAuthenticationCAVV("");
        paymentAmount.setCCCharge(BigDecimal.valueOf(0.0));
        paymentAmount.setCurrencyCode(wrRequest.getRequestedCurrency());
        DealType dealType = factory.createDealType();
        wrRequest.setDealDetails(dealType);
        DealType.BookingWebRequest bookingWebRequest = factory.createDealTypeBookingWebRequest();
        dealType.setBookingWebRequest(bookingWebRequest);
        DealType.BookingWebRequest.XMLFileDefinition xmlFileDefinition = factory.createDealTypeBookingWebRequestXMLFileDefinition();
        bookingWebRequest.setXMLFileDefinition(xmlFileDefinition);
        xmlFileDefinition.setFileCode("10");
        xmlFileDefinition.setFileDescription("FileDescription");
        xmlFileDefinition.setFileSupplier("TCCOM");
        /*			<AssociatedRequest>
				<BranchBudgetCtr>5300</BranchBudgetCtr>
				<AbtaNumber>J9375</AbtaNumber>
			</AssociatedRequest>
			*/
        DealType.BookingWebRequest.AssociatedRequest associatedRequest = factory.createDealTypeBookingWebRequestAssociatedRequest();
        bookingWebRequest.setAssociatedRequest(associatedRequest);
        associatedRequest.setBranchBudgetCtr(BigInteger.valueOf(5300));
        associatedRequest.setAbtaNumber(wrRequest.getPOS().getSource().get(0).getRequestorID().getID());
        DealType.BookingWebRequest.BookingResponse bookingResponse = factory.createDealTypeBookingWebRequestBookingResponse();
        bookingWebRequest.setBookingResponse(bookingResponse);
        DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday chosenPackageHoliday = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHoliday();
        bookingResponse.setChosenPackageHoliday(chosenPackageHoliday);
        //DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.Accommodation.AccommodationUnit accommodationUnit = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayAccommodationAccommodationUnit();
        //DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.TravelSegment travelSegment = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayTravelSegment();
        for(com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType itineraryItemRequestType : toscaBookingResponse.getPackageReservation().getPackage().getItineraryItems().getItineraryItem()){
            if(!(itineraryItemRequestType.getFlight() == null)){
                DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.TravelSegment travelSegment = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayTravelSegment();
                XMLGregorianCalendar departureDateTime = itineraryItemRequestType.getFlight().getDepartureDateTime();
                XMLGregorianCalendar arrivalDateTime = itineraryItemRequestType.getFlight().getArrivalDateTime();
                LocalDateTime localDepartureDateTime = departureDateTime.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
                LocalDateTime localArrivalDateTime = arrivalDateTime.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
                travelSegment.setArrivalDate(dateFormatter.format(localArrivalDateTime));
                travelSegment.setArrivalPoint(itineraryItemRequestType.getFlight().getArrivalAirport().getLocationCode());
                travelSegment.setArrivalTime(timeFormatter.format(localArrivalDateTime));

                travelSegment.setDepartureDate(dateFormatter.format(localDepartureDateTime));
                travelSegment.setDeparturePoint(itineraryItemRequestType.getFlight().getDepartureAirport().getLocationCode());
                travelSegment.setDepartureTime(timeFormatter.format(localDepartureDateTime));
                travelSegment.setFlightNumber(itineraryItemRequestType.getFlight().getOperatingAirline().getCode() + itineraryItemRequestType.getFlight().getOperatingAirline().getFlightNumber());
                travelSegment.setStatus("confirmed");
                travelSegment.setTransportMode("FC");

                //travelSegment.setClazz();
                if(travelSegment.getDeparturePoint().equals(hotelOffer.getFlights().getInboundFlight().getDepartureAirport().getLocationCode())){
                    String clazz = "";
                    if(hotelOffer.getFlights().getInboundFlight().getServiceClass().equals("Y")){
                        travelSegment.setClazz("Economy");
                    }else{
                        travelSegment.setClazz("Business");
                    }
                }else{
                    String clazz = "";
                    if(hotelOffer.getFlights().getOutboundFlight().getServiceClass().equals("Y")){
                        travelSegment.setClazz("Economy");
                    }else{
                        travelSegment.setClazz("Business");
                    }
                }
                hotelOffer.getFlights().getInboundFlight().getServiceClass();
                chosenPackageHoliday.getTravelSegment().add(travelSegment);
            }
            if(!(itineraryItemRequestType.getAccommodation() == null)){
                DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.Accommodation accommodation = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayAccommodation();
                //accommodation.setDeparturePoint();
                accommodation.setAccommodationCode(itineraryItemRequestType.getAccommodation().getIdentity().getHotelCode());
                accommodation.setProductName("A");
                accommodation.setAccommodationName(itineraryItemRequestType.getAccommodation().getIdentity().getHotelName());
                accommodation.setResortName(itineraryItemRequestType.getAccommodation().getResortName());
                accommodation.setStartDate(itineraryItemRequestType.getAccommodation().getDateRange().getStart().replace("-", ""));
                accommodation.setEndDate(itineraryItemRequestType.getAccommodation().getDateRange().getEnd().replace("-", ""));
                for(com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile roomProfile : itineraryItemRequestType.getAccommodation().getRoomProfiles().getRoomProfile()){
                    DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.Accommodation.AccommodationUnit accommodationUnit = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayAccommodationAccommodationUnit();
                    accommodationUnit.setName(roomProfile.getDescription().split(",")[0]);
                    accommodationUnit.setNumRooms(BigInteger.valueOf(roomProfile.getQuantity()));
                    accommodation.getAccommodationUnit().add(accommodationUnit);
                }

                for(com.thomascook.toscaBookAdapter.response.ItineraryItemResponseType itineraryItemRequestType1 :toscaBookingResponse.getPackageReservation().getPackage().getItineraryItems().getItineraryItem()){
                    if(!(itineraryItemRequestType1.getAccommodation() == null)){
                        accommodation.setBoardCode(itineraryItemRequestType1.getAccommodation().getMealPlans().getMealPlan().get(0).getCode());
                    }
                }

                accommodation.setNumNights(BigInteger.valueOf(Integer.parseInt(toscaBookingResponse.getPackageReservation().getPackage().getDateRange().getDuration().replace("P", "").replace("D", ""))));
                chosenPackageHoliday.getAccommodation().add(accommodation);
            }
        }
        DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.BookingInfo bookingInfo = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayBookingInfo();
        chosenPackageHoliday.setBookingInfo(bookingInfo);
        bookingInfo.setBookingReference(bookingReference);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        String bookingDateTime = dtf.format(now);
        bookingInfo.setBookingDateTime(bookingDateTime);
        DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.AtolCertificate atolCertificate = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayAtolCertificate();
        atolCertificate.setAtolType("1");
        chosenPackageHoliday.getAtolCertificate().add(atolCertificate);
        String leadPassenger = "";
        boolean missOrMaster = true;
        for(com.thomascook.toscaBookAdapter.response.PkgPassengerListItem passengerListItem :toscaBookingResponse.getPackageReservation().getPassengerListItems().getPassengerListItem()){
            Passenger passenger = factory.createPassenger();
            if(leadPassenger.equals("")){
                passenger.setLeadPassenger(true);
                leadPassenger = "no";
            }
            if(passengerListItem.getCode().equals("10")){
                LocalDate dob = LocalDate.now().minus(30,ChronoUnit.YEARS);
                DateTimeFormatter dtfDOB = DateTimeFormatter.ofPattern("yyyyMMdd");
                passenger.setDOB(dtfDOB.format(dob));
                if(passengerListItem.getName().getNamePrefix().get(0).equals("MR")){
                    passenger.setTitle("Mr");
                }
                if (passengerListItem.getName().getNamePrefix().get(0).equals("MRS")){
                    passenger.setTitle("Mrs");
                }
            }else{
                LocalDate dob = passengerListItem.getBirthDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                DateTimeFormatter dtfDOB = DateTimeFormatter.ofPattern("yyyyMMdd");
                passenger.setDOB(dtfDOB.format(dob));
                if(missOrMaster) {
                    passenger.setTitle("Miss");
                    missOrMaster = !missOrMaster;
                } else {
                    passenger.setTitle("Master");
                    missOrMaster = !missOrMaster;
                }
            }
            passenger.setFirstname(passengerListItem.getName().getGivenName().get(0));
            passenger.setSurname(passengerListItem.getName().getSurname());
            chosenPackageHoliday.getPassenger().add(passenger);
        }
        chosenPackageHoliday.setBrochureCode(toscaBookingResponse.getPackageReservation().getPackage().getProductCode());
        chosenPackageHoliday.setCurrentBookingStage("confirmed");
        chosenPackageHoliday.setProductType("PH");
        chosenPackageHoliday.setProductCode(toscaBookingResponse.getPackageReservation().getPackage().getBrandCode());
        chosenPackageHoliday.setOperatorCode(toscaBookingResponse.getPackageReservation().getPackage().getBrandCode());

        DealType.BookingWebRequest.BookingResponse.ChosenPackageHoliday.Cost cost = factory.createDealTypeBookingWebRequestBookingResponseChosenPackageHolidayCost();
        cost.setCurrency(toscaBookingResponse.getCurrencyCode());
        cost.setTotalOperatorCost(toscaBookingResponse.getPackageReservation().getInvoiceDetail().getGrossAmount().getAmount());
        chosenPackageHoliday.setCost(cost);

        JAXBContext context = JAXBContext.newInstance("com.thomascook.wrAdapter.request");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(wrRequest, sw);
        System.out.println(sw);
        return sw.toString();
    }

    public static FullRetailDownloadResponse sendWebrioHandoff(String retailinterfaceXML, String retailinterface) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPut put = new HttpPut(retailinterface);
        put.addHeader("Content-Type", "text/xml");
        put.setEntity(new ByteArrayEntity(retailinterfaceXML.getBytes("UTF-8")));
        HttpResponse response = client.execute(put);
        HttpEntity entity = response.getEntity();
        FullRetailDownloadResponse webrioResponse = new FullRetailDownloadResponse();
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                JAXBContext jc = JAXBContext.newInstance(FullRetailDownloadResponse.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                webrioResponse = (FullRetailDownloadResponse) unmarshaller.unmarshal(instream);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return webrioResponse;
    }

}
