import sbt.Keys.scalaSource

lazy val `mrpos` = (project in file("."))
  .aggregate(
    `mrpos-frontend`,
    `mrpos-docs`
  )
  .settings(Settings.value)
  .settings(Settings.noPublish)
  .settings(Settings.noAssemblyTest)
  .settings(crossScalaVersions := Nil)


lazy val `mrpos-frontend` = (project in file("mrpos-frontend"))
  // S E T T I N G S
  .settings(Information.value)
  .settings(Settings.value)
  .settings(Settings.noAssemblyTest)
  //.settings(scalaJSUseMainModuleInitializer := true)
  .settings(scalacOptions += "-Ymacro-annotations")
  .settings(scalacOptions += "-P:scalajs:sjsDefinedByDefault")
  .settings(crossScalaVersions := Settings.supportedScalaVersions)
  .settings(scalaJSModuleKind := ModuleKind.CommonJSModule)
  .settings(libraryDependencies ++= Dependencies.`mrpos-frontend`)
  .settings(libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.7")
  .settings(libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.6.3")
  .settings(libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.6.3")
  // P L U G I N S
  .enablePlugins(ScalaJSPlugin)

lazy val `mrpos-docs` = (project in file("mrpos-docs"))
  // S E T T I N G S
  .settings(Compile / scalaSource := baseDirectory.value / "src/main/mdoc")
  .settings(MdocSettings.value)
  .settings(Information.value)
  .settings(Settings.value)
  .settings(Settings.noAssemblyTest)
  .settings(crossScalaVersions := Nil)
  .settings(libraryDependencies ++= Dependencies.`mrpos-docs`)
  // P L U G I N S
  .enablePlugins(MdocPlugin)

lazy val `mrpos-web` = (project in file("mrpos-web"))
  // S E T T I N G S
  .settings(Information.value)
  .settings(Settings.value)
  .settings(Settings.noAssemblyTest)
  .settings(crossScalaVersions := Nil)
  .settings(libraryDependencies ++= Dependencies.`mrpos-web`)
  .settings(libraryDependencies += "me.shadaj" %%% "slinky-core" % "0.6.3")
  .settings(libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.6.3")
  .settings(libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.6.3")
  //.settings(libraryDependencies += "me.shadaj" %%% "slinky-docsMacros" % "0.6.3")
  .settings(libraryDependencies += "me.shadaj" %%% "slinky-react-router" % "1-5ee1000d")
  //.settings(libraryDependencies += "me.shadaj" %%% "slinky-history" % "0.6.3")
  .settings(Compile / npmDependencies ++= NpmDependencies.`mrpos-web`)
  .settings(Compile / npmDevDependencies ++= NpmDependencies.`dev-mrpos-web`)
  .settings(webpack / version := "4.5.0")
  .settings(startWebpackDevServer / version := "3.3.0")
  .settings(fastOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack-fastopt.config.js"))
  .settings(fullOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack-opt.config.js"))
  .settings(fastOptJS / webpackDevServerExtraArgs := Seq("--inline", "--hot"))
  .settings(fastOptJS / webpackBundlingMode := BundlingMode.LibraryOnly())
  .settings(scalacOptions ++= {
    if (scalaJSVersion.startsWith("0.6.")) Seq("-P:scalajs:sjsDefinedByDefault")
    else Nil
  })
  // P L U G I N S
  .enablePlugins(ScalaJSBundlerPlugin)
