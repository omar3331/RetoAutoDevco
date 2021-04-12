package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.*;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.IGNORE_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectRoundFlights implements Task {

    private static String departureFlight;
    private static String returnFlight;

    public static String getDepartureFlight() {
        return departureFlight;
    }

    public static void setDepartureFlight(String departureFlight) {
        SelectRoundFlights.departureFlight = departureFlight;
    }

    public static String getReturnFlight() {
        return returnFlight;
    }

    public static void setReturnFlight(String returnFlight) {
        SelectRoundFlights.returnFlight = returnFlight;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(SORT_BY_BUTTON),
                    Click.on(SHORT_DURATION_OPTION)
            );
            setDepartureFlight(FLIGHT_TIME.resolveFor(actor).getText());

            actor.attemptsTo(
                    Click.on(FIRST_FLIGHT_LIST),
                    Click.on(CONTINUE_BUTTON)
            );

            actor.attemptsTo(
                    Click.on(SORT_BY_BUTTON),
                    Click.on(EARLY_DEPARTURE_OPTION)
            );
            setReturnFlight(FLIGHT_TIME.resolveFor(actor).getText());

            actor.attemptsTo(
                    Click.on(FIRST_FLIGHT_LIST),
                    Click.on(CONTINUE_BUTTON),
                    Click.on(IGNORE_SEARCH)
            );

            actor.attemptsTo(
                    SwitchTo.newTab()
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECT_FLIGHT_PAGE, e);
        }
    }

    public static SelectRoundFlights toTravel() {
        return instrumented(SelectRoundFlights.class);
    }
}
