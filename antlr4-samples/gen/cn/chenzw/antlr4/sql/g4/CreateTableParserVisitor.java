// Generated from java-escape by ANTLR 4.11.1
package cn.chenzw.antlr4.sql.g4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CreateTableParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CreateTableParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(CreateTableParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#createTableDDL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableDDL(CreateTableParser.CreateTableDDLContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(CreateTableParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#ifNotExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExists(CreateTableParser.IfNotExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#createDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDefinitions(CreateTableParser.CreateDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#createDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDefinition(CreateTableParser.CreateDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(CreateTableParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(CreateTableParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#lengthOneDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthOneDimension(CreateTableParser.LengthOneDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#lengthTwoDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoDimension(CreateTableParser.LengthTwoDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#lengthTwoOptionalDimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthTwoOptionalDimension(CreateTableParser.LengthTwoOptionalDimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#collectionOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionOptions(CreateTableParser.CollectionOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraint(CreateTableParser.ColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#nullNotNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullNotNull(CreateTableParser.NullNotNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(CreateTableParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(CreateTableParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#primaryKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKey(CreateTableParser.PrimaryKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(CreateTableParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CreateTableParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#currentTimestamp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentTimestamp(CreateTableParser.CurrentTimestampContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstraint(CreateTableParser.TableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#indexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOption(CreateTableParser.IndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(CreateTableParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#indexColumnNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexColumnNames(CreateTableParser.IndexColumnNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#tableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOption(CreateTableParser.TableOptionContext ctx);
}