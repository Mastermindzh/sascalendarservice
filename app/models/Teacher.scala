package models
import play.api.libs.json.{JsValue, Json, OFormat}

case class Teacher(name: String, abbreviation: String)

object Teacher {
  implicit val teacherItemFormat: OFormat[Teacher] = Json.format[Teacher]

  def getInstanceFromJson(input: JsValue): Teacher = {
    val name = (input \ "name").as[String]
    val abbreviation = (input \ "abbreviation").as[String]
    Teacher(name, abbreviation)
  }
}
