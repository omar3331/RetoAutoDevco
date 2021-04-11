package com.devco.travelocity.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class CanNotFindTheElementOfThePageException extends SerenityManagedException {

    public static final String FAILED_LOCATION_ELEMENTS_HOME_PAGE = "Could not find the element on the home page";
    public static final String FAILED_LOCATION_ELEMENTS_SELECT_FLIGHT_PAGE = "Could not find the element on the select flight page";
    public static final String FAILED_LOCATION_ELEMENTS_SELECTED_FLIGHT_PAGE = "Could not find the element on the selected flight page";

    public CanNotFindTheElementOfThePageException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
