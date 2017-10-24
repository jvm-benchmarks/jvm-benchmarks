package org.foreignexchange.benchmark

import groovy.transform.CompileStatic
import org.foreignexchange.groovy.GroovyTestObject
import org.foreignexchange.time.NanoClock
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup

import java.time.ZonedDateTime

import static java.util.concurrent.TimeUnit.NANOSECONDS

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
@CompileStatic
class GroovyObjectCreationGroovyBenchmark {
    private static final String stringValue = "anonString"
    private static final int intValue = 1
    private static final long longValue = 1
    private static final double doubleValue = 1

    @Benchmark
    GroovyTestObject creation_NewInstance() {
        return new GroovyTestObject(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.instance), NanoClock.instance.instant())
    }

    @Benchmark
    GroovyTestObject creation_Builder() {
        return GroovyTestObject.builder()
        .stringProperty(stringValue)
        .intProperty(intValue)
        .longProperty(longValue)
        .doubleProperty(doubleValue)
        .dateTime(ZonedDateTime.now(NanoClock.instance))
        .created(NanoClock.instance.instant())
        .build()
    }

    @Benchmark
    GroovyTestObject creation_StaticMethodBackedByNewInstance() {
        return GroovyTestObject.create(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.instance), NanoClock.instance.instant())
    }

    @Benchmark
    GroovyTestObject creation_StaticMethodBackedByBuilder() {
        return GroovyTestObject.createBuilder(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.instance), NanoClock.instance.instant())
    }
}