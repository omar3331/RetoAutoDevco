package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SelectTwo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DECREASE_AMOUNT_TRAVELERS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DEPARTURE_DAY;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DONE_TRAVELERS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FIRST_ITEM_GOING_TO;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.GOING_TO_FIELD_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.GOING_TO_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.HOTELS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.INCREASE_AMOUNT_CHILDREN_TRAVELERS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.SEARCH_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.TRAVELERS_HOTEL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Reserving implements Task {

    private static final int NEXT_DAYS = 15;
    private static final int LATER_DAYS = 30;
    private static final int WAIT_TIME_ONE = 1;
    private final String country;

    public Reserving(String country) {
        this.country = country;
    }

    public static Reserving hotel(String country) {
        return instrumented(Reserving.class, country);
    }

    @Override
    @Step("{1} introduce data to reserve a hotel")
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(HOTELS_BUTTON),
                    Click.on(GOING_TO_INPUT),
                    Enter.keyValues(country).into(GOING_TO_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_GOING_TO, isEnabled()).forNoMoreThan(WAIT_TIME_ONE).seconds(),
                    Click.on(FIRST_ITEM_GOING_TO),
                    Click.on(DEPARTURE_DAY)
            );

            actor.attemptsTo(
                    SelectTwo.dates(NEXT_DAYS, LATER_DAYS),
                    Click.on(TRAVELERS_HOTEL),
                    Click.on(DECREASE_AMOUNT_TRAVELERS_BUTTON),
                    Click.on(INCREASE_AMOUNT_CHILDREN_TRAVELERS_BUTTON),
                    Click.on(DONE_TRAVELERS_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }

    }

}
