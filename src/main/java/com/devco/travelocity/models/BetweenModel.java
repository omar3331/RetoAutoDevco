package com.devco.travelocity.models;

public class BetweenModel {

    private String origin;
    private String destiny;

    public BetweenModel(String origin, String destiny){
        this.origin = origin;
        this.destiny = destiny;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestiny(){
        return destiny;
    }
}
