sbt-css-compress
===========
[![Build Status](https://teamcity.lolhens.de/app/rest/builds/buildType:SbtCssCompress_Build/statusIcon.svg)](https://teamcity.lolhens.de/viewType.html?buildTypeId=SbtCssCompress_Build&guest=1)

[sbt-web] plugin which compresses CSS using [yuicompressor].

This is a fork of [ground5hark/sbt-css-compress]

Plugin
======
Add the plugin to your `project/plugins.sbt`:
```scala
addSbtPlugin("de.lolhens.sbt" % "sbt-css-compress" % "0.2.0")
```

Add the bintray resolver:
```scala
resolvers += Resolver.bintrayIvyRepo("lolhens", "sbt-plugins")
```

Enable the [sbt-web] plugin for your project:
```scala
lazy val root = (project in file(".")).enablePlugins(SbtWeb)
```

Add the `css-compress` task to your asset pipeline in your `build.sbt`:
```scala
pipelineStages := Seq(cssCompress)
```

Configuration options
=====================
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

License
=======
This code is licensed under the [MIT License].

[ground5hark/sbt-css-compress]:https://github.com/ground5hark/sbt-css-compress
[sbt-web]:https://github.com/sbt/sbt-web
[yuicompressor]:http://yui.github.io/yuicompressor/
[MIT License]:http://opensource.org/licenses/MIT
