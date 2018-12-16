package ru.spbau.jvm.scala.lecture05

object Main {

  def main(args: Array[String]): Unit = {
    val number = ComplexNumber()

    println(number) // number.toString
    println(s"ComplexNumber(${number.x} ${number.y})")

    number.x += 1 // number.x.+=(1)
    number.y += 1 // number.y.+=(1)
    println(number)

    import ComplexNumber._

    Zero += number
    println(Zero)

    println(One(true))
    One(true) = 1
    println(One(true))

    println(I(false))
    I(false) += 1
    println(I(false))
  }
}
