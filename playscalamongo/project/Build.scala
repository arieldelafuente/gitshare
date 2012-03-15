import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "playscalamongo"
    val appVersion      = "1.0-SNAPSHOT"

    val casbah = "com.mongodb.casbah" %% "casbah" % "2.1.5.0"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
