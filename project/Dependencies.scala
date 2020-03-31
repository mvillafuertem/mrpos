import org.portablescala.sbtplatformdeps.PlatformDepsGroupArtifactID
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {

  val `mrpos-frontend`: Seq[sbt.ModuleID] = Seq(

    // P R O D U C T I O N

    // T E S T

    // I N T E G R A T I O N  T E S T

  )

  val `mrpos-docs`: Seq[ModuleID] = Seq(

    // P R O D U C T I O N

    // T E S T

  )

  val `mrpos-web` = Seq(

    // P R O D U C T I O N

    // T E S T

  )

  object Artifact {


  }


  object Version {

    val slinky = "0.6.4+2-3c8aef65"
    val scalajsDom = "0.9.7"

  }

}