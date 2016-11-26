val Organization = "io.github.gitbucket"
val ProjectName = "gitbucket-emoji-plugin"
val ProjectVersion = "4.4.0"

organization := Organization
name := ProjectName
version := ProjectVersion
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "io.github.gitbucket" %% "gitbucket"         % "4.7.0" % "provided",
  "javax.servlet"        % "javax.servlet-api" % "3.1.0" % "provided"
)

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps", "-Ybackend:GenBCode", "-Ydelambdafy:method", "-target:jvm-1.8")
javacOptions in compile ++= Seq("-target", "7", "-source", "7")
