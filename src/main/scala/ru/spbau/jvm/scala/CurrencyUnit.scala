package ru.spbau.jvm.scala

import scala.util.parsing.json._

sealed trait CurrencyUnit

class CountAndUnit(private val count: Double, private val unit: String) {
  def getCount: Double = count

  def getUnit: String = unit
}

object CurrencyUnit {
  private val CURRENCY_CONVERTER = "https://free.currencyconverterapi.com/api/v6/convert?q=%{from-type}_%{to-type}&date=%{date}&compact=ultra"

  def get(url: String): String = scala.io.Source.fromURL(url).mkString

  def сonvertCurrency(count: Double, from: String, to: String, date: String): Double = {
    val request = CURRENCY_CONVERTER.replaceFirst("\\%\\{from-type\\}", from)
      .replaceFirst("\\%\\{to-type\\}", to)
      .replaceFirst("\\%\\{date\\}", date)
    val response = JSON.parseFull(get(request))
    val resultString = response.get.asInstanceOf[Map[String, Map[String, Double]]](from + "_" + to)(date)
    count * resultString.toDouble
  }

  case object RUB extends CurrencyUnit

  case object EUR extends CurrencyUnit

  case object USD extends CurrencyUnit

  implicit class fromType(private val count: Double) extends AnyVal {
    def RUB: CountAndUnit = new CountAndUnit(count, "RUB")

    def EUR: CountAndUnit = new CountAndUnit(count, "EUR")

    def USD: CountAndUnit = new CountAndUnit(count, "USD")
  }

  implicit class toType(private val countAndUnit: CountAndUnit) extends AnyVal {

    def to(toType: USD.type): Double = сonvertCurrency(countAndUnit.getCount, countAndUnit.getUnit, "USD", "2018-12-18")

    def to(toType: EUR.type): Double = сonvertCurrency(countAndUnit.getCount, countAndUnit.getUnit, "EUR", "2018-12-18")

    def to(toType: RUB.type): Double = сonvertCurrency(countAndUnit.getCount, countAndUnit.getUnit, "RUB", "2018-12-18")
  }

  def main(args: Array[String]): Unit = {
    println((2 RUB) to RUB)
  }
}

