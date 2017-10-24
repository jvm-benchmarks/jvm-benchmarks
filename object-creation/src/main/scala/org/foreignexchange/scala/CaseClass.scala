package org.foreignexchange.scala

import java.time.{Instant, ZonedDateTime}


case class CaseClass(stringProperty: String,
                     intProperty: Int,
                     longProperty: Long,
                     doubleProperty: Double,
                     dateTime: ZonedDateTime)
                    (val created: Instant)
