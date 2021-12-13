package cn.chenzw.dependence.sqlparser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.table.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class BasicTests {


    @Test
    public void test() throws JSQLParserException {
        String ddlSql = "CREATE TABLE IF NOT EXISTS `sys_user` (\n" +
                "  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',\n" +
                "  `user_name` varchar(255) NOT NULL COMMENT '用户名',\n" +
                "  `status` tinyint(1) NOT NULL COMMENT '状态',\n" +
                "  `create_time` datetime NOT NULL COMMENT '创建时间',\n" +
                "  PRIMARY KEY (`user_id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息'";

        Statements statements = CCJSqlParserUtil.parseStatements(ddlSql);

        statements.getStatements().forEach(statement -> {
            CreateTable ct = (CreateTable) statement;

            // 列信息
            ct.getColumnDefinitions().stream().forEach(columnDefinition -> {
                log.info("ColumnName => {}", columnDefinition.getColumnName());
                log.info("ColumnSpecStrings => {}", columnDefinition.getColumnSpecStrings());
                log.info("ColDataType => {}, ArgumentsStringList => {}, {}, {}", columnDefinition.getColDataType().getDataType(),
                        columnDefinition.getColDataType().getArgumentsStringList(),
                        columnDefinition.getColDataType().getArrayData(),
                        columnDefinition.getColDataType().getCharacterSet()
                );
            });

            // 索引、主键信息
            List<Index> indexes = ct.getIndexes();
            for (Index index : indexes) {
                log.info("indexName => {}, indexType => {}, indexColumnsNames => {}, indexSpec => {}", index.getName(), index.getType(), index.getColumnsNames(), index.getIndexSpec());
            }

            List<String> createOptionsStrings = ct.getCreateOptionsStrings();
            log.info("createOptionsStrings => {}", createOptionsStrings);

            // 表备注等信息
            List<?> tableOptionsStrings = ct.getTableOptionsStrings();
            for (Object tableOptionsString : tableOptionsStrings) {
                log.info("tableOptionsString => {}", tableOptionsString);
            }

            Table table = ct.getTable();
            log.info("DatabaseName => {}, FullyQualifiedName => {}, Server => {}",
                    table.getDatabase().getDatabaseName(),
                    table.getDatabase().getFullyQualifiedName(),
                    table.getDatabase().getServer()
            );

            // 表名等信息
            log.info("FullyQualifiedName => {}, tableName => {}, SchemaName => {}, Pivot => {}, IndexHint => {}",
                    table.getFullyQualifiedName(),
                    table.getName(),
                    table.getSchemaName(),
                    table.getPivot(),
                    table.getIndexHint()
            );


            // 表名别名
            if (table.getAlias() != null) {
                log.info("AliasName => {}, AliasIsUseAs => {}",
                        table.getAlias().getName(),
                        table.getAlias().isUseAs());
            }


        });
    }
}
