libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.6.4"

sys.props.get("plugin.version") match {
  case Some(version) => addSbtPlugin("de.lolhens" %% "sbt-css-compress" % version)
  case _ => sys.error(
    """|The system property 'plugin.version' is not defined.
       |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
}
