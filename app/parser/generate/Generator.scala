package parser.generate

import play.api.libs.json._
import parser.ast._
import models.{Summary, Location => ModelLocation}

object Generator {
  /**
    * create json from response and build an object from it
    *
    * @param ast AST to build
    * @return instance from AST
    */
  def generateSummary(ast: AST): Summary = {
    val builder = new StringBuilder
    builder.append("{")
    buildStringSummary(builder, ast.root)
    builder.append("}")
    val string = Json.parse(builder.toString())
    Summary.getInstanceFromJson(string)
  }

  /**
    * Validate summary input
    *
    * @param node node to validate
    */
  private def validateSummary(node: Stylesheet): Unit = {
    if (node.getChildren.size < 1) {
      throw new IllegalArgumentException("Could not validate the summary.")
    }
  }

  /**
    * recursively build string summary
    *
    * @param builder builder
    * @param node    node to build
    */
  private def buildStringSummary(builder: StringBuilder, node: ASTNode): Unit = {
    node match {
      case node1: Stylesheet =>
        for (child <- node.getChildren) {
          buildStringSummary(builder, child)
          validateSummary(node1)
          if (child != node.getChildren.last) {
            builder.append(",")
          }
        }
      case _ => node match {
        case value: Value => builder.append("\"" + value.valueName + "\" : \"" + value.value + "\"")
        case _: Teachers =>
          buildTeachers(builder, node)
        case _ => node match {
          case teacher: Teacher =>
            builder.append("{\"name\":\"" + teacher.name + "\", \"abbreviation\":\"" + teacher.abbreviation + "\"}")
        }
      }
    }
  }

  /**
    * Build node into teachers object
    *
    * @param builder builder to build with
    * @param node    node to build
    * @return
    */
  private def buildTeachers(builder: StringBuilder, node: ASTNode) = {
    builder.append("\"teachers\":[")
    for (child <- node.getChildren if child.isInstanceOf[Teacher]) {
      buildStringSummary(builder, child.asInstanceOf[Teacher])
      if (child != node.getChildren.last) {
        builder.append(",")
      }
    }
    builder.append("]")
  }

  /**
    * Generate a location
    *
    * @param ast AST to generate location from
    * @return Location object
    */
  def generateLocation(ast: AST): ModelLocation = {
    val node: ASTNode = ast.root
    val location: Location = node.asInstanceOf[Location]

    new ModelLocation(location.city,getAddress(location), location.locationName, location.classroom, "")
  }

  /**
    * returns the address given the location
    * @param location location object with name etc.
    * @return
    */
  private def getAddress(location: Location): String = {
    var locationname = Option(location.locationName)
    if (location.city.toLowerCase.equals("arnhem")) {
      "Ruitenberglaan 26, 6828 CC"
    } else {
      location match {
        case albertinum if Option(location.locationName).getOrElse(default = "").toLowerCase.startsWith("k") => "Heyendaalseweg 129D, 6525 AJ"
        case technovium if location.classroom.toLowerCase.startsWith("4") => "Heyendaalseweg 98, 6525 EE"
        case _ => "Kapittelweg 33, 6525 EN"
      }
    }
  }
}
