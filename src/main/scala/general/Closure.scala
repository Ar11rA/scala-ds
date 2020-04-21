package general

object Closure {
  var num = 10

  private val add = (x:Int) => x + num

  def main(args: Array[String]): Unit = {
    println(add(5))
    num = 15
    println(add(5))
  }
}
