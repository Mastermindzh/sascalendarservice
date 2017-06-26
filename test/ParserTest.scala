import models.{Summary, Teacher, Location}
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import parser.Parser

@RunWith(classOf[JUnitRunner])
class ParserTest extends Specification {

  /**
    * Testing summary parser
    *
    */

  "SummaryParser Valid" should {
    "return valid json on the following string: " +
      "'M-MAD 1 M-MAD sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)'" in {
      val string = "M-MAD 1 M-MAD sep\n Johan Korten (ktnj) / Lars Tijsma (tsml)"
      val teacher1 = new Teacher("Johan Korten", "(ktnj)")
      val teacher2 = new Teacher("Lars Tijsma", "(tsml)")
      val teachers = List(teacher1, teacher2)
      val resultSummary = Summary("M-MAD", "1", "M-MAD sep", teachers, string)
      val testSummary = Parser.parseSummaryToJsonString("M-MAD 1 M-MAD sep\n Johan Korten (ktnj) / Lars Tijsma (tsml)")
      testSummary mustEqual resultSummary
    }
  }


  "SummaryParser Valid 2" should {

    "return valid json on the following string: " +
      "'ASD SWA ASD A-N feb\\n Theo Theunissen (tnsta)'" in {
      val string = "ASD SWA ASD A-N feb\\n Theo Theunissen (tnsta)"
      val teacher1 = new Teacher("Theo Theunissen", "(tnsta)")
      val teachers = List(teacher1)
      val resultSummary = Summary("ASD", "SWA", "ASD A-N feb", teachers, string)
      val testSummary = Parser.parseSummaryToJsonString("ASD SWA ASD A-N feb\\n Theo Theunissen (tnsta)")
      testSummary mustEqual resultSummary
    }
  }


  "SummaryParser Empty" should {
    "Return an error JSON with input: : ' ' " in {
      val string = " "
      Parser.parseSummaryToJsonString(string) must throwA[Exception]
    }
  }

  "SummaryParser No Semester" should {
    "Return an error JSON with input: : " +
      "'1 M-MAD sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)'" in {
      val string = "1 M-MAD sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)"
      Parser.parseSummaryToJsonString(string) must throwA[Exception]
    }
  }

  "SummaryParser No Subject" should {
    "Return an error JSON with input: : " +
      "'M-MAD M-MAD sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)'" in {
      val string = "M-MAD M-MAD sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)"
      Parser.parseSummaryToJsonString(string) must
        throwA[Exception]
    }
  }

  "SummaryParser No Class" should {
    "Return an error JSON with input: : " +
      "'M-MAD 1 sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)'" in {
      val string = "M-MAD 1 sep\\n Johan Korten (ktnj) / Lars Tijsma (tsml)"
      Parser.parseSummaryToJsonString(string) must
        throwA[Exception]
    }
  }

  "SummaryParser No Teacher(s)" should {
    "Return an error JSON with input: : " +
      "'M-MAD M-MAD sep\\n'" in {
      val string = "M-MAD M-MAD sep\\n"
      Parser.parseSummaryToJsonString(string) must throwA[Exception]
    }
  }

    /**
      * Testing location Parser
      */

    "LocationParser Valid" should {
      "Return valid JSON with input: : " +
        "'NM K010d'" in {
        val resultLocation = new Location("Nijmegen","Heyendaalseweg 129D, 6525 AJ", "K", "010d", "NM K010d")
        val testLocation = Parser.parseLocationToJsonString("NM K010d")
        testLocation mustEqual resultLocation
      }
    }

    "LocationParser Valid 2" should {
      "Return valid JSON with input: : " +
        "'C207'" in {
        val resultLocation = new Location("Arnhem","Ruitenberglaan 26, 6828 CC", "C", "207", "C207")
        val testLocation = Parser.parseLocationToJsonString("C207")
        testLocation mustEqual resultLocation
      }
    }

    "LocationParser Valid 3" should {
      "Return valid JSON with input: : " +
        "'K010d'" in {
        val resultLocation = new Location("Arnhem","Ruitenberglaan 26, 6828 CC", "K", "010d", "K010d")
        val testLocation = Parser.parseLocationToJsonString("K010d")
        testLocation mustEqual resultLocation
      }
    }

    "LocationParser Valid 4" should {
      "Return valid JSON with input: : " +
        "'412 NM'" in {
        val resultLocation = new Location("Nijmegen","Heyendaalseweg 98, 6525 EE", null, "412", "412 NM")
        val testLocation = Parser.parseLocationToJsonString("412 NM")
        testLocation mustEqual resultLocation
      }
    }

    "LocationParser No classname" should {
      "Return invalid JSON with input: : " +
        "'NM K010d'" in {
        Parser.parseLocationToJsonString("NM") must throwA[Exception]
      }
    }

  "LocationParser rawvalue startwith Nijmegen" should {
    "Return city nijmegen: : " +
      "'Nijmegen test'" in {
      val resultLocation = new Location("Nijmegen", "","", "", "Nijmegen test")
      val testLocation = Parser.parseLocationToJsonString("Nijmegen test")
      testLocation mustEqual resultLocation
    }
  }

  "LocationParser rawvalue startswith Arnhem" should {
    "Return city Arnhem: : " +
      "'Arnhem test'" in {
      val resultLocation = new Location("Arnhem", "","", "", "Arnhem test")
      val testLocation = Parser.parseLocationToJsonString("Arnhem test")
      testLocation mustEqual resultLocation
    }
  }

}