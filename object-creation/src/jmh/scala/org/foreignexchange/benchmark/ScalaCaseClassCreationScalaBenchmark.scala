package org.foreignexchange.benchmark

import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit.NANOSECONDS

import org.foreignexchange.scala.CaseClass
import org.foreignexchange.time.NanoClock
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class ScalaCaseClassCreationScalaBenchmark {
  private val stringValue = "anonString"
  private val intValue: Int = 1
  private val longValue: Long = 1
  private val doubleValue: Double = 1

  @Benchmark
  def creation_NewInstance: CaseClass = new CaseClass(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance))(NanoClock.getInstance.instant)

  @Benchmark
  def creation_Apply: CaseClass = CaseClass(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance))(NanoClock.getInstance.instant)
}
