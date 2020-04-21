package general

// Not using the app trait here; instead using the main fn approach
object StringInterpolation {
  def main(args: Array[String]) {

    // Basic
    val str1 = "Real"
    val str2 = "Deal"
    println(str1 + " " + str2)
    println(s"$str1 $str2")
    println(s"$str1\n$str2")
    println(raw"$str1 \n $str2")

    // Functions
    println(str1.length())
    println(str1.charAt(0))
    println(str1.concat(str2))
    println(str1.contains(str2.substring(1,3)))
    println("%s-%s".format(str1, str2))
  }
}
