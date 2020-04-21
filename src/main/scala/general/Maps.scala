package general

object Maps extends App {
  var hash: Map[Int, Int] = Map(1 -> 2, 2 -> 4)
  println(hash(2))

  val s = Seq("apple", "oranges", "apple", "banana", "apple", "oranges", "oranges")
  println(s.groupBy(identity).mapValues(_.size))

  println(hash.keys)
  println(hash.values)

  hash.keys.foreach{ k =>
    println(k + " : " + hash(k))
  }
}
