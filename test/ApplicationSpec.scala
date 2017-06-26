import java.io.{BufferedReader, File, InputStreamReader, StringReader}

import controllers.Application
import models.CalendarItem
import net.fortuna.ical4j.model.Date
import net.fortuna.ical4j.model.component.VEvent
import org.specs2.runner._
import org.junit.runner._
import org.specs2.mock.Mockito
import play.api.test._
import play.api.test.Helpers._
import org.specs2.mutable._
import play.api.libs.json.Json

import scala.io.Source

/**
  * Class to test Applications.Application
  */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification with Mockito {

  "Mock" should {
    "Mock calendar with 0 days" in {
      val m = new Application()
      val expectedResult = Source.fromFile("test/resources/calendarExpectedResult.txt", "UTF-8").getLines().mkString
      val testInput = "test/resources/calendarInput.txt"
      val calStringBuilder = StringBuilder.newBuilder
      for (line <- Source.fromFile(testInput).getLines()) {
        Stream.continually(m.processLine(calStringBuilder, line))
      }

      val result = m.getCalendarListItems(new StringReader(calStringBuilder.toString()), 0)
      val result2 = Json.obj("calendarItems" -> result).toString()
      result2 must equalTo(expectedResult)
    }
  }
  "Mock 1000 days" should {
    "Mock calendar with 1000 days" in {
      val m = new Application()
      val expectedResult = Source.fromFile("test/resources/calendarExpected1000DaysResult.txt", "UTF-8").getLines().mkString
      val testInput = "test/resources/calendarInput.txt"
      val calStringBuilder = StringBuilder.newBuilder
      for (line <- Source.fromFile(testInput).getLines()) {
        Stream.continually(m.processLine(calStringBuilder, line))
      }

      val result = m.getCalendarListItems(new StringReader(calStringBuilder.toString()), 1000)
      Json.obj("calendarItems" -> result).toString() must equalTo(expectedResult)
    }
  }

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      val home = route(FakeRequest(GET, "/boum")).get

      contentAsString(home) must contain("Action Not Found")
    }

    "should return an object from a VEvent" in new WithApplication {
      val event = new VEvent(new Date(), new Date(), "testsummary")
      val calendarItem: CalendarItem = CalendarItem.buildFromVEvent(event)

      event.getDescription
      calendarItem.summary.rawValue mustEqual "testsummary"
    }

    "should ignore faulty lines and add the valid ones to the stringbuilder" in new WithApplication {
      val invalidLines = List("METHOD:test", "CALSCALE:test", "X-WR-TIMEZONE:test", "X-PUBLISHED-TTL:test", "X-WR-CALNAME:test", "X-WR-CALDESC:test", "SUMMARY:Dit is je persoonlijke SAS rooster")
      val validLines = List("LOCATION:NM K010d", "PRIORITY:1")

      val testApp = new Application()
      val calStringBuilder = StringBuilder.newBuilder

      invalidLines.foreach(line => testApp.processLine(calStringBuilder, line))
      validLines.foreach(line => testApp.processLine(calStringBuilder, line))

      // check whether calStringBuilder has the expected number of chars (+2 for /n)
      calStringBuilder.length mustEqual validLines.head.length + validLines(1).length + 2
    }


  }
}
