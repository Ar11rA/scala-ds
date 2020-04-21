package general

object ArrayAndList extends App {
  var arr: Array[Int] = new Array[Int](5)
  arr(0) = 1
  arr(1) = 2
  arr(2) = 3
  arr(3) = 4
  arr(4) = 5
  println("Basic array")
  for (i <- arr) {
    print(i)
  }
  println()

  // linked list
  val lst: List[Int] = List(1, 2)
  // lst(0) not possible
  println(lst)
  println(0::lst)
  println(lst.head)
  println(lst.tail)
  println(lst.isEmpty)
}
