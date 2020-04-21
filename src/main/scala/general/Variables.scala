package general

object Variables extends App {

  //  Basic
  val s1: Boolean = true
  val s2: String = "demo"
  val s3: Byte = '1'
  val s4: Char = 'a'
  val s5: Double = 2.345
  val s6: Any = "anything"
  val s7: Float = 1.2f
  val s8:Int = s5.toInt + s7.toInt
  println(s"Printing randomly $s4 $s1 $s2 $s6 " +  s5 + s3 + s8)

  // Lazy -> memory only assigned when x is used
  lazy val x = 500

}
