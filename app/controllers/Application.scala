package controllers

import java.io.{BufferedReader, InputStreamReader, StringReader}
import java.net.URL

import statsd._
import models.CalendarItem
import net.fortuna.ical4j.data.CalendarBuilder
import net.fortuna.ical4j.filter.{Filter, PeriodRule}
import net.fortuna.ical4j.model.{Component, DateTime, Dur, Period}
import net.fortuna.ical4j.model.component.VEvent
import play.api.mvc._
import play.api.libs.json._

import scala.collection.mutable.ListBuffer

// useful import for treating java lists as scala lists
import scala.collection.JavaConversions._

class Application extends Controller {
  /**
    * Collects and returns a list of calendar items
    *
    * @param address     http(s) address of the .ics file
    * @param facultyType literally just the faculty type (for example: ICA)
    * @return json list of items
    */
  def getCalendarEvents(address: String, facultyType: String, nrOfDays: Int) = Action {
    Statsd.increment("request.getCalendarEvents")
    Ok(Json.obj("calendarItems" ->
      getCalendarListItems(new StringReader(filterCalendar(address, facultyType)), nrOfDays)
        .toList.sortWith(_.dateStart < _.dateStart))).as("UTF-8")
  }

  def getCalendarListItems(sin: StringReader, nrOfDays: Int) = {
    val start = System.nanoTime()
    EnableRelaxedParsing()
    val items = new ListBuffer[CalendarItem]()

    try {
      val cal = new CalendarBuilder().build(sin)

      if (nrOfDays > 0) {
        val today = java.util.Calendar.getInstance
        val period = new Period(new DateTime(today.getTime), new Dur(nrOfDays, 0, 0, 0))
        val oneWeekFilter = new Filter(new PeriodRule(period))

        oneWeekFilter.filter(cal.getComponents(Component.VEVENT)).foreach(x =>
          items += CalendarItem.buildFromVEvent(x.asInstanceOf[VEvent]))
      } else {
        cal.getComponents.toList.foreach(x => items += CalendarItem.buildFromVEvent(x.asInstanceOf[VEvent]))
      }
      Statsd.increment("parse.succeed")
    }
    catch {
      case _: Throwable => Statsd.increment("parse.error")
    }
    val time = System.nanoTime() - start
    Statsd.recordHistogramValue("time.getCalendarEvents", time, false);
    items
  }

  /**
    * Loop through the entire .ics file and filter out non-compliant lines.
    *
    * @param address     http(s) address of the .ics file
    * @param facultyType literally just the faculty type (for example: ICA)
    * @return
    */
  private def filterCalendar(address: String, facultyType: String): String = {
    var urlAdress = address
    if (address.startsWith("webcal")) {
      urlAdress = address.replaceFirst("webcal","http")
    }else if(!address.startsWith("http")){
      urlAdress = "http://" + address
    }
    val url = new URL(urlAdress + "&type=" + facultyType)
    val conn = url.openConnection()
    try {
      val br: BufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream))
      val calStringBuilder = StringBuilder.newBuilder

      Stream.continually(br.readLine())
        .takeWhile(Option(_).isDefined).foreach(line => processLine(calStringBuilder, line))
      calStringBuilder.toString
    }
    catch {
      case _: Exception => println("Error reading input stream input.")
        ""
    }
  }

  /**
    * Process a line and add it to a calendar.
    *
    * @param calendar calendar to add items to
    * @param line     line to process
    */
  def processLine(calendar: StringBuilder, line: String): Unit = {
    line match {
      case a if line.startsWith("METHOD:") =>
      case b if line.startsWith("CALSCALE:") =>
      case c if line.startsWith("X-") =>
      case d if line.startsWith("SUMMARY:Dit is je persoonlijke SAS rooster") =>
      case _ => calendar.append(line + "\n")
    }
  }

  /**
    * Enables relaxed parsing, this is necessary to parse Mozilla / Outlook calendars
    */
  private def EnableRelaxedParsing(): Unit = {
    System.setProperty("ical4j.unfolding.relaxed", "true")
    System.setProperty("ical4j.parsing.relaxed", "true")
    System.setProperty("ical4j.validation.relaxed", "true")
  }
}
