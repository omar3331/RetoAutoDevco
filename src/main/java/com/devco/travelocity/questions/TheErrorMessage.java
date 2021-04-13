package com.devco.travelocity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.devco.travelocity.userinterfaces.RoamNearHomePage.ERROR_MESSAGE_WITHOUT_CITY;

public class TheErrorMessage implements Question<Boolean> {

    private final String message;

    public TheErrorMessage(String message) {
        this.message = message;
    }

    public static TheErrorMessage inScreen(String message) {
        return new TheErrorMessage(message);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return message.equals(ERROR_MESSAGE_WITHOUT_CITY.resolveFor(actor).getText());
    }
}
