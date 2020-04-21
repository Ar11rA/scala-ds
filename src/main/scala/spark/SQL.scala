package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

// Datasets explored here
object SQL extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
  val spark = SparkSession
    .builder()
    .master("local[1]")
    .appName("SQL")
    .getOrCreate()
  val reader = spark.read
  val responses = reader
    .option("header", true)
    .option("inferSchema", value = true)
    .csv("./src/main/resources/fifa.csv")

  responses.printSchema()

  val allPlayers = responses.select("Name", "Age", "Overall", "Potential", "Club", "Nationality", "Position", "Value")
  println(allPlayers.count())

  val highPotentialPlayers = allPlayers.filter(allPlayers.col("Potential") >= 90 && allPlayers.col("Age") <= 22)

  highPotentialPlayers.sort("Value").show()
  highPotentialPlayers.orderBy(asc("Position"), desc("Value")).show()

  //  import spark.implicits._ -> convert RDD to DS
  //  sorted.toDS()
}
