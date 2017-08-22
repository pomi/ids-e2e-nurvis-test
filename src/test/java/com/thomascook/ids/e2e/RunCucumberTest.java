package com.thomascook.ids.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  tags = {"@Tosca"},
        monochrome = true,
        features = "src/test/cucumber/",
        format = { "pretty",
                "html:cucumber-html-reports",
                "json:cucumber-html-reports/cucumber.json" },
        glue = "com.thomascook.ids.e2e" )
public class RunCucumberTest {
}
