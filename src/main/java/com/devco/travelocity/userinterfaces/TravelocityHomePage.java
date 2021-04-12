package com.devco.travelocity.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.tools.ant.taskdefs.Tar;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.travelocity.com/")
public class TravelocityHomePage extends PageObject {

    public static final Target MORE_TRAVEL_BUTTON = Target.the("Menu button for more options").located(By.id("gc-custom-header-tool-bar-shop-menu"));
    public static final Target THINGS_TO_DO_OPTION = Target.the("Things to do option from menu").locatedBy("(//a//div[@class='uitk-type-300'])[6]");
    public static final Target THINGS_TO_DO_INPUT = Target.the("Things to do search").locatedBy("(//div[@class='uitk-layout-grid-item uitk-layout-grid-item-columnspan-small-1 uitk-layout-grid-item-columnspan-medium-2'])");
    public static final Target THINGS_TO_DO_FIELD_INPUT = Target.the("Things to do search input").located(By.id("location-field-location"));
    public static final Target FIRST_ITEM_THINGS_TO_DO = Target.the("First item search result of things to do").locatedBy("(//li[@data-stid='location-field-location-result-item'])[1]");

    public static final Target FLIGHTS_BUTTON = Target.the("Button flights").locatedBy("(//li[@role='presentation'])[2]");
    public static final Target ONE_WAY_BUTTON = Target.the("button one way").locatedBy("(//li[@class='uitk-tab uitk-tab-button '])[1]");
    public static final Target ORIGIN_INPUT = Target.the("Origin city field").locatedBy("(//div[@class='uitk-layout-grid-item uitk-layout-grid-item-columnspan-small-1 uitk-layout-grid-item-columnspan-medium-1'])[1]");
    public static final Target ORIGIN_FIELD_INPUT = Target.the("Origin city text field").located(By.id("location-field-leg1-origin"));
    public static final Target FIRST_ITEM_ORIGIN = Target.the("The first item on the list origin").locatedBy("(//li[@data-stid='location-field-leg1-origin-result-item'])[1]");
    public static final Target DESTINY_INPUT = Target.the("Destiny city field").locatedBy("(//div[@class='uitk-layout-grid-item uitk-layout-grid-item-columnspan-small-1 uitk-layout-grid-item-columnspan-medium-1'])[2]");
    public static final Target DESTINY_FIELD_INPUT = Target.the("Destiny city text field").located(By.id("location-field-leg1-destination"));
    public static final Target FIRST_ITEM_DESTINY = Target.the("The first item on the list destiny").locatedBy("(//li[@data-stid='location-field-leg1-destination-result-item'])[1]");
    public static final Target DEPARTURE_DAY = Target.the("Date to travel").locatedBy("(//div[@class='uitk-flex-item uitk-flex-basis-zero uitk-flex-grow-1 uitk-date-field-wrapper'])[1]");
    public static final Target RETURN_DAY = Target.the("Date to travel").locatedBy("(//div[@class='uitk-flex-item uitk-flex-basis-zero uitk-flex-grow-1 uitk-date-field-wrapper'])[2]");
    public static final Target CALENDAR = Target.the("Calendar to select travel dates").locatedBy("//div[@class='uitk-flex uitk-flex-row uitk-flex-gap-three uitk-flex-item uitk-date-fields uitk-flex-grow-1 ']");
    public static final Target DONE_CALENDAR_BUTTON = Target.the("button to select travel dates").locatedBy("//button[@data-stid='apply-date-picker']");
    public static final Target SEARCH_BUTTON = Target.the("button to perform the search").locatedBy("//button[@data-testid='submit-button']");

    public List<WebElementFacade> listDays(){ return findAll(By.xpath("//td[@class='uitk-date-picker-day-number']")); }

}
