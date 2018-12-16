package ru.spbau.jvm.scala.lecture05

final case class ComplexNumber(var x: Double = 0,
                               var y: Double = 0) {

  В Scala нет полей !!!

  /*
  private double x$; // backing field
  private double y$; // backing field

  public double x() {
      return x$;
  }

  public void x_$eq(double x) {
      x$ = x;
  }

  public double y() {
      return y$;
  }

  public void y_$eq(double y) {
      y$ = y;
  }
   */

  def +(number: ComplexNumber): ComplexNumber = {
    val ComplexNumber(x1, y1) = number
    ComplexNumber(x + x1, y + y1)
  }

  def +=(number: ComplexNumber): this.type = {
    val ComplexNumber(x1, y1) = number
    x += x1
    y += y1
    this
  }

  def apply(abscissa: Boolean): Double =
    if (abscissa) x else y

  def update(abscissa: Boolean, value: Double): Unit = {
    if (abscissa) x += value
    else y += value
  }
}

object ComplexNumber {

  val Zero = ComplexNumber()
  val One = ComplexNumber(1)
  val I = ComplexNumber(y = 1)
}
