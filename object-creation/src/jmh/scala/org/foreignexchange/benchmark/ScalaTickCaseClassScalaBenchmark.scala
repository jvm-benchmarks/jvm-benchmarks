package org.foreignexchange.benchmark

import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit.NANOSECONDS

import org.foreignexchange.domain.quote.Tick
import org.foreignexchange.time.NanoClock
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, Setup, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class ScalaTickCaseClassScalaBenchmark {
  val PROVIDER = "anonProvider"
  val INSTRUMENT = "anonInstrument"
  val value = 1
  var dateTime: ZonedDateTime = _

  @Setup
  def setUp() = {
    dateTime = ZonedDateTime.now(NanoClock.getInstance)
  }

  @Benchmark
  def creation_NewInstance: Tick = {
    val now = NanoClock.getInstance.instant
    new Tick(PROVIDER, INSTRUMENT, dateTime, value, value)(now)
  }

  @Benchmark
  def creation_Apply: Tick = {
    val now = NanoClock.getInstance.instant
    Tick(PROVIDER, INSTRUMENT, dateTime, value, value)(now)
  }
}
