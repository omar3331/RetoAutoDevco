package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.ThingsToDoPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectThings implements Task {

    private static String selectedCard;

    public static String getSelectedCard() {
        return selectedCard;
    }

    public static void setSelectedCard(String selectedCard) {
        SelectThings.selectedCard = selectedCard;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try{
            actor.attemptsTo(
                    Click.on(ATTRACTIONS_CARD),
                    Click.on(RECOMMENDATION_FIRST),
                    Scroll.to(INTEREST_THIRD),
                    Click.on(INTEREST_THIRD),
                    Scroll.to(TOURS_AND_ACTIVITIES_SIXTH),
                    Click.on(TOURS_AND_ACTIVITIES_SIXTH),
                    Scroll.to(ATTRACTION_CARD_TWO)
            );

            selectedCard = ATTRACTION_CARD_TWO.resolveFor(actor).getText();

            actor.attemptsTo(
                    Click.on(ATTRACTION_CARD_TWO),
                    SwitchTo.newTab()
            );

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECT_THINGS_TO_DO_PAGE, e);
        }

    }

    public static SelectThings toDo() {
        return instrumented(SelectThings.class);
    }
}
