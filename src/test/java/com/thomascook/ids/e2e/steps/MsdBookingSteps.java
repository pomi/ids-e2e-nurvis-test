package com.thomascook.ids.e2e.steps;

import com.thomascook.msdAdaptor.MsdBookings;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.Assert;

import java.util.HashSet;

public class MsdBookingSteps implements En {

    private MsdBookings msdSession;

    public MsdBookingSteps() {
        Given("^I should see that booking (\\d+) has passengers list$", (Integer bookingId, DataTable paxExpectedList) -> {
            String bookingGuid;
            HashSet<String> paxSet;
            HashSet<String> paxExpectedSet = new HashSet<>(paxExpectedList.asList(String.class));
            msdSession = new MsdBookings();

            bookingGuid = msdSession.getBookingGuidByMsdId(bookingId.toString());
            paxSet = msdSession.getAccommodationPaxByTcBookingGuid(bookingGuid);
            Assert.assertEquals(paxExpectedSet, paxSet);
        });
    }
}
