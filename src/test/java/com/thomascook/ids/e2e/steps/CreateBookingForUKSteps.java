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

public class CreateBookingForUKSteps implements En {

    private static final String tosca = Config.get().getTosca();

    public CreateBookingForUKSteps() {

        Given("^I request packages in SOLR from (.*?) to (.*?) with passengers$", (String departureAirport, String destination, DataTable dataTable) -> {
            String solr = Config.get().getSolrUk();
            assert !solr.isEmpty() : "Solr endpoint is not set";
            try {
                Holder.get().setPassengers(dataTable);
                Holder.get().setOtaPkgSearchRS(CreateBookingUK.getSOLRPackagesUK(solr, departureAirport, destination, dataTable));
                assert !Holder.get().getOtaPkgSearchRS().getHotelOffers().getHotelOffer().isEmpty() : "Hotel offers list is empty";
            } catch (IOException | JAXBException | DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        });

        When("^I check availability in Tosca, and add extras, and check costs, and confirm package$", () -> {
            String tosca = Config.get().getTosca();
            assert !tosca.isEmpty() : "Tosca endpoint is not set";

            int iteration = 1;
            for (HotelOfferType hotelOffer : Holder.get().getOtaPkgSearchRS().getHotelOffers().getHotelOffer()) {
                System.out.println("Iteration number " + iteration++);
                try {
                    OTAPkgAvailRQ toscaAvailabilityRequest = CreateBookingUK.createToscaAvailabilityRequest(hotelOffer, Holder.get().getPassengers());
                    String toscaAvailabilityRequestXML = CreateBookingUK.createToscaAvailabilityRequestXML(toscaAvailabilityRequest);
                    assert !toscaAvailabilityRequestXML.equals("") : "Tosca availability Request XML is empty";
                    OTAPkgAvailRS toscaAvailabilityResponse = CreateBookingUK.getToscaResponse(tosca, toscaAvailabilityRequestXML);

                    if (toscaAvailabilityResponse.getSuccess() == null && toscaAvailabilityResponse.getErrors() != null)
                        continue;

                    String toscaAvailabilityResponseXML = CreateBookingUK.createToscaAvailabilityResponseXML(toscaAvailabilityResponse);
                    OTAPkgExtrasInfoRQ toscaExtrasRequest = CreateBookingUK.createToscaExtrasRequest(toscaAvailabilityRequest, toscaAvailabilityResponse, Holder.get().getPassengers());
                    String toscaExtrasRequestXML = CreateBookingUK.createToscaExtrasRequestXML(toscaExtrasRequest);
                    OTAPkgExtrasInfoRS toscaExtrasResponse = CreateBookingUK.getToscaExtrasResponse(toscaExtrasRequestXML, tosca);
                    String toscaExtrasResponseXML = CreateBookingUK.createToscaExtrasResponseXML(toscaExtrasResponse);

                    if (toscaExtrasResponse.getSuccess() == null && toscaExtrasResponse.getErrors() != null)
                        continue;

                    OTAPkgCostRQ toscaCostRequest = CreateBookingUK.createToscaCostRequest(toscaExtrasResponse, toscaExtrasRequest);
                    String toscaCostRequestXML = CreateBookingUK.createToscaCostRequestXML(toscaCostRequest);
                    OTAPkgCostRS toscaCostResponse = CreateBookingUK.getToscaCostResponse(toscaCostRequestXML, tosca);
                    String toscaCostResponseXML = CreateBookingUK.createToscaCostResponseXML(toscaCostResponse);

                    if (toscaCostResponse.getSuccess() == null && toscaCostResponse.getErrors() != null)
                        continue;

                    OTAPkgBookRQ toscaBookRequest = CreateBookingUK.createToscaBookRequest(toscaCostRequest);
                    Holder.get().setToscaBookingRequest(toscaBookRequest);
                    String toscaBookRequestXML = CreateBookingUK.createToscaBookRequestXML(toscaBookRequest);
                    OTAPkgBookRS toscaBookResponse = CreateBookingUK.getToscaBookResponse(toscaBookRequestXML, tosca);
                    Holder.get().setToscaBookingResponse(toscaBookResponse);
                    String toscaBookResponseXML = CreateBookingUK.createToscaBookResponseXML(toscaBookResponse);
                    System.out.println(toscaBookResponseXML);
                    OTAPkgBookRQ toscaBookCommitRequest = CreateBookingUK.createToscaBookCommitRequest(toscaBookRequest, toscaBookResponse);
                    String toscaBookCommitRequestXML = CreateBookingUK.createToscaBookRequestXML(toscaBookCommitRequest);
                    OTAPkgBookRS toscaBookCommitResponse = CreateBookingUK.getToscaBookResponse(toscaBookCommitRequestXML, tosca);
                    if (toscaBookCommitResponse.getSuccess() == null) continue;
                    Holder.get().setHotelOffer(hotelOffer);
                    Holder.get().setBookingReference(toscaBookCommitResponse.getPackageReservation().getUniqueID().getID());
                    if (toscaBookCommitResponse.getSuccess() == null) continue;
                    System.out.println(toscaBookCommitResponse.getPackageReservation().getUniqueID().getID());
                    break;
                } catch (JAXBException | IOException | DatatypeConfigurationException e) {
                    e.printStackTrace();
                    continue;
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

        Then("^booking is created$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assert true;
            //throw new PendingException();
        });

        Given("^I have Tosca booking$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assert true;
            //throw new PendingException();
        });

        When("^I create XML for Webrio$", () -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                //if(holder.getToscaBookingRequest() != null && holder.getToscaBookingResponse() != null && holder.getHotelOffer() != null && holder.getBookingReference() != null)
                Holder.get().setRetailinterfaceXML(CreateBookingUK.createWebRioRequest(Holder.get().getToscaBookingRequest(),
                        Holder.get().getToscaBookingResponse(), Holder.get().getHotelOffer(), Holder.get().getBookingReference()));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

        When("^send it to WebRio$", () -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                String retailinterface = Config.get().getRetailInterface();
                assert !retailinterface.isEmpty() : "retailinterface endpoint is not set";
                Holder.get().setRetailDownloadResponse(CreateBookingUK.sendWebrioHandoff(Holder.get().getRetailinterfaceXML(), retailinterface));
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Then("^WebRio answered without errors$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^I create OnTour xml$", () -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                CreateBookingUK.createOnTourXML(Holder.get().getToscaBookingResponse(), Holder.get().getToscaBookingRequest(), Holder.get().getBookingReference());
            } catch (JAXBException e) {
                e.printStackTrace();
            }
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
