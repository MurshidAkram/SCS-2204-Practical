object q5{
  def countLetterOccurrences(words: List[String]): Int = {
    val wordLengths = words.map(_.length)
    val total = wordLengths.reduce(_ + _)
    total
  }

  def main(args: Array[String]): Unit = {
    val list = List("apple", "banana", "cherry", "date")
    val total = countLetterOccurrences(list)
    println(s"Total count of occurrences: $total")
  }
}

