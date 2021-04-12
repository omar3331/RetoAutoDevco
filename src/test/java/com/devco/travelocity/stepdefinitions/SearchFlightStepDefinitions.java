package com.devco.travelocity.stepdefinitions;

import com.devco.travelocity.models.BetweenModel;
import com.devco.travelocity.questions.Selected;
import com.devco.travelocity.tasks.*;
import com.devco.travelocity.tasks.flights.SelectCities;
import com.devco.travelocity.tasks.flights.SelectFlight;
import com.devco.travelocity.tasks.flights.SelectRound;
import com.devco.travelocity.tasks.flights.SelectRoundFlights;
import com.devco.travelocity.userinterfaces.TravelocityHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchFlightStepDefinitions {

    private TravelocityHomePage travelocityHomePage;

    @Before
    public void setup() {

        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Omar").wasAbleTo(OpenTheBrowser.on(travelocityHomePage));
    }

    @Given("^the user is travelocity page, he select a travel between (.*) and (.*)$")
    public void theUserIsTravelocityPageHeSelectATravelBetweenAnd(String origin, String destiny) {
        theActorInTheSpotlight().wasAbleTo(
                SelectCities.forFlight(new BetweenModel(origin, destiny))
        );
    }


    @When("^he want the cheapest flight ticket$")
    public void heWantTheCheapestFlightTicket() {
        theActorInTheSpotlight().attemptsTo(
                SelectFlight.toTravel()
        );

    }


    @Then("^he check if the selected flight is the \"([^\"]*)\"$")
    public void heCheckIfTheSelectedFlightIsThe(String type) {
        theActorInTheSpotlight().should(
                seeThat(Selected.flight(type))
        );
    }

    @Given("^the user want to select a round trip between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserWantToSelectARoundTripBetweenAnd(String origin, String destiny) {
        theActorInTheSpotlight().wasAbleTo(
                SelectRound.trip(new BetweenModel(origin, destiny))
        );
    }


    @When("^he selected the shortest flights$")
    public void heSelectedTheShortestFlights() {
        theActorInTheSpotlight().attemptsTo(
                SelectRoundFlights.toTravel()
        );

    }

    @Then("^he check both of them flights \"([^\"]*)\"$")
    public void heCheckBothOfThemFlights(String type) {
        theActorInTheSpotlight().should(
                seeThat(Selected.flight(type))
        );
    }


}
