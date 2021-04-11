package com.devco.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AvailableFlightsPage {

    public static final Target SORT_BY_BUTTON = Target.the("Order the List of available flights").locatedBy("//section[@class='uitk-spacing uitk-spacing-padding-large-blockend-two']");
    public static final Target PRICE_INCREASING_OPTION = Target.the("Option from the list, price increasing").locatedBy("//option[@data-opt-id='PRICE_INCREASING']");
    public static final Target FIRST_FLIGHT_LIST = Target.the("First flight of the list").locatedBy("(//button[@class='uitk-card-link'])[1]");
    public static final Target FLIGHT_TIME = Target.the("Time and duration of the flight").locatedBy("(//span[@data-test-id='departure-time'])[1]");
    public static final Target CONTINUE_BUTTON = Target.the("Button to continue with the purchase").locatedBy("//button[@class='uitk-button uitk-button-large uitk-button-has-text uitk-button-primary uitk-spacing uitk-spacing-margin-inlinestart-three']");
    public static final Target IGNORE_SEARCH = Target.the("Button to ignore the hotel search").locatedBy("//a[@class='uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-tertiary show-hover-style']");
    public static final Target FLIGHT_TIME_SELECTED = Target.the("Time and duration of the flight").locatedBy("(//div//span[@aria-hidden='true'])[2]");



}
