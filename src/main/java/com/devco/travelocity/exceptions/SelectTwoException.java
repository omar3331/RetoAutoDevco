package com.devco.travelocity.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class SelectTwoException extends SerenityManagedException {

    public static final String FAILED_SELECT_DATES = "Could not select dates in calendar";

    public SelectTwoException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
