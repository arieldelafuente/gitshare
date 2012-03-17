import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "playscalamongo"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here
        "joda-time" % "joda-time" % "1.6",
        "com.mongodb.casbah" % "casbah_2.9.0-1" % "2.1.5.0"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
