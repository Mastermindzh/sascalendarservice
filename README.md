# SASCalendarService
Takes a "sascalendar" url and parses the location and summary fields.

## Contributors
- Rick van Lieshout
- Wilko Zonnenberg


## Running the project
The project includes a makefile with a couple of commands:

| Command | result |
|--------|--------|
|run| Starts the application with dynamic compilation|
|prod| Starts the application without dynamic compilation|
|test| Runs the tests|

## Adding a new route
Declare a route in "conf/routes", make sure to follow the following convention:
`GET		/route				controllers.Controller.Method`


Create the controller in the folder `app/controllers` using the following stub:

```$xslt
package controllers

import play.api.mvc._
import models.AgendaItem

class FirstController extends Controller {
    def firstMethod = Action {
        Ok("Woohoo! it works!")
    }
}

```

#Scoverage

## How to use

Make sure your sbt version in project/build.properties is set correctly:
```
sbt.version = 0.13.13
```

Add the plugin in project/plugins.sbt:
```scala
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")
```

Run the tests with coverage:
```
$ sbt clean coverage test
```
or if you have integration tests as well
```
$ sbt clean coverage it:test
```


To generate the coverage report run
```
$ sbt coverageReport
```

Coverage reports will be in `target/scoverage-report`. There are HTML and XML reports. The XML is useful if you need to programatically use the results, or if you're writing a tool.

If you're running the coverage reports from within an sbt console session (as
opposed to one command per sbt launch), then the `coverage` command is sticky. To
turn it back off when you're done running reports, use the `coverageOff` command or reset `coverageEnabled` with `set coverageEnabled := false`.

