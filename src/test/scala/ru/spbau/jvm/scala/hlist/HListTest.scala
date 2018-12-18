package ru.spbau.jvm.scala.hlist

import org.junit.Test
import ru.spbau.jvm.scala.hlist.HList.HNil
import ru.spbau.jvm.scala.hlist.Number.{Inc, Zero}

class HListTest {
  @Test
  def testZip(): Unit = {
    val list1 = "a" :: 23 :: HNil
    val list2 = 1 :: true :: HNil
    val actual = list1 zip list2
    val expected = ("a", 1) :: (23, true) :: HNil
    assert(expected == actual)
  }

  @Test
  def testZipIfFirstShorter(): Unit = {
    val list1 = "a" :: 23 :: HNil
    val list2 = 1 :: true :: 4 :: 5 :: HNil
    val actual = list1 zip list2
    val expected = ("a", 1) :: (23, true) :: HNil
    assert(expected == actual)
  }

  @Test
  def testZipIfSecondShorter(): Unit = {
    val list1 = "a" :: 23 :: 4 :: 5 :: HNil
    val list2 = 1 :: true :: HNil
    val actual = list1 zip list2
    val expected = ("a", 1) :: (23, true) :: HNil
    assert(expected == actual)
  }

  @Test
  def testSplitAt(): Unit = {
    val list = "a" :: 23 :: 4 :: 5 :: HNil
    val two = Inc(Inc(Zero))
    val expectedLeft = "a" :: 23 :: HNil
    val expectedRight = 4 :: 5 :: HNil
    val (actualLeft, actualRight) = list splitAt two
    assert(expectedLeft == actualLeft)
    assert(expectedRight == actualRight)
  }

  @Test
  def testSplitAtIfNumberGreater(): Unit = {
    val list = "a" :: 23 :: 4 :: 5 :: HNil
    val six = Inc(Inc(Inc(Inc(Inc(Inc(Zero))))))
    val expectedLeft = "a" :: 23 :: 4 :: 5 :: HNil
    val expectedRight = HNil
    val (actualLeft, actualRight) = list splitAt six
    assert(expectedLeft == actualLeft)
    assert(expectedRight == actualRight)
  }

  @Test
  def testSplitAtWithZero(): Unit = {
    val list = "a" :: 23 :: 4 :: 5 :: HNil
    val expectedLeft = HNil
    val expectedRight = "a" :: 23 :: 4 :: 5 :: HNil
    val (actualLeft, actualRight) = list splitAt Zero
    assert(expectedLeft == actualLeft)
    assert(expectedRight == actualRight)
  }

}
