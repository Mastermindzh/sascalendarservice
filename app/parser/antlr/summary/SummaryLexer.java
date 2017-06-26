// Generated from app/parser/antlr/summary/Summary.g4 by ANTLR 4.7
package parser.antlr.summary;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SummaryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ABBR=4, SEMESTERNAME=5, MONTH=6, NUMBER=7, SUBJECTNAME=8, 
		SEMESTERCLASSNAME=9, NAME=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "ABBR", "SEMESTERNAME", "MONTH", "NUMBER", "SUBJECTNAME", 
		"SEMESTERCLASSNAME", "NAME", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\n'", "'\u002F'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "ABBR", "SEMESTERNAME", "MONTH", "NUMBER", "SUBJECTNAME", 
		"SEMESTERCLASSNAME", "NAME", "WS"
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


	public SummaryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Summary.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rf\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\'"+
		"\n\5\3\5\3\5\3\6\6\6,\n\6\r\6\16\6-\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\5\t:\n\t\3\n\3\n\3\n\3\n\5\n@\n\n\3\n\5\nC\n\n\3\n\3\n\3\n\3\n"+
		"\5\nI\n\n\5\nK\n\n\3\n\3\n\5\nO\n\n\3\n\3\n\3\n\3\13\3\13\6\13V\n\13\r"+
		"\13\16\13W\3\13\3\13\6\13\\\n\13\r\13\16\13]\3\f\6\fa\n\f\r\f\16\fb\3"+
		"\f\3\f\3]\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\b"+
		"\4\2C\\c|\6\2//\61;C\\c|\3\2c|\3\2\62;\3\2C\\\5\2\13\f\17\17\"\"\2q\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3"+
		"\31\3\2\2\2\5\34\3\2\2\2\7\36\3\2\2\2\t \3\2\2\2\13+\3\2\2\2\r/\3\2\2"+
		"\2\17\63\3\2\2\2\219\3\2\2\2\23;\3\2\2\2\25S\3\2\2\2\27`\3\2\2\2\31\32"+
		"\7^\2\2\32\33\7p\2\2\33\4\3\2\2\2\34\35\7\61\2\2\35\6\3\2\2\2\36\37\7"+
		"\61\2\2\37\b\3\2\2\2 !\7*\2\2!\"\t\2\2\2\"#\t\2\2\2#$\t\2\2\2$&\t\2\2"+
		"\2%\'\t\2\2\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7+\2\2)\n\3\2\2\2*,\t"+
		"\3\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\f\3\2\2\2/\60\t\4\2\2"+
		"\60\61\t\4\2\2\61\62\t\4\2\2\62\16\3\2\2\2\63\64\t\5\2\2\64\20\3\2\2\2"+
		"\65\66\t\2\2\2\66\67\t\2\2\2\67:\t\2\2\28:\t\5\2\29\65\3\2\2\298\3\2\2"+
		"\2:\22\3\2\2\2;J\5\13\6\2<=\7\"\2\2=?\t\2\2\2>@\t\2\2\2?>\3\2\2\2?@\3"+
		"\2\2\2@A\3\2\2\2AC\7\"\2\2B<\3\2\2\2BC\3\2\2\2CK\3\2\2\2DE\7\"\2\2EF\t"+
		"\2\2\2FH\7/\2\2GI\t\2\2\2HG\3\2\2\2HI\3\2\2\2IK\3\2\2\2JB\3\2\2\2JD\3"+
		"\2\2\2JK\3\2\2\2KN\3\2\2\2LM\7/\2\2MO\t\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3"+
		"\2\2\2PQ\7\"\2\2QR\5\r\7\2R\24\3\2\2\2SU\t\6\2\2TV\t\4\2\2UT\3\2\2\2V"+
		"W\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\7\"\2\2Z\\\5\13\6\2[Z\3\2\2"+
		"\2\\]\3\2\2\2]^\3\2\2\2][\3\2\2\2^\26\3\2\2\2_a\t\7\2\2`_\3\2\2\2ab\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\b\f\2\2e\30\3\2\2\2\16\2&-9?BH"+
		"JNW]b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}