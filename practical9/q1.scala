object q1{
  def interestCalculate(deposit: Double): Double = {
    val interest: Double => Double = {
      case amount if amount <= 20000 => amount * 0.02
      case amount if amount <= 200000 => amount * 0.04
      case amount if amount <= 2000000 => amount * 0.035
      case amount if amount > 2000000 => amount * 0.065
    }
    interest(deposit)
  }

  def main(args: Array[String]): Unit = {
    var flag = true

    while(flag){
      print("Enter deposit amount to calculate interest(press Enter to finish): ")
      val input = scala.io.StdIn.readLine()
      if(input.isEmpty){
        flag = false
      }
      else{
        try{
          val deposit = input.toInt
          val interest = interestCalculate(deposit)
          println(s"Interst for deposit $deposit is $interest")
        }
        catch{
          case e: NumberFormatException => println("Input amount is invalid")
        }
      }
    }
  }
}
