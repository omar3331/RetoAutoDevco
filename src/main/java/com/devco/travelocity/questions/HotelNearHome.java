package com.devco.travelocity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.devco.travelocity.userinterfaces.HotelsPage.*;

public class HotelNearHome implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {


        return !NAME_HOTEL_SELECTED.resolveFor(actor).getText().isEmpty();
    }

    public static HotelNearHome caracteristics() {
        return new HotelNearHome();
    }

}
