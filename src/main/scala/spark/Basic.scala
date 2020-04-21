package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Basic extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
  val spark = SparkSession.builder
    .master("local[*]")
    .appName("Spark Basic MRF")
    .getOrCreate()
  val sc = spark.sparkContext
  var arr: Array[Int] = sc.parallelize(1 to 100, 5).collect()
  var result = arr
    .map(i => i + 5)
    .filter(i => i % 2 == 0)
    .sum // OR .reduce(_+_)
  println(result)

}
