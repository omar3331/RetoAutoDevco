package com.devco.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RoamNearHomePage {

    public static final Target VACATION_RENTALS_BUTTON = Target.the("Button to search vacations rentals").locatedBy("(//li[@class='uitk-flex-item uitk-flex-grow-1 lobItem all-r-margin-one all-b-margin-six'])[4]");
    public static final Target GUEST_BUTTON = Target.the("Button to select the amount of persons for vacations rentals").locatedBy("//div[@class='uitk-layout-grid-item TravelersField uitk-layout-grid-item-columnspan-small-2 uitk-layout-grid-item-columnspan-medium-1']");
    public static final Target INCREASE_AMOUNT_TRAVELERS_BUTTON = Target.the("Button to increase the amount of travelers").locatedBy("(//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-step-input-button'])[2]");
    public static final Target INCREASE_AMOUNT_ROOMS_BUTTON = Target.the("Button to increase the amount of rooms").locatedBy("//button[@data-testid='add-room-button']");
    public static final Target FIRST_HOTEL_OF_LIST = Target.the("Selecting the first hotel of the list").locatedBy("(//div[@class='uitk-card-content uitk-grid uitk-cell all-y-padding-three all-x-padding-three listing-content'])[1]");
    public static final Target ERROR_MESSAGE_WITHOUT_CITY = Target.the("Message to search without entering a city").located(By.id("location-field-destination-input-error"));


}
