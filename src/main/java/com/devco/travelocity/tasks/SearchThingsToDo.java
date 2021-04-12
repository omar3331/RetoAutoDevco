package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
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

public class SearchThingsToDo implements Task {

    private String city;
    private int startDay;
    private int endDay;
    private TravelocityHomePage dateToDo;

    public SearchThingsToDo(String city){
        this.city = city;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        startDay = Date.start(3);
        endDay = Date.end(8);

        try{
            actor.attemptsTo(
                    Click.on(MORE_TRAVEL_BUTTON),
                    Click.on(THINGS_TO_DO_OPTION),
                    Click.on(THINGS_TO_DO_INPUT),
                    Enter.keyValues(city).into(THINGS_TO_DO_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_THINGS_TO_DO, isEnabled()).forNoMoreThan(1).seconds(),
                    Click.on(FIRST_ITEM_THINGS_TO_DO),
                    Click.on(DEPARTURE_DAY)
            );

            actor.attemptsTo(
                    WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                    Click.on(dateToDo.listDays().get(startDay)),
                    Click.on(DONE_CALENDAR_BUTTON),
                    Click.on(RETURN_DAY)
            );

            actor.attemptsTo(
                    WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                    Click.on(dateToDo.listDays().get(endDay)),
                    Click.on(DONE_CALENDAR_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_THINGS_TO_DO_PAGE, e);
        }

    }

    public static SearchThingsToDo InThe(String city) {
        return instrumented(SearchThingsToDo.class, city);
    }
}
