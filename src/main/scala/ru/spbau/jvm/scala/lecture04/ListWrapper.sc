final class ListWrapper[A](val toList: List[A]) {

  override def toString: String = toList.mkString("List(", ", ", ")")

  def foreach(action: A => Unit): Unit = toList.foreach(action)

  def withFilter(predicate: A => Boolean): ListWrapper[A] = new ListWrapper(toList.filter(predicate))

  def map[B](function: A => B): ListWrapper[B] = new ListWrapper(toList.map(function))

  def ++[B >: A](tail: ListWrapper[B]): ListWrapper[B] = new ListWrapper[B](toList ++ tail.toList)

  def :::[B >: A](prefix: ListWrapper[B]): ListWrapper[B] = new ListWrapper[B](toList ::: prefix.toList)

  def ::[B >: A](head: B): ListWrapper[B] = new ListWrapper(head :: toList)
}

object ListWrapper {

  def apply[T](elements: T*): ListWrapper[T] = new ListWrapper(elements.toList)

  def unapplySeq[T](list: ListWrapper[T]): Option[Seq[T]] = Some(list.toList)

  implicit def wrapper2list[T](list: ListWrapper[T]): List[T] = list.toList
}

object Modulo2 {

  def unapply(int: Int) = int % 2 match {
    case 0 => Some(0)
    case _ => None
  }
}

object isEven {

  def unapply(int: Int) = int % 2 == 0
}

val list = ListWrapper(1, 2, 3)
for {
  element <- list
  isEven() <- Some(element)
  // if element % 2 == 0
} println(s"$element % 2 = 0")

val ListWrapper(first, second, tail@_*) = list

list ++ ListWrapper(1) // list.++(ListWrapper(1))
1 :: list // list.::(1)
(0 :: list) ::: list // list.:::(0 :: list)

import scala.collection.JavaConverters._

val scalaList: List[Int] = list
val javaList: java.util.List[Int] = scalaList.asJava