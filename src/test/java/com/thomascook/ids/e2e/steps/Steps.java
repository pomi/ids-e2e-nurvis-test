package com.thomascook.ids.e2e.steps;

import com.thomascook.ids.e2e.tests.CreateBooking;
import cucumber.api.java8.En;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

/**
 * Created by omm on 6/26/2017.
 */
public class Steps implements En{
    public Steps() {
        When("^I request SOLR for existing packages$", () -> {
            assert(true);
        });

        When("^make price request to nurvis NL endpoint$", () -> {
            assert(true);
        });

        When("^request extras to package$", () -> {
            assert(true);
        });

        Then("^booking created$", () -> {
            assert(true);
        });

        Given("^I have a list of packages from SOLR and want to book one of them in Nurvis$", () -> {
            CreateBooking createBooking = new CreateBooking();
            try {
                createBooking.getSOLRPackages();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        });
    }
}
