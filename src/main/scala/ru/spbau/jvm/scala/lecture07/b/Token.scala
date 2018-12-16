package ru.spbau.jvm.scala.lecture07
package b

case class Token(text: String)

object Token {

  implicit def bToA(token: Token): a.Token = a.Token(token.text)

  implicit class TokenExt(private val token: Token) extends AnyVal {

    def print(): Unit = a.Token.printToken(token)
  }

}
