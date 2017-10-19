package com.thomascook.ids.e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@Tosca,~@Ignore"},
        monochrome = true,
        features = "src/test/cucumber",
        format = {"pretty",
                "html:cucumber-html-reports",
                "json:cucumber-html-reports/cucumber.json"},
        glue = "com.thomascook.ids.e2e.steps",
        snippets = SnippetType.CAMELCASE
)
public class RunCucumberTest {
    @Rule
    public static ErrorCollector ERROR_COLLECTOR = new ErrorCollector();
}
