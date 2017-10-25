package com.jvm.benchmark.object;

import com.jvm.benchmark.scala.CaseClassDefProperties;
import com.jvm.benchmark.scala.CaseClassLazyValProperties;
import com.jvm.benchmark.scala.CaseClassValProperties;
import com.jvm.benchmark.time.NanoClock;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
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
public class ScalaLazyValVsDefVsValJavaBenchmark {
    private int value = 1;
    private ZonedDateTime dateTime;

    @Setup
    public void setUp() {
        dateTime = ZonedDateTime.now(NanoClock.getInstance());
    }

    @Benchmark
    public String defProperty() {
        CaseClassDefProperties o = new CaseClassDefProperties(value, dateTime, NanoClock.getInstance().instant());
        return o.derivedDefProperty();
    }

    @Benchmark
    public String valProperty() {
        CaseClassValProperties o = new CaseClassValProperties(value, dateTime, NanoClock.getInstance().instant());
        return o.getDerivedValProperty();
    }

    @Benchmark
    public String lazyValProperty() {
        CaseClassLazyValProperties o = new CaseClassLazyValProperties(value, dateTime, NanoClock.getInstance().instant());
        return o.getDerivedLazyValProperty();
    }
}
