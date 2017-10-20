package com.thomascook.ids.e2e.steps;

import com.thomascook.msdAdaptor.MsdSession;
import com.thomascook.msdAdaptor.msdBookingDetails.MsdBookingDetails;
import com.thomascook.utils.Holder;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class MsdBookingSteps implements En {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsdBookingSteps.class);

    public MsdBookingSteps() {
        Given("^I should see that booking (\\d+) has passengers list$", (String bookingId, DataTable paxExpectedList) -> {
            String bookingGuid;
            HashSet<String> paxSet;

            HashSet<String> paxExpectedSet = new HashSet<>(paxExpectedList.asList(String.class));
            bookingGuid = MsdSession.get().getBookingGuidByMsdId(bookingId);


            MsdBookingDetails booking = new MsdBookingDetails();
            booking.setTransports(MsdSession.get().getBookingTransportsServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getTransports().forEach(it -> LOGGER.info(it.toString()));

            booking.setGeneralDetails(MsdSession.get().getBookingGeneralDetailsByBookingId(bookingId).prettyPrint());
            LOGGER.info(booking.getGeneralDetails().toString());

            booking.setAccommodations(MsdSession.get().getAccommodationServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getAccommodations().forEach(it -> LOGGER.info(it.toString()));

            booking.setTransfers(MsdSession.get().getBookingTransfersServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getTransfers().forEach(it -> LOGGER.info(it.toString()));

            booking.setExtraServices(MsdSession.get().getBookingExtraServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getExtraServices().forEach(it -> LOGGER.info(it.toString()));

            booking.setCustomer(MsdSession.get().getCustomerObjectByBookingId(bookingId).prettyPrint());
            LOGGER.info(booking.getCustomer().toString());

            LOGGER.info(booking.toString());


            paxSet = MsdSession.get().getAccommodationPaxByTcBookingGuid(bookingGuid);
            Assert.assertEquals(paxExpectedSet, paxSet);
        });

        Then("^I should see a booking with same number exists in msD$", () -> {
            String bookingGuid;

            bookingGuid = MsdSession.get().getBookingGuidByMsdId(Holder.get().getBookingNumber());
            assert bookingGuid != null;
        });

        And("^booking in msD should have same details as were set in onTour XML$", () -> {
            MsdBookingDetails msdBookingDetails = new MsdBookingDetails(Holder.get().getBookingNumber());

            Holder.get().setMsdBookingDetails(msdBookingDetails);
            LOGGER.info(msdBookingDetails.toString());
            msdBookingDetails.assertSameAsOnTourBookingInHolder();
        });
    }
}
