package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object FileOps extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)

  def filterer(i:String): Boolean = {
    val data = i.split(",")
    return data(3).contains("\"United States\"") && data(6).toFloat > 60
  }

  def mapper(i: String): String = {
    val details = i.split(",")
    return details(1) + "-" + details(2)
  }

  val spark = SparkSession.builder
    .master("local[*]")
    .appName("Spark File Basic")
    .getOrCreate()
  val sc = spark.sparkContext
  var rdd = sc.textFile("./src/main/resources/airports.txt")
  println(rdd.collect().length)
  var updatedRdd = rdd
    .filter(filterer)
    .map(mapper)
  updatedRdd.foreach(println)
  println(updatedRdd.collect().length)
}
