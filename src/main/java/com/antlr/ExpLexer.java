// Generated from /home/olya/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package com.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Number=3, Boolean=4, Add=5, Mul=6, Cmp=7, Eq=8, And=9, 
		Or=10, Not=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "Number", "Boolean", "Add", "Mul", "Cmp", "Eq", "And", 
		"Or", "Not", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", null, null, null, null, null, null, "'&&'", "'||'", 
		"'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "Number", "Boolean", "Add", "Mul", "Cmp", "Eq", "And", 
		"Or", "Not", "WS"
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


	public ExpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\5\4!\n\4\3\4\6\4$\n\4\r\4\16\4"+
		"%\3\4\3\4\6\4*\n\4\r\4\16\4+\5\4.\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\59\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bE\n\b\3\t\3\t"+
		"\3\t\3\t\5\tK\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\2"+
		"\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\5\4"+
		"\2--//\5\2\'\',,\61\61\5\2\13\f\17\17\"\"\2`\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2"+
		"\5\35\3\2\2\2\7 \3\2\2\2\t8\3\2\2\2\13:\3\2\2\2\r<\3\2\2\2\17D\3\2\2\2"+
		"\21J\3\2\2\2\23L\3\2\2\2\25O\3\2\2\2\27R\3\2\2\2\31T\3\2\2\2\33\34\7*"+
		"\2\2\34\4\3\2\2\2\35\36\7+\2\2\36\6\3\2\2\2\37!\t\2\2\2 \37\3\2\2\2 !"+
		"\3\2\2\2!#\3\2\2\2\"$\4\62;\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2"+
		"&-\3\2\2\2\')\7\60\2\2(*\4\62;\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2"+
		"\2,.\3\2\2\2-\'\3\2\2\2-.\3\2\2\2.\b\3\2\2\2/\60\7v\2\2\60\61\7t\2\2\61"+
		"\62\7w\2\2\629\7g\2\2\63\64\7h\2\2\64\65\7c\2\2\65\66\7n\2\2\66\67\7u"+
		"\2\2\679\7g\2\28/\3\2\2\28\63\3\2\2\29\n\3\2\2\2:;\t\2\2\2;\f\3\2\2\2"+
		"<=\t\3\2\2=\16\3\2\2\2>E\7>\2\2?@\7>\2\2@E\7?\2\2AE\7@\2\2BC\7@\2\2CE"+
		"\7?\2\2D>\3\2\2\2D?\3\2\2\2DA\3\2\2\2DB\3\2\2\2E\20\3\2\2\2FG\7?\2\2G"+
		"K\7?\2\2HI\7#\2\2IK\7?\2\2JF\3\2\2\2JH\3\2\2\2K\22\3\2\2\2LM\7(\2\2MN"+
		"\7(\2\2N\24\3\2\2\2OP\7~\2\2PQ\7~\2\2Q\26\3\2\2\2RS\7#\2\2S\30\3\2\2\2"+
		"TU\t\4\2\2UV\3\2\2\2VW\b\r\2\2W\32\3\2\2\2\n\2 %+-8DJ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}