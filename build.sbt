import com.typesafe.sbt.SbtGit._

name := "project euler"

version := "1.0"

scalaVersion := "2.11.1"

fork := true

javaOptions in Test += "-ea"

versionWithGit

showCurrentGitBranch

libraryDependencies ++= Seq("org.scalatest"    %% "scalatest"       % "2.2.0" % "test",
                            "org.assertj"      %  "assertj-core"    % "3.1.0" % "test",
                            "com.novocode"     %  "junit-interface" % "0.11"  % Test,
                            "com.google.guava" %  "guava"           % "18.0")

org.scalastyle.sbt.ScalastylePlugin.Settings

