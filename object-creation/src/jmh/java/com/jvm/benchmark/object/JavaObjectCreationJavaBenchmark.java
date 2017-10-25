package com.jvm.benchmark.object;

import com.jvm.benchmark.time.NanoClock;
import org.foreignexchange.java.JavaTestObject;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.time.ZonedDateTime;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
public class JavaObjectCreationJavaBenchmark {
    private static final String stringValue = "anonString";
    private static final int intValue = 1;
    private static final long longValue = 1;
    private static final double doubleValue = 1;

    @Benchmark
    public JavaTestObject creation_NewInstance() {
        return new JavaTestObject(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance()), NanoClock.getInstance().instant());
    }

    @Benchmark
    public JavaTestObject creation_StaticMethod() {
        return JavaTestObject.create(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance()), NanoClock.getInstance().instant());
    }
}
