package ru.spbau.jvm.scala

import java.util

import org.junit.Test


class SplayTreeTest {

  @Test
  def testAddAll(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 1, 2, 3, 4, 5, 6, 7, 8, 9)(Ordering.Long)
  }


  @Test
  def testAdd(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.add(1)
    splayTree.add(2)
    splayTree.add(2)
    splayTree.add(3)
    splayTree.add(4)
    splayTree.add(5)
    splayTree.add(5)
    splayTree.add(6)
    splayTree.add(7)
    splayTree.add(8)
    splayTree.add(9)
    splayTree.add(9)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 1, 2, 3, 4, 5, 6, 7, 8, 9)(Ordering.Long)
  }

  @Test
  def testRemove(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1, 10, 11, 15, 23)
    splayTree.remove(11)
    splayTree.remove(10)
    splayTree.remove(15)
    splayTree.remove(23)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 1, 2, 3, 4, 5, 6, 7, 8, 9)(Ordering.Long)
  }

  @Test
  def testRemoveAll(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1, 10, 11, 15, 23)
    splayTree.removeAll(11, 10, 15, 23)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 1, 2, 3, 4, 5, 6, 7, 8, 9)(Ordering.Long)
  }

  @Test
  def testSize(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1, 10, 11, 15, 23)
    splayTree.removeAll(11, 10, 15, 23)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    assert(splayTree.size() == 9)
    splayTree.add(18)
    assert(splayTree.size() == 10)
    splayTree.remove(1)
    assert(splayTree.size() == 9)
    splayTree.remove(1)
    assert(splayTree.size() == 9)
  }


  @Test
  def testIsEmpty(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1, 10, 11, 15, 23)
    splayTree.removeAll(11, 10, 15, 23)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    assert(!splayTree.isEmpty)
    splayTree.clear()
    assert(splayTree.isEmpty)
    splayTree.add(1)
    assert(!splayTree.isEmpty)
    splayTree.remove(1)
    assert(splayTree.isEmpty)
  }

  @Test
  def testContains(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 2, 8, 9, 1)
    assert(splayTree.contains(1))
    assert(splayTree.contains(2))
    assert(splayTree.contains(3))
    assert(splayTree.contains(4))
    assert(splayTree.contains(5))
    assert(splayTree.contains(6))
    assert(!splayTree.contains(100))
    assert(!splayTree.contains(-5))
    assert(!splayTree.contains(7))
  }

  @Test
  def testIterator(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    val iterator = splayTree.iterator()
    val list = new util.ArrayList[Long]
    while (iterator.hasNext) {
      list.add(iterator.next())
    }
    cmpList[Long](list, 1, 2, 3, 4, 5, 6, 7, 8, 9)(Ordering.Long)
  }

  @Test
  def testContainsAll(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    assert(splayTree.containsAll(1, 2, 3, 4, 5, 6, 7, 8, 9))
    assert(splayTree.containsAll(9, 8, 7, 6, 5, 4, 3, 2, 1))
    assert(!splayTree.containsAll(9, 8, 7, 6, 15, 4, 3, 2, 1))
  }

  @Test
  def testClear(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    splayTree.clear()
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list)(Ordering.Long)
    splayTree.add(1)
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 1)(Ordering.Long)
    splayTree.clear()
    list.clear()
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list)(Ordering.Long)
  }


  @Test
  def testMap(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    val stringSplayTree = splayTree.map[Long, String](elem => elem.toString)(Ordering.String)
    val list = new util.ArrayList[String]
    stringSplayTree.foreach[String, Unit](x => list.add(x))
    cmpList[String](list, "1", "2", "3", "4", "5", "6", "7", "8", "9")(Ordering.String)
  }


  @Test
  def testFlatMap(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    val newSplayTree = splayTree.flatMap[Long, Long](elem => {
      val innerSplayTree = new SplayTree[Long](Ordering.Long)
      innerSplayTree.addAll(elem * 10 + 1, elem * 10 + 5)
      innerSplayTree
    })(Ordering.Long)
    val list = new util.ArrayList[Long]
    newSplayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 11, 15, 21, 25, 31, 35, 41, 45, 51, 55, 61, 65, 71, 75, 81, 85, 91, 95)(Ordering.Long)
  }

  @Test
  def testForeach(): Unit = {
    val splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 1, 2, 3, 4, 5, 6, 7, 8, 9)(Ordering.Long)
  }


  @Test
  def testFilter(): Unit = {
    var splayTree: SplayTree[Long] = new SplayTree[Long](Ordering.Long)
    splayTree.addAll(5, 4, 6, 3, 7, 2, 8, 9, 1)
    splayTree = splayTree.filter[Long](elem => elem > 5)
    val list = new util.ArrayList[Long]
    splayTree.foreach[Long, Unit](x => list.add(x))
    cmpList[Long](list, 6, 7, 8, 9)(Ordering.Long)
  }

  private def cmpList[T](firstList: util.ArrayList[T], elems: T*)(comparator: Ordering[T]): Unit = {
    assert(firstList.size() == elems.size)
    for (i <- 0 until firstList.size()) {
      assert(comparator.compare(firstList.get(i), elems(i)) == 0)
    }
  }
}

