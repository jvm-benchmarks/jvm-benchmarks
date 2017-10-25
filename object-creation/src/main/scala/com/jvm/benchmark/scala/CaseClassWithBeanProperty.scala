package com.jvm.benchmark.scala

import java.time.{Instant, ZonedDateTime}

import scala.beans.BeanProperty

case class CaseClassWithBeanProperty(@BeanProperty stringProperty: String,
                                     @BeanProperty intProperty: Int,
                                     @BeanProperty longProperty: Long,
                                     @BeanProperty doubleProperty: Double,
                                     @BeanProperty dateTime: ZonedDateTime)
                                    (@BeanProperty val created: Instant)
