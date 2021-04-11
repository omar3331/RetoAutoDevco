package com.devco.travelocity.interactions;

import com.devco.travelocity.exceptions.SwitchToTabException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class SwitchTo implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            String originalWindow = driver.getWindowHandle();

            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        }catch (Exception e){
            throw new SwitchToTabException(SwitchToTabException.FAILED_SWITCH_TAB, e);
        }
    }

    public static SwitchTo newTab(){
        return new SwitchTo();
    }
}
