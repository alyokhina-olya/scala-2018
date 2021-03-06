package ru.spbau.jvm.scala.lecture06

trait Initialization {
  val text: String
  val textLength: Int
}

object Initialization {

  def main(args: Array[String]): Unit = {
    try {
      Bar
    } catch {
      case _: ExceptionInInitializerError =>
        println(EarlyDefinitions.Bar.textLength)
        println(LazyVals.Bar.textLength)
    }
  }

  class Foo extends Initialization {
    val text = "foo"
    val textLength = text.length
  }

  object Bar extends Foo {
    override val text: String = "foobar"
  }

  object EarlyDefinitions {

    class Foo extends Initialization {
      val text = "foo"
      val textLength = text.length
    }

    object Bar extends {
      override val text = "foobar"
    } with Foo

  }

  object LazyVals {

    class Foo extends Initialization {
      val text = "foo"
      lazy val textLength = text.length
    }

    object Bar extends Foo {
      override val text = "foobar"
    }

  }

}
