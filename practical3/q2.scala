object q2{
  def findLongStrings(list : List[String]): List[String] = {
    list.filter(_.length > 5)
  }

  def main(args : Array[String]) : Unit = {
    val list : List[String] = List("cat", "dog", "elephant", "tiger")
    val longStringList = findLongStrings(list)
    println(longStringList)
  }
}

