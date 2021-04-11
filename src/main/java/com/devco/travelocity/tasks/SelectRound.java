package com.devco.travelocity.tasks;

import com.devco.travelocity.models.BetweenModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectRound implements Task {

    private BetweenModel cities;

    public SelectRound(BetweenModel cities){
        this.cities = cities;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static SelectRound trip(BetweenModel cities){
        return instrumented(SelectRound.class, cities);
    }
}
