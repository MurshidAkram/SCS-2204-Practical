object q3{
  import scala.math.BigDecimal.RoundingMode
  def average(num1: Int, num2: Int) : Double = {
    val average = BigDecimal((num1 + num2) / 2.0)
    average.setScale(2, RoundingMode.HALF_UP).toDouble
  }

  def main(args : Array[String]) : Unit = {
    val num1 = scala.io.StdIn.readLine().toInt
    val num2 = scala.io.StdIn.readLine().toInt

    val roundedAverage = average(num1, num2)

    println(s"Average rounded to two decimal places(floating point) = $roundedAverage")
  }
}

