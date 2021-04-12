package com.devco.travelocity.stepdefinitions;

import com.devco.travelocity.questions.HotelNearHome;
import com.devco.travelocity.tasks.vacationsrentals.SearchVacations;
import com.devco.travelocity.tasks.vacationsrentals.SelectTheFirst;
import com.devco.travelocity.tasks.vacationsrentals.SelectVacations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TravelLocallyStepDefinitions {

    @Given("^the user in in travelocity page, access to the option travel locally$")
    public void theUserInInTravelocityPageAccessToTheOptionTravelLocally() {
        theActorInTheSpotlight().wasAbleTo(
                SelectVacations.rentals()
        );
    }


    @When("^he search vacation rentals in \"([^\"]*)\" city and select one of them$")
    public void heSearchVacationRentalsInCityAndSelectOneOfThem(String city) {
        theActorInTheSpotlight().attemptsTo(
                SearchVacations.rentalInA(city),
                SelectTheFirst.hotel()
        );
    }

    @Then("^he can see the important information of he selected$")
    public void heCanSeeTheImportantInformationOfHeSelected() {
        theActorInTheSpotlight().should(
                seeThat(HotelNearHome.caracteristics())
        );
    }

}
