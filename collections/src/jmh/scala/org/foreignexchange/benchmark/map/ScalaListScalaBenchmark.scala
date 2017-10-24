package org.foreignexchange.benchmark.map

import java.util.concurrent.TimeUnit.NANOSECONDS

import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Scope, Setup, State, Warmup}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class ScalaListScalaBenchmark {
  var scalaList: ScalaList = _
  var value: Int = _

  @Setup
  def setUp() = {
    value = 0
    scalaList = ScalaList(Seq(0), List(0))
  }

  @Benchmark
  def seq_Add: Seq[Int] = {
    value = value + 1
    scalaList.seq :+ value
  }

  @Benchmark
  def list_Add: List[Int] = {
    value = value + 1
    scalaList.list :+ value
  }

  @Benchmark
  def seq_Get: Int = {
    scalaList.seq(value)
  }

  @Benchmark
  def list_Get: Int = {
    scalaList.list(value)
  }
}
