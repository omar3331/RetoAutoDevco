package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FIRST_ITEM_ORIGIN;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.ORIGIN_FIELD_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.ORIGIN_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchWithout implements Task {


    private static final String CITY = "Peru";
    private static final int WAIT_TIME_ONE = 1;

    public static SearchWithout destinyCity() {
        return instrumented(SearchWithout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(ORIGIN_INPUT),
                    Enter.keyValues(CITY).into(ORIGIN_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_ORIGIN, isEnabled()).forNoMoreThan(WAIT_TIME_ONE).seconds(),
                    Click.on(FIRST_ITEM_ORIGIN),
                    Click.on(SEARCH_BUTTON)
            );
        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }


    }
}
