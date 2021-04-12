package com.devco.travelocity.questions;

import com.devco.travelocity.exceptions.CanNotFindTheElementOfThePageException;
import com.devco.travelocity.tasks.SelectThings;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.ThingsToDoPage.TITLE_SELECTED_THING;

public class CardSelected implements Question<Boolean> {

    private String title;
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            title = TITLE_SELECTED_THING.resolveFor(actor).getText();

        }catch (Exception e){
            throw new CanNotFindTheElementOfThePageException(CanNotFindTheElementOfThePageException.FAILED_LOCATION_ELEMENTS_THINGS_TO_DO_PAGE, e);
        }
        return title.equals(SelectThings.getSelectedCard());
    }

    public static CardSelected info() {
        return new CardSelected();
    }
}
