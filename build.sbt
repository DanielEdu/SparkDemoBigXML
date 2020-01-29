name := "xmlDemo"

version := "1.0"

scalaVersion := "2.11.12"

val sparkVersion = "2.3.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "com.databricks" %% "spark-avro" % "4.0.0",
  "org.apache.avro" % "avro" % "1.8.2",
  // https://mvnrepository.com/artifact/com.databricks/spark-xml
  "com.databricks" %% "spark-xml" % "0.5.0"   //Scala 2.11

)

mainClass in assembly := some("com.tdp.genesis.spark.xmlDemo")
assemblyJarName := "xmlDemo.jar"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}