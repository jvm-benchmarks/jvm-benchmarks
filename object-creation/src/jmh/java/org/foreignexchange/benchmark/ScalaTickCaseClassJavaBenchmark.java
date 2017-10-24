package org.foreignexchange.benchmark;

import org.foreignexchange.domain.quote.Tick;
import org.foreignexchange.time.NanoClock;
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

import java.time.Instant;
import java.time.ZonedDateTime;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
public class ScalaTickCaseClassJavaBenchmark {
    private static final String PROVIDER = "anonProvider";
    private static final String INSTRUMENT = "anonInstrument";
    private static final double value = 1;
    private ZonedDateTime dateTime;

    @Setup
    public void setUp() {
        dateTime = ZonedDateTime.now(NanoClock.getInstance());
    }

    @Benchmark
    public Tick creation_NewInstance() {
        Instant now = NanoClock.getInstance().instant();
        return new Tick(PROVIDER, INSTRUMENT, dateTime, value, value, now, now);
    }
}
