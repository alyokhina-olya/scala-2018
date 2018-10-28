// Generated from /home/olya/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package com.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExpParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExpParser.ExprContext ctx);
}