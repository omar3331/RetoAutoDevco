package com.devco.travelocity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.RoamNearHomePage.ERROR_MESSAGE_WITHOUT_CITY;

public class TheErrorMessage implements Question<Boolean> {

    private String message;

    public TheErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return message.equals(ERROR_MESSAGE_WITHOUT_CITY.resolveFor(actor).getText());
    }

    public static TheErrorMessage inScreen(String message) {
        return new TheErrorMessage(message);
    }
}
