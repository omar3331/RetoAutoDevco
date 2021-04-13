package com.devco.travelocity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.ERROR_MESSAGE_ONE_WAY;

public class TheError implements Question<String> {


    public static TheError message() {
        return new TheError();
    }

    @Override
    @Step("{3} validate the error message")
    public String answeredBy(Actor actor) {
        return ERROR_MESSAGE_ONE_WAY.resolveFor(actor).getText();
    }
}
