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

public class Reserving implements Task {

    private String country;

    public Reserving(String country){
        this.country = country;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        try{
            actor.attemptsTo(
                    Click.on(HOTELS_BUTTON),
                    Click.on(GOING_TO_INPUT),
                    Enter.keyValues(country).into(GOING_TO_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_GOING_TO, isEnabled()).forNoMoreThan(1).seconds(),
                    Click.on(FIRST_ITEM_GOING_TO),
                    Click.on(DEPARTURE_DAY)
            );

            actor.attemptsTo(
                    SelectTwo.dates(15,30),
                    Click.on(TRAVELERS_HOTEL),
                    Click.on(DECREASE_AMOUNT_TRAVELERS_BUTTON),
                    Click.on(INCREASE_AMOUNT_CHILDREN_TRAVELERS_BUTTON),
                    Click.on(DONE_TRAVELERS_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_HOME_PAGE, e);
        }

    }

    public static Reserving hotel(String country) {
        return instrumented(Reserving.class, country);
    }

}
