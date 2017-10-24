package org.foreignexchange.java;

import java.time.Instant;
import java.time.ZonedDateTime;

public class JavaTestObject {
    private final String stringProperty;
    private final int intProperty;
    private final long longProperty;
    private final double doubleProperty;
    private final ZonedDateTime dateTime;
    private final Instant created;

    public JavaTestObject(String stringProperty, int intProperty, long longProperty, double doubleProperty, ZonedDateTime dateTime, Instant created) {
        this.stringProperty = stringProperty;
        this.intProperty = intProperty;
        this.longProperty = longProperty;
        this.doubleProperty = doubleProperty;
        this.dateTime = dateTime;
        this.created = created;
    }

    public static JavaTestObject create(String stringProperty, int intProperty, long longProperty, double doubleProperty, ZonedDateTime dateTime, Instant created) {
        return new JavaTestObject(stringProperty, intProperty, longProperty, doubleProperty, dateTime, created);
    }

    public String getStringProperty() {
        return stringProperty;
    }

    public int getIntProperty() {
        return intProperty;
    }

    public long getLongProperty() {
        return longProperty;
    }

    public double getDoubleProperty() {
        return doubleProperty;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public Instant getCreated() {
        return created;
    }
}
