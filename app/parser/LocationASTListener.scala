package parser

import parser.antlr.location.{LocationBaseListener, LocationParser}
import parser.ast.{AST, ASTNode, Location}

class LocationASTListener extends LocationBaseListener {
  var ast: AST = new AST()
  var stack: List[ASTNode] = Nil

  override def enterStylesheet(ctx: LocationParser.StylesheetContext): Unit = {
    super.enterStylesheet(ctx)
    val node: Location = new Location
    ast = new AST
    ast.setRoot(node)
  }

  override def exitStylesheet(ctx: LocationParser.StylesheetContext): Unit = {
    super.exitStylesheet(ctx)
    val location: Location = ast.root.asInstanceOf[Location]
    if (Option(location.city).getOrElse("").isEmpty) {
      location.city = "Arnhem"
    }
    ast.root = location
  }

  /** Runs on entering the city */
  override def enterCity(ctx: LocationParser.CityContext): Unit = {
    super.enterCity(ctx)

    if (!ctx.children.isEmpty) {
      val location: Location = ast.root.asInstanceOf[Location]
      val cityValue: String = ctx.children.get(0).toString
      if (cityValue == "NM") {
        location.city = "Nijmegen"
      }
    }
  }

  /** Runs on exiting the city */
  override def exitCity(ctx: LocationParser.CityContext): Unit = {
    super.exitCity(ctx)
  }

  /** Runs on entering the locationname */
  override def enterLocationname(ctx: LocationParser.LocationnameContext): Unit = {
    super.enterLocationname(ctx)
    if (!ctx.children.isEmpty) {
      val location: Location = ast.root.asInstanceOf[Location]
      val locationNameValue: String = ctx.children.get(0).toString
      location.locationName = locationNameValue
    }
  }

  /** Runs on exiting the locationname */
  override def exitLocationname(ctx: LocationParser.LocationnameContext): Unit = {
    super.exitLocationname(ctx)
  }

  /** Runs on entering classroom part */
  override def enterClassroom(ctx: LocationParser.ClassroomContext): Unit = {
    super.enterClassroom(ctx)
    if (!ctx.children.isEmpty) {
      val location: Location = ast.root.asInstanceOf[Location]

      val classroomKey = if (ctx.children.size > 1) 1 else 0
      val classroom: String = ctx.children.get(classroomKey).toString
      if (ctx.children.size() >= 3) {
        val classroomAddon: String = ctx.children.get(2).toString
        location.classroom = classroom + classroomAddon
      }
      else {
        location.classroom = classroom
      }
    }
  }

  /** Runs on exiting classroom part */
  override def exitClassroom(ctx: LocationParser.ClassroomContext): Unit = {
    super.exitClassroom(ctx)
  }
}
