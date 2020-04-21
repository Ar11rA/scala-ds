package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

case class Quote(Id: BigInt, Author: String, Quote: String)

object Json extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("json")
    .getOrCreate()
  val reader = spark.read

  // dataframe approach
  val df = reader.json("./src/main/resources/quotes.json")
  df.show()
  df.printSchema()
  df.filter(df.col("Id") > 100).show()

  // typesafe dataset approach
  import spark.implicits._
  val ds = df.as[Quote]
  ds.filter(s => s.Id > 100).show()
}
