// Generated from app/parser/antlr/summary/Summary.g4 by ANTLR 4.7
package parser.antlr.summary;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SummaryParser}.
 */
public interface SummaryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SummaryParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(SummaryParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(SummaryParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SummaryParser#semester}.
	 * @param ctx the parse tree
	 */
	void enterSemester(SummaryParser.SemesterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#semester}.
	 * @param ctx the parse tree
	 */
	void exitSemester(SummaryParser.SemesterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SummaryParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSubject(SummaryParser.SubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSubject(SummaryParser.SubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SummaryParser#classname}.
	 * @param ctx the parse tree
	 */
	void enterClassname(SummaryParser.ClassnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#classname}.
	 * @param ctx the parse tree
	 */
	void exitClassname(SummaryParser.ClassnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SummaryParser#teacher}.
	 * @param ctx the parse tree
	 */
	void enterTeacher(SummaryParser.TeacherContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#teacher}.
	 * @param ctx the parse tree
	 */
	void exitTeacher(SummaryParser.TeacherContext ctx);
	/**
	 * Enter a parse tree produced by {@link SummaryParser#abbreviation}.
	 * @param ctx the parse tree
	 */
	void enterAbbreviation(SummaryParser.AbbreviationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#abbreviation}.
	 * @param ctx the parse tree
	 */
	void exitAbbreviation(SummaryParser.AbbreviationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SummaryParser#teachers}.
	 * @param ctx the parse tree
	 */
	void enterTeachers(SummaryParser.TeachersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SummaryParser#teachers}.
	 * @param ctx the parse tree
	 */
	void exitTeachers(SummaryParser.TeachersContext ctx);
}