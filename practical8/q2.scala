object q2{
  def patternmatch: Int => String = {
    case num if num % 3 == 0 && num % 5 == 0 => "Multiple of both Three and Five"
    case num if num % 3 == 0  => "Multiple of Three"
    case num if num % 5 == 0 => "Multiple of Five"
    case _ => "Not a Multiple of Three or Five"
  }

  def main(args: Array[String]): Unit = {
    if(args.length < 1 || args.length > 1){
      println("Invalid input(only one integer!")
      sys.exit(1)
    }
    else{
      try{
      val num = args(0).toInt
      println(patternmatch(num))
        }
      catch{
        case _: NumberFormatException =>
          println("input was not an integer!")
          sys.exit(1)
        }
    }
  }
}


