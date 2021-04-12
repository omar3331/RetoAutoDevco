package com.devco.travelocity.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/travel_locally.feature",
        glue = "com.devco.travelocity.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)
public class TravelLocallyRunner {
}
