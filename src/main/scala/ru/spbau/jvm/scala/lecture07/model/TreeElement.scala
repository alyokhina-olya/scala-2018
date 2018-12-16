package ru.spbau.jvm.scala.lecture07.model

trait TreeElement {

  def text: String

  def module: Module

  final def project: Project = module.project
}

object TreeElement {

  class TreeElementImpl(val text: String)
                       (implicit val module: Module) extends TreeElement

}
