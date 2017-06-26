package parser.antlr.location;
// Generated from app/parser/antlr/location/Location.g4 by ANTLR 4.7

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LocationParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            CITYNAME = 1, BIGCHAR = 2, CHAR = 3, CLASSNUMBER = 4, NUMBER = 5, WS = 6;
    public static final int
            RULE_stylesheet = 0, RULE_city = 1, RULE_classroom = 2, RULE_locationname = 3;
    public static final String[] ruleNames = {
            "stylesheet", "city", "classroom", "locationname"
    };

    private static final String[] _LITERAL_NAMES = {
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "CITYNAME", "BIGCHAR", "CHAR", "CLASSNUMBER", "NUMBER", "WS"
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
    public String getGrammarFileName() {
        return "Location.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public LocationParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class StylesheetContext extends ParserRuleContext {
        public ClassroomContext classroom() {
            return getRuleContext(ClassroomContext.class, 0);
        }

        public List<CityContext> city() {
            return getRuleContexts(CityContext.class);
        }

        public CityContext city(int i) {
            return getRuleContext(CityContext.class, i);
        }

        public StylesheetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stylesheet;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).enterStylesheet(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).exitStylesheet(this);
        }
    }

    public final StylesheetContext stylesheet() throws RecognitionException {
        StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_stylesheet);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(9);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CITYNAME) {
                    {
                        setState(8);
                        city();
                    }
                }

                setState(11);
                classroom();
                setState(13);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CITYNAME) {
                    {
                        setState(12);
                        city();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CityContext extends ParserRuleContext {
        public TerminalNode CITYNAME() {
            return getToken(LocationParser.CITYNAME, 0);
        }

        public CityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_city;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).enterCity(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).exitCity(this);
        }
    }

    public final CityContext city() throws RecognitionException {
        CityContext _localctx = new CityContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_city);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(15);
                match(CITYNAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ClassroomContext extends ParserRuleContext {
        public TerminalNode CLASSNUMBER() {
            return getToken(LocationParser.CLASSNUMBER, 0);
        }

        public List<LocationnameContext> locationname() {
            return getRuleContexts(LocationnameContext.class);
        }

        public LocationnameContext locationname(int i) {
            return getRuleContext(LocationnameContext.class, i);
        }

        public TerminalNode CHAR() {
            return getToken(LocationParser.CHAR, 0);
        }

        public ClassroomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classroom;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).enterClassroom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).exitClassroom(this);
        }
    }

    public final ClassroomContext classroom() throws RecognitionException {
        ClassroomContext _localctx = new ClassroomContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_classroom);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(18);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == BIGCHAR) {
                    {
                        setState(17);
                        locationname();
                    }
                }

                setState(20);
                match(CLASSNUMBER);
                setState(22);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CHAR) {
                    {
                        setState(21);
                        match(CHAR);
                    }
                }

                setState(25);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == BIGCHAR) {
                    {
                        setState(24);
                        locationname();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LocationnameContext extends ParserRuleContext {
        public TerminalNode BIGCHAR() {
            return getToken(LocationParser.BIGCHAR, 0);
        }

        public LocationnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_locationname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).enterLocationname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LocationListener) ((LocationListener) listener).exitLocationname(this);
        }
    }

    public final LocationnameContext locationname() throws RecognitionException {
        LocationnameContext _localctx = new LocationnameContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_locationname);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(27);
                match(BIGCHAR);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b \4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\3\2\5\2\f\n\2\3\2\3\2\5\2\20\n\2\3\3\3\3\3\4\5\4\25" +
                    "\n\4\3\4\3\4\5\4\31\n\4\3\4\5\4\34\n\4\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2\2" +
                    " \2\13\3\2\2\2\4\21\3\2\2\2\6\24\3\2\2\2\b\35\3\2\2\2\n\f\5\4\3\2\13\n" +
                    "\3\2\2\2\13\f\3\2\2\2\f\r\3\2\2\2\r\17\5\6\4\2\16\20\5\4\3\2\17\16\3\2" +
                    "\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\22\7\3\2\2\22\5\3\2\2\2\23\25\5\b\5" +
                    "\2\24\23\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\30\7\6\2\2\27\31\7\5\2" +
                    "\2\30\27\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\34\5\b\5\2\33\32\3\2\2" +
                    "\2\33\34\3\2\2\2\34\7\3\2\2\2\35\36\7\4\2\2\36\t\3\2\2\2\7\13\17\24\30" +
                    "\33";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}