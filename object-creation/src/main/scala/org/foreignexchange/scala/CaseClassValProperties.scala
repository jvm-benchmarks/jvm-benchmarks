package org.foreignexchange.scala

import java.time.{Instant, ZonedDateTime}

import org.foreignexchange.time.NanoClock

import scala.beans.BeanProperty

case class CaseClassValProperties(doubleProperty: Double,
                                  dateTime: ZonedDateTime,
                                  timestamp: Instant = NanoClock.getInstance().instant()) extends TraitVal

trait TraitVal {
  val doubleProperty: Double
  val dateTime: ZonedDateTime
  val timestamp: Instant
  @BeanProperty
  val derivedValProperty = "timestamp: " + timestamp.toString
}
