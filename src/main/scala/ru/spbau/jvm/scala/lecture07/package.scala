package ru.spbau.jvm.scala

package object lecture07 {

  import model._

  def printElement(element: TreeElement): Unit = {
    val path = element.project.path
    val moduleName = element.module.name

    println(s"$path/$moduleName/${element.text}")
  }

  class Token(val text: String)

  implicit def aToken2Token(token: a.Token): Token = new Token(token.text)

  implicit def bToken2Token[T](token: T)(implicit tToA: T => a.Token): Token = new Token(token.text)

  def printToken(token: Token): Unit = println(token.text)

}
