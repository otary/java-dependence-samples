// Generated from java-escape by ANTLR 4.11.1
package cn.chenzw.antlr4.sql.g4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CreateTableParser}.
 */
public interface CreateTableParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(CreateTableParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(CreateTableParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#createTableDDL}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableDDL(CreateTableParser.CreateTableDDLContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#createTableDDL}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableDDL(CreateTableParser.CreateTableDDLContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(CreateTableParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(CreateTableParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#ifNotExists}.
	 * @param ctx the parse tree
	 */
	void enterIfNotExists(CreateTableParser.IfNotExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#ifNotExists}.
	 * @param ctx the parse tree
	 */
	void exitIfNotExists(CreateTableParser.IfNotExistsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#createDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterCreateDefinitions(CreateTableParser.CreateDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#createDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitCreateDefinitions(CreateTableParser.CreateDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#createDefinition}.
	 * @param ctx the parse tree
	 */
	void enterCreateDefinition(CreateTableParser.CreateDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#createDefinition}.
	 * @param ctx the parse tree
	 */
	void exitCreateDefinition(CreateTableParser.CreateDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(CreateTableParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(CreateTableParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(CreateTableParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(CreateTableParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthOneDimension(CreateTableParser.LengthOneDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthOneDimension(CreateTableParser.LengthOneDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthTwoDimension(CreateTableParser.LengthTwoDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthTwoDimension(CreateTableParser.LengthTwoDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 */
	void enterLengthTwoOptionalDimension(CreateTableParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 */
	void exitLengthTwoOptionalDimension(CreateTableParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#collectionOptions}.
	 * @param ctx the parse tree
	 */
	void enterCollectionOptions(CreateTableParser.CollectionOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#collectionOptions}.
	 * @param ctx the parse tree
	 */
	void exitCollectionOptions(CreateTableParser.CollectionOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void enterColumnConstraint(CreateTableParser.ColumnConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void exitColumnConstraint(CreateTableParser.ColumnConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#nullNotNull}.
	 * @param ctx the parse tree
	 */
	void enterNullNotNull(CreateTableParser.NullNotNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#nullNotNull}.
	 * @param ctx the parse tree
	 */
	void exitNullNotNull(CreateTableParser.NullNotNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(CreateTableParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(CreateTableParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(CreateTableParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(CreateTableParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#primaryKey}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryKey(CreateTableParser.PrimaryKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#primaryKey}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryKey(CreateTableParser.PrimaryKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(CreateTableParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(CreateTableParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CreateTableParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CreateTableParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#currentTimestamp}.
	 * @param ctx the parse tree
	 */
	void enterCurrentTimestamp(CreateTableParser.CurrentTimestampContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#currentTimestamp}.
	 * @param ctx the parse tree
	 */
	void exitCurrentTimestamp(CreateTableParser.CurrentTimestampContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#tableConstraint}.
	 * @param ctx the parse tree
	 */
	void enterTableConstraint(CreateTableParser.TableConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#tableConstraint}.
	 * @param ctx the parse tree
	 */
	void exitTableConstraint(CreateTableParser.TableConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#indexOption}.
	 * @param ctx the parse tree
	 */
	void enterIndexOption(CreateTableParser.IndexOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#indexOption}.
	 * @param ctx the parse tree
	 */
	void exitIndexOption(CreateTableParser.IndexOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#indexType}.
	 * @param ctx the parse tree
	 */
	void enterIndexType(CreateTableParser.IndexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#indexType}.
	 * @param ctx the parse tree
	 */
	void exitIndexType(CreateTableParser.IndexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#indexColumnNames}.
	 * @param ctx the parse tree
	 */
	void enterIndexColumnNames(CreateTableParser.IndexColumnNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#indexColumnNames}.
	 * @param ctx the parse tree
	 */
	void exitIndexColumnNames(CreateTableParser.IndexColumnNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CreateTableParser#tableOption}.
	 * @param ctx the parse tree
	 */
	void enterTableOption(CreateTableParser.TableOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CreateTableParser#tableOption}.
	 * @param ctx the parse tree
	 */
	void exitTableOption(CreateTableParser.TableOptionContext ctx);
}