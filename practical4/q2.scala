object q2{
  def main(args: Array[String]): Unit = {
    if(args.length != 1){
      println("incorrect argument provided")
      System.exit(1)
    }

    val num = args(0).toInt

    if(num < 0){
      println("Negative")
    }
    else if(num == 0){
      println("zero")
    }
    else{
      println("positive")
    }
  }
}




