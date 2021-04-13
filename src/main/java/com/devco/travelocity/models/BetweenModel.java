package com.devco.travelocity.models;

public class BetweenModel {

    private final String origin;
    private final String destiny;

    public BetweenModel(String origin, String destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestiny() {
        return destiny;
    }
}
