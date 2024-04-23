package cn.chenzw.antlr4.basic2.core;

import java.util.Objects;

/**
 * 自定义逻辑
 *
 * @author chenzw
 */
public class EvalExprVisitor extends ExprBaseVisitor<Integer> {

    /**
     * 入口处调用
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Integer visitProg(ExprParser.ProgContext ctx) {
        ExprParser.ExprContext expr = ctx.expr();
        return visit(expr);
    }

    /**
     * expr:	expr ('*'|'/') expr
     *     |	expr ('+'|'-') expr
     *     |	INT
     *     |	'(' expr ')'
     * @param ctx the parse tree
     * @return
     */
    /**
     * expr ('*'|'/') expr
     */
    @Override
    public Integer visitMultiOrDiv(ExprParser.MultiOrDivContext ctx) {
        Integer op1 = visit(ctx.expr(0));
        Integer op2 = visit(ctx.expr(1));

        String operator = ctx.getChild(1).getText();
        if (Objects.equals(operator, "*")) {
            return op1 * op2;
        }

        if (Objects.equals(operator, "/")) {
            return op1 / op2;
        }

        return 0;
    }

    /**
     * expr ('+'|'-') expr
     */
    @Override
    public Integer visitAddOrSub(ExprParser.AddOrSubContext ctx) {
        Integer op1 = visit(ctx.expr(0));
        Integer op2 = visit(ctx.expr(1));

        String operator = ctx.getChild(1).getText();
        if (Objects.equals(operator, "+")) {
            return op1 + op2;
        }

        if (Objects.equals(operator, "-")) {
            return op1 - op2;
        }

        return 0;
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Integer visitSingle(ExprParser.SingleContext ctx) {
        return visit(ctx);
    }

    /**
     * INT
     *
     * @return
     */
    @Override
    public Integer visitLieteral(ExprParser.LieteralContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

}
