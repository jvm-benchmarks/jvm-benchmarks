package com.jvm.benchmark.`object`

import java.time.{Instant, ZonedDateTime}
import java.util.concurrent.TimeUnit.NANOSECONDS

import com.jvm.benchmark.scala.CaseClassDefProperties
import com.jvm.benchmark.time.NanoClock

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class CaseClassLazyValDefValBenchmark {
  val value = 1
  var dateTime: ZonedDateTime = _

  @Setup
  def setUp() = {
    dateTime = ZonedDateTime.now(NanoClock.getInstance)
  }

  @Benchmark
  def doNotGetDerivedProperty_Def: (Double, ZonedDateTime, Instant) = {
    val o = CaseClassDefProperties(value, dateTime)
    (o.doubleProperty, o.dateTime, o.timestamp)
  }

  @Benchmark
  def doNotGetDerivedProperty_LazyVal: (Double, ZonedDateTime, Instant) = {
    val o = CaseClassLazyValProperties(value, dateTime)
    (o.doubleProperty, o.dateTime, o.timestamp)
  }

  @Benchmark
  def doNotGetDerivedProperty_Val: (Double, ZonedDateTime, Instant) = {
    val o = CaseClassValProperties(value, dateTime)
    (o.doubleProperty, o.dateTime, o.timestamp)
  }

  @Benchmark
  def getDerivedProperty_Def: (Double, ZonedDateTime, Instant, String) = {
    val o = CaseClassDefProperties(value, dateTime)
    (o.doubleProperty, o.dateTime, o.timestamp, o.derivedDefProperty)
  }

  @Benchmark
  def getDerivedProperty_LazyVal: (Double, ZonedDateTime, Instant, String) = {
    val o = CaseClassLazyValProperties(value, dateTime)
    (o.doubleProperty, o.dateTime, o.timestamp, o.derivedLazyValProperty)
  }

  @Benchmark
  def getDerivedProperty_Val: (Double, ZonedDateTime, Instant, String) = {
    val o = CaseClassValProperties(value, dateTime)
    (o.doubleProperty, o.dateTime, o.timestamp, o.derivedValProperty)
  }
}
