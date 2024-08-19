object q2{
  def main(args: Array[String]): Unit = {
    if(args.length != 1){
      println("incorrect argument provided")
      System.exit(1)
    }

    val input = args(0).toInt

    val patternMatch = (num: Int) => num match {
      case n if n <= 0 => "Negative/Zero is input"
      case x if x % 2 == 0 => "Even Number is given"
      case _ => "Odd Number is given"
    }

    println(patternMatch(input))
  }
}
