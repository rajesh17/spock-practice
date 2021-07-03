package com.rajesh.demo.spock

import spock.lang.Specification
import spock.lang.Subject

class ExampleSpecification extends Specification {

    @Subject
    private Polygon polygon = new Polygon(5)

    void setupSpec(){
        //setup code that needs to run once at the start2
    }

    void setup() {
        //setup code that needs to be run before every test method
    }

    def "Simple Assertion"() {
        expect:
        1 == 1
    }

    def "given-when-then testing"() {
        given:
        def car = new Polygon(4)

        when:
        int sides = car.numberOfSides

        then:
        sides == 4

    }

    def "given-when-then testing version 2"() {
        when:
        int sides = new Polygon(4).numberOfSides

        then:
        sides == 4

    }

    def "given-when-then testing version 3"() {
        when:
        int sides = polygon.numberOfSides

        then:
        sides == 5

    }

    def "expect Exceptions"() {
        when:
        new Polygon(0)

        then:
        def exception = thrown(TooFewSidesException.class)
        exception.numberOfSides == 0

    }

    def "expect Exceptions for invalid inputs: #sides"() {
        when:
        new Polygon(sides)

        then:
        def exception = thrown(TooFewSidesException.class)
        exception.numberOfSides == sides

        where:
        sides << [-1, 0, 1, 2]

    }

    def "create polygon for inputs: #sides"() {
        expect:
        new Polygon(sides).numberOfSides == sides

        where:
        sides << [5, 6, 7, 8]

    }

    def "use data tables for calculating max"() {
        expect:
        Math.max(a, b) == max

        where:
        a | b | max
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0

    }

    def "mock a concrete class"() {
        given:
        Renderer renderer = Mock()
        @Subject
        def polygon = new Polygon(4, renderer)

        when:
        polygon.draw()

        then:
        4 * renderer.drawLine()
    }

    def "create a stub"() {
       given: "a palette with red as the primary color"
       Palette palette = Stub()
       palette.getPrimaryColor() >> Color.Red

       and: "a renderer is initialized"
       def renderer = new Renderer(palette)

       expect:
       renderer.getForegroundColor() == Color.Red

    }

    def "use a helper method"() {
        given:
        Renderer renderer = Mock()
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def polygon = shapeFactory.createDefaultPolygon()

        then:
        checkDefaultShape(polygon, renderer)
    }

    private static void checkDefaultShape(Polygon polygon, Renderer renderer){
        assert polygon.numberOfSides == 4
        assert polygon.renderer == renderer
    }

    def "use a with "() {
        given:
        Renderer renderer = Mock()
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def polygon = shapeFactory.createDefaultPolygon()

        then:
        with(polygon){
            numberOfSides == 4
            renderer == renderer
        }
    }

    def "use a 'verifyAll' "() {
        given:
        Renderer renderer = Mock()
        def shapeFactory = new ShapeFactory(renderer)

        when:
        def polygon = shapeFactory.createDefaultPolygon()

        then:
        verifyAll(polygon){
            numberOfSides == 4
            renderer == renderer
        }
    }

    void cleanup() {
        //code that tears down things at the end of a test method
    }

    void cleanupSpec(){
        //code that tears down once at the end when all tests have run
    }
}