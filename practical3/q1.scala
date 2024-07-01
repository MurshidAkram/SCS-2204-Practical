object q1{
  def reverse(string: String) : String = {
    if(string.isEmpty){
      ""
    }
    else{
      reverse(string.tail) + string.head
    }
  }

  def main(args: Array[String]): Unit = {
    val original = scala.io.StdIn.readLine()
    val reversed = reverse(original)
    println(s"Original Entered String: $original")
    println(s"Reversed String: $reversed")
  }
}

