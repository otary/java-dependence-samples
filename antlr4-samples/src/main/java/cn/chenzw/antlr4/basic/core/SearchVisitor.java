package cn.chenzw.antlr4.basic.core;

/**
 * @author chenzw
 */
public class SearchVisitor extends SearchParserBaseVisitor<String> {

    @Override
    public String visitIdentityExpr(SearchParser.IdentityExprContext ctx) {
        return ctx.getText();
    }
}
