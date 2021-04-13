package com.devco.travelocity.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class SwitchToTabException extends SerenityManagedException {

    public static final String FAILED_SWITCH_TAB = "Could not change to the nex tab";

    public SwitchToTabException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
