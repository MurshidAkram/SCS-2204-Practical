object q3{

  def filterPrime(list: List[Int]): List[Int] = {
    list.filter(num=>checkPrime(num))
  } 

  def checkPrime(num: Int): Boolean = {
    if(num <= 1){
      false
    }
    if(num == 2){
      true
    }
    for(i <- 2 to math.sqrt(num).toInt){
      if(num % i == 0){
        false
      }
    }
    true
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
              case e: NumberFormatException => println("Number is not valid")
            }
          }
        }

        val primeList = filterPrime(numList)
        println(primeList)
    }
}
