package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Fifa extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
  val spark = SparkSession.builder
    .master("local[*]")
    .appName("Spark Fifa Analysis")
    .getOrCreate()
  val sc = spark.sparkContext
  var fifaRdd = sc.textFile("./src/main/resources/fifa.csv")
  val header = fifaRdd.first()
  var rows = fifaRdd.filter(d => d != header)
  var collated = rows.map(r => (r.split(",")(2), r.split(",")(9), r.split(",")(7), r.split(",")(8)))
  var filtered = collated.filter(c => c._2 == "FC Barcelona")
  val sorted = filtered.sortBy(_._3, false)
  println(sorted.first())

}
