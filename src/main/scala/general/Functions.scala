package general

object Functions extends App {
  // Basic
  def isPrime(n: Int): Boolean = {
    var ctr : Integer = 0
    for(i <- 2 until n) {
      if (n % i == 0) ctr += 1
    }
    if (ctr == 0) return true
    return false
  }
  println(isPrime(23))
  println(isPrime(24))

  // Anonymous & named
  var add = (x: Int, y: Int) => x + y
  println(add(5,6))
  println(isPrime(add(5,6)))

  // HOF
  def math(x: Double, y:Double, f:(Double,Double) => Double): Double = f(x,y)
  var result = math(10.0, 12.0, (x, y) => x/y)
  println(result)
  result = math(10.0, 12.0, _*_)
  println(result)

  // Partial Apply
  var f = add(10, _:Int)
  println(f(30))
}
