package models

import play.api.libs.json._

case class Location(city: String, address: String, name: String, classRoom: String, var rawValue: String)

object Location {
  implicit val locationItemFormat: OFormat[Location] = Json.format[Location]

  def getInstanceFromJson(input: JsValue): Location = {
    val city = (input \ "city").as[String]
    val name = (input \ "locationName").as[String]
    val address = (input \ "address").as[String]
    val classRoom = (input \ "classroom").as[String]
    Location(city, address, name, classRoom, "")
  }

}

