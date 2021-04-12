package com.devco.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ThingsToDoPage {

    public static final Target ATTRACTIONS_CARD = Target.the("Attractions option from things to do page").locatedBy("(//li[@class='uitk-card uitk-card-roundcorner-all uitk-card-has-border uitk-card-has-link uitk-carousel-item'])[3]");
    public static final Target ATTRACTION_CARD_TWO = Target.the("Second attractions of the result list from things to do page").locatedBy("(//a[@data-testid='card-link'])[2]");
    public static final Target RECOMMENDATION_FIRST = Target.the("First recommendation from things to do page").located(By.id("cb-freeCancellation-categories"));
    public static final Target INTEREST_THIRD = Target.the("Third interest from things to do page").located(By.id("cb-AdventureOutdoor-categories"));
    public static final Target TOURS_AND_ACTIVITIES_SIXTH = Target.the("Sixth option of tours and activities from things to do page").located(By.id("cb-AirHelicopterBalloonTours-categories"));
    public static final Target TITLE_SELECTED_THING = Target.the("Title of thing selected from things to do page").locatedBy("//h1[@class='uitk-heading-4']");


}
