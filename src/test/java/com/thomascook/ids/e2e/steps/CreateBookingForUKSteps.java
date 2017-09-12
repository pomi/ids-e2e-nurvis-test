package com.thomascook.ids.e2e.steps;

import com.thomascook.Config;
import com.thomascook.ids.e2e.tests.CreateBookingUK;
import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import com.thomascook.toscaBookAdapter.request.OTAPkgBookRQ;
import com.thomascook.toscaBookAdapter.response.OTAPkgBookRS;
import com.thomascook.toscaCostAdapter.request.OTAPkgCostRQ;
import com.thomascook.toscaCostAdapter.response.OTAPkgCostRS;
import com.thomascook.toscaExtrasAdapter.request.OTAPkgExtrasInfoRQ;
import com.thomascook.toscaExtrasAdapter.response.OTAPkgExtrasInfoRS;
import com.thomascook.utils.Holder;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.opentravel.ota._2003._05.response.HotelOfferType;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

class CreateBookingForUKSteps implements En {

    private String toscaStaging;

    public CreateBookingForUKSteps() {

        Given("^I request packages in SOLR from (.*?) to (.*?) with passengers$", (String departureAirport, String destination, DataTable dataTable) -> {
            String solr = Config.get().getSolrUk();
            assert !solr.isEmpty() : "Solr endpoint is not set";
            try {
                Holder.setPassengers(dataTable);
                Holder.setOtaPkgSearchRS(CreateBookingUK.getSOLRPackagesUK(solr, departureAirport, destination, dataTable));
                assert !Holder.getOtaPkgSearchRS().getHotelOffers().getHotelOffer().isEmpty() : "Hotel offers list is empty";
            } catch (IOException | JAXBException | DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        });

        When("^I check availability in Tosca, and add extras, and check costs, and confirm package$", () -> {
            String tosca = Config.get().getTosca();
            assert !tosca.isEmpty() : "Tosca endpoint is not set";

            int iteration = 1;
            for (HotelOfferType hotelOffer : Holder.getOtaPkgSearchRS().getHotelOffers().getHotelOffer()) {
                System.out.println("Iteration number " + iteration++);
                try {
                    OTAPkgAvailRQ toscaAvailabilityRequest = CreateBookingUK.createToscaAvailabilityRequest(hotelOffer, Holder.getPassengers());
                    String toscaAvailabilityRequestXML = CreateBookingUK.createToscaAvailabilityRequestXML(toscaAvailabilityRequest);
                    assert !toscaAvailabilityRequestXML.equals("") : "Tosca availability Request XML is empty";
                    OTAPkgAvailRS toscaAvailabilityResponse = CreateBookingUK.getToscaResponse(toscaStaging, toscaAvailabilityRequestXML);

                    if (toscaAvailabilityResponse.getSuccess() == null && toscaAvailabilityResponse.getErrors() != null)
                        continue;

                    String toscaAvailabilityResponseXML = CreateBookingUK.createToscaAvailabilityResponseXML(toscaAvailabilityResponse);
                    OTAPkgExtrasInfoRQ toscaExtrasRequest = CreateBookingUK.createToscaExtrasRequest(toscaAvailabilityRequest, toscaAvailabilityResponse, Holder.getPassengers());
                    String toscaExtrasRequestXML = CreateBookingUK.createToscaExtrasRequestXML(toscaExtrasRequest);
                    OTAPkgExtrasInfoRS toscaExtrasResponse = CreateBookingUK.getToscaExtrasResponse(toscaExtrasRequestXML, tosca);

                    if (toscaExtrasResponse.getSuccess() == null && toscaExtrasResponse.getErrors() != null)
                        continue;

                    OTAPkgCostRQ toscaCostRequest = CreateBookingUK.createToscaCostRequest(toscaExtrasResponse, toscaExtrasRequest);
                    String toscaCostRequestXML = CreateBookingUK.createToscaCostRequestXML(toscaCostRequest);
                    OTAPkgCostRS toscaCostResponse = CreateBookingUK.getToscaCostResponse(toscaCostRequestXML, tosca);

                    if (toscaCostResponse.getSuccess() == null && toscaCostResponse.getErrors() != null)
                        continue;

                    String toscaCostResponseXML = CreateBookingUK.createToscaCostResponseXML(toscaCostResponse);
                    OTAPkgBookRQ toscaBookRequest = CreateBookingUK.createToscaBookRequest(toscaCostRequest);
                    String toscaBookRequestXML = CreateBookingUK.createToscaBookRequestXML(toscaBookRequest);
                    OTAPkgBookRS toscaBookResponse = CreateBookingUK.getToscaBookResponse(toscaBookRequestXML, tosca);
                    String toscaBookResponseXML = CreateBookingUK.createToscaBookResponseXML(toscaBookResponse);
                    OTAPkgBookRQ toscaBookCommitRequest = CreateBookingUK.createToscaBookCommitRequest(toscaBookRequest, toscaBookResponse);
                    String toscaBookCommitRequestXML = CreateBookingUK.createToscaBookRequestXML(toscaBookCommitRequest);
                    OTAPkgBookRS toscaBookCommitResponse = CreateBookingUK.getToscaBookResponse(toscaBookCommitRequestXML, tosca);
                    if (toscaBookCommitResponse.getSuccess() == null) continue;
                    System.out.println(toscaBookCommitResponse.getPackageReservation().getUniqueID().getID());
                } catch (JAXBException | IOException | DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
            }



            /*HashMap<String, Object> result = CreateBookingUK.checkSolrPackages(tosca, holder.getOtaPkgSearchRS(), holder.getPassengers());
            holder.setToscaAvailabilityResponse((OTAPkgAvailRS) result.get("response"));
            holder.setToscaAvailabiltyRequest((OTAPkgAvailRQ)result.get("request"));
            holder.setToscaExtrasRequest(CreateBookingUK.createToscaExtrasRequest(holder.getToscaAvailabiltyRequest(),holder.getToscaAvailabilityResponse(), holder.getPassengers()));
            OTAPkgExtrasInfoRS extrasResponse;
            try {
                extrasResponse = CreateBookingUK.getToscaExtrasResponse(holder.getToscaExtrasRequest(), tosca);
                assert !(extrasResponse == null) : "Extras response is null";
                holder.setToscaExtrasResponse(extrasResponse);
            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
            CreateBookingUK.createToscaCostRequest(holder.getToscaExtrasResponse(), holder.getToscaExtrasRequest());*/
        });

        When("^confirm package$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^booking is created$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Given("^I have Tosca booking$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^I create XML for Webrio$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^send it to WebRio$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^WebRio answered without errors$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^I create OnTour xml$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^put it on OnTour sftp$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^OnTour processed XML without errors$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

    }
}
