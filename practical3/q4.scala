object q4{
  def addEvenNum(numList: List[Int]): Int = {
    val evenList = numList.filter(_%2 == 0)
    evenList.sum
  }

  def main(args: Array[String]): Unit = {
    val numList: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val sum = addEvenNum(numList)
    println(s"Sum of even Numbers in the list= $sum")
  }
}


