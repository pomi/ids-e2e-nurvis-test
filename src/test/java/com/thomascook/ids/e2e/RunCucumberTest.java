package com.thomascook.ids.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by omm on 6/19/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(  tags = {"@Test"},
        monochrome = true,
        features = "src/test/cucumber/",
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },
        glue = "com.thomascook.ids.e2e" )
public class RunCucumberTest {
}
