package com.jvm.benchmark.control

import java.util.concurrent.TimeUnit.NANOSECONDS

import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class PatternMatchingBenchmark {

  @Benchmark
  def booleanPatternMatching: Boolean = {
    Math.random() < 0.5 match {
      case true ⇒ true
      case _ ⇒ false
    }
  }

  @Benchmark
  def booleanIfElse: Boolean = {
    if(Math.random() < 0.5) true else false
  }
}
