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

    private MsdSession msdSession;

    public MsdBookingSteps() {
        Given("^I should see that booking (\\d+) has passengers list$", (String bookingId, DataTable paxExpectedList) -> {
            String bookingGuid;
            HashSet<String> paxSet;

            HashSet<String> paxExpectedSet = new HashSet<>(paxExpectedList.asList(String.class));
            if (msdSession == null) {
                msdSession = new MsdSession();
            }

            bookingGuid = msdSession.getBookingGuidByMsdId(bookingId);


            MsdBookingDetails booking = new MsdBookingDetails();
            booking.setTransports(msdSession.getBookingTransportsServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getTransports().forEach(it -> LOGGER.info(it.toString()));

            booking.setGeneralDetails(msdSession.getBookingGeneralDetailsByBookingId(bookingId).prettyPrint());
            LOGGER.info(booking.getGeneralDetails().toString());

            booking.setAccomodations(msdSession.getAccommodationServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getAccommodations().forEach(it -> LOGGER.info(it.toString()));

            booking.setTransfers(msdSession.getBookingTransfersServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getTransfers().forEach(it -> LOGGER.info(it.toString()));

            booking.setExtraServices(msdSession.getBookingExtraServiceByBookingGuid(bookingGuid).prettyPrint());
            booking.getExtraServices().forEach(it -> LOGGER.info(it.toString()));

            booking.setCustomer(msdSession.getCustomerObjectByBookingId(bookingId).prettyPrint());
            LOGGER.info(booking.getCustomer().toString());

            LOGGER.error("====================== annnnnnddd... ========================");
            LOGGER.info(booking.toString());


            paxSet = msdSession.getAccommodationPaxByTcBookingGuid(bookingGuid);
            Assert.assertEquals(paxExpectedSet, paxSet);
        });

        Then("^I should see a booking with same number exists in msD$", () -> {
            String bookingGuid;

            if (msdSession == null) {
                msdSession = new MsdSession();
            }

            bookingGuid = msdSession.getBookingGuidByMsdId(Holder.get().getBookingNumber());
            assert bookingGuid != null;

        });
    }
}
