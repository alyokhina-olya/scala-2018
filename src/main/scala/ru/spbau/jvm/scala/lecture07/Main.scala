package ru.spbau.jvm.scala.lecture07

object Main {

  import a.{Token => AToken}
  import b.{Token => BToken}
  import model._

  implicit private val project: Project = new Project(".")
  implicit private val module: Module = project.addModule("root")

  def main(args: Array[String]): Unit = {
    val token = BToken("text")
    AToken.printToken(token)
    token.print()

    printToken(AToken("text"))
    printToken(token)

    val elementImpl = new TreeElement.TreeElementImpl("foo")
    printElement(elementImpl)
  }

}
