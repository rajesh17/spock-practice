package com.rajesh.demo.spock;

public class Palette {
    private Color primaryColor;

    public Palette(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }
}
