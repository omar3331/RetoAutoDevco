package com.devco.travelocity.questions;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.tasks.flights.SelectFlight;
import com.devco.travelocity.tasks.flights.SelectRoundFlights;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.DEPARTURE_FLIGHT_TIME_SELECTED;
import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.RETURN_FLIGHT_TIME_SELECTED;

public class Selected implements Question<Boolean> {
    private String departureHour;
    private String returnHour;
    private boolean comprobation = false;
    private final String type;

    public Selected(String type) {
        this.type = type;
    }

    public static Selected flight(String type) {
        return new Selected(type);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            departureHour = DEPARTURE_FLIGHT_TIME_SELECTED.resolveFor(actor).getText();

            comprobation = departureHour.equals(SelectFlight.getFlightHour());

            if ("selected".equals(type)) {
                returnHour = RETURN_FLIGHT_TIME_SELECTED.resolveFor(actor).getText();

                comprobation = (departureHour.equals(SelectRoundFlights.getDepartureFlight()) &&
                        returnHour.equals(SelectRoundFlights.getReturnFlight()));
            }

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECTED_FLIGHT_PAGE, e);
        }

        return comprobation;
    }
}
