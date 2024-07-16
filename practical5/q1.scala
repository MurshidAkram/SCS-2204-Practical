object q1{
  def getProductList(): List[String] = {
    def collector(counter: List[String]): List[String] = {
      println("Enter names of products(Press done when finished)")
      val input = scala.io.StdIn.readLine()
      if(input == "done"){
        counter
      }
      else{
        collector(counter:+ input)
      }
    }
    collector(List.empty)
  }

  def printProductList(products: List[String]): Unit = {
    def recursive(products: List[String], i: Int): Unit = {
      if(products.nonEmpty){
        println(s"index: ${i + 1} Product: ${products.head}")
        recursive(products.tail, i + 1)
      }
    }
    recursive(products, 0)
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    printProductList(productList)
    val total = getTotalProducts(productList)
    println(s"Total no. of products is $total")
  }
}

