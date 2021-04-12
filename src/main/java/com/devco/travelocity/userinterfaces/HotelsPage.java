package com.devco.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HotelsPage {

    public static final Target FIVE_STARS_SELECT = Target.the("Button to select a five stars hotel").locatedBy("(//div[@class='uitk-button-toggle all-b-margin-two'])[5]");
    public static final Target THE_BEST_RATING_SELECT = Target.the("The best rating selected").located(By.id("radio-guestRating-45"));
    public static final Target BEDROOMS_SELECT = Target.the("Select amount bedrooms of the hotel").locatedBy("(//div[@class='uitk-button-toggle all-b-margin-two'])[8]");
    public static final Target FOUR_HOTEL_OF_LIST = Target.the("Selecting the four hotel of the list").locatedBy("(//div[@class='uitk-card-content uitk-grid uitk-cell all-y-padding-three all-x-padding-three listing-content'])[4]");
    public static final Target NAME_FOUR_HOTEL_OF_LIST = Target.the("Selecting the name of four hotel of the list").locatedBy("(//h3[@data-stid='content-hotel-title'])[4]");
    public static final Target NAME_HOTEL_SELECTED = Target.the("Name of the hotel selected").locatedBy("//h1[@class='uitk-heading-3']");


}
