package models

import play.api.libs.json.{JsValue, Json, OFormat}


case class Summary(semester: String, subject: String, className: String, teachers: List[Teacher], var rawValue: String)

object Summary {
  implicit val summaryItemFormat: OFormat[Summary] = Json.format[Summary]

  def getInstanceFromJson(input: JsValue): Summary = {
    var teachers = List[Teacher]()
    var className = ""
    val semester = (input \ "semester").as[String]
    val subject = (input \ "subject").as[String]
    try {
      className = (input \ "classname").as[String]
    }
    catch {
      case _: Throwable => println("Error reading classname.")
    }
    try {
      teachers = (input \ "teachers").as[List[Teacher]]
    }
    catch {
      case _: Throwable => println("Error reading teachers.")
    }
    Summary(semester, subject, className, teachers, "")
  }
}

