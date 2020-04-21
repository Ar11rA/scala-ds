package general

object Match extends App {
  val points = 40
  points match {
    case 10 => println("1")
    case 20 => println("2")
    case 30 => println("3")
    case 40 => println("4")
    case 50 => println("5")
    case _ => println("!")
  }

  val result = points match {
    case 10 => "1"
    case 20 => "2"
    case 30 => "3"
    case 40 => "4"
    case 50 => "5"
    case _ => "!"
  }
  println(result)

  points match {
    case 10|20|30 => println("1")
    case 40|50 => println("2")
    case _ => println("!")
  }

}
