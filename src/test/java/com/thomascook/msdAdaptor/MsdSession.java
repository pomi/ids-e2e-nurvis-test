package com.thomascook.msdAdaptor;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.sun.nio.sctp.IllegalReceiveException;
import com.thomascook.Config;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.jayway.restassured.RestAssured.given;

public class MsdSession {

    //region Constants
    private static final String TC_BOOKINGS_CONTEXT_FOLDER = "tc_bookings";
    private static final String TC_BOOKING_ACCOMMODATION_CONTEXT_FOLDER = "tc_bookingaccommodations";
    private static final String TC_BOOKING_EXTRA_SERVICES_CONTEXT_FOLDER = "tc_bookingextraservices";
    private static final String TC_BOOKING_TRANSFERS_CONTEXT_FOLDER = "tc_bookingtransfers";
    private static final String TC_BOOKING_TRANSPORTS_CONTEXT_FOLDER = "tc_bookingtransports";
    private static final String CONTACTS_SERVICE_CONTEXT_FOLDER = "contacts";
    private static final String TC_GATEWAIES_CONTEXT_FOLDER = "tc_gatewaies";
    private static final String MSIS_AUTH_COOKIE_NAME = "MSISAuth";
    private static final String MSIS_AUTH1_COOKIE_NAME = "MSISAuth1";
    private static final String VALUE_TC_BOOKING_ID_JSONPATH = "tc_bookingid";
    private static final String TC_ACCOMMODATION_PAX_JSONPATH = "value[0].tc_participants";
    private static final String PAX_DELIMITER_REGEX = ",*\\r\\n";
    private static final String BASE_PATH_PREFIX = "/api/data/v8.2/";
    private static final String CUSTOMER_GUID_KEY_IN_CUSTOMER_ROLES = "_tc_customer_value";
    private static final String CUSTOMER_BOOKING_ROLES_SERVICE_TITLE = "tc_customerbookingroles";
    private static final String TC_BOOKING_ID_VALUE_KEY = "_tc_bookingid_value";
    private static final Header FF_HEADER = new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
    private static final String TC_GATEWAYID_VALUE_KEY = "tc_gatewayid";
    private static final String TC_BRANDS_CONTEXT_FOLDER = "tc_brands";
    private static final String TC_BRANDID_VALUE_VALUE_KEY = "tc_brandid";
    private static final String TC_IATA_MAP_KEY = "tc_iata";
    private static final String TC_BRANDID_MAP_KEY = "tc_brandcode";
    private static final String TC_TOUROPERATORS_CONTEXT_FOLDER = "tc_touroperators";
    private static final String TC_TOUROPERATORID_VALUE_KEY = "tc_touroperatorid";
    private static final String TC_TOUROPERATORCODE_MAP_KEY = "tc_touroperatorcode";
    private static final Header HEADER = new Header("Prefer", "odata.include-annotations=\"*\"");
//    private static final Header HEADER = new Header("Prefer", "odata.include-annotations=\"OData.Community.Display.V1.FormattedValue\"");
    //endregion

    private static Map<String, String> COOKIES_MAP = new HashMap<>();
    private static MsdSession instance;

    private static Logger logger = LoggerFactory.getLogger(MsdSession.class);

