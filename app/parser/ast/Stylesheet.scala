package parser.ast

class Stylesheet extends ASTNode {

  override def getChildren: List[ASTNode] = this.body

  override def addChild(child: ASTNode): Unit = {
    body = body ++ List(child)
  }
}
