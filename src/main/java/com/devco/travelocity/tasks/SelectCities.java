package com.devco.travelocity.tasks;

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
    private int dayToday;
    private Calendar day;
    private TravelocityHomePage travelDays;
    public SelectCities(BetweenModel cities){
        this.cities = cities;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        day = Date.dateSys();
        dayToday = day.get(Calendar.DAY_OF_MONTH)-1;

       try {
           actor.attemptsTo(
                   Click.on(FLIGHTS_BUTTON),
                   Click.on(ONE_WAY_BUTTON),
                   Click.on(INPUT_ORIGIN),
                   Enter.keyValues(cities.getOrigin()).into(INPUT_ORIGIN_FIELD),
                   WaitUntil.the(FIRST_ITEM_ORIGIN, isEnabled()).forNoMoreThan(1).seconds(),
                   Click.on(FIRST_ITEM_ORIGIN),
                   Click.on(INPUT_DESTINY),
                   Enter.keyValues(cities.getDestiny()).into(INPUT_DESTINY_FIELD),
                   WaitUntil.the(INPUT_DESTINY_FIELD, isEnabled()).forNoMoreThan(1).seconds(),
                   Click.on(FIRST_ITEM_DESTINY),
                   Click.on(TRAVEL_DATE)
                   );

           actor.attemptsTo(
                   WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                   Click.on(travelDays.listDays().get(dayToday)),
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
