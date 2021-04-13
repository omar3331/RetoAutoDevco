package com.devco.travelocity.tasks.flights;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SelectTwo;
import com.devco.travelocity.models.BetweenModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DEPARTURE_DAY;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DESTINY_FIELD_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DESTINY_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FIRST_ITEM_DESTINY;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FIRST_ITEM_ORIGIN;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FLIGHTS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.ORIGIN_FIELD_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.ORIGIN_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SelectRound implements Task {

    private static final int NEXT_DAYS = 6;
    private static final int LATER_DAYS = 15;
    private static final int WAIT_TIME_ONE = 1;
    private final BetweenModel cities;

    public SelectRound(BetweenModel cities) {
        this.cities = cities;
    }

    public static SelectRound trip(BetweenModel cities) {
        return instrumented(SelectRound.class, cities);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(FLIGHTS_BUTTON),
                    Click.on(ORIGIN_INPUT),
                    Enter.keyValues(cities.getOrigin()).into(ORIGIN_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_ORIGIN, isEnabled()).forNoMoreThan(WAIT_TIME_ONE).seconds(),
                    Click.on(FIRST_ITEM_ORIGIN),
                    Click.on(DESTINY_INPUT),
                    Enter.keyValues(cities.getDestiny()).into(DESTINY_FIELD_INPUT),
                    WaitUntil.the(DESTINY_FIELD_INPUT, isEnabled()).forNoMoreThan(WAIT_TIME_ONE).seconds(),
                    Click.on(FIRST_ITEM_DESTINY),
                    Click.on(DEPARTURE_DAY)
            );

            actor.attemptsTo(
                    SelectTwo.dates(NEXT_DAYS, LATER_DAYS),
                    Click.on(SEARCH_BUTTON)
            );

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }
    }
}
