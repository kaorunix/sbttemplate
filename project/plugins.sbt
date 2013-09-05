// -------------------------
// Eclipse
// -------------------------
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0")

// -------------------------
// IntelliJ IDEA
// -------------------------
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.3.0")

// -------------------------
// One Jar
// -------------------------
resolvers += Resolver.url(
  "sbt-plugin-releases",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/")
)(Resolver.ivyStylePatterns)

addSbtPlugin("com.github.retronym" % "sbt-onejar" % "0.8")

// -------------------------
// CoverageTool 
// -------------------------
resolvers += Classpaths.typesafeResolver

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"

addSbtPlugin("reaktor" % "sbt-scct" % "0.2-SNAPSHOT")
