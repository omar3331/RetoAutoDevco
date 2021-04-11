package com.devco.travelocity.questions;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.tasks.SelectFlight;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.AvailableFlightsPage.FLIGHT_TIME_SELECTED;

public class Selected implements Question<Boolean> {
    private String fligthHour;


    @Override
    public Boolean answeredBy(Actor actor) {
        try{
            fligthHour = FLIGHT_TIME_SELECTED.resolveFor(actor).getText();

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECTED_FLIGHT_PAGE, e);
        }

        return (fligthHour.equals(SelectFlight.getFlightHour()));
    }

    public static Selected flight() {
        return new Selected();
    }
}
