package com.rajesh.demo.spock

import spock.lang.Specification

class ExampleSpecification extends Specification{
    def "Simple Assertion"() {
        expect:
        1 == 1
    }
}
