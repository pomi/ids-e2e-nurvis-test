package com.thomascook.utils;

import com.thomascook.msdAdaptor.msdBookingDetails.MsdBookingDetails;
import com.thomascook.nurvisAdapter.request.ReservationCustomerTypeRequest;
import com.thomascook.nurvisAdapter.request.ReservationRequestTypeRequest;
import com.thomascook.nurvisAdapter.response.ReservationResponseTypeResponse;
import com.thomascook.ontour.Shipment;
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
    private static OTAPkgAvailRQ toscaAvailabilityRequest;
    private static OTAPkgExtrasInfoRQ toscaExtrasRequest;
    private static OTAPkgExtrasInfoRS toscaExtrasResponse;
    private static Map<String, Object> globalMap = new HashMap<>();
    private static String bookingNumber;
    private static ReservationRequestTypeRequest bookingRequestDetails;
    private static ReservationResponseTypeResponse bookingResponseDetails;
    private static Shipment onTourShipment;
    private static MsdBookingDetails msdBookingDetails;
    private static ReservationCustomerTypeRequest customer;

    private Holder() {
    }

    public static Holder get() {
        if (instance == null) {
            instance = new Holder();
        }
        return instance;
    }

    public static Map<String, Object> getProperties() {
        return globalMap;
    }

    public ReservationCustomerTypeRequest getCustomer() {
        return customer;
    }

    public void setCustomer(ReservationCustomerTypeRequest customer) {
        Holder.customer = customer;
    }

    public MsdBookingDetails getMsdBookingDetails() {
        return msdBookingDetails;
    }

    public void setMsdBookingDetails(MsdBookingDetails msdBookingDetails) {
        Holder.msdBookingDetails = msdBookingDetails;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        Holder.bookingNumber = bookingNumber;
    }

    public ReservationRequestTypeRequest getBookingRequestDetails() {
        return bookingRequestDetails;
    }

    public void setBookingRequestDetails(ReservationRequestTypeRequest bookingDetails) {
        Holder.bookingRequestDetails = bookingDetails;
    }

    public void setBookingResponseDetails(ReservationResponseTypeResponse bookingDetails) {
        Holder.bookingResponseDetails = bookingDetails;
    }

    public ReservationResponseTypeResponse getBookingResponceDetails() {
        return bookingResponseDetails;
    }

    public Shipment getOnTourShipment() {
        return onTourShipment;
    }

    public void setOnTourShipment(Shipment shipment) {
        Holder.onTourShipment = shipment;
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
        return toscaAvailabilityRequest;
    }

    public void setToscaAvailabiltyRequest(OTAPkgAvailRQ toscaAvailabiltyRequest) {
        Holder.toscaAvailabilityRequest = toscaAvailabiltyRequest;
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
}
