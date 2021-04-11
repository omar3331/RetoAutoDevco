package com.devco.travelocity.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class OpenTheBrowserException extends SerenityManagedException {

    public static String MESSAGE_FAILED_OPENBROWSER = "Failed open the browser";
    public OpenTheBrowserException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
