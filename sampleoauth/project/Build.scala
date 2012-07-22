import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "sampleoauth"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
        "net.databinder" %% "dispatch-http" % "0.8.8"        
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
