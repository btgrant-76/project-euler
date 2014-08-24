import com.typesafe.sbt.SbtGit._

name := "project euler"

version := "1.0"

scalaVersion := "2.11.1"

versionWithGit

showCurrentGitBranch

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

org.scalastyle.sbt.ScalastylePlugin.Settings

