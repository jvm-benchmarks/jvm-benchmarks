package com.jvm.benchmark.object

import com.jvm.benchmark.scala.CaseClassWithBeanProperty
import com.jvm.benchmark.time.NanoClock
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup

import java.time.Instant
import java.time.ZonedDateTime

import static java.util.concurrent.TimeUnit.NANOSECONDS

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class ScalaCaseClassWithPropertyCreationGroovyBenchmark {
    private static final String PROVIDER = "anonProvider"
    private static final String INSTRUMENT = "anonInstrument"
    private static final double value = 1
    private ZonedDateTime dateTime

    @Setup
    void setUp() {
        dateTime = ZonedDateTime.now(NanoClock.getInstance())
    }

    @Benchmark
    CaseClassWithBeanProperty creation_NewInstance() {
        Instant now = NanoClock.getInstance().instant()
        return new CaseClassWithBeanProperty(PROVIDER, INSTRUMENT, value, value, dateTime, now, now)
    }
}
