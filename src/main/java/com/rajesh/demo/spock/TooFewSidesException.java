package com.rajesh.demo.spock;

public class TooFewSidesException extends Exception{

    private int numberOfSides;

    public TooFewSidesException(String exception, int numberOfSides){
        this.numberOfSides = numberOfSides;
    }

}
