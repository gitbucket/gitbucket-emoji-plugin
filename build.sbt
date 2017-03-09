val Organization = "io.github.gitbucket"
val ProjectName = "gitbucket-emoji-plugin"
val ProjectVersion = "4.4.0"

organization := Organization
name := ProjectName
version := ProjectVersion
scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "io.github.gitbucket" %% "gitbucket"         % "4.10.0" % "provided",
  "javax.servlet"        % "javax.servlet-api" % "3.1.0"  % "provided"
)

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps", "-opt:_")
javacOptions in compile ++= Seq("-target", "7", "-source", "7")

useJCenter := true
