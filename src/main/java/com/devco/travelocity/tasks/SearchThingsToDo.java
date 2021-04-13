package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SelectTwo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DEPARTURE_DAY;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FIRST_ITEM_THINGS_TO_DO;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.MORE_TRAVEL_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.SEARCH_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.THINGS_TO_DO_FIELD_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.THINGS_TO_DO_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.THINGS_TO_DO_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchThingsToDo implements Task {

    private static final int NEXT_DAYS = 3;
    private static final int LATER_DAYS = 8;
    private static final int WAIT_TIME_ONE = 1;
    private final String city;

    public SearchThingsToDo(String city) {
        this.city = city;
    }

    public static SearchThingsToDo InThe(String city) {
        return instrumented(SearchThingsToDo.class, city);
    }

    @Override
    @Step("{1} search things to do in a period")
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(MORE_TRAVEL_BUTTON),
                    Click.on(THINGS_TO_DO_OPTION),
                    Click.on(THINGS_TO_DO_INPUT),
                    Enter.keyValues(city).into(THINGS_TO_DO_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_THINGS_TO_DO, isEnabled()).forNoMoreThan(WAIT_TIME_ONE).seconds(),
                    Click.on(FIRST_ITEM_THINGS_TO_DO),
                    Click.on(DEPARTURE_DAY)
            );

            actor.attemptsTo(
                    SelectTwo.dates(NEXT_DAYS, LATER_DAYS),
                    Click.on(SEARCH_BUTTON)
            );

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_THINGS_TO_DO_PAGE, e);
        }

    }
}
