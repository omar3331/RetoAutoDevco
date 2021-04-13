package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FLIGHTS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.ONE_WAY_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectOneWay implements Task {


    public static SelectOneWay Flight() {
        return instrumented(SelectOneWay.class);
    }

    @Override
    @Step("{1} select a one way option in home page")
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(FLIGHTS_BUTTON),
                    Click.on(ONE_WAY_BUTTON)
            );

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }

    }
}
