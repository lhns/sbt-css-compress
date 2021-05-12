# sbt-css-compress

[![Test Workflow](https://github.com/LolHens/sbt-css-compress/workflows/test/badge.svg)](https://github.com/LolHens/sbt-css-compress/actions?query=workflow%3Atest)
[![Release Notes](https://img.shields.io/github/release/LolHens/sbt-css-compress.svg?maxAge=3600)](https://github.com/LolHens/sbt-css-compress/releases/latest)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.lolhens/sbt-css-compress/badge.svg)](https://search.maven.org/artifact/de.lolhens/sbt-css-compress)
[![Apache License 2.0](https://img.shields.io/github/license/LolHens/sbt-css-compress.svg?maxAge=3600)](https://opensource.org/licenses/MIT)
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)

This is a fork of [basedRNC/sbt-css-compress].

[sbt-web] plugin which compresses CSS using [yuicompressor].

## Plugin
Add the plugin to your `project/plugins.sbt`:
```scala
addSbtPlugin("de.lolhens" % "sbt-css-compress" % "0.2.0")
```

Enable the [sbt-web] plugin for your project:
```scala
lazy val root = (project in file(".")).enablePlugins(SbtWeb)
```

Add the `css-compress` task to your asset pipeline in your `build.sbt`:
```scala
pipelineStages := Seq(cssCompress)
```

## Configuration options
Option                | Description
----------------------|------------
cssCompressSuffix     | Extension to append to each compressed file. Defaults to `".min.css"`
cssCompressParentDir  | Parent directory name where compressed CSS will go. Defaults to `""`, which outputs the file into the base target directory
cssCompressLineBreak  | Number of characters on a line before attempting to insert a line break. This is merely a hint to the compressor. Defaults to `-1` (never)

An example of providing an option is below:

```scala
cssCompressSuffix := ".min.css"
```

This will produce assets with the specified `cssCompressSuffix` suffix value under the `cssCompressParentDir`
directory within the `target` folder. This will be `target/web/public/main` or `target/web/stage`. You can also specify
`includeFilter in cssCompress` or `excludeFilter in cssCompress` to select files on a custom criteria.

## License
This code is licensed under the [MIT License].

[basedRNC/sbt-css-compress]:https://github.com/basedRNC/sbt-css-compress
[sbt-web]:https://github.com/sbt/sbt-web
[yuicompressor]:http://yui.github.io/yuicompressor/
[MIT License]:http://opensource.org/licenses/MIT
