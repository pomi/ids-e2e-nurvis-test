package com.thomascook.ids.e2e.steps;

import com.thomascook.Context;
import com.thomascook.ids.e2e.Holder;
import com.thomascook.ids.e2e.tests.CreateBookingUK;
import com.thomascook.toscaAdapter.request.OTAPkgAvailRQ;
import com.thomascook.toscaAdapter.response.OTAPkgAvailRS;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.util.HashMap;

@ContextConfiguration(classes = Context.class)
public class CreateBookingForUKSteps implements En {

    @Autowired
    private Holder holder;

    @Value("${staging.uk.solr}")
    String solrStaging;

    @Value("${staging.uk.tosca}")
    String toscaStaging;

    public CreateBookingForUKSteps() {

        Given("^I request packages in SOLR from (.*?) to (.*?) with passengers$", (String departureAirport, String destination, DataTable dataTable) -> {
            String solr = "";
            if(System.getProperty("env").equals("staging")) solr = solrStaging;
            assert !solr.isEmpty() : "Solr endpoint is not set";
            try {
                holder.setPassengers(dataTable);
                holder.setOtaPkgSearchRS(CreateBookingUK.getSOLRPackagesUK(solr, departureAirport, destination, dataTable));
                assert !holder.getOtaPkgSearchRS().getHotelOffers().getHotelOffer().isEmpty() : "Hotel offers list is empty";
            } catch (IOException | JAXBException | DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        });

        When("^I check availability in Tosca$", () -> {
            String tosca = "";
            if(System.getProperty("env").equals("staging")) tosca = toscaStaging;
            assert !tosca.isEmpty() : "Solr endpoint is not set";
            HashMap<String, Object> result = CreateBookingUK.checkSolrPackages(toscaStaging, holder.getOtaPkgSearchRS(), holder.getPassengers());
            holder.setToscaAvailabilityResponse((OTAPkgAvailRS) result.get("response"));
            holder.setToscaAvailabiltyRequest((OTAPkgAvailRQ)result.get("request"));
        });

        When("^add extras$", () -> {
            String tosca = "";
            if(System.getProperty("env").equals("staging")) tosca = toscaStaging;
            assert !tosca.isEmpty() : "Solr endpoint is not set";
            CreateBookingUK.createToscaExtrasRequest(holder.getToscaAvailabiltyRequest(),holder.getToscaAvailabilityResponse(), holder.getPassengers());
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
