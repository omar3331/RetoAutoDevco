package com.devco.travelocity.tasks.vacationsrentals;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SelectTwo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.RoamNearHomePage.GUEST_BUTTON;
import static com.devco.travelocity.userinterfaces.RoamNearHomePage.INCREASE_AMOUNT_ROOMS_BUTTON;
import static com.devco.travelocity.userinterfaces.RoamNearHomePage.INCREASE_AMOUNT_TRAVELERS_BUTTON;
import static com.devco.travelocity.userinterfaces.RoamNearHomePage.VACATION_RENTALS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DEPARTURE_DAY;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.DONE_TRAVELERS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.FIRST_ITEM_GOING_TO;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.GOING_TO_FIELD_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.GOING_TO_INPUT;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SearchVacations implements Task {

    private static final int NEXT_DAYS = 11;
    private static final int LATER_DAYS = 16;
    private static final int WAIT_TIME_ONE = 1;
    private final String city;

    public SearchVacations(String city) {
        this.city = city;
    }

    public static SearchVacations rentalInA(String city) {
        return instrumented(SearchVacations.class, city);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            actor.attemptsTo(
                    Click.on(VACATION_RENTALS_BUTTON),
                    Click.on(GOING_TO_INPUT),
                    Enter.keyValues(city).into(GOING_TO_FIELD_INPUT),
                    WaitUntil.the(FIRST_ITEM_GOING_TO, isEnabled()).forNoMoreThan(WAIT_TIME_ONE).seconds(),
                    Click.on(FIRST_ITEM_GOING_TO),
                    Click.on(DEPARTURE_DAY),
                    SelectTwo.dates(NEXT_DAYS, LATER_DAYS),
                    Click.on(GUEST_BUTTON),
                    Click.on(INCREASE_AMOUNT_TRAVELERS_BUTTON),
                    Click.on(INCREASE_AMOUNT_ROOMS_BUTTON),
                    Click.on(DONE_TRAVELERS_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );


        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_ROAM_NEAR_HOME_PAGE, e);
        }

    }
}
