package com.jvm.benchmark.groovy

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.builder.Builder

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@EqualsAndHashCode(excludes = ["created"])
@CompileStatic
class GroovyTestObject {
    final String stringProperty
    final int intProperty
    final long longProperty
    final double doubleProperty
    final ZonedDateTime dateTime
    final Instant created

    @Builder
    GroovyTestObject(String stringProperty, int intProperty, long longProperty, double doubleProperty, ZonedDateTime dateTime, Instant created) {
        this.stringProperty = stringProperty
        this.intProperty = intProperty
        this.longProperty = longProperty
        this.doubleProperty = doubleProperty
        this.dateTime = dateTime.withZoneSameInstant(ZoneId.of("Z"))
        this.created = created
    }

    static GroovyTestObject create(String stringProperty, int intProperty, long longProperty, double doubleProperty, ZonedDateTime dateTime, Instant created) {
        return new GroovyTestObject(stringProperty, intProperty, longProperty, doubleProperty, dateTime, created)
    }

    static GroovyTestObject createBuilder(String stringProperty, int intProperty, long longProperty, double doubleProperty, ZonedDateTime dateTime, Instant created) {
        return GroovyTestObject.builder()
        .stringProperty(stringProperty)
        .intProperty(intProperty)
        .longProperty(longProperty)
        .doubleProperty(doubleProperty)
        .dateTime(dateTime)
        .created(created)
        .build()
    }
}
