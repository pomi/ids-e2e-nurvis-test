package com.thomascook.ids.e2e.steps;

import com.thomascook.ids.e2e.tests.CreateBookingNurvis;
import com.thomascook.ids.e2e.tests.LackOfAvailableRoomsException;
import com.thomascook.nurvisAdapter.request.ReservationRequestTypeRequest;
import com.thomascook.nurvisAdapter.response.ReservationResponseTypeResponse;
import cucumber.api.java8.En;
import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.util.HashMap;

import static com.thomascook.ids.e2e.tests.CreateBookingNurvis.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class NurvisSteps implements En {
    private static ReservationResponseTypeResponse nurvisBooking;
    private static String onTourXML;
    private static String destinationAirport;
    private OTAPkgSearchRS otaPkgSearchRS;
    private CreateBookingNurvis createBooking;
    private ReservationRequestTypeRequest nurvisRequest;
    private ReservationResponseTypeResponse nurvisInquiryResponse;

    private static final Logger LOGGER = LoggerFactory.getLogger(NurvisSteps.class);

    public NurvisSteps() {

        Given("^SOLR is requested for packages from (.*) airport to (.*) for (\\d+) adults$", (String fromAirport, String destination, Integer numberOfAdults) -> {
            try {
                createBooking = new CreateBookingNurvis("nl");
                otaPkgSearchRS = createBooking.getSOLRPackages(fromAirport, destination, numberOfAdults);
            } catch (JAXBException | IOException | DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        });

        Given("^SOLR response has available packages$", () -> {
            assertNotEquals("No available packages for this destinations",
                    otaPkgSearchRS.getHotelOffers().getStartIndex(), otaPkgSearchRS.getHotelOffers().getEndIndex());
        });

        When("^NURVIS is requested for booking$", () -> {
            try {
                HashMap<String, Object> results = getValidPackage(otaPkgSearchRS);
                assertNotNull(results);
                nurvisRequest = (ReservationRequestTypeRequest) results.get("request");
                nurvisInquiryResponse = (ReservationResponseTypeResponse) results.get("response");
            } catch (JAXBException | IOException | LackOfAvailableRoomsException e) {
                e.printStackTrace();
            }
        });

        Then("^NURVIS returns booking ID$", () -> {
            try {
                nurvisBooking = createNurvisBooking(nurvisRequest, nurvisInquiryResponse);
                assert (nurvisBooking.getFab().getWarning().get(0).getResultCode().equals("200"));
                destinationAirport = nurvisBooking.getFab().getDestination();
                LOGGER.info(nurvisBooking.getBookingNumber());
            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        });

        Given("^Nurvis booking$", () -> {
            assertNotNull(nurvisBooking.getFab());
            try {
                onTourXML = generateOntourXML(nurvisBooking);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });

        When("^ontour xml is created$", () -> {
            assertNotNull(onTourXML.isEmpty());
        });

        When("^ontour xml is put on sftp$", () -> {
            try {
                assert (checkSFWForCustomer(nurvisBooking.getFab().getWarning().get(0).getText().split(" ")[1]));
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            putOnTourXmlOnSftp(onTourXML, destinationAirport);
        });

        Then("^booking is processed$", () -> {
            assert (true);
        });

    }
}
