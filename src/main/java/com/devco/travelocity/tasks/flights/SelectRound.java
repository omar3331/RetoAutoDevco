package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.models.BetweenModel;
import com.devco.travelocity.userinterfaces.TravelocityHomePage;
import com.devco.travelocity.utils.Date;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectRound implements Task {

    private BetweenModel cities;
    private int dayToTravel;
    private int dayToReturn;
    private TravelocityHomePage travelDays;

    public SelectRound(BetweenModel cities){
        this.cities = cities;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        dayToTravel = Date.start(6);
        dayToReturn = Date.end(15);

        try {
            actor.attemptsTo(
                    Click.on(FLIGHTS_BUTTON),
                    Click.on(ORIGIN_INPUT),
                    Enter.keyValues(cities.getOrigin()).into(ORIGIN_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_ORIGIN, isEnabled()).forNoMoreThan(1).seconds(),
                    Click.on(FIRST_ITEM_ORIGIN),
                    Click.on(DESTINY_INPUT),
                    Enter.keyValues(cities.getDestiny()).into(DESTINY_FIELD_INPUT),
                    WaitUntil.the(DESTINY_FIELD_INPUT, isEnabled()).forNoMoreThan(1).seconds(),
                    Click.on(FIRST_ITEM_DESTINY),
                    Click.on(DEPARTURE_DAY)
            );

            actor.attemptsTo(
                    WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                    Click.on(travelDays.listDays().get(dayToTravel)),
                    Click.on(DONE_CALENDAR_BUTTON),
                    Click.on(RETURN_DAY)
            );

            actor.attemptsTo(
                    WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                    Click.on(travelDays.listDays().get(dayToReturn)),
                    Click.on(DONE_CALENDAR_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }
    }

    public static SelectRound trip(BetweenModel cities){
        return instrumented(SelectRound.class, cities);
    }
}
