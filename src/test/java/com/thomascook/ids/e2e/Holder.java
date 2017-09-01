package com.thomascook.ids.e2e;

import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import com.thomascook.toscaExtrasAdapter.request.OTAPkgExtrasInfoRQ;
import com.thomascook.toscaExtrasAdapter.response.OTAPkgExtrasInfoRS;
import cucumber.api.DataTable;
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
    OTAPkgExtrasInfoRQ toscaExtrasRequest;
    OTAPkgExtrasInfoRS toscaExtrasResponse;

    public OTAPkgExtrasInfoRQ getToscaExtrasRequest() {
        return toscaExtrasRequest;
    }

    public void setToscaExtrasRequest(OTAPkgExtrasInfoRQ toscaExtrasRequest) {
        this.toscaExtrasRequest = toscaExtrasRequest;
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
