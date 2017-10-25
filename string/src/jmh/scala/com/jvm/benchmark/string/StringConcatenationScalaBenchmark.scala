package com.jvm.benchmark.string

import java.util.concurrent.TimeUnit.NANOSECONDS

import com.jvm.benchmark.scala.StringConcatenation
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, Setup, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class StringConcatenationScalaBenchmark {
  var stringProperty1: String = _
  var stringProperty2: String = _

  @Setup
  def setUp() = {
    stringProperty1 = "stringProperty1"
    stringProperty2 = "stringProperty2"
  }


  @Benchmark
  def stringFormat: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.stringFormat
  }

  @Benchmark
  def sInterpolatedString: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.sInterpolatedString
  }

  @Benchmark
  def rawInterpolatedString: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.rawInterpolatedString
  }

  @Benchmark
  def operatorConcatenatedString: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.operatorConcatenatedString
  }

  @Benchmark
  def methodConcatenatedString: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.methodConcatenatedString
  }

  @Benchmark
  def stringBuilderString: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.stringBuilderString
  }

  @Benchmark
  def stringBufferString: String = {
    val stringConcatenation = StringConcatenation(stringProperty1, stringProperty2)
    stringConcatenation.stringBufferString
  }
}
