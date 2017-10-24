package org.foreignexchange.benchmark.string

import java.util.concurrent.TimeUnit.NANOSECONDS

import org.foreignexchange.scala.StringWrapper
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, Setup, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class StringWrapperScalaBenchmark {
  var stringProperty1: String = _
  var stringProperty2: String = _

  @Setup
  def setUp() = {
    stringProperty1 = "stringProperty1"
    stringProperty2 = "stringProperty2"
  }


  @Benchmark
  def concatenatedStringKeyValueIntoMap: Object = {
    val concatenatedString = stringProperty1 + stringProperty2
    val map = Map(concatenatedString -> new Object())

    map(concatenatedString)
  }

  @Benchmark
  def stringWrapperKeyValueIntoMap: Object = {
    val stringWrapper = StringWrapper(stringProperty1, stringProperty2)
    val map = Map(stringWrapper -> new Object())

    map(stringWrapper)
  }
}
