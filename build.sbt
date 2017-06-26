name := "play_scala_rest_framework"

version := "1.0"

lazy val `play_scala_rest_framework` = (project in file(".")).enablePlugins(PlayScala, SonarRunnerPlugin)

scalaVersion := "2.11.7"

coverageEnabled := true

coverageExcludedPackages := "<empty>;org.*;parser.antlr.*;controllers.javascript.*;controllers.ReverseRoutes;controllers.routes;router.*;main.*;conf.*;"

libraryDependencies ++= Seq(jdbc, cache, ws, specs2 % Test)

libraryDependencies += filters

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)
