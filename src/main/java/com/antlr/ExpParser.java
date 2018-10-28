// Generated from /home/olya/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package com.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, Number=19, WS=20;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'('", "')'", "'!'", "'*'", "'/'", "'%'", "'+'", 
		"'-'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "Number", "WS"
	};
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
	public String getGrammarFileName() { return "Exp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public double value;
		public ExprContext left;
		public Token Number;
		public ExprContext expression;
		public Token op;
		public ExprContext right;
		public TerminalNode EOF() { return getToken(ExpParser.EOF, 0); }
		public TerminalNode Number() { return getToken(ExpParser.Number, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				{
				setState(3);
				match(EOF);
				((ExprContext)_localctx).value =  0;
				}
				break;
			case Number:
				{
				setState(5);
				((ExprContext)_localctx).Number = match(Number);
				((ExprContext)_localctx).value = Double.parseDouble((((ExprContext)_localctx).Number!=null?((ExprContext)_localctx).Number.getText():null));
				}
				break;
			case T__0:
				{
				setState(7);
				match(T__0);
				((ExprContext)_localctx).value = 1;
				}
				break;
			case T__1:
				{
				setState(9);
				match(T__1);
				((ExprContext)_localctx).value = 0;
				}
				break;
			case T__2:
				{
				setState(12); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(11);
						match(T__2);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(14); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(16);
					((ExprContext)_localctx).expression = expr(0);
					}
					}
					setState(19); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - -1)) & ~0x3f) == 0 && ((1L << (_la - -1)) & ((1L << (EOF - -1)) | (1L << (T__0 - -1)) | (1L << (T__1 - -1)) | (1L << (T__2 - -1)) | (1L << (T__4 - -1)) | (1L << (Number - -1)))) != 0) );
				setState(21);
				match(T__3);
				((ExprContext)_localctx).value =  ((ExprContext)_localctx).expression.value;
				}
				break;
			case T__4:
				{
				setState(24);
				match(T__4);
				setState(25);
				((ExprContext)_localctx).expression = expr(14);
				((ExprContext)_localctx).value =  (((ExprContext)_localctx).expression.value == 0) ? 1 : 0;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(95);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(30);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(31);
						((ExprContext)_localctx).op = match(T__5);
						setState(32);
						((ExprContext)_localctx).right = expr(14);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value * ((ExprContext)_localctx).right.value;
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(35);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(36);
						((ExprContext)_localctx).op = match(T__6);
						setState(37);
						((ExprContext)_localctx).right = expr(13);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value / ((ExprContext)_localctx).right.value;
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(40);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(41);
						((ExprContext)_localctx).op = match(T__7);
						setState(42);
						((ExprContext)_localctx).right = expr(12);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value % ((ExprContext)_localctx).right.value;
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(45);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(46);
						((ExprContext)_localctx).op = match(T__8);
						setState(47);
						((ExprContext)_localctx).right = expr(11);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value + ((ExprContext)_localctx).right.value;
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(50);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(51);
						((ExprContext)_localctx).op = match(T__9);
						setState(52);
						((ExprContext)_localctx).right = expr(10);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).left.value - ((ExprContext)_localctx).right.value;
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(56);
						((ExprContext)_localctx).op = match(T__10);
						setState(57);
						((ExprContext)_localctx).right = expr(9);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value < ((ExprContext)_localctx).right.value) ? 1 : 0;
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(61);
						((ExprContext)_localctx).op = match(T__11);
						setState(62);
						((ExprContext)_localctx).right = expr(8);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value > ((ExprContext)_localctx).right.value) ? 1 : 0;
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(66);
						((ExprContext)_localctx).op = match(T__12);
						setState(67);
						((ExprContext)_localctx).right = expr(7);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value <= ((ExprContext)_localctx).right.value) ? 1 : 0;
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(71);
						((ExprContext)_localctx).op = match(T__13);
						setState(72);
						((ExprContext)_localctx).right = expr(6);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value >= ((ExprContext)_localctx).right.value) ? 1 : 0;
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(76);
						((ExprContext)_localctx).op = match(T__14);
						setState(77);
						((ExprContext)_localctx).right = expr(5);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value == ((ExprContext)_localctx).right.value) ? 1 : 0;
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(81);
						((ExprContext)_localctx).op = match(T__15);
						setState(82);
						((ExprContext)_localctx).right = expr(4);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value != ((ExprContext)_localctx).right.value) ? 1 : 0;
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(86);
						((ExprContext)_localctx).op = match(T__16);
						setState(87);
						((ExprContext)_localctx).right = expr(3);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value == 0 || ((ExprContext)_localctx).right.value == 0) ? 0 : 1;
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(91);
						((ExprContext)_localctx).op = match(T__17);
						setState(92);
						((ExprContext)_localctx).right = expr(2);
						((ExprContext)_localctx).value =  (((ExprContext)_localctx).left.value == 0 && ((ExprContext)_localctx).right.value == 0) ? 0 : 1;
						}
						break;
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26g\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2\17\n\2\r\2\16\2\20\3\2\6\2\24\n"+
		"\2\r\2\16\2\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\37\n\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2b\n\2\f\2\16\2e\13\2\3\2\2\3\2\3"+
		"\2\2\2\2y\2\36\3\2\2\2\4\5\b\2\1\2\5\6\7\2\2\3\6\37\b\2\1\2\7\b\7\25\2"+
		"\2\b\37\b\2\1\2\t\n\7\3\2\2\n\37\b\2\1\2\13\f\7\4\2\2\f\37\b\2\1\2\r\17"+
		"\7\5\2\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\23"+
		"\3\2\2\2\22\24\5\2\2\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26"+
		"\3\2\2\2\26\27\3\2\2\2\27\30\7\6\2\2\30\31\b\2\1\2\31\37\3\2\2\2\32\33"+
		"\7\7\2\2\33\34\5\2\2\20\34\35\b\2\1\2\35\37\3\2\2\2\36\4\3\2\2\2\36\7"+
		"\3\2\2\2\36\t\3\2\2\2\36\13\3\2\2\2\36\16\3\2\2\2\36\32\3\2\2\2\37c\3"+
		"\2\2\2 !\f\17\2\2!\"\7\b\2\2\"#\5\2\2\20#$\b\2\1\2$b\3\2\2\2%&\f\16\2"+
		"\2&\'\7\t\2\2\'(\5\2\2\17()\b\2\1\2)b\3\2\2\2*+\f\r\2\2+,\7\n\2\2,-\5"+
		"\2\2\16-.\b\2\1\2.b\3\2\2\2/\60\f\f\2\2\60\61\7\13\2\2\61\62\5\2\2\r\62"+
		"\63\b\2\1\2\63b\3\2\2\2\64\65\f\13\2\2\65\66\7\f\2\2\66\67\5\2\2\f\67"+
		"8\b\2\1\28b\3\2\2\29:\f\n\2\2:;\7\r\2\2;<\5\2\2\13<=\b\2\1\2=b\3\2\2\2"+
		">?\f\t\2\2?@\7\16\2\2@A\5\2\2\nAB\b\2\1\2Bb\3\2\2\2CD\f\b\2\2DE\7\17\2"+
		"\2EF\5\2\2\tFG\b\2\1\2Gb\3\2\2\2HI\f\7\2\2IJ\7\20\2\2JK\5\2\2\bKL\b\2"+
		"\1\2Lb\3\2\2\2MN\f\6\2\2NO\7\21\2\2OP\5\2\2\7PQ\b\2\1\2Qb\3\2\2\2RS\f"+
		"\5\2\2ST\7\22\2\2TU\5\2\2\6UV\b\2\1\2Vb\3\2\2\2WX\f\4\2\2XY\7\23\2\2Y"+
		"Z\5\2\2\5Z[\b\2\1\2[b\3\2\2\2\\]\f\3\2\2]^\7\24\2\2^_\5\2\2\4_`\b\2\1"+
		"\2`b\3\2\2\2a \3\2\2\2a%\3\2\2\2a*\3\2\2\2a/\3\2\2\2a\64\3\2\2\2a9\3\2"+
		"\2\2a>\3\2\2\2aC\3\2\2\2aH\3\2\2\2aM\3\2\2\2aR\3\2\2\2aW\3\2\2\2a\\\3"+
		"\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\3\3\2\2\2ec\3\2\2\2\7\20\25\36a"+
		"c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}