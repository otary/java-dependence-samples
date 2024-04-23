package cn.chenzw.antlr4.sql.core;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * @author chenzw
 */
public class CreateTableVisitor extends CreateTableParserBaseVisitor<String> {

    private String tableName;

    @Override
    public String visitTableName(CreateTableParser.TableNameContext ctx) {
        this.tableName = ctx.getText();
        return super.visitTableName(ctx);
    }

    @Override
    public String visitColumnDefinition(CreateTableParser.ColumnDefinitionContext ctx) {
      /*  System.out.println(ctx.getText());
        System.out.println(ctx.getChildCount());
        System.out.println(ctx.dataType());*/

        return super.visitColumnDefinition(ctx);
    }

    @Override
    public String visitIndexColumnNames(CreateTableParser.IndexColumnNamesContext ctx) {
        System.out.println("IndexColumnNames => " + ctx.getText());
        return super.visitIndexColumnNames(ctx);
    }

    @Override
    public String visitTableOption(CreateTableParser.TableOptionContext ctx) {
        System.out.println(ctx.tableComment + " " + ctx.getText());
        return super.visitTableOption(ctx);
    }


    @Override
    public String visitCreateDefinitions(CreateTableParser.CreateDefinitionsContext ctx) {
        List<TerminalNode> comma = ctx.Comma();
        for (TerminalNode terminalNode : comma) {
            System.out.println(terminalNode.getText());
        }
        System.out.println("-----执行这里");
        return super.visitCreateDefinitions(ctx);
    }

    @Override
    public String visitCreateDefinition(CreateTableParser.CreateDefinitionContext ctx) {
        System.out.println("执行这里22----");
        return super.visitCreateDefinition(ctx);
    }

    public String getTableName() {
        return tableName;
    }
}
