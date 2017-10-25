package com.jvm.benchmark.scala

case class StringConcatenation(stringProperty1: String,
                               stringProperty2: String) {
  lazy val stringFormat = String.format("%s-%s", stringProperty1, stringProperty1)
  lazy val sInterpolatedString = s"${stringProperty1}-${stringProperty2}"
  lazy val rawInterpolatedString = raw"${stringProperty1}-${stringProperty2}"
  lazy val operatorConcatenatedString = stringProperty1 + "-" + stringProperty2
  lazy val methodConcatenatedString = stringProperty1.concat("-").concat(stringProperty2)
  lazy val stringBuilderString = {
    val stringBuilder = new StringBuilder()
    stringBuilder.append(stringProperty1)
    stringBuilder.append("-")
    stringBuilder.append(stringProperty2)

    stringBuilder.toString()
  }
  lazy val stringBufferString = {
    val stringBuffer = new StringBuffer()
    stringBuffer.append(stringProperty1)
    stringBuffer.append("-")
    stringBuffer.append(stringProperty2)

    stringBuffer.toString()
  }
}
