import sbt.Keys._
import sbt.{Def, _}

object Information {

  val value: Seq[Def.Setting[_]] = Settings.value ++ Seq(
    organization := "io.github.mvillafuertem",
    homepage := Some(url("https://github.com/mvillafuertem/mrpos")),
    licenses := List("MIT" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        "mvillafuertem",
        "Miguel Villafuerte",
        "mvillafuertem@email.com",
        url("https://github.com/mvillafuertem")
      )
    )
  )

}
