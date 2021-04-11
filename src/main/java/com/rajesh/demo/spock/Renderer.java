package com.rajesh.demo.spock;

public class Renderer {

    private Palette palette;

    public Renderer(){}

    public Renderer(Palette palette){
        this.palette = palette;
    }

    public void drawLine(){}

    public Color getForegroundColor(){
        return palette.getPrimaryColor();
    }

}
