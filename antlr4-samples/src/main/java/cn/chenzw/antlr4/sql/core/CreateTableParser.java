// Generated from java-escape by ANTLR 4.11.1
package cn.chenzw.antlr4.sql.core;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CreateTableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AUTO_INCREMENT=1, BIGINT=2, BINARY=3, BIT=4, BLOB=5, BTREE=6, BOOLEAN=7,
		BOOL=8, CHARACTER=9, CHARSET=10, CHAR=11, COLLATE=12, COMMENT=13, CONSTRAINT=14,
		CREATE=15, CURRENT_TIMESTAMP=16, DATETIME=17, DATE=18, DECIMAL=19, DEC=20,
		DEFAULT=21, DOUBLE=22, ENGINE=23, ENUM=24, EXISTS=25, FALSE=26, FIXED=27,
		FLOAT=28, HASH=29, INDEX=30, IF=31, INTEGER=32, INT=33, JSON=34, KEY_BLOCK_SIZE=35,
		KEY=36, LOCALTIMESTAMP=37, LOCALTIME=38, LONGBLOB=39, LONGTEXT=40, MEDIUMBLOB=41,
		MEDIUMINT=42, MEDIUMTEXT=43, NATIONAL=44, NCHAR=45, NOT=46, NOW=47, NULL=48,
		NUMERIC=49, NVARCHAR=50, ON=51, PARSER=52, PRECISION=53, PRIMARY=54, REAL=55,
		SERIAL=56, SET=57, SIGNED=58, SMALLINT=59, TABLE=60, TEMPORARY=61, TEXT=62,
		TIMESTAMP=63, TIME=64, TINYBLOB=65, TINYINT=66, TINYTEXT=67, TRUE=68,
		UNIQUE=69, UNSIGNED=70, UPDATE=71, USING=72, VALUE=73, VARBINARY=74, VARCHAR=75,
		VARYING=76, WITH=77, YEAR=78, ZEROFILL=79, Equal=80, Semicolon=81, Comma=82,
		LeftParenthesis=83, RightParenthesis=84, Tilde=85, Exclamation=86, Plus=87,
		Minus=88, Integer=89, Number=90, FilesizeLiteral=91, Literal=92, PlaceholderString=93,
		BackQuotedString=94, RawString=95, SPACE=96, BLOCK_COMMENT=97, LINE_COMMENT=98;
	public static final int
		RULE_root = 0, RULE_createTableDDL = 1, RULE_tableName = 2, RULE_ifNotExists = 3,
		RULE_createDefinitions = 4, RULE_createDefinition = 5, RULE_columnDefinition = 6,
		RULE_dataType = 7, RULE_lengthOneDimension = 8, RULE_lengthTwoDimension = 9,
		RULE_lengthTwoOptionalDimension = 10, RULE_collectionOptions = 11, RULE_columnConstraint = 12,
		RULE_nullNotNull = 13, RULE_comment = 14, RULE_defaultValue = 15, RULE_primaryKey = 16,
		RULE_unaryOperator = 17, RULE_constant = 18, RULE_currentTimestamp = 19,
		RULE_tableConstraint = 20, RULE_indexOption = 21, RULE_indexType = 22,
		RULE_indexColumnNames = 23, RULE_tableOption = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "createTableDDL", "tableName", "ifNotExists", "createDefinitions",
			"createDefinition", "columnDefinition", "dataType", "lengthOneDimension",
			"lengthTwoDimension", "lengthTwoOptionalDimension", "collectionOptions",
			"columnConstraint", "nullNotNull", "comment", "defaultValue", "primaryKey",
			"unaryOperator", "constant", "currentTimestamp", "tableConstraint", "indexOption",
			"indexType", "indexColumnNames", "tableOption"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, "'='", "';'", "','",
			"'('", "')'", "'~'", "'!'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AUTO_INCREMENT", "BIGINT", "BINARY", "BIT", "BLOB", "BTREE", "BOOLEAN",
			"BOOL", "CHARACTER", "CHARSET", "CHAR", "COLLATE", "COMMENT", "CONSTRAINT",
			"CREATE", "CURRENT_TIMESTAMP", "DATETIME", "DATE", "DECIMAL", "DEC",
			"DEFAULT", "DOUBLE", "ENGINE", "ENUM", "EXISTS", "FALSE", "FIXED", "FLOAT",
			"HASH", "INDEX", "IF", "INTEGER", "INT", "JSON", "KEY_BLOCK_SIZE", "KEY",
			"LOCALTIMESTAMP", "LOCALTIME", "LONGBLOB", "LONGTEXT", "MEDIUMBLOB",
			"MEDIUMINT", "MEDIUMTEXT", "NATIONAL", "NCHAR", "NOT", "NOW", "NULL",
			"NUMERIC", "NVARCHAR", "ON", "PARSER", "PRECISION", "PRIMARY", "REAL",
			"SERIAL", "SET", "SIGNED", "SMALLINT", "TABLE", "TEMPORARY", "TEXT",
			"TIMESTAMP", "TIME", "TINYBLOB", "TINYINT", "TINYTEXT", "TRUE", "UNIQUE",
			"UNSIGNED", "UPDATE", "USING", "VALUE", "VARBINARY", "VARCHAR", "VARYING",
			"WITH", "YEAR", "ZEROFILL", "Equal", "Semicolon", "Comma", "LeftParenthesis",
			"RightParenthesis", "Tilde", "Exclamation", "Plus", "Minus", "Integer",
			"Number", "FilesizeLiteral", "Literal", "PlaceholderString", "BackQuotedString",
			"RawString", "SPACE", "BLOCK_COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CreateTableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public List<CreateTableDDLContext> createTableDDL() {
			return getRuleContexts(CreateTableDDLContext.class);
		}
		public CreateTableDDLContext createTableDDL(int i) {
			return getRuleContext(CreateTableDDLContext.class,i);
		}
		public TerminalNode EOF() { return getToken(CreateTableParser.EOF, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(CreateTableParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(CreateTableParser.Semicolon, i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener) ((CreateTableParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor) return ((CreateTableParserVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			createTableDDL();
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					match(Semicolon);
					setState(52);
					createTableDDL();
					}
					}
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Semicolon) {
				{
				setState(58);
				match(Semicolon);
				}
			}

			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableDDLContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(CreateTableParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(CreateTableParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public CreateDefinitionsContext createDefinitions() {
			return getRuleContext(CreateDefinitionsContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(CreateTableParser.TEMPORARY, 0); }
		public IfNotExistsContext ifNotExists() {
			return getRuleContext(IfNotExistsContext.class,0);
		}
		public List<TableOptionContext> tableOption() {
			return getRuleContexts(TableOptionContext.class);
		}
		public TableOptionContext tableOption(int i) {
			return getRuleContext(TableOptionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CreateTableParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CreateTableParser.Comma, i);
		}
		public CreateTableDDLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableDDL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterCreateTableDDL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitCreateTableDDL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitCreateTableDDL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableDDLContext createTableDDL() throws RecognitionException {
		CreateTableDDLContext _localctx = new CreateTableDDLContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_createTableDDL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(CREATE);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPORARY) {
				{
				setState(64);
				match(TEMPORARY);
				}
			}

			setState(67);
			match(TABLE);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(68);
				ifNotExists();
				}
			}

			setState(71);
			tableName();
			setState(72);
			createDefinitions();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 10499586L) != 0) {
				{
				setState(73);
				tableOption();
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 10499586L) != 0 || _la==Comma) {
					{
					{
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(74);
						match(Comma);
						}
					}

					setState(77);
					tableOption();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode BackQuotedString() { return getToken(CreateTableParser.BackQuotedString, 0); }
		public TerminalNode RawString() { return getToken(CreateTableParser.RawString, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !(_la==BackQuotedString || _la==RawString) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfNotExistsContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CreateTableParser.IF, 0); }
		public TerminalNode NOT() { return getToken(CreateTableParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(CreateTableParser.EXISTS, 0); }
		public IfNotExistsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifNotExists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterIfNotExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitIfNotExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitIfNotExists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfNotExistsContext ifNotExists() throws RecognitionException {
		IfNotExistsContext _localctx = new IfNotExistsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifNotExists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(IF);
			setState(88);
			match(NOT);
			setState(89);
			match(EXISTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateDefinitionsContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(CreateTableParser.LeftParenthesis, 0); }
		public List<CreateDefinitionContext> createDefinition() {
			return getRuleContexts(CreateDefinitionContext.class);
		}
		public CreateDefinitionContext createDefinition(int i) {
			return getRuleContext(CreateDefinitionContext.class,i);
		}
		public TerminalNode RightParenthesis() { return getToken(CreateTableParser.RightParenthesis, 0); }
		public List<TerminalNode> Comma() { return getTokens(CreateTableParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CreateTableParser.Comma, i);
		}
		public CreateDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterCreateDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitCreateDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitCreateDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateDefinitionsContext createDefinitions() throws RecognitionException {
		CreateDefinitionsContext _localctx = new CreateDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_createDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(LeftParenthesis);
			setState(92);
			createDefinition();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(93);
				match(Comma);
				setState(94);
				createDefinition();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateDefinitionContext extends ParserRuleContext {
		public Token field;
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public TerminalNode BackQuotedString() { return getToken(CreateTableParser.BackQuotedString, 0); }
		public TerminalNode RawString() { return getToken(CreateTableParser.RawString, 0); }
		public TableConstraintContext tableConstraint() {
			return getRuleContext(TableConstraintContext.class,0);
		}
		public CreateDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterCreateDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitCreateDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitCreateDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateDefinitionContext createDefinition() throws RecognitionException {
		CreateDefinitionContext _localctx = new CreateDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_createDefinition);
		int _la;
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((CreateDefinitionContext)_localctx).field = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BackQuotedString || _la==RawString) ) {
					((CreateDefinitionContext)_localctx).field = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(103);
				columnDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				tableConstraint();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<ColumnConstraintContext> columnConstraint() {
			return getRuleContexts(ColumnConstraintContext.class);
		}
		public ColumnConstraintContext columnConstraint(int i) {
			return getRuleContext(ColumnConstraintContext.class,i);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitColumnDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			dataType();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 92675704803569666L) != 0 || _la==UNIQUE) {
				{
				{
				setState(108);
				columnConstraint();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public Token typeName;
		public Token sign;
		public TerminalNode CHAR() { return getToken(CreateTableParser.CHAR, 0); }
		public TerminalNode VARCHAR() { return getToken(CreateTableParser.VARCHAR, 0); }
		public TerminalNode TINYTEXT() { return getToken(CreateTableParser.TINYTEXT, 0); }
		public TerminalNode TEXT() { return getToken(CreateTableParser.TEXT, 0); }
		public TerminalNode MEDIUMTEXT() { return getToken(CreateTableParser.MEDIUMTEXT, 0); }
		public TerminalNode LONGTEXT() { return getToken(CreateTableParser.LONGTEXT, 0); }
		public TerminalNode NCHAR() { return getToken(CreateTableParser.NCHAR, 0); }
		public TerminalNode NVARCHAR() { return getToken(CreateTableParser.NVARCHAR, 0); }
		public LengthOneDimensionContext lengthOneDimension() {
			return getRuleContext(LengthOneDimensionContext.class,0);
		}
		public List<TerminalNode> BINARY() { return getTokens(CreateTableParser.BINARY); }
		public TerminalNode BINARY(int i) {
			return getToken(CreateTableParser.BINARY, i);
		}
		public TerminalNode COLLATE() { return getToken(CreateTableParser.COLLATE, 0); }
		public List<TerminalNode> RawString() { return getTokens(CreateTableParser.RawString); }
		public TerminalNode RawString(int i) {
			return getToken(CreateTableParser.RawString, i);
		}
		public List<TerminalNode> BackQuotedString() { return getTokens(CreateTableParser.BackQuotedString); }
		public TerminalNode BackQuotedString(int i) {
			return getToken(CreateTableParser.BackQuotedString, i);
		}
		public TerminalNode CHARACTER() { return getToken(CreateTableParser.CHARACTER, 0); }
		public List<TerminalNode> SET() { return getTokens(CreateTableParser.SET); }
		public TerminalNode SET(int i) {
			return getToken(CreateTableParser.SET, i);
		}
		public TerminalNode CHARSET() { return getToken(CreateTableParser.CHARSET, 0); }
		public TerminalNode NATIONAL() { return getToken(CreateTableParser.NATIONAL, 0); }
		public TerminalNode VARYING() { return getToken(CreateTableParser.VARYING, 0); }
		public TerminalNode TINYINT() { return getToken(CreateTableParser.TINYINT, 0); }
		public TerminalNode SMALLINT() { return getToken(CreateTableParser.SMALLINT, 0); }
		public TerminalNode MEDIUMINT() { return getToken(CreateTableParser.MEDIUMINT, 0); }
		public TerminalNode INT() { return getToken(CreateTableParser.INT, 0); }
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public TerminalNode BIGINT() { return getToken(CreateTableParser.BIGINT, 0); }
		public TerminalNode ZEROFILL() { return getToken(CreateTableParser.ZEROFILL, 0); }
		public TerminalNode SIGNED() { return getToken(CreateTableParser.SIGNED, 0); }
		public TerminalNode UNSIGNED() { return getToken(CreateTableParser.UNSIGNED, 0); }
		public TerminalNode REAL() { return getToken(CreateTableParser.REAL, 0); }
		public LengthTwoDimensionContext lengthTwoDimension() {
			return getRuleContext(LengthTwoDimensionContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(CreateTableParser.DOUBLE, 0); }
		public TerminalNode PRECISION() { return getToken(CreateTableParser.PRECISION, 0); }
		public TerminalNode DECIMAL() { return getToken(CreateTableParser.DECIMAL, 0); }
		public TerminalNode DEC() { return getToken(CreateTableParser.DEC, 0); }
		public TerminalNode FIXED() { return getToken(CreateTableParser.FIXED, 0); }
		public TerminalNode NUMERIC() { return getToken(CreateTableParser.NUMERIC, 0); }
		public TerminalNode FLOAT() { return getToken(CreateTableParser.FLOAT, 0); }
		public LengthTwoOptionalDimensionContext lengthTwoOptionalDimension() {
			return getRuleContext(LengthTwoOptionalDimensionContext.class,0);
		}
		public TerminalNode DATE() { return getToken(CreateTableParser.DATE, 0); }
		public TerminalNode TINYBLOB() { return getToken(CreateTableParser.TINYBLOB, 0); }
		public TerminalNode BLOB() { return getToken(CreateTableParser.BLOB, 0); }
		public TerminalNode MEDIUMBLOB() { return getToken(CreateTableParser.MEDIUMBLOB, 0); }
		public TerminalNode LONGBLOB() { return getToken(CreateTableParser.LONGBLOB, 0); }
		public TerminalNode BOOL() { return getToken(CreateTableParser.BOOL, 0); }
		public TerminalNode BOOLEAN() { return getToken(CreateTableParser.BOOLEAN, 0); }
		public TerminalNode SERIAL() { return getToken(CreateTableParser.SERIAL, 0); }
		public TerminalNode JSON() { return getToken(CreateTableParser.JSON, 0); }
		public TerminalNode BIT() { return getToken(CreateTableParser.BIT, 0); }
		public TerminalNode TIME() { return getToken(CreateTableParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(CreateTableParser.TIMESTAMP, 0); }
		public TerminalNode DATETIME() { return getToken(CreateTableParser.DATETIME, 0); }
		public TerminalNode VARBINARY() { return getToken(CreateTableParser.VARBINARY, 0); }
		public TerminalNode YEAR() { return getToken(CreateTableParser.YEAR, 0); }
		public CollectionOptionsContext collectionOptions() {
			return getRuleContext(CollectionOptionsContext.class,0);
		}
		public TerminalNode ENUM() { return getToken(CreateTableParser.ENUM, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataType);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4612856998310971392L) != 0 || _la==TINYTEXT || _la==VARCHAR) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(115);
					lengthOneDimension();
					}
				}

				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BINARY) {
					{
					setState(118);
					match(BINARY);
					}
				}

				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHARACTER || _la==CHARSET) {
					{
					setState(124);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CHARACTER:
						{
						setState(121);
						match(CHARACTER);
						setState(122);
						match(SET);
						}
						break;
					case CHARSET:
						{
						setState(123);
						match(CHARSET);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(126);
					_la = _input.LA(1);
					if ( !(_la==BINARY || _la==BackQuotedString || _la==RawString) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(129);
					match(COLLATE);
					setState(130);
					_la = _input.LA(1);
					if ( !(_la==BackQuotedString || _la==RawString) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(NATIONAL);
				setState(134);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CHARACTER || _la==VARCHAR) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(135);
					lengthOneDimension();
					}
				}

				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BINARY) {
					{
					setState(138);
					match(BINARY);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(NCHAR);
				setState(142);
				((DataTypeContext)_localctx).typeName = match(VARCHAR);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(143);
					lengthOneDimension();
					}
				}

				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BINARY) {
					{
					setState(146);
					match(BINARY);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(NATIONAL);
				setState(150);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CHARACTER || _la==CHAR) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				match(VARYING);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(152);
					lengthOneDimension();
					}
				}

				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BINARY) {
					{
					setState(155);
					match(BINARY);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 576465163234836484L) != 0 || _la==TINYINT) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(159);
					lengthOneDimension();
					}
				}

				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIGNED || _la==UNSIGNED) {
					{
					setState(162);
					((DataTypeContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==SIGNED || _la==UNSIGNED) ) {
						((DataTypeContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ZEROFILL) {
					{
					setState(165);
					match(ZEROFILL);
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				((DataTypeContext)_localctx).typeName = match(REAL);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(169);
					lengthTwoDimension();
					}
				}

				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIGNED || _la==UNSIGNED) {
					{
					setState(172);
					((DataTypeContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==SIGNED || _la==UNSIGNED) ) {
						((DataTypeContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ZEROFILL) {
					{
					setState(175);
					match(ZEROFILL);
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				((DataTypeContext)_localctx).typeName = match(DOUBLE);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PRECISION) {
					{
					setState(179);
					match(PRECISION);
					}
				}

				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(182);
					lengthTwoDimension();
					}
				}

				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIGNED || _la==UNSIGNED) {
					{
					setState(185);
					((DataTypeContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==SIGNED || _la==UNSIGNED) ) {
						((DataTypeContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ZEROFILL) {
					{
					setState(188);
					match(ZEROFILL);
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(191);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 562950357647360L) != 0) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(192);
					lengthTwoOptionalDimension();
					}
				}

				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIGNED || _la==UNSIGNED) {
					{
					setState(195);
					((DataTypeContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==SIGNED || _la==UNSIGNED) ) {
						((DataTypeContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ZEROFILL) {
					{
					setState(198);
					match(ZEROFILL);
					}
				}

				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(201);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & 1155173390856757261L) != 0) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(202);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & -9223372036854644712L) != 0 || (((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 17409L) != 0) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(203);
					lengthOneDimension();
					}
				}

				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(206);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ENUM || _la==SET) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
				collectionOptions();
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BINARY) {
					{
					setState(208);
					match(BINARY);
					}
				}

				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CHARACTER || _la==CHARSET) {
					{
					setState(214);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CHARACTER:
						{
						setState(211);
						match(CHARACTER);
						setState(212);
						match(SET);
						}
						break;
					case CHARSET:
						{
						setState(213);
						match(CHARSET);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(216);
					_la = _input.LA(1);
					if ( !(_la==BINARY || _la==BackQuotedString || _la==RawString) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LengthOneDimensionContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(CreateTableParser.LeftParenthesis, 0); }
		public TerminalNode Integer() { return getToken(CreateTableParser.Integer, 0); }
		public TerminalNode RightParenthesis() { return getToken(CreateTableParser.RightParenthesis, 0); }
		public LengthOneDimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lengthOneDimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterLengthOneDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitLengthOneDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitLengthOneDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthOneDimensionContext lengthOneDimension() throws RecognitionException {
		LengthOneDimensionContext _localctx = new LengthOneDimensionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lengthOneDimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(LeftParenthesis);
			setState(222);
			match(Integer);
			setState(223);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LengthTwoDimensionContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(CreateTableParser.LeftParenthesis, 0); }
		public List<TerminalNode> Integer() { return getTokens(CreateTableParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(CreateTableParser.Integer, i);
		}
		public TerminalNode Comma() { return getToken(CreateTableParser.Comma, 0); }
		public TerminalNode RightParenthesis() { return getToken(CreateTableParser.RightParenthesis, 0); }
		public LengthTwoDimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lengthTwoDimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterLengthTwoDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitLengthTwoDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitLengthTwoDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthTwoDimensionContext lengthTwoDimension() throws RecognitionException {
		LengthTwoDimensionContext _localctx = new LengthTwoDimensionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lengthTwoDimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(LeftParenthesis);
			setState(226);
			match(Integer);
			setState(227);
			match(Comma);
			setState(228);
			match(Integer);
			setState(229);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LengthTwoOptionalDimensionContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(CreateTableParser.LeftParenthesis, 0); }
		public List<TerminalNode> Integer() { return getTokens(CreateTableParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(CreateTableParser.Integer, i);
		}
		public TerminalNode RightParenthesis() { return getToken(CreateTableParser.RightParenthesis, 0); }
		public TerminalNode Comma() { return getToken(CreateTableParser.Comma, 0); }
		public LengthTwoOptionalDimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lengthTwoOptionalDimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterLengthTwoOptionalDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitLengthTwoOptionalDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitLengthTwoOptionalDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthTwoOptionalDimensionContext lengthTwoOptionalDimension() throws RecognitionException {
		LengthTwoOptionalDimensionContext _localctx = new LengthTwoOptionalDimensionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lengthTwoOptionalDimension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(LeftParenthesis);
			setState(232);
			match(Integer);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(233);
				match(Comma);
				setState(234);
				match(Integer);
				}
			}

			setState(237);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CollectionOptionsContext extends ParserRuleContext {
		public TerminalNode LeftParenthesis() { return getToken(CreateTableParser.LeftParenthesis, 0); }
		public List<TerminalNode> Literal() { return getTokens(CreateTableParser.Literal); }
		public TerminalNode Literal(int i) {
			return getToken(CreateTableParser.Literal, i);
		}
		public TerminalNode RightParenthesis() { return getToken(CreateTableParser.RightParenthesis, 0); }
		public List<TerminalNode> Comma() { return getTokens(CreateTableParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CreateTableParser.Comma, i);
		}
		public CollectionOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterCollectionOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitCollectionOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitCollectionOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionOptionsContext collectionOptions() throws RecognitionException {
		CollectionOptionsContext _localctx = new CollectionOptionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_collectionOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(LeftParenthesis);
			setState(240);
			match(Literal);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(241);
				match(Comma);
				setState(242);
				match(Literal);
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnConstraintContext extends ParserRuleContext {
		public NullNotNullContext nullNotNull() {
			return getRuleContext(NullNotNullContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(CreateTableParser.DEFAULT, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public TerminalNode AUTO_INCREMENT() { return getToken(CreateTableParser.AUTO_INCREMENT, 0); }
		public TerminalNode ON() { return getToken(CreateTableParser.ON, 0); }
		public TerminalNode UPDATE() { return getToken(CreateTableParser.UPDATE, 0); }
		public CurrentTimestampContext currentTimestamp() {
			return getRuleContext(CurrentTimestampContext.class,0);
		}
		public PrimaryKeyContext primaryKey() {
			return getRuleContext(PrimaryKeyContext.class,0);
		}
		public TerminalNode KEY() { return getToken(CreateTableParser.KEY, 0); }
		public TerminalNode UNIQUE() { return getToken(CreateTableParser.UNIQUE, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode COLLATE() { return getToken(CreateTableParser.COLLATE, 0); }
		public TerminalNode BackQuotedString() { return getToken(CreateTableParser.BackQuotedString, 0); }
		public TerminalNode SERIAL() { return getToken(CreateTableParser.SERIAL, 0); }
		public TerminalNode VALUE() { return getToken(CreateTableParser.VALUE, 0); }
		public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterColumnConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitColumnConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitColumnConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnConstraint);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				nullNotNull();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(DEFAULT);
				setState(252);
				defaultValue();
				}
				break;
			case AUTO_INCREMENT:
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AUTO_INCREMENT:
					{
					setState(253);
					match(AUTO_INCREMENT);
					}
					break;
				case ON:
					{
					setState(254);
					match(ON);
					setState(255);
					match(UPDATE);
					setState(256);
					currentTimestamp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				primaryKey();
				}
				break;
			case KEY:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				match(KEY);
				}
				break;
			case UNIQUE:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				match(UNIQUE);
				setState(263);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(262);
					match(KEY);
					}
					break;
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(265);
				comment();
				}
				break;
			case COLLATE:
				enterOuterAlt(_localctx, 8);
				{
				setState(266);
				match(COLLATE);
				setState(267);
				match(BackQuotedString);
				}
				break;
			case SERIAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(268);
				match(SERIAL);
				setState(269);
				match(DEFAULT);
				setState(270);
				match(VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NullNotNullContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(CreateTableParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(CreateTableParser.NOT, 0); }
		public NullNotNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullNotNull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterNullNotNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitNullNotNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitNullNotNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullNotNullContext nullNotNull() throws RecognitionException {
		NullNotNullContext _localctx = new NullNotNullContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_nullNotNull);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(273);
				match(NOT);
				}
			}

			setState(276);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public Token content;
		public TerminalNode COMMENT() { return getToken(CreateTableParser.COMMENT, 0); }
		public TerminalNode Literal() { return getToken(CreateTableParser.Literal, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(COMMENT);
			setState(279);
			((CommentContext)_localctx).content = match(Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultValueContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(CreateTableParser.NULL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public List<CurrentTimestampContext> currentTimestamp() {
			return getRuleContexts(CurrentTimestampContext.class);
		}
		public CurrentTimestampContext currentTimestamp(int i) {
			return getRuleContext(CurrentTimestampContext.class,i);
		}
		public TerminalNode ON() { return getToken(CreateTableParser.ON, 0); }
		public TerminalNode UPDATE() { return getToken(CreateTableParser.UPDATE, 0); }
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_defaultValue);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(NULL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(282);
					unaryOperator();
					}
					break;
				}
				setState(285);
				constant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				currentTimestamp();
				setState(290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(287);
					match(ON);
					setState(288);
					match(UPDATE);
					setState(289);
					currentTimestamp();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryKeyContext extends ParserRuleContext {
		public TerminalNode PRIMARY() { return getToken(CreateTableParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(CreateTableParser.KEY, 0); }
		public PrimaryKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterPrimaryKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitPrimaryKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitPrimaryKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryKeyContext primaryKey() throws RecognitionException {
		PrimaryKeyContext _localctx = new PrimaryKeyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primaryKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(PRIMARY);
			setState(295);
			match(KEY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode Exclamation() { return getToken(CreateTableParser.Exclamation, 0); }
		public TerminalNode Tilde() { return getToken(CreateTableParser.Tilde, 0); }
		public TerminalNode Plus() { return getToken(CreateTableParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CreateTableParser.Minus, 0); }
		public TerminalNode NOT() { return getToken(CreateTableParser.NOT, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_la = _input.LA(1);
			if ( !((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & 8246337208321L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Literal() { return getToken(CreateTableParser.Literal, 0); }
		public TerminalNode Integer() { return getToken(CreateTableParser.Integer, 0); }
		public TerminalNode Minus() { return getToken(CreateTableParser.Minus, 0); }
		public TerminalNode TRUE() { return getToken(CreateTableParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CreateTableParser.FALSE, 0); }
		public TerminalNode Number() { return getToken(CreateTableParser.Number, 0); }
		public TerminalNode NULL() { return getToken(CreateTableParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(CreateTableParser.NOT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constant);
		int _la;
		try {
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(Literal);
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(Integer);
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				match(Minus);
				setState(302);
				match(Integer);
				}
				break;
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 5);
				{
				setState(304);
				match(Number);
				}
				break;
			case NOT:
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(305);
					match(NOT);
					}
				}

				setState(308);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CurrentTimestampContext extends ParserRuleContext {
		public TerminalNode NOW() { return getToken(CreateTableParser.NOW, 0); }
		public TerminalNode LeftParenthesis() { return getToken(CreateTableParser.LeftParenthesis, 0); }
		public TerminalNode RightParenthesis() { return getToken(CreateTableParser.RightParenthesis, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(CreateTableParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode LOCALTIME() { return getToken(CreateTableParser.LOCALTIME, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(CreateTableParser.LOCALTIMESTAMP, 0); }
		public TerminalNode Integer() { return getToken(CreateTableParser.Integer, 0); }
		public CurrentTimestampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_currentTimestamp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterCurrentTimestamp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitCurrentTimestamp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitCurrentTimestamp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CurrentTimestampContext currentTimestamp() throws RecognitionException {
		CurrentTimestampContext _localctx = new CurrentTimestampContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_currentTimestamp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_TIMESTAMP:
			case LOCALTIMESTAMP:
			case LOCALTIME:
				{
				setState(311);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 412316925952L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(312);
					match(LeftParenthesis);
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Integer) {
						{
						setState(313);
						match(Integer);
						}
					}

					setState(316);
					match(RightParenthesis);
					}
				}

				}
				break;
			case NOW:
				{
				setState(319);
				match(NOW);
				setState(320);
				match(LeftParenthesis);
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Integer) {
					{
					setState(321);
					match(Integer);
					}
				}

				setState(324);
				match(RightParenthesis);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableConstraintContext extends ParserRuleContext {
		public Token name;
		public PrimaryKeyContext pk;
		public Token index;
		public Token indexFormat;
		public IndexColumnNamesContext indexColumnNames() {
			return getRuleContext(IndexColumnNamesContext.class,0);
		}
		public PrimaryKeyContext primaryKey() {
			return getRuleContext(PrimaryKeyContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(CreateTableParser.CONSTRAINT, 0); }
		public List<IndexOptionContext> indexOption() {
			return getRuleContexts(IndexOptionContext.class);
		}
		public IndexOptionContext indexOption(int i) {
			return getRuleContext(IndexOptionContext.class,i);
		}
		public TerminalNode BackQuotedString() { return getToken(CreateTableParser.BackQuotedString, 0); }
		public List<TerminalNode> RawString() { return getTokens(CreateTableParser.RawString); }
		public TerminalNode RawString(int i) {
			return getToken(CreateTableParser.RawString, i);
		}
		public List<TerminalNode> Literal() { return getTokens(CreateTableParser.Literal); }
		public TerminalNode Literal(int i) {
			return getToken(CreateTableParser.Literal, i);
		}
		public TerminalNode UNIQUE() { return getToken(CreateTableParser.UNIQUE, 0); }
		public IndexTypeContext indexType() {
			return getRuleContext(IndexTypeContext.class,0);
		}
		public TerminalNode INDEX() { return getToken(CreateTableParser.INDEX, 0); }
		public TerminalNode KEY() { return getToken(CreateTableParser.KEY, 0); }
		public TableConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterTableConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitTableConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitTableConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableConstraintContext tableConstraint() throws RecognitionException {
		TableConstraintContext _localctx = new TableConstraintContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_tableConstraint);
		int _la;
		try {
			setState(372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTRAINT) {
					{
					setState(327);
					match(CONSTRAINT);
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Literal || _la==RawString) {
						{
						setState(328);
						((TableConstraintContext)_localctx).name = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Literal || _la==RawString) ) {
							((TableConstraintContext)_localctx).name = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					}
				}

				setState(333);
				((TableConstraintContext)_localctx).pk = primaryKey();
				setState(335);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(334);
					((TableConstraintContext)_localctx).index = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==Literal || _la==RawString) ) {
						((TableConstraintContext)_localctx).index = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BackQuotedString || _la==RawString) {
					{
					setState(337);
					_la = _input.LA(1);
					if ( !(_la==BackQuotedString || _la==RawString) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(340);
				indexColumnNames();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT || _la==KEY_BLOCK_SIZE || _la==WITH) {
					{
					{
					setState(341);
					indexOption();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTRAINT) {
					{
					setState(347);
					match(CONSTRAINT);
					setState(349);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
					case 1:
						{
						setState(348);
						((TableConstraintContext)_localctx).name = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Literal || _la==RawString) ) {
							((TableConstraintContext)_localctx).name = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					}
				}

				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNIQUE) {
					{
					setState(353);
					match(UNIQUE);
					}
				}

				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INDEX || _la==KEY) {
					{
					setState(356);
					((TableConstraintContext)_localctx).indexFormat = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==INDEX || _la==KEY) ) {
						((TableConstraintContext)_localctx).indexFormat = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BackQuotedString || _la==RawString) {
					{
					setState(359);
					((TableConstraintContext)_localctx).index = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==BackQuotedString || _la==RawString) ) {
						((TableConstraintContext)_localctx).index = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(362);
					indexType();
					}
				}

				setState(365);
				indexColumnNames();
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT || _la==KEY_BLOCK_SIZE || _la==WITH) {
					{
					{
					setState(366);
					indexOption();
					}
					}
					setState(371);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexOptionContext extends ParserRuleContext {
		public TerminalNode KEY_BLOCK_SIZE() { return getToken(CreateTableParser.KEY_BLOCK_SIZE, 0); }
		public TerminalNode FilesizeLiteral() { return getToken(CreateTableParser.FilesizeLiteral, 0); }
		public TerminalNode Equal() { return getToken(CreateTableParser.Equal, 0); }
		public TerminalNode WITH() { return getToken(CreateTableParser.WITH, 0); }
		public TerminalNode PARSER() { return getToken(CreateTableParser.PARSER, 0); }
		public TerminalNode Literal() { return getToken(CreateTableParser.Literal, 0); }
		public TerminalNode RawString() { return getToken(CreateTableParser.RawString, 0); }
		public TerminalNode COMMENT() { return getToken(CreateTableParser.COMMENT, 0); }
		public IndexOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterIndexOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitIndexOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitIndexOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexOptionContext indexOption() throws RecognitionException {
		IndexOptionContext _localctx = new IndexOptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_indexOption);
		int _la;
		try {
			setState(384);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_BLOCK_SIZE:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				match(KEY_BLOCK_SIZE);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(375);
					match(Equal);
					}
				}

				setState(378);
				match(FilesizeLiteral);
				}
				break;
			case WITH:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(WITH);
				setState(380);
				match(PARSER);
				setState(381);
				_la = _input.LA(1);
				if ( !(_la==Literal || _la==RawString) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(382);
				match(COMMENT);
				setState(383);
				match(Literal);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexTypeContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(CreateTableParser.USING, 0); }
		public TerminalNode BTREE() { return getToken(CreateTableParser.BTREE, 0); }
		public TerminalNode HASH() { return getToken(CreateTableParser.HASH, 0); }
		public IndexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterIndexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitIndexType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitIndexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexTypeContext indexType() throws RecognitionException {
		IndexTypeContext _localctx = new IndexTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_indexType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(USING);
			setState(387);
			_la = _input.LA(1);
			if ( !(_la==BTREE || _la==HASH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexColumnNamesContext extends ParserRuleContext {
		public List<TerminalNode> LeftParenthesis() { return getTokens(CreateTableParser.LeftParenthesis); }
		public TerminalNode LeftParenthesis(int i) {
			return getToken(CreateTableParser.LeftParenthesis, i);
		}
		public List<TerminalNode> RightParenthesis() { return getTokens(CreateTableParser.RightParenthesis); }
		public TerminalNode RightParenthesis(int i) {
			return getToken(CreateTableParser.RightParenthesis, i);
		}
		public List<TerminalNode> BackQuotedString() { return getTokens(CreateTableParser.BackQuotedString); }
		public TerminalNode BackQuotedString(int i) {
			return getToken(CreateTableParser.BackQuotedString, i);
		}
		public List<TerminalNode> RawString() { return getTokens(CreateTableParser.RawString); }
		public TerminalNode RawString(int i) {
			return getToken(CreateTableParser.RawString, i);
		}
		public List<TerminalNode> Integer() { return getTokens(CreateTableParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(CreateTableParser.Integer, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CreateTableParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CreateTableParser.Comma, i);
		}
		public IndexColumnNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexColumnNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterIndexColumnNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitIndexColumnNames(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitIndexColumnNames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexColumnNamesContext indexColumnNames() throws RecognitionException {
		IndexColumnNamesContext _localctx = new IndexColumnNamesContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_indexColumnNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(LeftParenthesis);
			setState(390);
			_la = _input.LA(1);
			if ( !(_la==BackQuotedString || _la==RawString) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParenthesis) {
				{
				setState(391);
				match(LeftParenthesis);
				setState(392);
				match(Integer);
				setState(393);
				match(RightParenthesis);
				}
			}

			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(396);
				match(Comma);
				setState(397);
				_la = _input.LA(1);
				if ( !(_la==BackQuotedString || _la==RawString) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParenthesis) {
					{
					setState(398);
					match(LeftParenthesis);
					setState(399);
					match(Integer);
					setState(400);
					match(RightParenthesis);
					}
				}

				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(408);
			match(RightParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableOptionContext extends ParserRuleContext {
		public Token tableComment;
		public TerminalNode ENGINE() { return getToken(CreateTableParser.ENGINE, 0); }
		public TerminalNode BackQuotedString() { return getToken(CreateTableParser.BackQuotedString, 0); }
		public TerminalNode RawString() { return getToken(CreateTableParser.RawString, 0); }
		public TerminalNode Equal() { return getToken(CreateTableParser.Equal, 0); }
		public TerminalNode AUTO_INCREMENT() { return getToken(CreateTableParser.AUTO_INCREMENT, 0); }
		public TerminalNode Integer() { return getToken(CreateTableParser.Integer, 0); }
		public TerminalNode CHARACTER() { return getToken(CreateTableParser.CHARACTER, 0); }
		public TerminalNode SET() { return getToken(CreateTableParser.SET, 0); }
		public TerminalNode CHARSET() { return getToken(CreateTableParser.CHARSET, 0); }
		public TerminalNode DEFAULT() { return getToken(CreateTableParser.DEFAULT, 0); }
		public TerminalNode COLLATE() { return getToken(CreateTableParser.COLLATE, 0); }
		public TerminalNode COMMENT() { return getToken(CreateTableParser.COMMENT, 0); }
		public TerminalNode Literal() { return getToken(CreateTableParser.Literal, 0); }
		public TableOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).enterTableOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableParserListener ) ((CreateTableParserListener)listener).exitTableOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableParserVisitor ) return ((CreateTableParserVisitor<? extends T>)visitor).visitTableOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableOptionContext tableOption() throws RecognitionException {
		TableOptionContext _localctx = new TableOptionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tableOption);
		int _la;
		try {
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(ENGINE);
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(411);
					match(Equal);
					}
				}

				setState(414);
				_la = _input.LA(1);
				if ( !(_la==BackQuotedString || _la==RawString) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				match(AUTO_INCREMENT);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(416);
					match(Equal);
					}
				}

				setState(419);
				match(Integer);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEFAULT) {
					{
					setState(420);
					match(DEFAULT);
					}
				}

				setState(426);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CHARACTER:
					{
					setState(423);
					match(CHARACTER);
					setState(424);
					match(SET);
					}
					break;
				case CHARSET:
					{
					setState(425);
					match(CHARSET);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(428);
					match(Equal);
					}
				}

				setState(431);
				_la = _input.LA(1);
				if ( !(_la==BackQuotedString || _la==RawString) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEFAULT) {
					{
					setState(432);
					match(DEFAULT);
					}
				}

				setState(435);
				match(COLLATE);
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(436);
					match(Equal);
					}
				}

				setState(439);
				_la = _input.LA(1);
				if ( !(_la==BackQuotedString || _la==RawString) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(440);
				match(COMMENT);
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Equal) {
					{
					setState(441);
					match(Equal);
					}
				}

				setState(444);
				((TableOptionContext)_localctx).tableComment = match(Literal);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001b\u01c0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00006\b\u0000\n\u0000\f\u0000"+
		"9\t\u0000\u0001\u0000\u0003\u0000<\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0003\u0001B\b\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001F\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001L\b\u0001\u0001\u0001\u0005\u0001O\b\u0001\n\u0001\f\u0001R\t\u0001"+
		"\u0003\u0001T\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004`\b\u0004\n\u0004\f\u0004c\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005j\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0005\u0006n\b\u0006\n\u0006\f\u0006q\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0003\u0007u\b\u0007\u0001\u0007\u0003\u0007x\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001\u0007\u0003"+
		"\u0007\u0080\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0084\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0089\b\u0007\u0001\u0007"+
		"\u0003\u0007\u008c\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0091\b\u0007\u0001\u0007\u0003\u0007\u0094\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u009a\b\u0007\u0001\u0007\u0003"+
		"\u0007\u009d\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a1\b\u0007"+
		"\u0001\u0007\u0003\u0007\u00a4\b\u0007\u0001\u0007\u0003\u0007\u00a7\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ab\b\u0007\u0001\u0007\u0003"+
		"\u0007\u00ae\b\u0007\u0001\u0007\u0003\u0007\u00b1\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00b5\b\u0007\u0001\u0007\u0003\u0007\u00b8\b"+
		"\u0007\u0001\u0007\u0003\u0007\u00bb\b\u0007\u0001\u0007\u0003\u0007\u00be"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c2\b\u0007\u0001\u0007"+
		"\u0003\u0007\u00c5\b\u0007\u0001\u0007\u0003\u0007\u00c8\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00cd\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00d2\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00d7\b\u0007\u0001\u0007\u0003\u0007\u00da\b\u0007"+
		"\u0003\u0007\u00dc\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00ec\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00f4\b\u000b\n\u000b\f\u000b\u00f7\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0102\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0108\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0110\b\f\u0001\r\u0003"+
		"\r\u0113\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u011c\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0123\b\u000f\u0003\u000f\u0125"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u0133\b\u0012\u0001\u0012\u0003\u0012\u0136\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u013b\b\u0013\u0001\u0013"+
		"\u0003\u0013\u013e\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0143\b\u0013\u0001\u0013\u0003\u0013\u0146\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u014a\b\u0014\u0003\u0014\u014c\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u0150\b\u0014\u0001\u0014\u0003\u0014\u0153\b"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0157\b\u0014\n\u0014\f\u0014"+
		"\u015a\t\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u015e\b\u0014\u0003"+
		"\u0014\u0160\b\u0014\u0001\u0014\u0003\u0014\u0163\b\u0014\u0001\u0014"+
		"\u0003\u0014\u0166\b\u0014\u0001\u0014\u0003\u0014\u0169\b\u0014\u0001"+
		"\u0014\u0003\u0014\u016c\b\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0170"+
		"\b\u0014\n\u0014\f\u0014\u0173\t\u0014\u0003\u0014\u0175\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0179\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0181\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u018b\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0192\b\u0017\u0005\u0017\u0194"+
		"\b\u0017\n\u0017\f\u0017\u0197\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u019d\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u01a2\b\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01a6\b"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01ab\b\u0018\u0001"+
		"\u0018\u0003\u0018\u01ae\b\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01b2"+
		"\b\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01b6\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u01bb\b\u0018\u0001\u0018\u0003\u0018"+
		"\u01be\b\u0018\u0001\u0018\u0000\u0000\u0019\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000"+
		"\u0011\u0001\u0000^_\b\u0000\u000b\u000b((++--22>>CCKK\u0002\u0000\u0003"+
		"\u0003^_\u0002\u0000\t\tKK\u0002\u0000\t\t\u000b\u000b\u0005\u0000\u0002"+
		"\u0002 !**;;BB\u0002\u0000::FF\u0003\u0000\u0013\u0014\u001b\u001c11\b"+
		"\u0000\u0005\u0005\u0007\b\u0012\u0012\"\"\'\'))88AA\u0005\u0000\u0003"+
		"\u0004\u0011\u0011?@JJNN\u0002\u0000\u0018\u001899\u0002\u0000..UX\u0002"+
		"\u0000\u001a\u001aDD\u0002\u0000\u0010\u0010%&\u0002\u0000\\\\__\u0002"+
		"\u0000\u001e\u001e$$\u0002\u0000\u0006\u0006\u001d\u001d\u0210\u00002"+
		"\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0004U\u0001\u0000"+
		"\u0000\u0000\u0006W\u0001\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000"+
		"\ni\u0001\u0000\u0000\u0000\fk\u0001\u0000\u0000\u0000\u000e\u00db\u0001"+
		"\u0000\u0000\u0000\u0010\u00dd\u0001\u0000\u0000\u0000\u0012\u00e1\u0001"+
		"\u0000\u0000\u0000\u0014\u00e7\u0001\u0000\u0000\u0000\u0016\u00ef\u0001"+
		"\u0000\u0000\u0000\u0018\u010f\u0001\u0000\u0000\u0000\u001a\u0112\u0001"+
		"\u0000\u0000\u0000\u001c\u0116\u0001\u0000\u0000\u0000\u001e\u0124\u0001"+
		"\u0000\u0000\u0000 \u0126\u0001\u0000\u0000\u0000\"\u0129\u0001\u0000"+
		"\u0000\u0000$\u0135\u0001\u0000\u0000\u0000&\u0145\u0001\u0000\u0000\u0000"+
		"(\u0174\u0001\u0000\u0000\u0000*\u0180\u0001\u0000\u0000\u0000,\u0182"+
		"\u0001\u0000\u0000\u0000.\u0185\u0001\u0000\u0000\u00000\u01bd\u0001\u0000"+
		"\u0000\u000027\u0003\u0002\u0001\u000034\u0005Q\u0000\u000046\u0003\u0002"+
		"\u0001\u000053\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u0000"+
		"97\u0001\u0000\u0000\u0000:<\u0005Q\u0000\u0000;:\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0005\u0000\u0000"+
		"\u0001>\u0001\u0001\u0000\u0000\u0000?A\u0005\u000f\u0000\u0000@B\u0005"+
		"=\u0000\u0000A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001"+
		"\u0000\u0000\u0000CE\u0005<\u0000\u0000DF\u0003\u0006\u0003\u0000ED\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GH\u0003\u0004\u0002\u0000HS\u0003\b\u0004\u0000IP\u00030\u0018\u0000"+
		"JL\u0005R\u0000\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MO\u00030\u0018\u0000NK\u0001\u0000\u0000\u0000"+
		"OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000SI\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0003\u0001\u0000\u0000\u0000"+
		"UV\u0007\u0000\u0000\u0000V\u0005\u0001\u0000\u0000\u0000WX\u0005\u001f"+
		"\u0000\u0000XY\u0005.\u0000\u0000YZ\u0005\u0019\u0000\u0000Z\u0007\u0001"+
		"\u0000\u0000\u0000[\\\u0005S\u0000\u0000\\a\u0003\n\u0005\u0000]^\u0005"+
		"R\u0000\u0000^`\u0003\n\u0005\u0000_]\u0001\u0000\u0000\u0000`c\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005T\u0000\u0000"+
		"e\t\u0001\u0000\u0000\u0000fg\u0007\u0000\u0000\u0000gj\u0003\f\u0006"+
		"\u0000hj\u0003(\u0014\u0000if\u0001\u0000\u0000\u0000ih\u0001\u0000\u0000"+
		"\u0000j\u000b\u0001\u0000\u0000\u0000ko\u0003\u000e\u0007\u0000ln\u0003"+
		"\u0018\f\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\r\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000rt\u0007\u0001\u0000\u0000su\u0003\u0010\b\u0000"+
		"ts\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000"+
		"\u0000vx\u0005\u0003\u0000\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000x\u007f\u0001\u0000\u0000\u0000yz\u0005\t\u0000\u0000z}\u0005"+
		"9\u0000\u0000{}\u0005\n\u0000\u0000|y\u0001\u0000\u0000\u0000|{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0007\u0002\u0000"+
		"\u0000\u007f|\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u0082\u0005\f\u0000\u0000\u0082"+
		"\u0084\u0007\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u00dc\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005,\u0000\u0000\u0086\u0088\u0007\u0003\u0000\u0000\u0087\u0089"+
		"\u0003\u0010\b\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u008c\u0005"+
		"\u0003\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u00dc\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"-\u0000\u0000\u008e\u0090\u0005K\u0000\u0000\u008f\u0091\u0003\u0010\b"+
		"\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0003\u0000"+
		"\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u00dc\u0001\u0000\u0000\u0000\u0095\u0096\u0005,\u0000\u0000"+
		"\u0096\u0097\u0007\u0004\u0000\u0000\u0097\u0099\u0005L\u0000\u0000\u0098"+
		"\u009a\u0003\u0010\b\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u009d"+
		"\u0005\u0003\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d\u00dc\u0001\u0000\u0000\u0000\u009e\u00a0"+
		"\u0007\u0005\u0000\u0000\u009f\u00a1\u0003\u0010\b\u0000\u00a0\u009f\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0007\u0006\u0000\u0000\u00a3\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a7\u0005O\u0000\u0000\u00a6\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00dc\u0001\u0000"+
		"\u0000\u0000\u00a8\u00aa\u00057\u0000\u0000\u00a9\u00ab\u0003\u0012\t"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00ae\u0007\u0006\u0000"+
		"\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00b1\u0005O\u0000\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00dc\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005\u0016\u0000\u0000"+
		"\u00b3\u00b5\u00055\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b8\u0003\u0012\t\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00bb"+
		"\u0007\u0006\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00be"+
		"\u0005O\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u00dc\u0001\u0000\u0000\u0000\u00bf\u00c1\u0007"+
		"\u0007\u0000\u0000\u00c0\u00c2\u0003\u0014\n\u0000\u00c1\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c5\u0007\u0006\u0000\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c8\u0005O\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00dc\u0001\u0000\u0000"+
		"\u0000\u00c9\u00dc\u0007\b\u0000\u0000\u00ca\u00cc\u0007\t\u0000\u0000"+
		"\u00cb\u00cd\u0003\u0010\b\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cd\u00dc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0007\n\u0000\u0000\u00cf\u00d1\u0003\u0016\u000b\u0000\u00d0\u00d2"+
		"\u0005\u0003\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d9\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0005\t\u0000\u0000\u00d4\u00d7\u00059\u0000\u0000\u00d5\u00d7\u0005"+
		"\n\u0000\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00da\u0007\u0002"+
		"\u0000\u0000\u00d9\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00dbr\u0001\u0000\u0000"+
		"\u0000\u00db\u0085\u0001\u0000\u0000\u0000\u00db\u008d\u0001\u0000\u0000"+
		"\u0000\u00db\u0095\u0001\u0000\u0000\u0000\u00db\u009e\u0001\u0000\u0000"+
		"\u0000\u00db\u00a8\u0001\u0000\u0000\u0000\u00db\u00b2\u0001\u0000\u0000"+
		"\u0000\u00db\u00bf\u0001\u0000\u0000\u0000\u00db\u00c9\u0001\u0000\u0000"+
		"\u0000\u00db\u00ca\u0001\u0000\u0000\u0000\u00db\u00ce\u0001\u0000\u0000"+
		"\u0000\u00dc\u000f\u0001\u0000\u0000\u0000\u00dd\u00de\u0005S\u0000\u0000"+
		"\u00de\u00df\u0005Y\u0000\u0000\u00df\u00e0\u0005T\u0000\u0000\u00e0\u0011"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005S\u0000\u0000\u00e2\u00e3\u0005"+
		"Y\u0000\u0000\u00e3\u00e4\u0005R\u0000\u0000\u00e4\u00e5\u0005Y\u0000"+
		"\u0000\u00e5\u00e6\u0005T\u0000\u0000\u00e6\u0013\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\u0005S\u0000\u0000\u00e8\u00eb\u0005Y\u0000\u0000\u00e9\u00ea"+
		"\u0005R\u0000\u0000\u00ea\u00ec\u0005Y\u0000\u0000\u00eb\u00e9\u0001\u0000"+
		"\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0005T\u0000\u0000\u00ee\u0015\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0005S\u0000\u0000\u00f0\u00f5\u0005\\\u0000\u0000"+
		"\u00f1\u00f2\u0005R\u0000\u0000\u00f2\u00f4\u0005\\\u0000\u0000\u00f3"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0005T\u0000\u0000\u00f9\u0017\u0001\u0000\u0000\u0000\u00fa\u0110"+
		"\u0003\u001a\r\u0000\u00fb\u00fc\u0005\u0015\u0000\u0000\u00fc\u0110\u0003"+
		"\u001e\u000f\u0000\u00fd\u0102\u0005\u0001\u0000\u0000\u00fe\u00ff\u0005"+
		"3\u0000\u0000\u00ff\u0100\u0005G\u0000\u0000\u0100\u0102\u0003&\u0013"+
		"\u0000\u0101\u00fd\u0001\u0000\u0000\u0000\u0101\u00fe\u0001\u0000\u0000"+
		"\u0000\u0102\u0110\u0001\u0000\u0000\u0000\u0103\u0110\u0003 \u0010\u0000"+
		"\u0104\u0110\u0005$\u0000\u0000\u0105\u0107\u0005E\u0000\u0000\u0106\u0108"+
		"\u0005$\u0000\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0107\u0108\u0001"+
		"\u0000\u0000\u0000\u0108\u0110\u0001\u0000\u0000\u0000\u0109\u0110\u0003"+
		"\u001c\u000e\u0000\u010a\u010b\u0005\f\u0000\u0000\u010b\u0110\u0005^"+
		"\u0000\u0000\u010c\u010d\u00058\u0000\u0000\u010d\u010e\u0005\u0015\u0000"+
		"\u0000\u010e\u0110\u0005I\u0000\u0000\u010f\u00fa\u0001\u0000\u0000\u0000"+
		"\u010f\u00fb\u0001\u0000\u0000\u0000\u010f\u0101\u0001\u0000\u0000\u0000"+
		"\u010f\u0103\u0001\u0000\u0000\u0000\u010f\u0104\u0001\u0000\u0000\u0000"+
		"\u010f\u0105\u0001\u0000\u0000\u0000\u010f\u0109\u0001\u0000\u0000\u0000"+
		"\u010f\u010a\u0001\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000"+
		"\u0110\u0019\u0001\u0000\u0000\u0000\u0111\u0113\u0005.\u0000\u0000\u0112"+
		"\u0111\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113"+
		"\u0114\u0001\u0000\u0000\u0000\u0114\u0115\u00050\u0000\u0000\u0115\u001b"+
		"\u0001\u0000\u0000\u0000\u0116\u0117\u0005\r\u0000\u0000\u0117\u0118\u0005"+
		"\\\u0000\u0000\u0118\u001d\u0001\u0000\u0000\u0000\u0119\u0125\u00050"+
		"\u0000\u0000\u011a\u011c\u0003\"\u0011\u0000\u011b\u011a\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000"+
		"\u0000\u011d\u0125\u0003$\u0012\u0000\u011e\u0122\u0003&\u0013\u0000\u011f"+
		"\u0120\u00053\u0000\u0000\u0120\u0121\u0005G\u0000\u0000\u0121\u0123\u0003"+
		"&\u0013\u0000\u0122\u011f\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000"+
		"\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u0119\u0001\u0000"+
		"\u0000\u0000\u0124\u011b\u0001\u0000\u0000\u0000\u0124\u011e\u0001\u0000"+
		"\u0000\u0000\u0125\u001f\u0001\u0000\u0000\u0000\u0126\u0127\u00056\u0000"+
		"\u0000\u0127\u0128\u0005$\u0000\u0000\u0128!\u0001\u0000\u0000\u0000\u0129"+
		"\u012a\u0007\u000b\u0000\u0000\u012a#\u0001\u0000\u0000\u0000\u012b\u0136"+
		"\u0005\\\u0000\u0000\u012c\u0136\u0005Y\u0000\u0000\u012d\u012e\u0005"+
		"X\u0000\u0000\u012e\u0136\u0005Y\u0000\u0000\u012f\u0136\u0007\f\u0000"+
		"\u0000\u0130\u0136\u0005Z\u0000\u0000\u0131\u0133\u0005.\u0000\u0000\u0132"+
		"\u0131\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u00050\u0000\u0000\u0135\u012b"+
		"\u0001\u0000\u0000\u0000\u0135\u012c\u0001\u0000\u0000\u0000\u0135\u012d"+
		"\u0001\u0000\u0000\u0000\u0135\u012f\u0001\u0000\u0000\u0000\u0135\u0130"+
		"\u0001\u0000\u0000\u0000\u0135\u0132\u0001\u0000\u0000\u0000\u0136%\u0001"+
		"\u0000\u0000\u0000\u0137\u013d\u0007\r\u0000\u0000\u0138\u013a\u0005S"+
		"\u0000\u0000\u0139\u013b\u0005Y\u0000\u0000\u013a\u0139\u0001\u0000\u0000"+
		"\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000"+
		"\u0000\u013c\u013e\u0005T\u0000\u0000\u013d\u0138\u0001\u0000\u0000\u0000"+
		"\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0146\u0001\u0000\u0000\u0000"+
		"\u013f\u0140\u0005/\u0000\u0000\u0140\u0142\u0005S\u0000\u0000\u0141\u0143"+
		"\u0005Y\u0000\u0000\u0142\u0141\u0001\u0000\u0000\u0000\u0142\u0143\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0146\u0005"+
		"T\u0000\u0000\u0145\u0137\u0001\u0000\u0000\u0000\u0145\u013f\u0001\u0000"+
		"\u0000\u0000\u0146\'\u0001\u0000\u0000\u0000\u0147\u0149\u0005\u000e\u0000"+
		"\u0000\u0148\u014a\u0007\u000e\u0000\u0000\u0149\u0148\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014c\u0001\u0000\u0000"+
		"\u0000\u014b\u0147\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014f\u0003 \u0010\u0000"+
		"\u014e\u0150\u0007\u000e\u0000\u0000\u014f\u014e\u0001\u0000\u0000\u0000"+
		"\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000"+
		"\u0151\u0153\u0007\u0000\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000"+
		"\u0154\u0158\u0003.\u0017\u0000\u0155\u0157\u0003*\u0015\u0000\u0156\u0155"+
		"\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u0175"+
		"\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b\u015d"+
		"\u0005\u000e\u0000\u0000\u015c\u015e\u0007\u000e\u0000\u0000\u015d\u015c"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u0160"+
		"\u0001\u0000\u0000\u0000\u015f\u015b\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000\u0000\u0000\u0161\u0163"+
		"\u0005E\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0162\u0163\u0001"+
		"\u0000\u0000\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u0166\u0007"+
		"\u000f\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0165\u0166\u0001"+
		"\u0000\u0000\u0000\u0166\u0168\u0001\u0000\u0000\u0000\u0167\u0169\u0007"+
		"\u0000\u0000\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0168\u0169\u0001"+
		"\u0000\u0000\u0000\u0169\u016b\u0001\u0000\u0000\u0000\u016a\u016c\u0003"+
		",\u0016\u0000\u016b\u016a\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u0171\u0003.\u0017"+
		"\u0000\u016e\u0170\u0003*\u0015\u0000\u016f\u016e\u0001\u0000\u0000\u0000"+
		"\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000\u0000"+
		"\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0175\u0001\u0000\u0000\u0000"+
		"\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u014b\u0001\u0000\u0000\u0000"+
		"\u0174\u015f\u0001\u0000\u0000\u0000\u0175)\u0001\u0000\u0000\u0000\u0176"+
		"\u0178\u0005#\u0000\u0000\u0177\u0179\u0005P\u0000\u0000\u0178\u0177\u0001"+
		"\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017a\u0001"+
		"\u0000\u0000\u0000\u017a\u0181\u0005[\u0000\u0000\u017b\u017c\u0005M\u0000"+
		"\u0000\u017c\u017d\u00054\u0000\u0000\u017d\u0181\u0007\u000e\u0000\u0000"+
		"\u017e\u017f\u0005\r\u0000\u0000\u017f\u0181\u0005\\\u0000\u0000\u0180"+
		"\u0176\u0001\u0000\u0000\u0000\u0180\u017b\u0001\u0000\u0000\u0000\u0180"+
		"\u017e\u0001\u0000\u0000\u0000\u0181+\u0001\u0000\u0000\u0000\u0182\u0183"+
		"\u0005H\u0000\u0000\u0183\u0184\u0007\u0010\u0000\u0000\u0184-\u0001\u0000"+
		"\u0000\u0000\u0185\u0186\u0005S\u0000\u0000\u0186\u018a\u0007\u0000\u0000"+
		"\u0000\u0187\u0188\u0005S\u0000\u0000\u0188\u0189\u0005Y\u0000\u0000\u0189"+
		"\u018b\u0005T\u0000\u0000\u018a\u0187\u0001\u0000\u0000\u0000\u018a\u018b"+
		"\u0001\u0000\u0000\u0000\u018b\u0195\u0001\u0000\u0000\u0000\u018c\u018d"+
		"\u0005R\u0000\u0000\u018d\u0191\u0007\u0000\u0000\u0000\u018e\u018f\u0005"+
		"S\u0000\u0000\u018f\u0190\u0005Y\u0000\u0000\u0190\u0192\u0005T\u0000"+
		"\u0000\u0191\u018e\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000"+
		"\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193\u018c\u0001\u0000\u0000"+
		"\u0000\u0194\u0197\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000"+
		"\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0198\u0001\u0000\u0000"+
		"\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0198\u0199\u0005T\u0000\u0000"+
		"\u0199/\u0001\u0000\u0000\u0000\u019a\u019c\u0005\u0017\u0000\u0000\u019b"+
		"\u019d\u0005P\u0000\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019c\u019d"+
		"\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01be"+
		"\u0007\u0000\u0000\u0000\u019f\u01a1\u0005\u0001\u0000\u0000\u01a0\u01a2"+
		"\u0005P\u0000\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01be\u0005"+
		"Y\u0000\u0000\u01a4\u01a6\u0005\u0015\u0000\u0000\u01a5\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01aa\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a8\u0005\t\u0000\u0000\u01a8\u01ab\u00059\u0000"+
		"\u0000\u01a9\u01ab\u0005\n\u0000\u0000\u01aa\u01a7\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a9\u0001\u0000\u0000\u0000\u01ab\u01ad\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ae\u0005P\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ad"+
		"\u01ae\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af"+
		"\u01be\u0007\u0000\u0000\u0000\u01b0\u01b2\u0005\u0015\u0000\u0000\u01b1"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b5\u0005\f\u0000\u0000\u01b4\u01b6"+
		"\u0005P\u0000\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7\u01be\u0007"+
		"\u0000\u0000\u0000\u01b8\u01ba\u0005\r\u0000\u0000\u01b9\u01bb\u0005P"+
		"\u0000\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000"+
		"\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01be\u0005\\\u0000"+
		"\u0000\u01bd\u019a\u0001\u0000\u0000\u0000\u01bd\u019f\u0001\u0000\u0000"+
		"\u0000\u01bd\u01a5\u0001\u0000\u0000\u0000\u01bd\u01b1\u0001\u0000\u0000"+
		"\u0000\u01bd\u01b8\u0001\u0000\u0000\u0000\u01be1\u0001\u0000\u0000\u0000"+
		"Q7;AEKPSaiotw|\u007f\u0083\u0088\u008b\u0090\u0093\u0099\u009c\u00a0\u00a3"+
		"\u00a6\u00aa\u00ad\u00b0\u00b4\u00b7\u00ba\u00bd\u00c1\u00c4\u00c7\u00cc"+
		"\u00d1\u00d6\u00d9\u00db\u00eb\u00f5\u0101\u0107\u010f\u0112\u011b\u0122"+
		"\u0124\u0132\u0135\u013a\u013d\u0142\u0145\u0149\u014b\u014f\u0152\u0158"+
		"\u015d\u015f\u0162\u0165\u0168\u016b\u0171\u0174\u0178\u0180\u018a\u0191"+
		"\u0195\u019c\u01a1\u01a5\u01aa\u01ad\u01b1\u01b5\u01ba\u01bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
