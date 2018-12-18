package ru.spbau.jvm.scala.hlist

trait Zippable[L <: HList, R <: HList, Result <: HList] {
  def apply(left: L, right: R): Result
}

object Zippable {

  import HList._

  implicit def nilBothZippable[R <: HList]: Zippable[HNil.type, HNil.type, HNil.type] =
    (_: HNil.type, _: HNil.type) => HNil

  implicit def nilFirstZippable[L <: HList, HLeft]: Zippable[HCons[HLeft, L], HNil.type, HNil.type] =
    (_: HCons[HLeft, L], _: HNil.type) => HNil

  implicit def nilSecondZippable[R <: HList, HRight]: Zippable[HNil.type, HCons[HRight, R], HNil.type] =
    (_: HNil.type, _: HCons[HRight, R]) => HNil

  implicit def zippable[L <: HList, R <: HList, TLeft, TRight, Result <: HList]
  (implicit zippable: Zippable[L, R, Result])
  : Zippable[HCons[TLeft, L], HCons[TRight, R], HCons[(TLeft, TRight), Result]] =
    (left: HCons[TLeft, L], right: HCons[TRight, R]) =>
      HCons((left.head, right.head), zippable(left.tail, right.tail))
}