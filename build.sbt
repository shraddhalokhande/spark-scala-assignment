// this file was written for spark 2.0.0 and scala 2.11.8

version := "1.0"

val sparkVersion = "3.1.1"

name := "spark-scala-assignment"

logBuffered in Test := false

scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-streaming-kinesis-asl" % sparkVersion

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
//libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.4.3_0.12.0" % "test"
libraryDependencies += "commons-io" % "commons-io" % "2.9.0"
libraryDependencies += "commons-cli" % "commons-cli" % "1.4"
libraryDependencies += "com.github.losizm" %% "little-cli" % "0.8.0"

fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")

parallelExecution in Test := false

import scalariform.formatter.preferences._

assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

