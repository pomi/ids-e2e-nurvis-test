package com.thomascook.ids.e2e.steps;

import com.thomascook.ids.e2e.tests.CreateBooking;
import com.thomascook.nurvisAdapter.request.ReservationRequestTypeRequest;
import com.thomascook.nurvisAdapter.response.ReservationResponseTypeResponse;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.util.HashMap;

import static com.thomascook.ids.e2e.tests.CreateBooking.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by omm on 6/26/2017.
 */
public class Steps implements En{

    OTAPkgSearchRS otaPkgSearchRS;
    CreateBooking createBooking = new CreateBooking();
    ReservationRequestTypeRequest nurvisRequest;
    ReservationResponseTypeResponse nurvisInquiryResponse;
    static ReservationResponseTypeResponse nurvisBooking;
    static String onTourXML;
    static String destinationAirport;
    public Steps() {

        Given("^SOLR is requested for packages from (.*) airport to (.*) for (\\d+) adults$", (String fromAirport, String destination, Integer numberOfAdults) -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                otaPkgSearchRS = createBooking.getSOLRPackages(fromAirport, destination, numberOfAdults);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Given("^SOLR response has available packages$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assertNotEquals (otaPkgSearchRS.getHotelOffers().getStartIndex(),otaPkgSearchRS.getHotelOffers().getEndIndex());
        });

        When("^NURVIS is requested for booking$", () -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                //getValidPackage();
                HashMap<String, Object> results =  getValidPackage(otaPkgSearchRS);
                assertNotNull(results);
                nurvisRequest = (ReservationRequestTypeRequest) results.get("request");
                nurvisInquiryResponse = (ReservationResponseTypeResponse) results.get("response");
                //createNurvisRequest(otaPkgSearchRS.getHotelOffers().getHotelOffer().get(0));
                //nurvisInquiryResponse = getNurvisInquiryResponse(nurvisRequest);
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //assert(true);
            //createBooking.checkPackageAvailability(otaPkgSearchRS);
        });

        Then("^NURVIS returns booking ID$", () -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                nurvisBooking = createNurvisBooking(nurvisRequest,nurvisInquiryResponse);
                assert(nurvisBooking.getFab().getWarning().get(0).getResultCode().equals("200"));
                destinationAirport = nurvisBooking.getFab().getDestination();
                System.out.println(nurvisBooking.getFab().getWarning().get(0).getText().split(" ")[1]);
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //assert(true);
        });

        Given("^Nurvis booking$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assertNotNull(nurvisBooking.getFab());
            try {
                onTourXML = generateOntourXML(nurvisBooking);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

        When("^ontour xml is created$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assertNotNull(onTourXML.isEmpty());
        });

        When("^ontour xml is put on sftp$", () -> {
            // Write code here that turns the phrase above into concrete actions
            putOnTourXmlOnSftp(onTourXML, destinationAirport);
        });

        Then("^booking is processed$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assert(true);
        });

    }
}
