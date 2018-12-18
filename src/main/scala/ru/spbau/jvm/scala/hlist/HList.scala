package ru.spbau.jvm.scala
package hlist

import ru.spbau.jvm.scala.hlist.Number.{Inc, Zero}

sealed trait HList

object HList {

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

  case object HNil extends HList

  implicit class HListExt[R <: HList](private val list: R) extends AnyVal {

    def ::[H](head: H) = HCons(head, list)

    def :::[L <: HList, Result <: HList](left: L)
                                        (implicit appendable: Appendable[L, R, Result]): Result =
      appendable(left, list)

    def zip[L <: HList, Result <: HList](left: L)
                                        (implicit zippable: Zippable[R, L, Result]): Result =
      zippable(list, left)

    def splitAt[N <: Number, LResult <: HList, RResult <: HList](pos: N)
                                                                (implicit splittable: Splittable[R, N, LResult, RResult]): (LResult, RResult) =
      splittable(list, pos)

    def ==[L <: HList](left: L)
                      (implicit equalable: Equalable[L, R]): Boolean =
      equalable(left, list)

  }

  def main(args: Array[String]): Unit = {
    val list1 = 1 :: 2 :: 3 :: HNil
    val two = Inc(Inc(Zero))
    val (l, r) = list1 splitAt two
    println(l)
    println(r)
    val list2 = 1 :: 2 :: 3 :: HNil
    val list3 = 1 :: 2 :: 3 :: HNil
    println(list2.zip(list3))
  }
}