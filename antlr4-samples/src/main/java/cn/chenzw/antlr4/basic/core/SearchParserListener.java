// Generated from C:/Users/chenzw/IdeaProjects/java-dependence-samples/anltr4-samples/src/main/java/cn/chenzw/anltr4/basic\SearchParser.g4 by ANTLR 4.9.1
package cn.chenzw.antlr4.basic.core;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SearchParser}.
 */
public interface SearchParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SearchParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SearchParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SearchParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SearchParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(SearchParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(SearchParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identityExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentityExpr(SearchParser.IdentityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identityExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentityExpr(SearchParser.IdentityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lrExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLrExpr(SearchParser.LrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lrExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLrExpr(SearchParser.LrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(SearchParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(SearchParser.BoolExprContext ctx);
}
