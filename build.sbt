val Organization = "gitbucket"
val ProjectName = "gitbucket-emoji-plugin"
val ProjectVersion = "4.3.0"

organization := Organization
name := ProjectName
version := ProjectVersion
scalaVersion := "2.11.8"

resolvers ++= Seq(
  "amateras-repo" at "http://amateras.sourceforge.jp/mvn/",
  "amateras-snapshot-repo" at "http://amateras.sourceforge.jp/mvn-snapshot/"
)

libraryDependencies ++= Seq(
  "gitbucket"          % "gitbucket-assembly" % "4.3.0" % "provided",
  "javax.servlet"      % "javax.servlet-api"  % "3.1.0" % "provided"
)

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps")
javacOptions in compile ++= Seq("-target", "7", "-source", "7")
