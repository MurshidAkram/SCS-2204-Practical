case class Product(id: Int, name: String, quantity: Int, price: Double)

object q1{
  val inventory1: Map[Int, Product] = Map(
    1 -> Product(1, "cat", 10, 10),
    2 -> Product(2, "dog", 5, 20),
    3 -> Product(3, "bat", 15, 5)
  )
  
  val inventory2: Map[Int, Product] = Map(
    2 -> Product(2, "cat", 3, 30),
    4 -> Product(4, "rat", 7, 15)
  )

  def getNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  def getTotal(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  def checkEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  def merge(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    (inventory1.keySet ++ inventory2.keySet).map { id =>
      val product1 = inventory1.get(id)
      val product2 = inventory2.get(id)
      val merged = (product1, product2) match {
        case (Some(p1), Some(p2)) =>
          Product(id, p1.name, p1.quantity + p2.quantity, math.max(p1.price, p2.price))
        case (Some(p), None) => p
        case (None, Some(p)) => p
        case(None, None) =>throw new Exception("not applicable")
      }
      id -> merged
    }.toMap
  }

  def printifExist(inventory: Map[Int, Product], id: Int): Unit = {
    inventory.get(id) match {
      case Some(product) => println(s"Product: $product")
      case None => println("Product does not exist.")
    }
  }

  def main(args: Array[String]): Unit = {
    val names = getNames(inventory1)
    println(s"Products in Inventory 1: $names")

    val total = getTotal(inventory1)
    println(s"Total value of inventory1: $total")

    val isEmpty = checkEmpty(inventory1)
    println(s"inventory 1 empty or not: $isEmpty")

    val merged = merge(inventory1, inventory2)
    println("Merged inventory: " + merged)
    printifExist(inventory1, 1)
    printifExist(inventory2, 5)
  }
}


