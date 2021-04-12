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

import java.util.Calendar;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectCities implements Task {

    private BetweenModel cities;
    private int travelDay;
    private TravelocityHomePage travel;
    public SelectCities(BetweenModel cities){
        this.cities = cities;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        travelDay = Date.start(5);

       try {
           actor.attemptsTo(
                   Click.on(FLIGHTS_BUTTON),
                   Click.on(ONE_WAY_BUTTON),
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
                   Click.on(travel.listDays().get(travelDay)),
                   Click.on(DONE_CALENDAR_BUTTON),
                   Click.on(SEARCH_BUTTON)
           );


       }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
       }
    }


    public static SelectCities forFlight(BetweenModel cities) {
        return instrumented(SelectCities.class, cities);
    }
}
