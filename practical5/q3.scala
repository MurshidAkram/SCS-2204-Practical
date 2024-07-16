object q3{
  def fibonacci(num: Int): Int = {
    if(num <= 0){
      0
    }
    else if(num == 1){
      1
    }
    else{
      fibonacci(num - 1) + fibonacci(num - 2)
    }
  }

  def fibonacciSequence(n: Int): Unit = {
    if(n > 0){
      fibonacciSequence(n - 1)
    }
     println(fibonacci(n))
  }

  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readInt()
    fibonacciSequence(num)
  }
}
