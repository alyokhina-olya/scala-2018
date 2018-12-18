package ru.spbau.jvm.scala

import org.junit.Test
import org.testng.Assert.assertEquals
import ru.spbau.jvm.scala.CurrencyUnit.{RUB, USD, fromType, toType}

class CurrencyUnitTest {

  @Test
  def testConvertRUBToRUB(): Unit = {
    assertEquals(2.3, (2.3 RUB) to RUB)
  }

  @Test
  def testConvertEURToUSD(): Unit = {
    assertEquals(2.6119604999999995, (2.3 EUR) to USD)
  }

  @Test
  def testConvertUSDToRUB(): Unit = {
    assertEquals(154.8472677, (2.3 USD) to RUB)
  }
}
