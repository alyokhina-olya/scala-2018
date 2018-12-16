package ru.spbau.jvm.scala.lecture08

import scala.collection.mutable

class Graph {

  case class Vertex()

  type Edge = (Vertex, Vertex)

  private val vertices = mutable.ArrayBuffer.empty[Vertex]
  private val edges = mutable.ArrayBuffer.empty[Edge]

  def +=(vertex: Vertex): Unit = {
    vertices += vertex
  }

  def +=(edge: Edge): Unit = {
    edges += edge
  }
}

object Graph {

  def main(args: Array[String]): Unit = {
    val firstGraph = new Graph
    val secondGraph = new Graph

    val fromVertex = firstGraph.Vertex()
    firstGraph += fromVertex
    //    secondGraph.+=(fromVertex) // compilation error

    val toVertex = firstGraph.Vertex()
    firstGraph += toVertex
    firstGraph += (fromVertex, toVertex)
    //    secondGraph.+=(toVertex)
    //    secondGraph.+=((fromVertex, toVertex))

    val edge = (fromVertex, toVertex)
    println(edgeText(edge))
    println(edgeText((secondGraph.Vertex(), secondGraph.Vertex())))
  }

  private def edgeText(vertex: Graph#Edge) = {
    val (from, to) = vertex
    s"$from -> $to"
  }

}
