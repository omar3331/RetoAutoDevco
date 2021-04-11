package com.devco.travelocity.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class DateException extends SerenityManagedException {

    public static final String MESSAGE_FAILED_GET_DATE = "Could not get the actual date";
    public DateException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
