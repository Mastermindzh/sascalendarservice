package parser.ast

class AST {
  var root: ASTNode = _

  def setRoot(stylesheet: ASTNode): Unit = {
    root = stylesheet
  }
}
