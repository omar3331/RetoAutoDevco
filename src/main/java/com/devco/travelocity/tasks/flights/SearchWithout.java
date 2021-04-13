package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchWithout implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(ORIGIN_INPUT),
                    Enter.keyValues("Peru").into(ORIGIN_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_ORIGIN, isEnabled()).forNoMoreThan(1).seconds(),
                    Click.on(FIRST_ITEM_ORIGIN),
                    Click.on(SEARCH_BUTTON)
            );
        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }


    }

    public static SearchWithout destinyCity() {
        return instrumented(SearchWithout.class);
    }
}
