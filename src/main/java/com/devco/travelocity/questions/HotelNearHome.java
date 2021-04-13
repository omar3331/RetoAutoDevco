package com.devco.travelocity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static com.devco.travelocity.userinterfaces.HotelsPage.NAME_HOTEL_SELECTED;

public class HotelNearHome implements Question<Boolean> {


    public static HotelNearHome caracteristics() {
        return new HotelNearHome();
    }

    @Override
    @Step("{4} validate the hotel selected")
    public Boolean answeredBy(Actor actor) {


        return !NAME_HOTEL_SELECTED.resolveFor(actor).getText().isEmpty();
    }

}
