package com.jvm.benchmark.`object`

import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit.NANOSECONDS

import com.jvm.benchmark.groovy.GroovyTestObject
import com.jvm.benchmark.time.NanoClock
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class GroovyObjectCreationScalaBenchmark {
  private val stringValue = "anonString"
  private val intValue: Int = 1
  private val longValue: Long = 1
  private val doubleValue: Double = 1

  @Benchmark
  def creation_NewInstance: GroovyTestObject = new GroovyTestObject(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance), NanoClock.getInstance.instant)

  @Benchmark
  def creation_StaticMethodBackedByNewInstance: GroovyTestObject = GroovyTestObject.create(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance), NanoClock.getInstance.instant)

  @Benchmark
  def creation_StaticMethodBackedByBuilder: GroovyTestObject = GroovyTestObject.createBuilder(stringValue, intValue, longValue, doubleValue, ZonedDateTime.now(NanoClock.getInstance), NanoClock.getInstance.instant)
}
