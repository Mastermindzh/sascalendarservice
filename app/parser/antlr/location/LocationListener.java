package parser.antlr.location;

// Generated from app/parser/antlr/location/Location.g4 by ANTLR 4.7

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LocationParser}.
 */
public interface LocationListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link LocationParser#stylesheet}.
     *
     * @param ctx the parse tree
     */
    void enterStylesheet(LocationParser.StylesheetContext ctx);

    /**
     * Exit a parse tree produced by {@link LocationParser#stylesheet}.
     *
     * @param ctx the parse tree
     */
    void exitStylesheet(LocationParser.StylesheetContext ctx);

    /**
     * Enter a parse tree produced by {@link LocationParser#city}.
     *
     * @param ctx the parse tree
     */
    void enterCity(LocationParser.CityContext ctx);

    /**
     * Exit a parse tree produced by {@link LocationParser#city}.
     *
     * @param ctx the parse tree
     */
    void exitCity(LocationParser.CityContext ctx);

    /**
     * Enter a parse tree produced by {@link LocationParser#classroom}.
     *
     * @param ctx the parse tree
     */
    void enterClassroom(LocationParser.ClassroomContext ctx);

    /**
     * Exit a parse tree produced by {@link LocationParser#classroom}.
     *
     * @param ctx the parse tree
     */
    void exitClassroom(LocationParser.ClassroomContext ctx);

    /**
     * Enter a parse tree produced by {@link LocationParser#locationname}.
     *
     * @param ctx the parse tree
     */
    void enterLocationname(LocationParser.LocationnameContext ctx);

    /**
     * Exit a parse tree produced by {@link LocationParser#locationname}.
     *
     * @param ctx the parse tree
     */
    void exitLocationname(LocationParser.LocationnameContext ctx);
}