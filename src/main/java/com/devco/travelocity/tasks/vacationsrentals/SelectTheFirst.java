package com.devco.travelocity.tasks.vacationsrentals;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.devco.travelocity.userinterfaces.RoamNearHomePage.FIRST_HOTEL_OF_LIST;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectTheFirst implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    Click.on(FIRST_HOTEL_OF_LIST),
                    SwitchTo.newTab()
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECT_HOTEL_PAGE,e);
        }

    }

    public static SelectTheFirst hotel() {
        return instrumented(SelectTheFirst.class);
    }
}
