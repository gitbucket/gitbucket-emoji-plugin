val Organization = "io.github.gitbucket"
val ProjectName = "gitbucket-emoji-plugin"
val ProjectVersion = "4.5.0-SNAPSHOT"

organization := Organization
name := ProjectName
version := ProjectVersion
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "io.github.gitbucket" %% "gitbucket"         % "4.12.0" % "provided",
  "javax.servlet"        % "javax.servlet-api" % "3.1.0"  % "provided"
)

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps")
javacOptions in compile ++= Seq("-target", "8", "-source", "8")

useJCenter := true
