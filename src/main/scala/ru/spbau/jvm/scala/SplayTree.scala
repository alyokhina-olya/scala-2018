package ru.spbau.jvm.scala

import java.util.NoSuchElementException


class SplayTree[T](comparator: Ordering[T]) {
  private var count: Int = 0
  private var root: Node = _

  def size(): Int = count

  def isEmpty: Boolean = count == 0

  def contains(o: T): Boolean = {
    if (!o.isInstanceOf[T] || root == null) {
      return false
    }
    val key: T = o.asInstanceOf[T]
    root = find(root, key)
    root != null && root.key == key
  }


  def add(e: T): Boolean = {
    if (contains(e)) {
      return false
    }
    if (root == null) {
      root = new Node(e)
    }
    else {
      root = insert(root, e)
    }
    count += 1
    true
  }

  def remove(o: T): Boolean = {
    var result: Boolean = false
    if (contains(o)) {
      result = true
      count -= 1
    }
    root = remove(root, o.asInstanceOf[T])
    result
  }


  def iterator(): Iterator[T] = {
    new SplayTreeIterator
  }

  def containsAll(elems: T*): Boolean = {
    for (elem <- elems) {
      if (!contains(elem)) {
        return false
      }
    }
    true
  }

  def addAll(elems: T*): Boolean = {
    var result = true
    for (elem <- elems) {
      result &= add(elem.asInstanceOf[T])
    }
    result
  }

  def removeAll(elems: T*): Boolean = {
    var result = true
    for (elem <- elems) {
      result &= remove(elem.asInstanceOf[T])
    }
    result
  }

  def clear(): Unit = {
    count = 0
    root = null
  }


  def map[U <: T, V](f: U => V)(cmpV: Ordering[V]): SplayTree[V] = {
    val newSplayTree = new SplayTree[V](cmpV)
    val iterator = this.iterator()
    while (iterator.hasNext) {
      newSplayTree.add(f(iterator.next.asInstanceOf[U]))
    }
    newSplayTree
  }

  def flatMap[U <: T, V](f: U => SplayTree[V])(cmpV: Ordering[V]): SplayTree[V] = {
    val newSplayTree = new SplayTree[V](cmpV)
    val iterator = this.iterator()
    while (iterator.hasNext) {
      val innerSplayTreeIterator = f(iterator.next.asInstanceOf[U]).iterator()
      while (innerSplayTreeIterator.hasNext) {
        newSplayTree.add(innerSplayTreeIterator.next())
      }
    }
    newSplayTree
  }

  def foreach[U <: T, V](f: U => V): Unit = {
    val iterator = this.iterator()
    while (iterator.hasNext) {
      f(iterator.next.asInstanceOf[U])
    }
  }

  def filter[U <: T](f: U => Boolean): SplayTree[T] = {
    val newSplayTree = new SplayTree[T](comparator)
    val iterator = this.iterator()
    while (iterator.hasNext) {
      val cur = iterator.next
      if (f(cur.asInstanceOf[U])) {
        newSplayTree.add(cur)
      }
    }
    newSplayTree
  }


  private def setParent(child: Node, parent: Node): Unit = {
    if (child != null) {
      child.parent = parent
    }
  }


  private def keepParent(node: Node): Unit = {
    if (node != null) {
      setParent(node.left, node)
      setParent(node.right, node)
    }
  }

  private def rotate(parent: Node, child: Node): Unit = {
    val grandparent: Node = parent.parent
    if (grandparent != null) {
      if (grandparent.left == parent) {
        grandparent.left = child
      }
      else {
        grandparent.right = child
      }
    }
    if (parent.left == child) {
      val parentCopy = parent
      parent.left = child.right
      child.right = parentCopy
    }
    else {
      val parentCopy = parent
      parent.right = child.left
      child.left = parentCopy
    }
    keepParent(child)
    keepParent(parent)
    child.parent = grandparent
  }

  private def splay(node: Node): Node = {
    if (node.parent == null) {
      return node
    }
    val parent: Node = node.parent
    val grandparent: Node = parent.parent
    if (grandparent == null) {
      rotate(parent, node)
      return node
    }
    val isZigzig = (grandparent.left == parent) == (parent.left == node)
    if (isZigzig) {
      rotate(grandparent, parent)
      rotate(parent, node)
    }
    else {
      rotate(parent, node)
      rotate(grandparent, node)
    }
    splay(node)
  }

  private def find(node: Node, key: T): Node = {
    if (node == null) {
      return null
    }
    if (key == node.key) {
      return splay(node)
    }
    if (comparator.compare(key, node.key) < 0 && node.left != null) {
      return find(node.left, key)
    }
    if (comparator.compare(key, node.key) > 0 && node.right != null) {
      return find(node.right, key)
    }
    splay(node)
  }

  private def split(root: Node, key: T): (Node, Node) = {
    if (root == null) {
      return (null, null)
    }
    val newRoot = find(root, key)
    if (comparator.compare(newRoot.key, key) == 0) {
      setParent(newRoot.left, null)
      setParent(newRoot.right, null)
      return (root.left, root.right)
    }
    if (comparator.compare(newRoot.key, key) < 0) {
      val right = newRoot.right
      newRoot.right = null
      setParent(right, null)
      (newRoot, right)
    }
    else {
      val left = newRoot.left
      newRoot.left = null
      setParent(left, null)
      (left, newRoot)
    }
  }

  private def insert(root: Node, key: T): Node = {
    if (root == null) {
      return new Node(key)
    }
    val (left, right) = split(root, key)
    val newRoot = new Node(key, left, right)
    keepParent(newRoot)
    newRoot
  }

  private def merge(left: Node, right: Node): Node = {
    if (right == null) {
      return left
    }
    if (left == null) {
      return right
    }
    val newRoot = find(right, left.key)
    newRoot.left = left
    left.parent = newRoot
    newRoot
  }

  private def remove(root: Node, key: T): Node = {
    val newRoot = find(root, key)
    if (newRoot == null) {
      return newRoot
    }
    setParent(newRoot.left, null)
    setParent(newRoot.right, null)
    merge(newRoot.left, newRoot.right)
  }

  private def next(node: Node): Node = {
    if (node == null) {
      null
    }
    else {
      if (node.right != null) {
        this.min(node.right)
      }
      else {
        var cur = node.parent
        while (cur != null && comparator.compare(cur.key, node.key) <= 0) {
          cur = cur.parent
        }
        cur
      }
    }
  }

  private def min(node: Node): Node = {
    if (node == null) {
      return null
    }
    if (node.left != null) {
      return min(node.left)
    }
    node
  }

  private class Node(val key: T,
                     var left: Node = null,
                     var right: Node = null,
                     var parent: Node = null)

  private class SplayTreeIterator extends Iterator[T] {
    var curNode: Node = SplayTree.this.min(SplayTree.this.root)
    var nextNode: Node = SplayTree.this.next(curNode)

    override def hasNext: Boolean = {
      curNode != null
    }

    override def next(): T = {
      if (curNode == null) {
        throw new NoSuchElementException
      }
      val result = curNode.key
      curNode = nextNode
      nextNode = SplayTree.this.next(curNode)
      result
    }
  }

}
