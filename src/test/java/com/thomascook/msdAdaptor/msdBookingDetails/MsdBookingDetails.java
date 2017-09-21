package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MsdBookingDetails {
    private MsdBookingGeneralDetails generalDetails;
    private List<MsdAccommodation> accommodations;
    private List<MsdTransport> transports;
    private List<MsdExtraService> extraServices;
    private List<MsdTransfer> transfers;
    private MsdCustomer customer;

    public MsdBookingGeneralDetails getGeneralDetails() {
        return generalDetails;
    }

    public List<MsdAccommodation> getAccommodations() {
        return accommodations;
    }

    public List<MsdTransport> getTransports() {
        return transports;
    }

    public List<MsdTransfer> getTransfers() {
        return transfers;
    }

    public List<MsdExtraService> getExtraServices() {
        return extraServices;
    }

    public MsdCustomer getCustomer() {
        return customer;
    }

    /**
     * Fills in the Booking General details according to response on rest-call
     *
     * @param msdGeneralDetailsServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setGeneralDetails(String msdGeneralDetailsServiceJson) {
        this.generalDetails = (MsdBookingGeneralDetails) getMapFromServiceJson(msdGeneralDetailsServiceJson, MsdBookingGeneralDetails.class);
    }

    /**
     * Fills in the transports according to response on rest-call
     *
     * @param msdTransportServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setTransports(String msdTransportServiceJson) {
        this.transports = getMapListFromServiceJson(msdTransportServiceJson, MsdTransport.class);
    }

    /**
     * Fills in the accommodations according to response on rest-call
     *
     * @param msdAccommodationServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setAccomodations(String msdAccommodationServiceJson) {
        this.accommodations = getMapListFromServiceJson(msdAccommodationServiceJson, MsdAccommodation.class);
    }

    /**
     * Fills in the transfers according to response on rest-call
     *
     * @param msdTransfersServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setTransfers(String msdTransfersServiceJson) {
        this.transfers = getMapListFromServiceJson(msdTransfersServiceJson, MsdTransfer.class);
    }

    /**
     * Fills in the extraServices according to response on rest-call
     *
     * @param msdExtraServicesJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setExtraServices(String msdExtraServicesJson) {
        this.extraServices = getMapListFromServiceJson(msdExtraServicesJson, MsdExtraService.class);
    }

    /**
     * Fills in the customer according to response on rest-call
     *
     * @param msdCustomerServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setCustomer(String msdCustomerServiceJson) {
        this.customer = (MsdCustomer) getMapFromServiceJson(msdCustomerServiceJson, MsdCustomer.class);
    }

    /**
     * Sets details to fields that contains a List of Maps.
     *
     * @param msdServiceJson {@link org.json.JSONArray} in {@link String} format.
     * @param serviceType    A class the jsonMap is expected be mapped to.
     * @return A {@link List} of json Maps.
     */
    private ArrayList getMapListFromServiceJson(String msdServiceJson, Class serviceType) {
        ArrayList<Map> jsonMapsList;
        ArrayList mapList = new ArrayList<>();


        jsonMapsList = (ArrayList<Map>) new JSONObject(msdServiceJson).toMap().get("value");

        jsonMapsList.forEach((Map it) -> {
            assert it instanceof Map;

            Constructor<?> cons = null;
            try {
                cons = serviceType.getConstructor(Map.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                mapList.add(cons.newInstance(it));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return mapList;
    }

    /**
     * Sets details to Map-structured fields.
     *
     * @param jsonObject {@link JSONObject} in String format. Usually {@link Response}.prettyPrint().
     * @param T          A class the jsonMap is expected be mapped to. The class should extend {@link MsdService}.
     * @return Object of a class that implements {@link MsdService}.
     */
    private MsdService getMapFromServiceJson(String jsonObject, Class T) {
        Map jsonObjectMap;

        jsonObjectMap = ((ArrayList<Map>) (new JSONObject(jsonObject)).toMap().get("value")).get(0);
        Constructor<?> cons = null;

        try {
            cons = T.getConstructor(Map.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            return (MsdService) cons.newInstance(jsonObjectMap);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("generalDetails", generalDetails)
                .add("accommodations", accommodations)
                .add("transports", transports)
                .add("extraServices", extraServices)
                .add("transfers", transfers)
                .add("customer", customer)
                .toString();
    }
}
