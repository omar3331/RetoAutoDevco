package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.interactions.SwitchTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.devco.travelocity.userinterfaces.ThingsToDoPage.ATTRACTIONS_CARD;
import static com.devco.travelocity.userinterfaces.ThingsToDoPage.ATTRACTION_CARD_TWO;
import static com.devco.travelocity.userinterfaces.ThingsToDoPage.INTEREST_THIRD;
import static com.devco.travelocity.userinterfaces.ThingsToDoPage.RECOMMENDATION_FIRST;
import static com.devco.travelocity.userinterfaces.ThingsToDoPage.TOURS_AND_ACTIVITIES_SIXTH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectThings implements Task {

    private static String selectedCard;

    public static String getSelectedCard() {
        return selectedCard;
    }

    public static void setSelectedCard(String selectedCard) {
        SelectThings.selectedCard = selectedCard;
    }

    public static SelectThings toDo() {
        return instrumented(SelectThings.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
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

        } catch (Exception e) {
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_SELECT_THINGS_TO_DO_PAGE, e);
        }

    }
}
