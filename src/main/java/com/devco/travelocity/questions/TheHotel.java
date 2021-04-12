package com.devco.travelocity.questions;

import com.devco.travelocity.tasks.SelectTheBest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.HotelsPage.NAME_HOTEL_SELECTED;

public class TheHotel implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        return SelectTheBest.getHotelName().equals(NAME_HOTEL_SELECTED.resolveFor(actor).getText());
    }

    public static TheHotel heSelected() {
        return new TheHotel();
    }

}