    private MsdSession() {
        String msdBaseUrl = Config.get().getMsdBaseUrl();
        String msdUserName = Config.get().getMsdLogin();
        String msdUserPassword = Config.get().getMsdPassword();

        COOKIES_MAP = getCookiesMap(msdBaseUrl, msdUserName, msdUserPassword);
        RestAssured.baseURI = String.format("https://%s", msdBaseUrl);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static MsdSession get() {
        if (null == instance) {
            instance = new MsdSession();
        }
        return instance;
    }

    public void terminateSession() {
        instance = null;
    }

    /**
     * Return booking guid by msD id.
     *
     * @param msdId
     * @return
     */
    public String getBookingGuidByMsdId(String msdId) {
        return (String) (
                (Map) (
                        (ArrayList) getBookingGeneralDetailsByBookingId(msdId).getBody().jsonPath().get("value"))
                        .get(0))
                .get(VALUE_TC_BOOKING_ID_JSONPATH);
    }

    public Response getBookingGeneralDetailsByBookingId(String msdId) {
        int responseSize;
        String request;
        Response bookingGeneralInfoObject;

        assert null != msdId;

        request = String.format("?$filter=(tc_name eq '%s')", msdId);

        RestAssured.basePath = String.format(BASE_PATH_PREFIX + "%s", TC_BOOKINGS_CONTEXT_FOLDER.toLowerCase());
        for (int i = 0; i < Config.get().getFetchBookingTimeoutSec() / Config.get().getWaitBetweenTiesSec(); i++) {
            bookingGeneralInfoObject = given().header(HEADER).cookies(COOKIES_MAP).then().statusCode(200).get(request);
            responseSize = bookingGeneralInfoObject.jsonPath().getList("value").size();

            if (responseSize == 1) {
                return bookingGeneralInfoObject;
            } else if (responseSize < 1) {
                try {
                    Thread.sleep(Config.get().getWaitBetweenTiesSec());
                } catch (InterruptedException e) {
                    logger.info(String.valueOf(i));
                    logger.error(e.getMessage());
                }
                continue;
            } else
                throw new IllegalReceiveException(String.format("%d bookings were found instead of one. tc_booking_id = %s", responseSize, msdId));
        }

        throw new IllegalReceiveException(String.format("No booking with %s number was found", msdId));
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
        String request;
        Response response;

        request = String.format("?$filter=%s eq %s", filteredKey, bookingGuid);
        RestAssured.basePath = BASE_PATH_PREFIX + serviceName;

        response = given().header(HEADER).cookies(COOKIES_MAP).get(request);
        if (response.getStatusCode() == 400) {
            throw new IllegalReceiveException(String.format("'%s' response on '%s' request\n%s", response.getStatusLine(), request, response.prettyPrint()));
        }

        return response;
    }

    /**
     * Return accommodation object by msD Id.
     *
     * @param bookingGuid
     * @return
     */
    public Response getAccommodationServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_ACCOMMODATION_CONTEXT_FOLDER, TC_BOOKING_ID_VALUE_KEY, bookingGuid);
    }

    public Response getBookingExtraServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_EXTRA_SERVICES_CONTEXT_FOLDER, TC_BOOKING_ID_VALUE_KEY, bookingGuid);
    }

    public Response getBookingTransfersServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_TRANSFERS_CONTEXT_FOLDER, TC_BOOKING_ID_VALUE_KEY, bookingGuid);
    }

    public Response getBookingTransportsServiceByBookingGuid(String bookingGuid) {
        return getServiceObjectByNameAndTcBookingGuid(TC_BOOKING_TRANSPORTS_CONTEXT_FOLDER, TC_BOOKING_ID_VALUE_KEY, bookingGuid);
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
        customerRolesResponse = getServiceObjectByNameAndTcBookingGuid(CUSTOMER_BOOKING_ROLES_SERVICE_TITLE, TC_BOOKING_ID_VALUE_KEY, bookingGuid);
        customerGuid = getValueFromResponseByKey(customerRolesResponse, CUSTOMER_GUID_KEY_IN_CUSTOMER_ROLES);
        return getServiceObjectByNameAndTcBookingGuid(CONTACTS_SERVICE_CONTEXT_FOLDER, "contactid", customerGuid);
    }

    /**
     * Gets gateway IATA code by guid.
     *
     * @param gatewayGuid msd guid.
     * @return IATA code.
     */
    public String getIataValueByGatewayGuid(String gatewayGuid) {
        Response msdGatewayObject = getServiceObjectByNameAndTcBookingGuid(TC_GATEWAIES_CONTEXT_FOLDER, TC_GATEWAYID_VALUE_KEY, gatewayGuid);
        return getValueFromResponseByKey(msdGatewayObject, TC_IATA_MAP_KEY);
    }

    /**
     * Gets brand name using {@code _tc_brandid_value} guid.
     *
     * @param brandGuid Brand guid.
     * @return Brand name.
     */
    public String getTcBrandNameByBrandGuid(String brandGuid) {
        Response msdBrandObject = getServiceObjectByNameAndTcBookingGuid(TC_BRANDS_CONTEXT_FOLDER, TC_BRANDID_VALUE_VALUE_KEY, brandGuid);
        return getValueFromResponseByKey(msdBrandObject, TC_BRANDID_MAP_KEY);
    }

    /**
     * Gets TO_CODE value by {@code _tc_touroperatorid_value} guid.
     *
     * @param toCodeGuid {@code _tc_touroperatorid_value} guid.
     * @return TO_CODE.
     */
    public String getTcToCodeByTourOperatorGiud(String toCodeGuid) {
        Response msdTourOperatorObject = getServiceObjectByNameAndTcBookingGuid(TC_TOUROPERATORS_CONTEXT_FOLDER, TC_TOUROPERATORID_VALUE_KEY, toCodeGuid);
        return getValueFromResponseByKey(msdTourOperatorObject, TC_TOUROPERATORCODE_MAP_KEY);
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
    private String getValueFromResponseByKey(Response responseObject, String key) {
        return (String) responseObject.jsonPath().getList(String.format("value.%s", key)).get(0);
    }

    /**
     * Transforms Value object of msD-json Response into a {@link Map}.
     *
     * @param msdObject An object returned in msD response.
     * @return Value object converted to map.
     */
    private Map getMsdValueMap(Response msdObject) {
        return ((ArrayList<Map>) new JSONObject(msdObject).toMap().get("value")).get(0);
    }

    /**
     * Gets msD site cookies in order to use them in msD requests.
     * <p>
     * Using Selenium WebDriver logs in to the msD site, grabs cookies.
     *
     * @param baseUrl      msD url
     * @param userName     User login
     * @param userPassword User password
     * @return Map of cookies prepared to use in Resasurred requests.
     */
    private Map<String, String> getCookiesMap(String baseUrl, String userName, String userPassword) {
        String cookie1, cookie2;
        Map<String, String> cookiesMap;
        WebDriver driver;
        cookiesMap = new HashMap<>();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setJavascriptEnabled(false);
        PhantomJsDriverManager.getInstance().setup();
        driver = new PhantomJSDriver(capabilities);
        try {
            logger.info("Getting cookies with WebDriver");
            driver.get(String.format("https://%s", baseUrl));
            driver.findElement(By.id("cred_userid_inputtext")).sendKeys(userName + Keys.TAB);
            (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(By.id("passwordInput"))).sendKeys(userPassword);
            driver.findElement(By.id("submitButton")).click();

            driver.manage().getCookies().forEach(it -> logger.info(it.toString()));

            cookie1 = driver.manage().getCookieNamed(MSIS_AUTH_COOKIE_NAME).getValue();
            cookie2 = driver.manage().getCookieNamed(MSIS_AUTH1_COOKIE_NAME).getValue();

            cookiesMap.put(MSIS_AUTH_COOKIE_NAME, cookie1);
            cookiesMap.put(MSIS_AUTH1_COOKIE_NAME, cookie2);
            logger.info("Cookies were recorded");

            return cookiesMap;
        } finally {
            driver.close();
        }
    }
}
