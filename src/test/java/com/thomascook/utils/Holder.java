package com.thomascook.utils;

import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import com.thomascook.toscaBookAdapter.request.OTAPkgBookRQ;
import com.thomascook.toscaBookAdapter.response.OTAPkgBookRS;
import com.thomascook.toscaExtrasAdapter.request.OTAPkgExtrasInfoRQ;
import com.thomascook.toscaExtrasAdapter.response.OTAPkgExtrasInfoRS;
import com.thomascook.wrAdapter.response.FullRetailDownloadResponse;
import cucumber.api.DataTable;
import org.opentravel.ota._2003._05.response.HotelOfferType;
import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;

import java.util.HashMap;
import java.util.Map;

public class Holder {
    private static Holder instance;

    private static OTAPkgSearchRS otaPkgSearchRS;
    private static String placeholder;
    private static DataTable passengers;
    private static OTAPkgAvailRS toscaAvailabilityResponse;
    private static OTAPkgAvailRQ toscaAvailabiltyRequest;
    private static OTAPkgExtrasInfoRQ toscaExtrasRequest;
    private static OTAPkgExtrasInfoRS toscaExtrasResponse;
    private static Map<String, Object> globalMap = new HashMap<>();
    private static OTAPkgBookRQ toscaBookRequest;
    private static OTAPkgBookRS toscaBookResponse;
    private static HotelOfferType hotelOffer;
    private static String id;
    private static String webRioRequest;
    private static FullRetailDownloadResponse fullRetailDownloadResponse;

    private Holder() {
    }

    public static Holder get() {
        if (instance == null) {
            instance = new Holder();
        }
        return instance;
    }

    public static OTAPkgSearchRS getOtaPkgSearchRS() {
        return otaPkgSearchRS;
    }

    public static void setOtaPkgSearchRS(OTAPkgSearchRS otaPkgSearchRS) {
        Holder.otaPkgSearchRS = otaPkgSearchRS;
    }

    public static DataTable getPassengers() {
        return passengers;
    }

    public static void setPassengers(DataTable passengers) {
        Holder.passengers = passengers;
    }

    public static OTAPkgAvailRS getToscaAvailabilityResponse() {
        return toscaAvailabilityResponse;
    }

    public static void setToscaAvailabilityResponse(OTAPkgAvailRS toscaAvailabilityResponse) {
        Holder.toscaAvailabilityResponse = toscaAvailabilityResponse;
    }

    public static OTAPkgAvailRQ getToscaAvailabiltyRequest() {
        return toscaAvailabiltyRequest;
    }

    public static void setToscaAvailabiltyRequest(OTAPkgAvailRQ toscaAvailabiltyRequest) {
        Holder.toscaAvailabiltyRequest = toscaAvailabiltyRequest;
    }

    public static OTAPkgExtrasInfoRQ getToscaExtrasRequest() {
        return toscaExtrasRequest;
    }

    public static void setToscaExtrasRequest(OTAPkgExtrasInfoRQ toscaExtrasRequest) {
        Holder.toscaExtrasRequest = toscaExtrasRequest;
    }

    public static OTAPkgExtrasInfoRS getToscaExtrasResponse() {
        return toscaExtrasResponse;
    }

    public static void setToscaExtrasResponse(OTAPkgExtrasInfoRS toscaExtrasResponse) {
        Holder.toscaExtrasResponse = toscaExtrasResponse;
    }

    public static Map<String, Object> getProperties() {
        return globalMap;
    }

    public void setToscaBookingRequest(OTAPkgBookRQ toscaBookRequest) {
        Holder.toscaBookRequest = toscaBookRequest;
    }

    public void setToscaBookingResponse(OTAPkgBookRS toscaBookResponse) {
        Holder.toscaBookResponse = toscaBookResponse;
    }

    public void setHotelOffer(HotelOfferType hotelOffer) {
        Holder.hotelOffer = hotelOffer;
    }

    public void setBookingReference(String id) {
        Holder.id = id;
    }

    public static Holder getInstance() {
        return instance;
    }

    public static String getPlaceholder() {
        return placeholder;
    }

    public static Map<String, Object> getGlobalMap() {
        return globalMap;
    }

    public static OTAPkgBookRQ getToscaBookingRequest() {
        return toscaBookRequest;
    }

    public static OTAPkgBookRS getToscaBookingResponse() {
        return toscaBookResponse;
    }

    public static HotelOfferType getHotelOffer() {
        return hotelOffer;
    }

    public static String getBookingReference() {
        return id;
    }

    public void setRetailinterfaceXML(String webRioRequest) {
        Holder.webRioRequest = webRioRequest;
    }

    public static String getRetailinterfaceXML() {
        return webRioRequest;
    }

    public void setRetailDownloadResponse(FullRetailDownloadResponse fullRetailDownloadResponse) {
        Holder.fullRetailDownloadResponse = fullRetailDownloadResponse;
    }
}
