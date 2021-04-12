package com.devco.travelocity.stepdefinitions;

import com.devco.travelocity.questions.CardSelected;
import com.devco.travelocity.tasks.SearchThingsToDo;
import com.devco.travelocity.tasks.SelectThings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ThingsToDoStepDefinitions {

    @Given("^the user is in travelocity page, select things to do in \"([^\"]*)\"$")
    public void theUserIsInTravelocityPageSelectThingsToDoIn(String city) {
        theActorInTheSpotlight().wasAbleTo(
                SearchThingsToDo.InThe(city)
        );
    }


    @When("^he select things to do of Attractions$")
    public void heSelectThingsToDoOfAttractions() {
        theActorInTheSpotlight().attemptsTo(
                SelectThings.toDo()
        );

    }

    @Then("^he can see the information of his selection$")
    public void heCanSeeTheInformationOfHisSelection() {
        theActorInTheSpotlight().should(
                seeThat(CardSelected.info())
        );

    }


}
