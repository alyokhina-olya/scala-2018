package ru.spbau.jvm.scala

import org.junit.Test
import org.testng.Assert.assertEquals
import ru.spbau.jvm.scala.LengthUnit.{FromMetr, km, mi, toMetr, yd}

class LengthUnitTest {
  @Test
  def testConvertMToKm(): Unit = {
    assertEquals(0.0023, (2.3 m) to km)
  }

  @Test
  def testConvertKmToMi(): Unit = {
    assertEquals(1.2419006479481642, (2.3 km) to mi)
  }

  @Test
  def testConvertMToYd(): Unit = {
    assertEquals(1.0936132983377078, (1 m) to yd)
  }

}
