package ru.spbau.jvm.scala.calculator

import org.junit.Test

class CalculatorTest {
  @Test
  def testSum(): Unit = {
    assert(Calculator.getResult("1 + 3") == 4)
    assert(Calculator.getResult(" 1 + 3 + 5 + 8") == 17)
    assert(Calculator.getResult(" 1  - 3") == -2)
    assert(Calculator.getResult("-1 - 3") == -4)
    assert(Calculator.getResult(" 1 + 3 - 5 - 8") == -9)
  }

  @Test
  def testMul(): Unit = {
    assert(Calculator.getResult("1 * 3") == 3)
    assert(Calculator.getResult("1 / 3") == 1.0 / 3)
    assert(Calculator.getResult("1 % 3") == 1)
    assert(Calculator.getResult("1 / true") == 1)
    assert(Calculator.getResult("4 / true") == 4)
    assert(Calculator.getResult("true * false") == 0)
    assert(Calculator.getResult("false / 4") == 0)
    assert(Calculator.getResult("true % 4") == 1)
  }

  @Test
  def testLogicalOperations(): Unit = {
    assert(Calculator.getResult("1 && 0") ==0)
    assert(Calculator.getResult("1 || 0") ==1)
    assert(Calculator.getResult("true || 0") ==1)
    assert(Calculator.getResult("true || false") ==1)
    assert(Calculator.getResult("true && 0") ==0)
    assert(Calculator.getResult("true && false") ==0)
    assert(Calculator.getResult("!false") ==1)
    assert(Calculator.getResult("!true") ==0)
    assert(Calculator.getResult("!5") ==0)
    assert(Calculator.getResult("!0") ==1)
  }

  @Test
  def testCmp(): Unit = {
    assert(Calculator.getResult(" (1 + 3) < 5") == 1)
    assert(Calculator.getResult(" (1 + 3) <= (234)") == 1)
    assert(Calculator.getResult(" (1 + 3) > 5") == 0)
    assert(Calculator.getResult(" (1 + 3) >= 4") == 1)
    assert(Calculator.getResult(" (1 + 3)  == 5") == 0)
    assert(Calculator.getResult(" (1 + 3) !=  5") == 1)
    assert(Calculator.getResult(" (1 + 3) == 4") == 1)
    assert(Calculator.getResult(" (1 + 3) != 4") == 0)
  }

  @Test
  def testOrder(): Unit = {
    assert(Calculator.getResult("1 + 3 * 5") == 16)
    assert(Calculator.getResult("1 + 3 || 0") == 1)
    assert(Calculator.getResult("1 + 3 && 0") == 0)
    assert(Calculator.getResult("(1 + 3) - (3 * 7) / 21") == 3)
    assert(Calculator.getResult("(1 + 3) - (3 * 7) / 21 && 0") == 0)
    assert(Calculator.getResult("(1 + 3) - (3 * 7) / 21 && !0") == 1)
    assert(Calculator.getResult("(1 + 3) - !(3 * 7) / 21 ") == 4)
  }
}
