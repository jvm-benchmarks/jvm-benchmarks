package com.jvm.benchmark.`object`

import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit.NANOSECONDS

import com.jvm.benchmark.scala.CaseClass
import com.jvm.benchmark.time.NanoClock

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
