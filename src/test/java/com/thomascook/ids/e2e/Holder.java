package com.thomascook.ids.e2e;

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
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class Holder {

    private OTAPkgSearchRS otaPkgSearchRS;
    private String placeholder;
    private static Properties properties;
    private DataTable passengers;
    private OTAPkgAvailRS toscaAvailabilityResponse;
    private OTAPkgAvailRQ toscaAvailabiltyRequest;
    private OTAPkgExtrasInfoRS toscaExtrasResponse;
    private OTAPkgBookRS toscaBookingResponse;
    private OTAPkgExtrasInfoRQ toscaExtrasRequest;
    private OTAPkgBookRQ toscaBookingRequest;
    private org.opentravel.ota._2003._05.response.HotelOfferType hotelOffer;
    private String bookingReference;
    private String retailinterfaceXML;
    private FullRetailDownloadResponse retailDownloadResponse;

    public FullRetailDownloadResponse getRetailDownloadResponse() {
        return retailDownloadResponse;
    }

    public void setRetailDownloadResponse(FullRetailDownloadResponse retailDownloadResponse) {
        this.retailDownloadResponse = retailDownloadResponse;
    }

    public String getRetailinterfaceXML() {
        return retailinterfaceXML;
    }

    public void setRetailinterfaceXML(String retailinterfaceXML) {
        this.retailinterfaceXML = retailinterfaceXML;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public HotelOfferType getHotelOffer() {
        return hotelOffer;
    }

    public void setHotelOffer(HotelOfferType hotelOffer) {
        this.hotelOffer = hotelOffer;
    }

    public OTAPkgExtrasInfoRQ getToscaExtrasRequest() {
        return toscaExtrasRequest;
    }

    public void setToscaExtrasRequest(OTAPkgExtrasInfoRQ toscaExtrasRequest) {
        this.toscaExtrasRequest = toscaExtrasRequest;
    }

    public OTAPkgBookRS getToscaBookingResponse() {
        return toscaBookingResponse;
    }

    public OTAPkgBookRQ getToscaBookingRequest() {
        return toscaBookingRequest;
    }

    public void setToscaBookingRequest(OTAPkgBookRQ toscaBookingRequest) {
        this.toscaBookingRequest = toscaBookingRequest;
    }

    public void setToscaBookingResponse(OTAPkgBookRS toscaBookingResponse) {
        this.toscaBookingResponse = toscaBookingResponse;
    }

    public OTAPkgExtrasInfoRS getToscaExtrasResponse() {
        return toscaExtrasResponse;
    }

    public void setToscaExtrasResponse(OTAPkgExtrasInfoRS toscaExtrasResponse) {
        this.toscaExtrasResponse = toscaExtrasResponse;
    }

    public OTAPkgAvailRS getToscaAvailabilityResponse() {
        return toscaAvailabilityResponse;
    }

    public void setToscaAvailabilityResponse(OTAPkgAvailRS toscaAvailabilityResponse) {
        this.toscaAvailabilityResponse = toscaAvailabilityResponse;
    }

    public OTAPkgAvailRQ getToscaAvailabiltyRequest() {
        return toscaAvailabiltyRequest;
    }

    public void setToscaAvailabiltyRequest(OTAPkgAvailRQ toscaAvailabiltyRequest) {
        this.toscaAvailabiltyRequest = toscaAvailabiltyRequest;
    }

    public DataTable getPassengers() {
        return passengers;
    }

    public void setPassengers(DataTable passengers) {
        this.passengers = passengers;
    }

    public OTAPkgSearchRS getOtaPkgSearchRS() {
        return otaPkgSearchRS;
    }

    public void setOtaPkgSearchRS(OTAPkgSearchRS otaPkgSearchRS) {
        this.otaPkgSearchRS = otaPkgSearchRS;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
