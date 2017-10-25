package com.jvm.benchmark.object;

import com.jvm.benchmark.scala.CaseClassWithBeanProperty;
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
public class ScalaNewObjectFromExistingObjectJavaBenchmark {
    private CaseClassWithBeanProperty caseClassWithBeanProperty;

    @Setup
    public void setUp() {
        caseClassWithBeanProperty = new CaseClassWithBeanProperty("anonString", 1, 1, 1, ZonedDateTime.now(NanoClock.getInstance()), NanoClock.getInstance().instant());
    }

    @Benchmark
    public CaseClassWithBeanProperty creation_NewInstance() {
        return new CaseClassWithBeanProperty(caseClassWithBeanProperty.getStringProperty(),
        caseClassWithBeanProperty.getIntProperty(),
        caseClassWithBeanProperty.getLongProperty(),
        caseClassWithBeanProperty.getDoubleProperty(),
        caseClassWithBeanProperty.getDateTime(),
        NanoClock.getInstance().instant());
    }

    @Benchmark
    public CaseClassWithBeanProperty creation_Copy() {
        return caseClassWithBeanProperty.copy(caseClassWithBeanProperty.getStringProperty(),
        caseClassWithBeanProperty.getIntProperty(),
        caseClassWithBeanProperty.getLongProperty(),
        caseClassWithBeanProperty.getDoubleProperty(),
        caseClassWithBeanProperty.getDateTime(),
        NanoClock.getInstance().instant());
    }
}
