package parser

import statsd._
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime._
import parser.antlr.location.{LocationLexer, LocationParser}
import parser.antlr.summary._
import parser.ast.AST
import parser.generate.Generator
import models.{Summary, Location => ModelLocation}

object Parser {
  /**
    * parse summary to json string
    * @param summary summary to parse
    * @return summary object with info from json string
    */
  def parseSummaryToJsonString(summary: String): Summary = {
    val start = System.nanoTime()
    if (!summary.isEmpty) {
      print(summary)
      val summaryObject = parseSummary(summary)
      summaryObject.rawValue = summary

      val time = System.nanoTime() - start
      Statsd.recordHistogramValue("time.parseSummary", time, true)

      summaryObject
    } else {
      throw new IllegalArgumentException("Could not validate the summary.")
    }
  }

  /**
    * parse a location to a json string
    * @param location location string
    * @return ModelLocation with parsed result
    */
  def parseLocationToJsonString(location: String): ModelLocation = {
    val start = System.nanoTime()

    location match {
      case locationEmpty if location.isEmpty => throw new IllegalArgumentException("Could not validate the location.")
      case locationNijmegen if location.toLowerCase.startsWith("nijmegen") => ModelLocation("Nijmegen","", "", "", location)
      case locationArnhem if location.toLowerCase.startsWith("arnhem") => ModelLocation("Arnhem","", "", "", location)
      case _ => parseValidLocation(location, start)
    }
  }

  /**
    * Parses a valid location
    * @param location location to Parse
    * @param start    starttime (datadog)
    * @return locationObject
    */
  private def parseValidLocation(location: String, start: Long) = {
      val locationObject = parseLocation(location)
      locationObject.rawValue = location

      val time = System.nanoTime() - start
      Statsd.recordHistogramValue("time.parseLocation", time, true)

      locationObject
  }

  /**
    * parse summary
    * @param summary
    * @return
    */
  def parseSummary(summary: String): Summary = {
    // Lex (with Antlr's generated lexer)
    val inputStream = new ANTLRInputStream(summary)
    val lexer = new SummaryLexer(inputStream)
    val tokens = new CommonTokenStream(lexer)
    // Parse (with Antlr's generated parser)
    val parser = new SummaryParser(tokens)
    val parseTree = parser.stylesheet
    // Extract AST from the Antlr parse tree
    val listener = new SummaryASTListener
    val walker = new ParseTreeWalker
    walker.walk(listener, parseTree)
    val ast = listener.ast
    // now generate the JSON from the AST Pane
    generateSummary(ast)
  }

  /**
    * generate summary
    * @param ast
    * @return
    */
  def generateSummary(ast: AST): Summary = {
    if (Option(ast).isDefined) {
      println("Generating output...")
      val generator = Generator
      generator.generateSummary(ast)
    }
    else {
      throw new IllegalArgumentException("Could not validate the Summary.")
    }
  }

  /**
    * parse location
    * @param location location to parse
    * @return parsed location
    */
  def parseLocation(location: String): ModelLocation = {
    // Lex (with Antlr's generated lexer)
    val inputStream = new ANTLRInputStream(location)
    val lexer = new LocationLexer(inputStream)
    val tokens = new CommonTokenStream(lexer)
    // Parse (with Antlr's generated parser)
    val parser = new LocationParser(tokens)
    val parseTree = parser.stylesheet
    // Extract AST from the Antlr parse tree
    val listener = new LocationASTListener
    val walker = new ParseTreeWalker
    walker.walk(listener, parseTree)
    val ast = listener.ast
    // now generate the JSON from the AST Pane
    generateLocation(ast)
  }

  /**
    * generate location
    * @param ast ast to generate from
    * @return generated location
    */
  def generateLocation(ast: AST): ModelLocation = {
    if (Option(ast).isDefined) {
      val generator = Generator
      generator.generateLocation(ast)
    }
    else {
      throw new IllegalArgumentException("Could not validate the location.")
    }
  }
}
