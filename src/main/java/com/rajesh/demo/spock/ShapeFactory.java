package com.rajesh.demo.spock;

public class ShapeFactory {

    private Renderer renderer;

    ShapeFactory(Renderer renderer) {
        this.renderer = renderer;
    }

    public Polygon createDefaultPolygon() throws Exception {
        return new Polygon(4, renderer);
    }
}
