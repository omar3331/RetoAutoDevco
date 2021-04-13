package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static com.devco.travelocity.userinterfaces.HotelsPage.BEDROOMS_SELECT;
import static com.devco.travelocity.userinterfaces.HotelsPage.FIVE_STARS_SELECT;
import static com.devco.travelocity.userinterfaces.HotelsPage.FOUR_HOTEL_OF_LIST;
import static com.devco.travelocity.userinterfaces.HotelsPage.NAME_FOUR_HOTEL_OF_LIST;
import static com.devco.travelocity.userinterfaces.HotelsPage.THE_BEST_RATING_SELECT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectTheBest implements Task {

    private static String hotelName;

    public static String getHotelName() {
        return hotelName;
    }

    public static void setHotelName(String hotelName) {
        SelectTheBest.hotelName = hotelName;
    }

    public static SelectTheBest hotel() {
        return instrumented(SelectTheBest.class);
    }

    @Override
    @Step("{2} select a hotel of the list")
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(FIVE_STARS_SELECT),
                    Scroll.to(THE_BEST_RATING_SELECT),
                    Click.on(THE_BEST_RATING_SELECT),
                    Scroll.to(BEDROOMS_SELECT),
                    Click.on(BEDROOMS_SELECT),
                    Scroll.to(FOUR_HOTEL_OF_LIST)
            );
            setHotelName(NAME_FOUR_HOTEL_OF_LIST.resolveFor(actor).getText());

            actor.attemptsTo(
                    Click.on(FOUR_HOTEL_OF_LIST),
                    SwitchTo.newTab()
            );

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECT_HOTEL_PAGE, e);
        }
    }
}
