# sbt-css-compress
[![Test Workflow](https://github.com/LolHens/sbt-css-compress/workflows/test/badge.svg)](https://github.com/LolHens/sbt-css-compress/actions?query=workflow%3Atest)
[![Release Notes](https://img.shields.io/github/release/LolHens/sbt-css-compress.svg?maxAge=3600)](https://github.com/LolHens/sbt-css-compress/releases/latest)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.lolhens/sbt-css-compress/badge.svg)](https://search.maven.org/artifact/de.lolhens/sbt-css-compress)
[![Apache License 2.0](https://img.shields.io/github/license/LolHens/sbt-css-compress.svg?maxAge=3600)](https://opensource.org/licenses/MIT)

[sbt-web] plugin which compresses CSS using [yuicompressor].

This is a fork of [basedRNC/sbt-css-compress]

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
