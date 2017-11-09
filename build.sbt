sbtPlugin := true

organization := "de.lolhens.sbt"

name := "sbt-css-compress"

version := "0.2.0"

resolvers ++= Seq(
  Resolver.bintrayIvyRepo("LolHens", "sbt-css-compress")
)

addCrossSbtPlugin("com.typesafe.sbt" %% "sbt-web" % "1.4.3")

libraryDependencies += "com.yahoo.platform.yui" % "yuicompressor" % "2.4.8"

bintrayReleaseOnPublish := false


def addCrossSbtPlugin(dependency: ModuleID): Setting[Seq[ModuleID]] =
  libraryDependencies += {
    val sbtV = (sbtBinaryVersion in pluginCrossBuild).value
    val scalaV = (scalaBinaryVersion in update).value
    Defaults.sbtPluginExtra(dependency, sbtV, scalaV)
  }


crossSbtVersions := Seq("0.13.16", "1.0.2")

scriptedSettings
scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  s"-Dproject.version=${version.value}"
)
//scriptedBufferLog := false
