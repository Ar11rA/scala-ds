package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object WordCount extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
  val spark = SparkSession.builder
    .master("local[*]")
    .appName("Spark Word Count")
    .getOrCreate()
  val sc = spark.sparkContext
  val lines = sc.parallelize(
    Seq("Spark Intellij Idea Scala test one",
      "Spark Intellij Idea Scala test two",
      "Spark Intellij Idea Scala test three"))

  val counts = lines
    .flatMap(line => line.split(" "))
    .map(word => (word, 1))
    .reduceByKey(_ + _)

  counts.foreach(println)
}
