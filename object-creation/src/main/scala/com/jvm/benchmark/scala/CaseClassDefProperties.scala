package com.jvm.benchmark.scala

import java.time.{Instant, ZonedDateTime}

import com.jvm.benchmark.time.NanoClock

import scala.beans.BeanProperty

case class CaseClassDefProperties(doubleProperty: Double,
                                  dateTime: ZonedDateTime,
                                  timestamp: Instant = NanoClock.getInstance().instant()) extends TraitDef

trait TraitDef {
  def doubleProperty: Double

  def dateTime: ZonedDateTime

  def timestamp: Instant

  @BeanProperty
  def derivedDefProperty = "timestamp: " + timestamp.toString
}
