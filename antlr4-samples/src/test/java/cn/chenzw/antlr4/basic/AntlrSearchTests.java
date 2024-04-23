package cn.chenzw.antlr4.basic;

import cn.chenzw.antlr4.basic.core.SearchLexer;
import cn.chenzw.antlr4.basic.core.SearchParser;
import cn.chenzw.antlr4.basic.core.SearchParserBaseVisitor;
import cn.chenzw.antlr4.basic.core.SearchVisitor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class AntlrSearchTests {

    @Test
    public void test() {
        CharStream input = CharStreams.fromString("(country:中国||country:美国)&&city:北京");

        // 从字符流分析词法，解析为token
        SearchLexer searchLexer = new SearchLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(searchLexer);
        SearchParser searchParser = new SearchParser(tokens);

        // 使用监听器，遍历语法树，根据语法定义，prog为语法树的根节点
        SearchParser.ProgContext prog = searchParser.prog();

        // 使用visitor，生成自定义的对象
        Integer integer = prog.accept(new SearchParserBaseVisitor<>());

        log.info(" => {}", integer);

        // 打印生成的语法树
        log.info("tree => {}", prog.toStringTree(searchParser));


        SearchParser.ExpressionContext expressionContext = searchParser.prog().expression();
        if (expressionContext instanceof SearchParser.BoolExprContext) {
            // 条件表达式包含与或非
            log.info("BoolExpr => {}", expressionContext.getText());
        } else if (expressionContext instanceof SearchParser.LrExprContext) {
            // 被括号包含
            System.out.println("-------111");
        } else if (expressionContext instanceof SearchParser.EqExprContext) {
            // 等式
            System.out.println("-------222");
        }
    }

    @Test
    public void test2() {
        CharStream input = CharStreams.fromString("(country:中国||country:美国)&&city:北京");

        // 从字符流分析词法，解析为token
        SearchLexer searchLexer = new SearchLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(searchLexer);
        SearchParser searchParser = new SearchParser(tokens);

        // 使用监听器，遍历语法树，根据语法定义，prog为语法树的根节点
        SearchParser.ProgContext prog = searchParser.prog();

        // 使用visitor，生成自定义的对象
        String sss = prog.accept(new SearchVisitor());

        System.out.println(sss);
    }
}
