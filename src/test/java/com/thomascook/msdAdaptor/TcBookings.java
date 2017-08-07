package com.thomascook.msdAdaptor;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.sun.nio.sctp.IllegalReceiveException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class TcBookings {

    private static final String TC_BOOKINGS_CONTEXT_FOLDER = "tc_bookings";
    private static final String TC_BOOKING_ACCOMMODATION_CONTEXT_FOLDER = "tc_bookingaccommodations";
    private static final String TC_BOOKING_EXTRA_SERVICES_CONTEXT_FOLDER = "tc_bookingextraservices";
    private static final String TC_BOOKING_TRANSFERS_CONTEXT_FOLDER = "tc_bookingtransfers";
    private static final String TC_BOOKING_TRANSPORTS_CONTEXT_FOLDER = "tc_bookingtransports";
    private static final String CONTACTS_SERVICE_CONTEXT_FOLDER = "contacts";

    private static final String login = "tcgdyncrmtest@thomascook.com";
    private static final String password = "1LetMeInPlease_247a!Some9nums6here#OMG-come_on!!";

    private static final Map<String, String> COOKIES_MAP;

    private static final String VALUE_TC_BOOKINGID_JSONPATH = "value.tc_bookingid";
    private static final String TC_ACCOMMODATION_PAX_JSONPATH = "value[0].tc_participants";
    private static final String PAX_DELIMITER_REGEX = ",*\\r\\n";
    private static final String BASE_PATH_PREFIX = "/api/data/v8.2/";
    private static final String CUSTOMER_GUID_KEY_IN_CUSTOMER_ROLES = "_tc_customer_value";
    private static final String CUSTOMERBOOKINGROLES_SERVICE_TITLE = "tc_customerbookingroles";
    private static final String TC_BOOKINGID_VALUE_KEY = "_tc_bookingid_value";

    public TcBookings(String baseUrl) {
        RestAssured.baseURI = String.format("https://%s", baseUrl);

//        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//        authScheme.setUserName(login);
//        authScheme.setPassword(password);

    }

    static {
        COOKIES_MAP = new HashMap<>();

        COOKIES_MAP.put("MSISAuth1", "Q3hybCtLMmxBUnl5MjRxYmEwa25mVDQyN0xDdERzL2dzMHNXc05ReS9QU3hWL2dUc0hvU1V2bzZ4WXU2UDEzeEdYTUJzUFFTbkRLY2RxWFlzZkxwSWxTTEw1Y3E5S2poY3NvcldHZFc1QTJGMVcxaERJcXN2dmNrREZxVlJES3VVV2pPb2F1TmpPTTBiYkhIcGRnN2xOVSs5QjRVMGlxcHpvRnhST01qaXVOR3RIMVBDZzUxMjVVK2FUWjQ1Y2RzTGtJTkYvd2RiN2FLSFk1aWk2cTJndlkyZVY2c0Q3S3djNXYvV2k4TEs4VmUwRERVaXc4TFdlQTZJRFpmMTFlcFdpOXAreGoyYm5jWUU2R1Y2MXBER2d4YjRJeVpEeFNQUmM0ZzJyQlRjRDJsVEVXYTZTeFEvaU1kd1lLZ2FlOTg5bEllNEZlOEpaZHJwMHByOWF3bG9xWXdEd2ZBMHRYQ2tFd0Qxd2FxQThML01XelFZTE1paGNUZU5TMjM2aTdPYnBlVjRPODZtckdLZ01EaEFuSzhMcEV5bWFNTHNMOTVoMk9TaCtoZHNGU0hrNENJQTVyOVVYb2ZKTHRTanJhVVR1OUt2d3pGV1VMaUJmbEE3RjhaMWNpSXhialVMNmxrOTBKakZINDRHV1dDL3VCZ1ZZWjk3a1FKM0h5bjZCSnVHTlc1bVBsUUczRkVzSndFTUdmU1NaVzkxMkJlaXgvL2wwZlN3SlYydG9Cdis0bm5CT1JHaUg1MFg4VEdEWmZhRFN6UWR1UXBGd0tKQXUwMzFjVnFReUlGN2xPOVErUENKcXM4L01UVGV4MUlSYWMvNEJGWEZvMDJ0VklKVTlsZ3ZXc1RuUCtCZGh3RUNuaFFPSnYyZ3pkd21zMHl5a2Z2M1VhRXc4d3dqYjhLTERza25oWHdDY0JCNlpveE9UNGpieVZFQVFMNGJ1QzhkdFhzeFlPUURXSWlKK0prYjM4YmtHZzRHUUVNY2R3RFo2YjJSS01tOE5EbkhZTTN0Q0RzSFI4djVQaVk1blN6RndiVWdDRWljSUNZZU0xZnB5aDB1MUpnQ09tamhibXhsQmZNMStNMUhnQUdQU0dlMVZaN09EKzdyTVJid25rSmd5RDQ4ME5YQUZYVDNjK1ltRGljZXQzWE9GcWtxMFd0N2lyTXdacXdzOVJlOXIzdSt6TTF2MHhMTno4R3p6UU5QNWFrMFUrYkpkRFE9PC9Db29raWU+PC9TZWN1cml0eUNvbnRleHRUb2tlbj4=");
        COOKIES_MAP.put("MSISAuth", "77u/PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz48U2VjdXJpdHlDb250ZXh0VG9rZW4gcDE6SWQ9Il9mNjJkMTQ4NS1kMzQxLTRmODgtYjhiMi0wMTliZDgzNzg1YjctNTQzMDA2RTkxODkyNkE3OTdFNDE0ODJDRkJDREEzODMiIHhtbG5zOnAxPSJodHRwOi8vZG9jcy5vYXNpcy1vcGVuLm9yZy93c3MvMjAwNC8wMS9vYXNpcy0yMDA0MDEtd3NzLXdzc2VjdXJpdHktdXRpbGl0eS0xLjAueHNkIiB4bWxucz0iaHR0cDovL2RvY3Mub2FzaXMtb3Blbi5vcmcvd3Mtc3gvd3Mtc2VjdXJlY29udmVyc2F0aW9uLzIwMDUxMiI+PElkZW50aWZpZXI+dXJuOnV1aWQ6NWEwMTExZDMtNzJiYi00ZWMxLTkzYzUtYmMxNWQ4YzNkMTg5PC9JZGVudGlmaWVyPjxDb29raWUgeG1sbnM9Imh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwNi8wNS9zZWN1cml0eSI+QUFFQUFHUy9GY3BiWnlRUStnSmZrcmFwaU0vTUFQSVlzWDNITk01VmZWR29GY0xvNWFmbHRtSFovYlVpbURML2gyMkRJOWUrY1R4S3BNdTdjL29OR2NOYzN0OGFUcE4vM1cveFVLd0V6dEJRWXVqQlF6VEI3M1d4cUFVcWdSTm5SYUhUeHdKcVFwRnk1TmhVMVNJOWF6SmMyYjhkbkhxeE1pbkQ2T3U5THR6VjBremZMUkZna2tvNEtXWk1ER2dKZmloTWppYWtLQUU0ZExsWkd1UUt2NUhVZG81T0M1SG9xT1FIRWVJcTVRaXVIaEU2c1dtUWt6NFZ2Mk1DL1BnV3RkK0ptY252NktxU1RuenZMV2ppYjFNOEg1M01FVEk0SXVRUHVrTG44UitsQXVxUWZlSUNnRW42V2RleUJWSlJlbmtyeDM2REtLMjRNcHpZWlVOdXZreXJVVUhaWXRaT1FRMERRM2I2RGE2WjVjRjk1RmhIM3BWbTU1Y055UXRLYkRUak13QUJBQUF1ZWh3cUZ3dDYwbGV4MzUvZUJaZ0RxTE5XUkF1M3lwMDVTb2dIZHBtOS9wZ3RRckFvbWEySjBzWnkzM0c2Zmxqc0NmSW1PWjF3Vy83Z0h6dmlyQ0NodEVadFpEQWZabWdpcUFRd1RtOXp5Nk8weFEwRDZnV1U4NkV6Ulp6eXQ1UUlOYi9JaVhZbG8ybUZqeERiUjI5VVVxQ1BXeXIwakw4VGoycFB6WE5QT1JNek1ETitzZlMyRzFDV2FsZW5INlpJMnVaTWF6eEpzbVQwdThwVmQxQlVSOVFkMGdabElxNzUvYi9HeXlnZ0NiMHBOOVo3RTdXU3Q0cllNb3VObnovVzVxYjBGVnBpZENtRzljOXdqdmdlU0xQbnNtNS8rTHpiOU1kZEFMMnJwNVA0cFJUblZ4eXpkNXQyeEt2MXF4WHhrbUpuOEV1S1BnL1RYU0V2UGlGU29BTUFBT09EWGUwL3A1NUcvbHNibkJ6clF5N1dqVU9MZUxNdDBXZitJTXVqcGc2cWR5Q3NTVnI2TXJiTDFMSldRTXBINmwrbmg1NkFsRkxRdXhMbjFsVXlNdEFBK1lnT2xLNytmaW5yVXY2bndBdVhSSVRUUlpQVzhGRDE3YnRscW85ZE05OFdEK2dOd2dKTXpnNUdlN1doM0hobXltWWQ3ZFFvdFp3dmtRL0JqRXZOd3F0d0NSaFRNSDNzOFI1aXBYM3BIMGY0V1RpVmFCbk82eXJueFNCdFFpTis4bUw4UHJvbUVoanBLc25xZ2UyRnNtYndEMkZ3YkNjNkZic0xtQkFyKzhkMFhwNWZiRW5SeWNDNTFzTy9POHAwVThWMDNzaUNUMENyS3VjRnMyQUkvNXRXM0tiVHRKZ3lid3ZHdmg3");
    }

    /**
     * Return booking guid by msD id.
     *
     * @param msdId
     * @return
     */
    public String getBookingGuidByMsdId(String msdId) {
        int responseSize;
        String request;
        Response idha;

        request = String.format("?$filter=(tc_name eq \'%s\')&$select=tc_bookingid", msdId);

        RestAssured.basePath = String.format(BASE_PATH_PREFIX + "%s", TC_BOOKINGS_CONTEXT_FOLDER.toLowerCase());
        idha = given().cookies(COOKIES_MAP).get(request);
        responseSize = idha.jsonPath().getList("value").size();

        if (responseSize == 1) {
            return idha.jsonPath().getList(VALUE_TC_BOOKINGID_JSONPATH).get(0).toString();
        } else if (responseSize < 1) {
            throw new IllegalReceiveException(String.format("No one booking with %s number was found", msdId));
        } else
            throw new IllegalReceiveException(String.format("%d bookings were found instead of one. tc_booking_id = %s", responseSize, msdId));
    }

    /**
     * Returns Restassured object of given service by booking Guid.
     *
     * @param serviceName Service name
     * @param filteredKey Key in {@code serviceName} service query should be filtered by.
     * @param bookingGuid Booking Guid to look for.
     * @return
     */
    private Response getServiceObjectByNameAndTcBookingGuid(String serviceName, String filteredKey, String bookingGuid) {
        int responseSize;
        String request;

        request = String.format("?$filter=%s eq %s", filteredKey, bookingGuid);
        RestAssured.basePath = BASE_PATH_PREFIX + serviceName;

        Response response = given().cookies(COOKIES_MAP).get(request);
        responseSize = response.jsonPath().getList("value").size();
        if (responseSize == 1) {
            return response;
        } else if (responseSize < 1) {
            throw new IllegalReceiveException(String.format("No one booking with %s tc_booking_id was found", bookingGuid));
        } else
            throw new IllegalReceiveException(String.format("%d bookings were found instead of one. tc_booking_id = %s", responseSize, bookingGuid));
    }

    /**
     * Return accommodation object by msD Id.
     *
     * @param bookingGuid
     * @return
     */
    public Response getAccommodationServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_ACCOMMODATION_CONTEXT_FOLDER, TC_BOOKINGID_VALUE_KEY, bookingGuid);
    }


    public Response getBookingExtraServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_EXTRA_SERVICES_CONTEXT_FOLDER, TC_BOOKINGID_VALUE_KEY, bookingGuid);
    }

    public Response getBookingTransfersServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_TRANSFERS_CONTEXT_FOLDER, TC_BOOKINGID_VALUE_KEY, bookingGuid);
    }

    public Response getBookingTransportsServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_TRANSPORTS_CONTEXT_FOLDER, TC_BOOKINGID_VALUE_KEY, bookingGuid);
    }

    /**
     * Returns Customer (accounts table in odata) object by msD booking Id.
     * <p>
     * It gets booking Guid by booking Id from {@code tc_bookings} table, then gets {@code tc_customerbookingroles} value
     * and then searches for according object in {@code contacts} service
     *
     * @param bookingId msD Id.
     * @return Customer object as Restassured response.
     */
    public Response getCustomerObjectByBookingId(String bookingId) {
        String bookingGuid, customerGuid;
        Response customerRolesResponse;

        bookingGuid = getBookingGuidByMsdId(bookingId);
        customerRolesResponse = getServiceObjectByNameAndTcBookingGuid(CUSTOMERBOOKINGROLES_SERVICE_TITLE, TC_BOOKINGID_VALUE_KEY, bookingGuid);
        customerGuid = getValueFromResponseByKey(customerRolesResponse, CUSTOMER_GUID_KEY_IN_CUSTOMER_ROLES);
        return getServiceObjectByNameAndTcBookingGuid(CONTACTS_SERVICE_CONTEXT_FOLDER, "contactid", customerGuid);
    }

    /**
     * Return accommodation service PAX list.
     *
     * @param tcBookingGuid
     * @return
     */
    public String[] getAccommodationPaxByTcBookingGuid(String tcBookingGuid) {
        return getAccommodationServiceByBookingGuid(tcBookingGuid).jsonPath().getString(TC_ACCOMMODATION_PAX_JSONPATH).split(PAX_DELIMITER_REGEX);
    }

    /**
     * General query to defined service table with possibility to filter the service records list.
     *
     * @param serviceName      Name of service table.
     * @param filteredKey      json-map key to filter by.
     * @param filteredGuid     Filtered key value to compare with.
     * @param returnedValueKey json-map key which value is to be returned.
     * @return {@code returnedValueKey} value from filtered json-object.
     */
    public List<String> getValueListInGivenServiceByTcBookingId(String serviceName, String filteredKey, String filteredGuid, String returnedValueKey) {
        Response serviceObject;

        serviceObject = getServiceObjectByNameAndTcBookingGuid(serviceName, filteredKey, filteredGuid);
        return serviceObject.jsonPath().getList(String.format("value.%s", returnedValueKey));
    }

    /**
     * Returns a value (by given key) from given response using jsonPath.
     *
     * @param responseObject a Restassured response in json map format.
     * @param key            json map Key that points to a desired value.
     * @return String representation of map value.
     */
    public String getValueFromResponseByKey(Response responseObject, String key) {
        return (String) responseObject.jsonPath().getList(String.format("value.%s", key)).get(0);
    }
}
