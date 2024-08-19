object q3{
  def main(args: Array[String]): Unit = {
    val toUpper: String => String = _.toUpperCase
    val toLower: String => String = _.toLowerCase

    def formatNames(name: String, function: String => String): String = {
      function(name)
    }

    val benny = formatNames("Benny", toUpper)
    println(benny)

    val niroshan = formatNames("Niroshan", name => name.take(2).toUpperCase + name.drop(2))
    println(niroshan)

    val saman = formatNames("Saman", toLower)
    println(saman)

    val kumara = formatNames("Kumara", name => name.init + name.last.toUpper)
    println(kumara)
  }
}
