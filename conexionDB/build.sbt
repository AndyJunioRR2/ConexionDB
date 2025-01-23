ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "conexionDB",
    libraryDependencies ++= Seq(
      "mysql" % "mysql-connector-java" % "8.0.33", // Driver MySQL (reemplaza con la versión más reciente si es necesario)
      "org.slf4j" % "slf4j-simple" % "2.0.9" // Dependencia para el logging (opcional, pero recomendado)
    )
  )