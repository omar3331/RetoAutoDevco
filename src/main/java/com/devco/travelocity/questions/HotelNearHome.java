package com.devco.travelocity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.HotelsPage.NAME_HOTEL_SELECTED;

public class HotelNearHome implements Question<Boolean> {


    public static HotelNearHome caracteristics() {
        return new HotelNearHome();
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        return !NAME_HOTEL_SELECTED.resolveFor(actor).getText().isEmpty();
    }

}
