val Organization = "io.github.gitbucket"
val ProjectName = "gitbucket-emoji-plugin"
val ProjectVersion = "4.5.0"
val GitBucketVersion = Option(System.getProperty("gitbucket.version")).getOrElse("4.18.0")

organization := Organization
name := ProjectName
version := ProjectVersion
scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "io.github.gitbucket" %% "gitbucket"         % GitBucketVersion % "provided",
  "javax.servlet"        % "javax.servlet-api" % "3.1.0"          % "provided"
)

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps")
javacOptions in compile ++= Seq("-target", "8", "-source", "8")

useJCenter := true
