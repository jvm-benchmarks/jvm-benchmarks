package com.jvm.benchmark.collections

import java.time.Instant

import scala.beans.BeanProperty
import scala.collection.immutable.{HashMap, TreeMap}

case class ScalaMap(@BeanProperty hashMap: HashMap[Instant, String],
                    @BeanProperty treeMap: TreeMap[Instant, String])
