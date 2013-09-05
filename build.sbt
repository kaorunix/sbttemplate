organization := "org.colibrifw"

name := "sbttemplate"

version := "0.1.0"

scalaVersion := "2.10.0"

parallelExecution in Test := false

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "tokyotyrant" at "http://zact.googlecode.com/svn/maven/repository",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "org.specs2" %% "specs2" % "1.13" % "test",
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.1",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.1",
  "mysql" % "mysql-connector-java" % "5.1.10",
  "org.slf4j" % "slf4j-api" % "1.7.1",
  "ch.qos.logback" % "logback-classic" % "1.0.7",
  "com.github.nscala-time" %% "nscala-time" % "0.2.0",
  "com.google.protobuf" % "protobuf-java" % "2.5.0",
  "javax.transaction" % "jta" % "1.1",
  "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0",
  "com.jsuereth" %% "scala-arm" % "1.3",
  "com.typesafe" % "config" % "0.4.0",
  "commons-codec" % "commons-codec" % "1.7",
  "redis.clients" % "jedis" % "2.1.0",
  "com.github.seratch"     %% "scalikejdbc"                     % "1.6.0",
  "com.github.seratch"     %% "scalikejdbc-config"              % "1.6.0",
  "com.github.seratch"     %% "scalikejdbc-interpolation"       % "1.6.0",
  "com.github.seratch"     %% "scalikejdbc-test"                % "1.6.0"            % "test",
  "org.slf4j"              %  "slf4j-simple"                    % "[1.7,)",
  "org.mockito"            %  "mockito-core"                    % "1.9.5"            % "test",
  "net.databinder" %% "dispatch-core" % "0.8.9",
  "net.databinder" %% "dispatch-http" % "0.8.9",
  "net.databinder" %% "dispatch-nio" % "0.8.9",
  "net.databinder" %% "dispatch-json" % "0.8.9",
  "org.msgpack" % "msgpack" % "0.6.7"
)

scalacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-encoding", "UTF-8")

// CoverageTool
seq(ScctPlugin.instrumentSettings : _*)

// Specs2:JUnit:XmlReport
testOptions in Test += Tests.Argument("junitxml", "console")

publishArtifact in (Compile, packageDoc) := true

// One-jar
seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

mappings in oneJar <<= (mappings in oneJar).map { old: Seq[(File, String)] =>
  old.filterNot(_._1.getName == "slf4j-log4j12-1.4.3.jar")
}

libraryDependencies += "commons-lang" % "commons-lang" % "2.6"
