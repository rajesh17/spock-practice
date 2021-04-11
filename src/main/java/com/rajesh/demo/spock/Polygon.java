package com.rajesh.demo.spock;

public class Polygon {
    private final int numberOfSides;
    private Renderer renderer;

    public Polygon(int numberOfSides) throws Exception {
        if(numberOfSides <= 2){
            throw new TooFewSidesException("cannot enter less than 2 tires", numberOfSides);
        }
        this.numberOfSides = numberOfSides;
    }

    public Polygon(int numberOfSides, Renderer renderer) throws Exception {
        if(numberOfSides <= 2){
            throw new TooFewSidesException("cannot enter less than 2 tires", numberOfSides);
        }
        this.numberOfSides = numberOfSides;
        this.renderer = renderer;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void draw(){
        for (int i = 0; i < numberOfSides; i++) {
            renderer.drawLine();
        }
    }
}
