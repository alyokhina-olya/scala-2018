package ru.spbau.jvm.scala.hlist


trait Equalable[L <: HList, R <: HList] {
  def apply(left: L, right: R): Boolean
}

object Equalable {

  import HList._

  implicit def nilBothEqualable: Equalable[HNil.type, HNil.type] =
    (_: HNil.type, _: HNil.type) => true

  implicit def nilFirstEqualable[L <: HList, HLeft]: Equalable[HCons[HLeft, L], HNil.type] =
    (_: HCons[HLeft, L], _: HNil.type) => false

  implicit def nilSecondEqualable[R <: HList, HRight]: Equalable[HNil.type, HCons[HRight, R]] =
    (_: HNil.type, _: HCons[HRight, R]) => false


  implicit def equalable[HLeft, L <: HList, HRight, R <: HList]
  (implicit equalable: Equalable[L, R]): Equalable[HCons[HLeft, L], HCons[HRight, R]] =
    (left: HCons[HLeft, L], right: HCons[HRight, R]) => {
      if (left.head.equals(right.head)) equalable(left.tail, right.tail)
      else false
    }
}
