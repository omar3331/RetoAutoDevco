package com.devco.travelocity.tasks.vacationsrentals;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.TRAVEL_LOCALLY_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectVacations implements Task {


    public static SelectVacations rentals() {
        return instrumented(SelectVacations.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Scroll.to(TRAVEL_LOCALLY_OPTION),
                    Click.on(TRAVEL_LOCALLY_OPTION)
            );

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }

    }
}
