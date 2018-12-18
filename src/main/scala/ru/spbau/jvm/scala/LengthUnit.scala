package ru.spbau.jvm.scala


sealed trait LengthUnit


object LengthUnit {

  case object m extends LengthUnit

  case object km extends LengthUnit

  case object inch extends LengthUnit

  case object ft extends LengthUnit

  case object yd extends LengthUnit

  case object mi extends LengthUnit

  implicit class toMetr(private val count: Double) extends AnyVal {
    def m: Double = count

    def km: Double = count * 1000

    def inch: Double = count * 0.0254

    def ft: Double = count * 0.3048

    def yd: Double = count * 0.9144

    def mi: Double = count * 1852
  }

  implicit class FromMetr(private val count: Double) extends AnyVal {
    def to(toType: m.type): Double = count

    def to(toType: km.type): Double = count / 1000.0

    def to(toType: inch.type): Double = count / 0.0254

    def to(toType: ft.type): Double = count / 0.3048

    def to(toType: yd.type): Double = count / 0.9144

    def to(toType: mi.type): Double = count / 1852
  }

  def main(args: Array[String]): Unit = {
    println((2 m) to km)
  }
}
