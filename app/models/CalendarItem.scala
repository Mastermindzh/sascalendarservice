package models

import net.fortuna.ical4j.model.Property
import net.fortuna.ical4j.model.component.VEvent
import net.fortuna.ical4j.model.property.DateProperty
import parser.Parser
import play.api.libs.json._

case class CalendarItem(
                         summary: Summary,
                         description: String,
                         location: Location,
                         dateStart: Long,
                         dateEnd: Long,
                         dateStamp: Long,
                         uid: String,
                         priority: String)

object CalendarItem {
  implicit val calendarItemFormat: OFormat[CalendarItem] = Json.format[CalendarItem]

  /**
    * create a CalendarItem from a VEvent
    *
    * @param event the VEvent to convert
    * @return a CalendarItem with all the relevant information from the VEvent
    */
  def buildFromVEvent(event: VEvent): CalendarItem = {
    CalendarItem(
      parseSummary(getEventValue(event.getSummary)),
      getEventValue(event.getDescription),
      parseLocation(getEventValue(event.getLocation)),
      getEventUnixTime(event.getStartDate),
      getEventUnixTime(event.getEndDate()),
      getEventUnixTime(event.getDateStamp),
      getEventValue(event.getUid),
      getEventValue(event.getPriority)
    )
  }

  /**
    * Get the value from a VEvent property
    * @param property property to get value off
    * @return value of property (as Long)
    */
  def getEventUnixTime(property: DateProperty): Long = {
    if (Option(property).isDefined) {
      property.getDate().getTime / 1000
    } else {
      0
    }
  }

  /**
    * Get the value from a VEvent property
    * @param property property to get value off
    * @return value of property (as string)
    */
  def getEventValue(property: Property): String = {
    if (Option(property).isDefined) {
      property.getValue
    } else {
      ""
    }
  }

  /**
    * Parse the event location
    * @param input location to parse
    * @return
    */
  def parseLocation(input: String): Location = {
    try {
      // try catch (json might not be valid etc)
      val locationObject = Parser.parseLocationToJsonString(input)
      locationObject
    } catch {
      case _: Throwable =>
        Statsd.increment("request.parse.failed.location")
        Location("","", "", "", input)
    }
  }

  /**
    * Parse the event summary
    * @param input summary to be parsed
    * @return
    */
  def parseSummary(input: String): Summary = {
    try {
      // try catch (json might not be valid etc)
      val summaryObject = Parser.parseSummaryToJsonString(input)
      summaryObject
    } catch {
      case _: Throwable =>
        Statsd.increment("request.parse.failed.summary")
        // input // make sure we return some useful info
        Summary("", "", "", List[Teacher](), input)
    }
  }

}


