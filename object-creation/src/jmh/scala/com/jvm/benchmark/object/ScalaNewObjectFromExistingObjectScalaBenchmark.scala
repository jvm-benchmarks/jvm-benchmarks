package com.jvm.benchmark.`object`

import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit.NANOSECONDS

import com.jvm.benchmark.scala.CaseClassWithBeanProperty
import com.jvm.benchmark.time.NanoClock

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
class ScalaNewObjectFromExistingObjectScalaBenchmark {
  private var caseClassWithBeanProperty: CaseClassWithBeanProperty = _

  @Setup
  def setUp() = {
    caseClassWithBeanProperty = new CaseClassWithBeanProperty("anonString", 1, 1, 1, ZonedDateTime.now(NanoClock.getInstance()))(NanoClock.getInstance().instant())
  }

  @Benchmark
  def creation_NewInstance: CaseClassWithBeanProperty =
    new CaseClassWithBeanProperty(caseClassWithBeanProperty.stringProperty,
      caseClassWithBeanProperty.intProperty + 1,
      caseClassWithBeanProperty.longProperty + 1,
      caseClassWithBeanProperty.doubleProperty + 1,
      caseClassWithBeanProperty.dateTime)(NanoClock.getInstance.instant)

  @Benchmark
  def creation_Copy: CaseClassWithBeanProperty =
    caseClassWithBeanProperty.copy(intProperty = caseClassWithBeanProperty.intProperty + 1,
      longProperty = caseClassWithBeanProperty.longProperty + 1,
      doubleProperty = caseClassWithBeanProperty.doubleProperty + 1)(NanoClock.getInstance.instant)

}
