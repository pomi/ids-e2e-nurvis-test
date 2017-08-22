package com.thomascook.msdAdaptor;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.sun.nio.sctp.IllegalReceiveException;
import com.thomascook.Context;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.*;

import static com.jayway.restassured.RestAssured.given;

@ContextConfiguration(classes = Context.class)
@Component
public class MsdBookings {

    private static final String TC_BOOKINGS_CONTEXT_FOLDER = "tc_bookings";
    private static final String TC_BOOKING_ACCOMMODATION_CONTEXT_FOLDER = "tc_bookingaccommodations";
    private static final String TC_BOOKING_EXTRA_SERVICES_CONTEXT_FOLDER = "tc_bookingextraservices";
    private static final String TC_BOOKING_TRANSFERS_CONTEXT_FOLDER = "tc_bookingtransfers";
    private static final String TC_BOOKING_TRANSPORTS_CONTEXT_FOLDER = "tc_bookingtransports";
    private static final String CONTACTS_SERVICE_CONTEXT_FOLDER = "contacts";
    private static final String MSIS_AUTH_COOKIE_NAME = "MSISAuth";
    private static final String MSIS_AUTH1_COOKIE_NAME = "MSISAuth1";

    private static Map<String, String> COOKIES_MAP = new HashMap<>();

    private static final String VALUE_TC_BOOKINGID_JSONPATH = "value.tc_bookingid";
    private static final String TC_ACCOMMODATION_PAX_JSONPATH = "value[0].tc_participants";
    private static final String PAX_DELIMITER_REGEX = ",*\\r\\n";
    private static final String BASE_PATH_PREFIX = "/api/data/v8.2/";
    private static final String CUSTOMER_GUID_KEY_IN_CUSTOMER_ROLES = "_tc_customer_value";
    private static final String CUSTOMERBOOKINGROLES_SERVICE_TITLE = "tc_customerbookingroles";
    private static final String TC_BOOKINGID_VALUE_KEY = "_tc_bookingid_value";

    private static Logger logger = LoggerFactory.getLogger(MsdBookings.class);

    public MsdBookings(@Value("${staging.msd.baseUrl}") String msdBaseUrl,
                       @Value("${staging.msd.user.name}") String msdUserName,
                       @Value("${staging.msd.user.password}") String msdUserPassword) {
        COOKIES_MAP = getCookiesMap(msdBaseUrl, msdUserName, msdUserPassword);
        RestAssured.baseURI = String.format("https://%s", msdBaseUrl);
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
    public HashSet<String> getAccommodationPaxByTcBookingGuid(String tcBookingGuid) {
        String[] paxArray = getAccommodationServiceByBookingGuid(tcBookingGuid).jsonPath().getString(TC_ACCOMMODATION_PAX_JSONPATH).split(PAX_DELIMITER_REGEX);
        return new HashSet<>(Arrays.asList(paxArray));
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

    private Map<String, String> getCookiesMap(String baseUrl, String userName, String userPasswword) {

        Map<String, String> cookiesMap = new HashMap<>();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setJavascriptEnabled(false);
        PhantomJsDriverManager.getInstance().setup();

        WebDriver driver = new PhantomJSDriver(capabilities);
        driver.get(String.format("https://%s", baseUrl));
        driver.findElement(By.id("cred_userid_inputtext")).sendKeys(userName + Keys.TAB);
        (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(By.id("passwordInput"))).sendKeys(userPasswword);
        driver.findElement(By.id("submitButton")).click();

        cookiesMap.put(MSIS_AUTH_COOKIE_NAME, driver.manage().getCookieNamed(MSIS_AUTH_COOKIE_NAME).getValue());
        cookiesMap.put(MSIS_AUTH1_COOKIE_NAME, driver.manage().getCookieNamed(MSIS_AUTH1_COOKIE_NAME).getValue());

        driver.close();

        return cookiesMap;
    }
}
