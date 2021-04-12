package com.devco.travelocity.stepdefinitions;

import com.devco.travelocity.questions.TheHotel;
import com.devco.travelocity.tasks.Reserving;
import com.devco.travelocity.tasks.SelectTheBest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchHotelStepDefinitions {

    @Given("^the user is in travelocity page, search hotel in \"([^\"]*)\"$")
    public void theUserIsInTravelocityPageSearchHotelIn(String country) {
        theActorInTheSpotlight().wasAbleTo(
                Reserving.hotel(country)
        );
    }


    @When("^he activate some one filters and select the hotel$")
    public void heActivateSomeOneFiltersAndSelectTheHotel() {
        theActorInTheSpotlight().attemptsTo(
                SelectTheBest.hotel()
        );

    }

    @Then("^he can see the selected hotel$")
    public void heCanSeeTheSelectedHotel() {
        theActorInTheSpotlight().should(
                seeThat(TheHotel.heSelected())
        );
    }

}
