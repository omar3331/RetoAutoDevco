package com.devco.travelocity.tasks.vacationsrentals;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SelectTwo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.RoamNearHomePage.*;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchVacations implements Task {

    private String city;

    public SearchVacations(String city){
        this.city = city;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            actor.attemptsTo(
                    Click.on(VACATION_RENTALS_BUTTON),
                    Click.on(GOING_TO_INPUT),
                    Enter.keyValues(city).into(GOING_TO_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_GOING_TO, isEnabled()).forNoMoreThan(1).seconds(),
                    Click.on(FIRST_ITEM_GOING_TO),
                    Click.on(DEPARTURE_DAY),
                    SelectTwo.dates(11,16),
                    Click.on(GUEST_BUTTON),
                    Click.on(INCREASE_AMOUNT_TRAVELERS_BUTTON),
                    Click.on(INCREASE_AMOUNT_ROOMS_BUTTON),
                    Click.on(DONE_TRAVELERS_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );



        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_ROAM_NEAR_HOME_PAGE, e);
        }

    }

    public static SearchVacations rentalInA(String city) {
        return instrumented(SearchVacations.class, city);
    }
}
