package com.jvm.benchmark.scala

import java.time.{Instant, ZonedDateTime}

import com.jvm.benchmark.time.NanoClock

import scala.beans.BeanProperty

case class CaseClassLazyValProperties(doubleProperty: Double,
                                      dateTime: ZonedDateTime,
                                      timestamp: Instant = NanoClock.getInstance().instant()) extends TraitLazyVal

trait TraitLazyVal {
  val doubleProperty: Double
  val dateTime: ZonedDateTime
  val timestamp: Instant
  @BeanProperty
  lazy val derivedLazyValProperty = "timestamp: " + timestamp.toString
}
