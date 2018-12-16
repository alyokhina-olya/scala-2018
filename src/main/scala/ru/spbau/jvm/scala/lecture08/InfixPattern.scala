package ru.spbau.jvm.scala.lecture08

object InfixPattern {

  type ++[Left, Right] = (Left, Right)

  object ++ {
    def unapply[Left, Right](pair: Left ++ Right): Option[Left ++ Right] = {
      val (first, second) = pair
      Some(first, second)
    }
  }

  implicit class Ext[Left](private val left: Left) extends AnyVal {
    def ++[Right](right: Right): (Left, Right) = (left, right)
  }

  def main(args: Array[String]): Unit = 42 ++ 42 match {
    case left ++ right => println(left + right)
  }
}
