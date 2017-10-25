package com.jvm.benchmark.collections

import java.time.Instant
import java.util.concurrent.TimeUnit.NANOSECONDS

import com.jvm.benchmark.time.NanoClock
import ScalaMap

import scala.collection.SortedMap
import scala.collection.immutable.{HashMap, TreeMap}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class ScalaMapScalaBenchmark {
  var scalaMap: ScalaMap = _
  var now: Instant = _

  @Setup
  def setUp() = {
    now = NanoClock.getInstance().instant()
    scalaMap = ScalaMap(
      HashMap(now -> "initial"),
      TreeMap(now -> "initial")
    )
  }

  @Benchmark
  def hashMap_Put: Map[Instant, String] = {
    scalaMap.hashMap + (NanoClock.getInstance().instant() -> "description")
  }

  @Benchmark
  def treeMap_Put: SortedMap[Instant, String] = {
    scalaMap.treeMap + (NanoClock.getInstance().instant() -> "description")
  }

  @Benchmark
  def hashMap_Get: String = {
    scalaMap.hashMap(now)
  }

  @Benchmark
  def treeMap_Get: String = {
    scalaMap.treeMap(now)
  }
}
