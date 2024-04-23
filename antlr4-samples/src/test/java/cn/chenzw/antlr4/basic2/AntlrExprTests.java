package cn.chenzw.antlr4.basic2;

import cn.chenzw.antlr4.basic2.core.*;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
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
public class AntlrExprTests {

    @Test
    public void test() {
        // 构建字符流
        CodePointCharStream charStream = CharStreams.fromString("1+2+3*4");

        // 从字符流分析词法， 解析为token
        ExprLexer lexer = new ExprLexer(charStream);

        // 从token进行分析
        ExprParser parser = new ExprParser(new CommonTokenStream(lexer));

        // 使用监听器，遍历语法树，根据语法定义，prog为语法树的根节点
        ExprParser.ProgContext prog = parser.prog();
       /*
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExprBaseListener(), prog);
        */

        // 使用visitor，生成自定义的对象
        Integer integer = prog.accept(new EvalExprVisitor());

        log.info(" => {}", integer);

        // Assert.assertEquals(15, integer);

        // 打印生成的语法树
        log.info("tree => {}", prog.toStringTree(parser));
    }
}
