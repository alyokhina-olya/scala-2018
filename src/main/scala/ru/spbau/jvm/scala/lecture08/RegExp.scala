package ru.spbau.jvm.scala.lecture08

object RegExp {

  private val Decimal = """(-)?(\d+)(\.\d*)?""".r

  def main(args: Array[String]): Unit = {
    "1.0" match {
      case Decimal(sign, one, _) =>
        val Decimal(_, two, _) = "2.0"
      case _ =>
    }

    for (Decimal(sign, i, d) <- Decimal.findAllIn("1.0 and 2.0, 33")) {
      println(s"$sign$i.$d")
    }
  }

}
