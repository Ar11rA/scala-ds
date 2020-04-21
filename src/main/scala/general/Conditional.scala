package general

object Conditional extends App {
  def getMax(x: Int, y: Int):Int = {

    // With braces
    //    if(x > y) {
    //      return x
    //    }
    //    return y

    // without braces
     if(x > y) return x
     return y
  }
  println(getMax(2,3))
  println(getMax(4,3))
}
