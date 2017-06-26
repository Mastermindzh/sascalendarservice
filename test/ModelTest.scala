import java.io.StringReader

import models.{Location, Summary, Teacher}
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.libs.json._

import scala.io.Source

@RunWith(classOf[JUnitRunner])
class ModelTest extends Specification {

  val modelJson: String = "Return the right data when given json string"

  "TeacherModel" should {
     modelJson in {
      val result = Teacher("TeacherName","TeacherAbbreviation")
      val result2 = Teacher.getInstanceFromJson(Json.parse("{\"name\":\"TeacherName\",\"abbreviation\":\"TeacherAbbreviation\"}"))
      result2 must equalTo(result)
    }
  }

  "LocationModel" should {
    modelJson in {
      val result = Location("city","address", "name","classRoom","")
      val result2 = Location.getInstanceFromJson(
        Json.parse("{\"city\":\"city\",\"locationName\":\"name\", \"address\":\"address\", \"classroom\":\"classRoom\"}"))
      result2 must equalTo(result)
    }
  }

}