package com.thomascook.utils;

import com.thomascook.nurvisAdapter.request.ReservationRequestTypeRequest;
import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import com.thomascook.toscaExtrasAdapter.request.OTAPkgExtrasInfoRQ;
import com.thomascook.toscaExtrasAdapter.response.OTAPkgExtrasInfoRS;
import cucumber.api.DataTable;
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
    private static String bookingNumber;
    private static ReservationRequestTypeRequest bookingDetails = new ReservationRequestTypeRequest();


    private Holder() {
    }

    public static Holder get() {
        if (instance == null) {
            instance = new Holder();
        }
        return instance;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public ReservationRequestTypeRequest getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(ReservationRequestTypeRequest bookingDetails) {
        Holder.bookingDetails = bookingDetails;
    }

    public void setBookingNumber(String bookingNumber) {
        Holder.bookingNumber = bookingNumber;
    }

    public OTAPkgSearchRS getOtaPkgSearchRS() {
        return otaPkgSearchRS;
    }

    public void setOtaPkgSearchRS(OTAPkgSearchRS otaPkgSearchRS) {
        Holder.otaPkgSearchRS = otaPkgSearchRS;
    }

    public DataTable getPassengers() {
        return passengers;
    }

    public void setPassengers(DataTable passengers) {
        Holder.passengers = passengers;
    }

    public OTAPkgAvailRS getToscaAvailabilityResponse() {
        return toscaAvailabilityResponse;
    }

    public void setToscaAvailabilityResponse(OTAPkgAvailRS toscaAvailabilityResponse) {
        Holder.toscaAvailabilityResponse = toscaAvailabilityResponse;
    }

    public OTAPkgAvailRQ getToscaAvailabiltyRequest() {
        return toscaAvailabiltyRequest;
    }

    public void setToscaAvailabiltyRequest(OTAPkgAvailRQ toscaAvailabiltyRequest) {
        Holder.toscaAvailabiltyRequest = toscaAvailabiltyRequest;
    }

    public OTAPkgExtrasInfoRQ getToscaExtrasRequest() {
        return toscaExtrasRequest;
    }

    public void setToscaExtrasRequest(OTAPkgExtrasInfoRQ toscaExtrasRequest) {
        Holder.toscaExtrasRequest = toscaExtrasRequest;
    }

    public OTAPkgExtrasInfoRS getToscaExtrasResponse() {
        return toscaExtrasResponse;
    }

    public void setToscaExtrasResponse(OTAPkgExtrasInfoRS toscaExtrasResponse) {
        Holder.toscaExtrasResponse = toscaExtrasResponse;
    }

    public static Map<String, Object> getProperties() {
        return globalMap;
    }
}
