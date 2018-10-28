package ru.spbau.jvm.scala.calculator

import com.antlr.{ExpLexer, ExpParser}
import org.antlr.v4.runtime.{BufferedTokenStream, CharStreams}


object Calculator extends App {
  def printGreeting(): Unit = {
    println("Введите арифметическое выражение")
  }

  def getResult(expression: String): Double = {
    val expLexer = new ExpLexer(CharStreams.fromString(expression))
    val expParser = new ExpParser(new BufferedTokenStream(expLexer))
    expParser.expr().value
  }

  override def main(args: Array[String]): Unit = {
    printGreeting()
    val expression = scala.io.StdIn.readLine()
    println(getResult(expression))
  }

}