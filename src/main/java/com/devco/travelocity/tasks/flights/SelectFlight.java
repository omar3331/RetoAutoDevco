package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.CONTINUE_BUTTON;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.FIRST_FLIGHT_LIST;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.FLIGHT_TIME;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.IGNORE_SEARCH;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.PRICE_INCREASING_OPTION;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.SORT_BY_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFlight implements Task {

    private static String flightHour;

    public static String getFlightHour() {
        return flightHour;
    }

    public static void setFlightHour(String flightHour) {
        SelectFlight.flightHour = flightHour;
    }

    public static SelectFlight toTravel() {
        return instrumented(SelectFlight.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(SORT_BY_BUTTON),
                    Click.on(PRICE_INCREASING_OPTION)
            );
            setFlightHour(FLIGHT_TIME.resolveFor(actor).getText());

            actor.attemptsTo(
                    Click.on(FIRST_FLIGHT_LIST),
                    Click.on(CONTINUE_BUTTON),
                    Click.on(IGNORE_SEARCH)
            );

            actor.attemptsTo(
                    SwitchTo.newTab()
            );


        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECT_FLIGHT_PAGE, e);
        }

    }
}
