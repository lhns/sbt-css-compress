organization := "de.lolhens"
name := "sbt-css-compress"
version := "0.0.1-SNAPSHOT"

enablePlugins(SbtPlugin)

addSbtPlugin("com.github.sbt" %% "sbt-web" % "1.5.5")

libraryDependencies += "com.yahoo.platform.yui" % "yuicompressor" % "2.4.8"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("https://github.com/LolHens/sbt-css-compress"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/LolHens/sbt-css-compress"),
    "scm:git@github.com:LolHens/sbt-css-compress.git"
  )
)
developers := List(
  Developer(id = "LolHens", name = "Pierre Kisters", email = "pierrekisters@gmail.com", url = url("https://github.com/LolHens/"))
)


scriptedLaunchOpts ++= Seq(
  "-Xmx1024M",
  "-Dplugin.version=" + version.value
)

scriptedBufferLog := false


Compile / doc / sources := Seq.empty

version := {
  val tagPrefix = "refs/tags/"
  sys.env.get("CI_VERSION").filter(_.startsWith(tagPrefix)).map(_.drop(tagPrefix.length)).getOrElse(version.value)
}

publishMavenStyle := true

publishTo := sonatypePublishToBundle.value

credentials ++= (for {
  username <- sys.env.get("SONATYPE_USERNAME")
  password <- sys.env.get("SONATYPE_PASSWORD")
} yield Credentials(
  "Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  username,
  password
)).toList
