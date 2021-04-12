package com.devco.travelocity.interactions;

import com.devco.travelocity.userinterfaces.TravelocityHomePage;
import com.devco.travelocity.utils.Date;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.devco.travelocity.userinterfaces.TravelocityHomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectTwo implements Interaction {

    private int startDay;
    private int endDay;
    private TravelocityHomePage date;

    public SelectTwo(int starDay, int endDay) {
        this.startDay = Date.start(starDay);
        this.endDay = Date.end(endDay);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try{

            actor.attemptsTo(
                    WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                    Click.on(date.listDays().get(startDay)),
                    Click.on(DONE_CALENDAR_BUTTON),
                    Click.on(RETURN_DAY)
            );

            actor.attemptsTo(
                    WaitUntil.the(CALENDAR, isPresent()).forNoMoreThan(2).seconds(),
                    Click.on(date.listDays().get(endDay)),
                    Click.on(DONE_CALENDAR_BUTTON)
            );

        }catch (Exception e){

        }
    }

    public static SelectTwo dates(int starDay, int endDay){
        return new SelectTwo(starDay, endDay);
    }
}
