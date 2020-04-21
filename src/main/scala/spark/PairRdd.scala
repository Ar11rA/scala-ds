package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object PairRdd extends App {
  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
  val spark = SparkSession.builder
    .master("local[*]")
    .appName("Spark Pair RDD")
    .getOrCreate()
  val sc = spark.sparkContext
  val tuple = List(("A", 1), ("B", 2), ("C", 3), ("A", 4), ("A", 3))
  val pairRDD = sc.parallelize(tuple)

  println("Map")
  // Map Values
  var mapped = pairRDD.mapValues(d => d * 10)
  mapped.foreach(println)

  println("Filter")
  // filter Values
  var filtered = mapped.filter(d => d._2 % 3 != 0)
  filtered.foreach(println)

  println("ReduceByKey sum")
  // Reduce by key
  var sum = filtered.reduceByKey((x, y) => x + y)
  sum.foreach(println)

  println("GroupByKey group")
  // Reduce by key
  var group = filtered.groupByKey()
  group.foreach(println)
  var m = group.collectAsMap()
  println(m)

  // properties
  var rdd = sc.textFile("./src/main/resources/properties.csv")
  val header = rdd.first()
  var rows = rdd.filter(d => d != header)
  var paired = rows.map(r => (r.split(",")(3), (1, r.split(",")(2).toDouble)))
  var totalPrice = paired.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
  totalPrice.foreach(println)
  println("TOTAL PRICE")
  totalPrice.foreach(p => {
      println("%s : %e".format(p._1, p._2._2/p._2._1))
  })

}


