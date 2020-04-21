package general

object Looping extends App {
  var ctr: Int = 1

  println("While")
  while (ctr < 10) {
    print(ctr)
    ctr += 1
  }

  println("Do While")
  // execute at least once
  do {
    print(ctr)
    ctr += 1
  } while(ctr < 9)

  // No ++ or -- operators in scala
  println("for loops")
  for (i <- 1 to 5) { // 1.to(5)
    print(i)
  }

  for (i <- 1 until 5) { // 1.to(5)
    print(i)
  }

  println("Nested")
  for (i <- 1 to 4; j <- 1 to 3) {
    print(s"$i and $j \t")
  }

  // List
  var lst = List(1,2,3,4)
  for (i <- lst) {
    print(i)
  }
  for (i <- lst; if i < 3) {
    print(i)
  }
}

