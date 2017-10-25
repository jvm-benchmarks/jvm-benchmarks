package com.jvm.benchmark.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class NanoClock extends Clock {
    private static final NanoClock instance = new NanoClock();
    private Clock clock;
    private long initialNanos;
    private Instant initialInstant;

    private NanoClock() {
        this(Clock.systemUTC());
    }

    private NanoClock(Clock clock) {
        this.clock = clock;
        initialInstant = clock.instant();
        initialNanos = getSystemNanos();
    }

    public static Clock getInstance() {
        return instance;
    }

    public static Instant now() {
        return instance.instant();
    }

    @Override
    public ZoneId getZone() {
        return clock.getZone();
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return new NanoClock(clock.withZone(zone));
    }

    @Override
    public Instant instant() {
        return initialInstant.plusNanos(getSystemNanos() - initialNanos);
    }

    private long getSystemNanos() {
        return System.nanoTime();
    }
}
