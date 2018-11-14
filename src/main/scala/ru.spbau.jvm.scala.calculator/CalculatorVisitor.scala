package ru.spbau.jvm.scala.calculator

import com.antlr.{ExpBaseVisitor, ExpParser}

object CalculatorVisitor extends ExpBaseVisitor[Node] {
  override def visitExpression(ctx: ExpParser.ExpressionContext): Node = {

    if (ctx.Number() != null) {
      return new Node(ctx.Number().getText.toDouble)
    }

    if (ctx.Boolean() != null) {
      return new Node(ctx.Boolean().getText.toBoolean)
    }

    if (ctx.Add() != null) {
      if (ctx.Add().getText.equals("+")) return ctx.expression(0).accept(this) + ctx.expression(1).accept(this)
      if (ctx.Add().getText.equals("-")) return ctx.expression(0).accept(this) - ctx.expression(1).accept(this)
    }
    if (ctx.Mul() != null) {
      if (ctx.Mul().getText.equals("*")) return ctx.expression(0).accept(this) * ctx.expression(1).accept(this)
      if (ctx.Mul().getText.equals("/")) return ctx.expression(0).accept(this) / ctx.expression(1).accept(this)
      if (ctx.Mul().getText.equals("%")) return ctx.expression(0).accept(this) % ctx.expression(1).accept(this)
    }

    if (ctx.Cmp() != null) {
      if (ctx.Cmp().getText.equals("<")) return ctx.expression(0).accept(this) < ctx.expression(1).accept(this)
      if (ctx.Cmp().getText.equals(">")) return ctx.expression(0).accept(this) > ctx.expression(1).accept(this)
      if (ctx.Cmp().getText.equals("<=")) return ctx.expression(0).accept(this) <= ctx.expression(1).accept(this)
      if (ctx.Cmp().getText.equals(">=")) return ctx.expression(0).accept(this) >= ctx.expression(1).accept(this)
    }

    if (ctx.Eq() != null) {
      if (ctx.Eq().getText.equals("==")) return ctx.expression(0).accept(this) == ctx.expression(1).accept(this)
      if (ctx.Eq().getText.equals("!=")) return ctx.expression(0).accept(this) != ctx.expression(1).accept(this)
    }

    if (ctx.And() != null) {
      return ctx.expression(0).accept(this) && ctx.expression(1).accept(this)
    }
    if (ctx.Or() != null) {
      return ctx.expression(0).accept(this) || ctx.expression(1).accept(this)
    }
    if (ctx.Not() != null) {
      return ctx.expression(0).accept(this).not()
    }

    ctx.expression(0).accept(this)
  }

}





