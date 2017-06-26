package parser.ast

class ASTNode {

  var body: List[ASTNode] = Nil

  def getChildren: List[ASTNode] = this.body

  def addChild(child: ASTNode): Unit = {
    body = body ++ List(child)
  }
}
