import Dependencies.Version
import sbt.Keys.scalaSource

lazy val `mrpos` = (project in file("."))
  .aggregate(
    `mrpos-frontend`,
    `mrpos-docs`
  )
  .settings(Settings.value)
  .settings(Settings.noPublish)
  .settings(Settings.noAssemblyTest)


lazy val `mrpos-frontend` = (project in file("mrpos-frontend"))
  // S E T T I N G S
  .settings(Information.value)
  .settings(Settings.value)
  .settings(Settings.noAssemblyTest)
  .settings(scalaJSUseMainModuleInitializer := false)
  .settings(scalacOptions += "-Ymacro-annotations")
  .settings(libraryDependencies ++= Dependencies.`mrpos-frontend`)
  .settings(libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0")
  .settings(libraryDependencies ++= Seq(
    "me.shadaj" %%% "slinky-native",
    "me.shadaj" %%% "slinky-hot"
  ).map(_ % Version.slinky))
  // P L U G I N S
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val `mrpos-docs` = (project in file("mrpos-docs"))
  // S E T T I N G S
  .settings(Compile / scalaSource := baseDirectory.value / "src/main/mdoc")
  .settings(MdocSettings.value)
  .settings(Information.value)
  .settings(Settings.value)
  .settings(Settings.noAssemblyTest)
  .settings(libraryDependencies ++= Dependencies.`mrpos-docs`)
  // P L U G I N S
  .enablePlugins(MdocPlugin)

