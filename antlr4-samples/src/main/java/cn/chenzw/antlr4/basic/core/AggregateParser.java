// Generated from C:/Users/chenzw/IdeaProjects/java-dependence-samples/anltr4-samples/src/main/java/cn/chenzw/anltr4/basic\AggregateParser.g4 by ANTLR 4.9.1
package cn.chenzw.antlr4.basic.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AggregateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SPACE=1, SPEC_ESSQL_COMMENT=2, COMMENT_INPUT=3, LINE_COMMENT=4, MINUS=5,
		STAR=6, COLON=7, EQ=8, NE=9, BOOLOR=10, BOOLAND=11, DOT=12, LBRACKET=13,
		RBRACKET=14, LPAREN=15, RPAREN=16, COMMA=17, SEMI=18, GT=19, AFTER=20,
		SINGLE_QUOTE=21, DOUBLE_QUOTE=22, REVERSE_QUOTE=23, UNDERLINE=24, CHINESE=25,
		ID=26, INT=27, FLOAT=28, DOTINTEGER=29, DOTID=30;
	public static final int
		RULE_expr = 0, RULE_aggClause = 1, RULE_cardinalityAggClause = 2, RULE_termsAfterAggClause = 3,
		RULE_termsAggClause = 4, RULE_geoBoundingBoxAggClause = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "aggClause", "cardinalityAggClause", "termsAfterAggClause", "termsAggClause",
			"geoBoundingBoxAggClause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'-'", "'*'", null, "'='", "'!='", null,
			null, "'.'", "'['", "']'", "'('", "')'", null, "';'", "'>'", null, "'''",
			"'\"'", "'`'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SPACE", "SPEC_ESSQL_COMMENT", "COMMENT_INPUT", "LINE_COMMENT",
			"MINUS", "STAR", "COLON", "EQ", "NE", "BOOLOR", "BOOLAND", "DOT", "LBRACKET",
			"RBRACKET", "LPAREN", "RPAREN", "COMMA", "SEMI", "GT", "AFTER", "SINGLE_QUOTE",
			"DOUBLE_QUOTE", "REVERSE_QUOTE", "UNDERLINE", "CHINESE", "ID", "INT",
			"FLOAT", "DOTINTEGER", "DOTID"
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
	public String getGrammarFileName() { return "AggregateParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AggregateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public List<AggClauseContext> aggClause() {
			return getRuleContexts(AggClauseContext.class);
		}
		public AggClauseContext aggClause(int i) {
			return getRuleContext(AggClauseContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(AggregateParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(AggregateParser.SEMI, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AggregateParserVisitor ) return ((AggregateParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			aggClause();
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(13);
				match(SEMI);
				setState(14);
				aggClause();
				}
				}
				setState(19);
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

	public static class AggClauseContext extends ParserRuleContext {
		public CardinalityAggClauseContext cardinalityAggClause() {
			return getRuleContext(CardinalityAggClauseContext.class,0);
		}
		public TermsAggClauseContext termsAggClause() {
			return getRuleContext(TermsAggClauseContext.class,0);
		}
		public TermsAfterAggClauseContext termsAfterAggClause() {
			return getRuleContext(TermsAfterAggClauseContext.class,0);
		}
		public GeoBoundingBoxAggClauseContext geoBoundingBoxAggClause() {
			return getRuleContext(GeoBoundingBoxAggClauseContext.class,0);
		}
		public AggClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).enterAggClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).exitAggClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AggregateParserVisitor ) return ((AggregateParserVisitor<? extends T>)visitor).visitAggClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggClauseContext aggClause() throws RecognitionException {
		AggClauseContext _localctx = new AggClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aggClause);
		try {
			setState(24);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				cardinalityAggClause();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				termsAggClause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				termsAfterAggClause();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(23);
				geoBoundingBoxAggClause();
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

	public static class CardinalityAggClauseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(AggregateParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(AggregateParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(AggregateParser.RPAREN, 0); }
		public CardinalityAggClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinalityAggClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).enterCardinalityAggClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).exitCardinalityAggClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AggregateParserVisitor ) return ((AggregateParserVisitor<? extends T>)visitor).visitCardinalityAggClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityAggClauseContext cardinalityAggClause() throws RecognitionException {
		CardinalityAggClauseContext _localctx = new CardinalityAggClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cardinalityAggClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(LPAREN);
			setState(27);
			match(ID);
			setState(28);
			match(RPAREN);
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

	public static class TermsAfterAggClauseContext extends ParserRuleContext {
		public Token field;
		public Token after;
		public TerminalNode AFTER() { return getToken(AggregateParser.AFTER, 0); }
		public List<TerminalNode> ID() { return getTokens(AggregateParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AggregateParser.ID, i);
		}
		public TermsAfterAggClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termsAfterAggClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).enterTermsAfterAggClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).exitTermsAfterAggClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AggregateParserVisitor ) return ((AggregateParserVisitor<? extends T>)visitor).visitTermsAfterAggClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsAfterAggClauseContext termsAfterAggClause() throws RecognitionException {
		TermsAfterAggClauseContext _localctx = new TermsAfterAggClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_termsAfterAggClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((TermsAfterAggClauseContext)_localctx).field = match(ID);
			setState(31);
			match(AFTER);
			setState(32);
			((TermsAfterAggClauseContext)_localctx).after = match(ID);
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

	public static class TermsAggClauseContext extends ParserRuleContext {
		public Token field;
		public TerminalNode ID() { return getToken(AggregateParser.ID, 0); }
		public TerminalNode GT() { return getToken(AggregateParser.GT, 0); }
		public TermsAggClauseContext termsAggClause() {
			return getRuleContext(TermsAggClauseContext.class,0);
		}
		public TermsAggClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termsAggClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).enterTermsAggClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).exitTermsAggClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AggregateParserVisitor ) return ((AggregateParserVisitor<? extends T>)visitor).visitTermsAggClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsAggClauseContext termsAggClause() throws RecognitionException {
		TermsAggClauseContext _localctx = new TermsAggClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_termsAggClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			((TermsAggClauseContext)_localctx).field = match(ID);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GT) {
				{
				setState(35);
				match(GT);
				setState(36);
				termsAggClause();
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

	public static class GeoBoundingBoxAggClauseContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(AggregateParser.LBRACKET, 0); }
		public TerminalNode ID() { return getToken(AggregateParser.ID, 0); }
		public TerminalNode RBRACKET() { return getToken(AggregateParser.RBRACKET, 0); }
		public GeoBoundingBoxAggClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_geoBoundingBoxAggClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).enterGeoBoundingBoxAggClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AggregateParserListener ) ((AggregateParserListener)listener).exitGeoBoundingBoxAggClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AggregateParserVisitor ) return ((AggregateParserVisitor<? extends T>)visitor).visitGeoBoundingBoxAggClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeoBoundingBoxAggClauseContext geoBoundingBoxAggClause() throws RecognitionException {
		GeoBoundingBoxAggClauseContext _localctx = new GeoBoundingBoxAggClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_geoBoundingBoxAggClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(LBRACKET);
			setState(40);
			match(ID);
			setState(41);
			match(RBRACKET);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 .\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25\13"+
		"\2\3\3\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\5\6(\n\6\3\7\3\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2\2,\2\16\3\2\2"+
		"\2\4\32\3\2\2\2\6\34\3\2\2\2\b \3\2\2\2\n$\3\2\2\2\f)\3\2\2\2\16\23\5"+
		"\4\3\2\17\20\7\24\2\2\20\22\5\4\3\2\21\17\3\2\2\2\22\25\3\2\2\2\23\21"+
		"\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\23\3\2\2\2\26\33\5\6\4\2\27\33"+
		"\5\n\6\2\30\33\5\b\5\2\31\33\5\f\7\2\32\26\3\2\2\2\32\27\3\2\2\2\32\30"+
		"\3\2\2\2\32\31\3\2\2\2\33\5\3\2\2\2\34\35\7\21\2\2\35\36\7\34\2\2\36\37"+
		"\7\22\2\2\37\7\3\2\2\2 !\7\34\2\2!\"\7\26\2\2\"#\7\34\2\2#\t\3\2\2\2$"+
		"\'\7\34\2\2%&\7\25\2\2&(\5\n\6\2\'%\3\2\2\2\'(\3\2\2\2(\13\3\2\2\2)*\7"+
		"\17\2\2*+\7\34\2\2+,\7\20\2\2,\r\3\2\2\2\5\23\32\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
