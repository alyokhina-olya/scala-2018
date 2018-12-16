package ru.spbau.jvm.scala.lecture08

class Extractable(string: String) {

  // since 2.11

  def _1: Int = string.length

  def _2: String = string

  def isEmpty: Boolean = false

  def get: Extractable = this
}

object Extractable {

  def unapply(string: String): Extractable = new Extractable(string)

  def main(args: Array[String]): Unit = args match {
    case Array(Extractable(length, _)) => println(length)
    case _ =>
  }
}
