object q1{
	class RationalNumber(num: Int, denom: Int) {
     	require(denom != 0, "denominator must not be zero/undefined")
  
      	val numerator: Int = num
      	val denominator: Int = denom
  
      	def neg: RationalNumber = new RationalNumber(-numerator, denominator)
  
      	override def toString: String = s"$numerator/$denominator"
}

	def main(args: Array[String]): Unit = {
	println("Enter numerator: ")
	val num = scala.io.StdIn.readLine().toInt  
	println("Enter denominator: ")
	val den = scala.io.StdIn.readLine().toInt  
    	val x = new RationalNumber(num, den)
    	println(s"rational number: $x")       
    	println(s"negative rational number: ${x.neg}")   
	}
}


