package com.rajesh.demo.spock

import spock.lang.Specification

class ExampleSpecification extends Specification{
    def "Simple Assertion"() {
        expect:
        1 == 1
    }

    def "given-when-then testing"() {
        given:
        def car = new Vehicle(4)

        when:
        int tires = car.numberOfTires

        then:
        tires == 4

    }

    def "given-when-then testing version 2"() {
        when:
        int tires = new Vehicle(4).numberOfTires

        then:
        tires == 4

    }
}
