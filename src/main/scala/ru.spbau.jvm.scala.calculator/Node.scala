package ru.spbau.jvm.scala.calculator

class Node(private val doubleValue: Double) {
  private val eps: Double = 0.00000001

  private val booleanValue: Boolean = if (math.abs(doubleValue) < eps) false else true

  def toDouble: Double = doubleValue

  def this(booleanValue: Boolean) = this(if (booleanValue) 1.0 else 0.0)

  def +(that: Node) = new Node(doubleValue + that.doubleValue)

  def -(that: Node) = new Node(doubleValue - that.doubleValue)

  def *(that: Node) = new Node(doubleValue * that.doubleValue)

  def /(that: Node) = new Node(doubleValue / that.doubleValue)

  def %(that: Node) = new Node(doubleValue % that.doubleValue)

  def ==(that: Node) = new Node(math.abs(doubleValue - that.doubleValue) < eps)

  def !=(that: Node) = new Node(math.abs(doubleValue - that.doubleValue) > eps)

  def <(that: Node) = new Node(doubleValue < that.doubleValue)

  def >(that: Node) = new Node(doubleValue > that.doubleValue)

  def <=(that: Node) = new Node(doubleValue <= that.doubleValue)

  def >=(that: Node) = new Node(doubleValue >= that.doubleValue)

  def &&(that: Node) = new Node(booleanValue && that.booleanValue)

  def ||(that: Node) = new Node(booleanValue || that.booleanValue)

  def not() = new Node(!booleanValue)

}
