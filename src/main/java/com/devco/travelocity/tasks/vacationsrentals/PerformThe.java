package com.devco.travelocity.tasks.vacationsrentals;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.devco.travelocity.userinterfaces.RoamNearHomePage.VACATION_RENTALS_BUTTON;
import static com.devco.travelocity.userinterfaces.TravelocityHomePage.SEARCH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PerformThe implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    Click.on(VACATION_RENTALS_BUTTON),
                    Click.on(SEARCH_BUTTON)
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_ROAM_NEAR_HOME_PAGE, e);
        }

    }

    public static PerformThe search() {
        return instrumented(PerformThe.class);
    }
}
