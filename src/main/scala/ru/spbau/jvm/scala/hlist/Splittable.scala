package ru.spbau.jvm.scala.hlist

import ru.spbau.jvm.scala.hlist.Number.{Inc, Zero}

trait Splittable[M <: HList, N <: Number, L <: HList, R <: HList] {
  def apply(left: M, pos: N): (L, R)
}

object Splittable {

  import HList._

  implicit def zeroSplitable[M <: HList]: Splittable[M, Zero.type, HNil.type, M] =
    (list: M, _: Zero.type) => (HNil, list)

  implicit def zeroSplitable1[N <: Number]: Splittable[HNil.type, N, HNil.type, HNil.type] =
    (_: HNil.type, _: N) => (HNil, HNil)

  implicit def Splittable[H, M <: HList, L <: HList, R <: HList, N <: Number]
  (implicit Splittable: Splittable[M, N, L, R]): Splittable[HCons[H, M], Inc[N], HCons[H, L], R] =
    (list: HCons[H, M], pos: Inc[N]) => {
      val (l, r) = Splittable(list.tail, pos.dec)
      (HCons(list.head, l), r)
    }
}