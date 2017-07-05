package com.thomascook.ids.e2e.steps;

import com.thomascook.ids.e2e.tests.CreateBooking;
import cucumber.api.java8.En;
import org.opentravel.ota._2003._05.response.OTAPkgSearchRS;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by omm on 6/26/2017.
 */
public class Steps implements En{
    OTAPkgSearchRS otaPkgSearchRS;
    CreateBooking createBooking = new CreateBooking();
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
            assert(true);
            //createBooking.checkPackageAvailability(otaPkgSearchRS);
        });

        Then("^NURVIS returns booking ID$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assert(true);
        });
    }
}
