package parser.antlr.summary;

// Generated from app/parser/antlr/summary/Summary.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SummaryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ABBR=4, SEMESTERNAME=5, MONTH=6, NUMBER=7, SUBJECTNAME=8, 
		SEMESTERCLASSNAME=9, NAME=10, WS=11;
	public static final int
		RULE_stylesheet = 0, RULE_semester = 1, RULE_subject = 2, RULE_classname = 3, 
		RULE_teacher = 4, RULE_abbreviation = 5, RULE_teachers = 6;
	public static final String[] ruleNames = {
		"stylesheet", "semester", "subject", "classname", "teacher", "abbreviation", 
		"teachers"
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

	@Override
	public String getGrammarFileName() { return "Summary.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SummaryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public SemesterContext semester() {
			return getRuleContext(SemesterContext.class,0);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public TeachersContext teachers() {
			return getRuleContext(TeachersContext.class,0);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitStylesheet(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			semester();
			setState(15);
			subject();
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMESTERCLASSNAME) {
				{
				setState(16);
				classname();
				}
			}

			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(19);
				match(T__0);
				}
			}

			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(22);
				teachers();
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

	public static class SemesterContext extends ParserRuleContext {
		public TerminalNode SEMESTERNAME() { return getToken(SummaryParser.SEMESTERNAME, 0); }
		public SemesterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semester; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterSemester(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitSemester(this);
		}
	}

	public final SemesterContext semester() throws RecognitionException {
		SemesterContext _localctx = new SemesterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_semester);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(SEMESTERNAME);
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

	public static class SubjectContext extends ParserRuleContext {
		public TerminalNode SEMESTERNAME() { return getToken(SummaryParser.SEMESTERNAME, 0); }
		public TerminalNode NUMBER() { return getToken(SummaryParser.NUMBER, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitSubject(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_la = _input.LA(1);
			if ( !(_la==SEMESTERNAME || _la==NUMBER) ) {
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

	public static class ClassnameContext extends ParserRuleContext {
		public TerminalNode SEMESTERCLASSNAME() { return getToken(SummaryParser.SEMESTERCLASSNAME, 0); }
		public ClassnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterClassname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitClassname(this);
		}
	}

	public final ClassnameContext classname() throws RecognitionException {
		ClassnameContext _localctx = new ClassnameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(SEMESTERCLASSNAME);
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

	public static class TeacherContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SummaryParser.NAME, 0); }
		public AbbreviationContext abbreviation() {
			return getRuleContext(AbbreviationContext.class,0);
		}
		public TeacherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_teacher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterTeacher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitTeacher(this);
		}
	}

	public final TeacherContext teacher() throws RecognitionException {
		TeacherContext _localctx = new TeacherContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_teacher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(NAME);
			setState(32);
			abbreviation();
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

	public static class AbbreviationContext extends ParserRuleContext {
		public TerminalNode ABBR() { return getToken(SummaryParser.ABBR, 0); }
		public AbbreviationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abbreviation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterAbbreviation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitAbbreviation(this);
		}
	}

	public final AbbreviationContext abbreviation() throws RecognitionException {
		AbbreviationContext _localctx = new AbbreviationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_abbreviation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(ABBR);
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

	public static class TeachersContext extends ParserRuleContext {
		public List<TeacherContext> teacher() {
			return getRuleContexts(TeacherContext.class);
		}
		public TeacherContext teacher(int i) {
			return getRuleContext(TeacherContext.class,i);
		}
		public TeachersContext teachers() {
			return getRuleContext(TeachersContext.class,0);
		}
		public TeachersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_teachers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).enterTeachers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SummaryListener ) ((SummaryListener)listener).exitTeachers(this);
		}
	}

	public final TeachersContext teachers() throws RecognitionException {
		TeachersContext _localctx = new TeachersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_teachers);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				teacher();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(37);
				teacher();
				setState(38);
				match(T__1);
				setState(39);
				teacher();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(41);
				teacher();
				setState(42);
				match(T__2);
				setState(43);
				teachers();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\5\2\24\n\2\3"+
		"\2\5\2\27\n\2\3\2\5\2\32\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\60\n\b\3\b\2\2\t\2\4\6\b\n"+
		"\f\16\2\3\4\2\7\7\t\t\2/\2\20\3\2\2\2\4\33\3\2\2\2\6\35\3\2\2\2\b\37\3"+
		"\2\2\2\n!\3\2\2\2\f$\3\2\2\2\16/\3\2\2\2\20\21\5\4\3\2\21\23\5\6\4\2\22"+
		"\24\5\b\5\2\23\22\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2\2\25\27\7\3\2\2\26"+
		"\25\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\32\5\16\b\2\31\30\3\2\2\2\31"+
		"\32\3\2\2\2\32\3\3\2\2\2\33\34\7\7\2\2\34\5\3\2\2\2\35\36\t\2\2\2\36\7"+
		"\3\2\2\2\37 \7\13\2\2 \t\3\2\2\2!\"\7\f\2\2\"#\5\f\7\2#\13\3\2\2\2$%\7"+
		"\6\2\2%\r\3\2\2\2&\60\5\n\6\2\'(\5\n\6\2()\7\4\2\2)*\5\n\6\2*\60\3\2\2"+
		"\2+,\5\n\6\2,-\7\5\2\2-.\5\16\b\2.\60\3\2\2\2/&\3\2\2\2/\'\3\2\2\2/+\3"+
		"\2\2\2\60\17\3\2\2\2\6\23\26\31/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}