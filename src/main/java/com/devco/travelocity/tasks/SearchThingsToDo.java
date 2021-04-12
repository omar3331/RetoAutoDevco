package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SelectTwo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchThingsToDo implements Task {

    private String city;

    public SearchThingsToDo(String city){
        this.city = city;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

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
                    SelectTwo.dates(3,8),
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
