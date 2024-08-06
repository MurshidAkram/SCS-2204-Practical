object q2{
  def calculateSquare(list: List[Int]): List[Int] = {
    list.map(num=> num * num)
  }

  def main(args: Array[String]): Unit = {
      var numList = List[Int]()
      var flag = true

      while(flag){
        print("Enter numbers(press Enter to finish): ")
        val input = scala.io.StdIn.readLine()
        if(input.isEmpty){
          flag = false
        }
        else{
          try{
            val num = input.toInt
            numList = numList :+ num
          }
          catch{
            case e: NumberFormatException => println("No. is not valid")
          }
        }
      }

      val squareList = calculateSquare(numList)
      println(squareList)
  }
}
  
