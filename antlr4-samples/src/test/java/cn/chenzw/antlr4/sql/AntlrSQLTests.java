package cn.chenzw.antlr4.sql;

import cn.chenzw.antlr4.sql.core.CreateTableParser;
import cn.chenzw.antlr4.sql.core.CreateTableVisitor;
import cn.chenzw.antlr4.sql.core.DDLLexer;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class AntlrSQLTests {

    @Test
    public void test() {
        // 构建字符流
        CodePointCharStream charStream = CharStreams.fromString("CREATE TABLE my_table (id INT, name VARCHAR(50));");

        // 从字符流分析词法， 解析为token
        DDLLexer lexer = new DDLLexer(charStream);

        // 从token进行分析
        CreateTableParser parser = new CreateTableParser(new CommonTokenStream(lexer));

        // 使用监听器，遍历语法树，根据语法定义
        CreateTableParser.RootContext rootContext = parser.root();

        CreateTableVisitor createTableVisitor = new CreateTableVisitor();
        rootContext.accept(createTableVisitor);

        log.info("TableName => {}", createTableVisitor.getTableName());

    }
}
