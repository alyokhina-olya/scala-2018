package ru.spbau.jvm.scala.lecture07.model

import scala.collection.mutable

final class Project(val path: String) {

  private val modules_ = mutable.Map.empty[String, Module]

  def modules: Seq[Module] = modules_.values.toSeq

  def addModule(name: String): Module = {
    val module = new Module(name)(this)
    modules_(name) = module
    module
  }
}
