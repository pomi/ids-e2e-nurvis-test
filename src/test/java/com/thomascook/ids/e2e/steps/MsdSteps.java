package com.thomascook.ids.e2e.steps;

import com.thomascook.msdAdaptor.MsdBookings;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.Assert;

import java.util.HashSet;

class MsdSteps implements En {

    private MsdBookings booking;

    public MsdSteps() {
        Given("^I should see that booking (\\d+) has passengers list$", (Integer bookingId, DataTable paxExpectedList) -> {
            String bookingGuid;
            HashSet<String> paxSet;
            HashSet<String> paxExpectedSet = new HashSet<>(paxExpectedList.asList(String.class));

            bookingGuid = booking.getBookingGuidByMsdId(bookingId.toString());
            paxSet = booking.getAccommodationPaxByTcBookingGuid(bookingGuid);
            Assert.assertEquals(paxExpectedSet, paxSet);
        });
    }


}
