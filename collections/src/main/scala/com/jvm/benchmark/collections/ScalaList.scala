package com.jvm.benchmark.collections

import scala.beans.BeanProperty
import scala.collection.immutable.List

case class ScalaList(@BeanProperty seq: Seq[Int],
                     @BeanProperty list: List[Int])
