package ru.spbau.jvm.scala.hlist


sealed trait Number

object Number {
  case class Inc[T <: Number](dec:T) extends Number
  case object Zero extends Number
}