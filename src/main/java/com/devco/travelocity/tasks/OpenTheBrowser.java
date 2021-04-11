package com.devco.travelocity.tasks;

import com.devco.travelocity.exceptions.OpenTheBrowserException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task {

    private PageObject url;

    public OpenTheBrowser(PageObject url){
        this.url = url;
    }

    @Override
    @Step("{0} opens the browser on the Travelocity Home Page")
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(Open.browserOn(url));
        }catch (Exception e){
            throw new OpenTheBrowserException(OpenTheBrowserException.MESSAGE_FAILED_OPENBROWSER, e);
        }
    }

    public static OpenTheBrowser on(PageObject url){
        return instrumented(OpenTheBrowser.class, url);
    }
}
