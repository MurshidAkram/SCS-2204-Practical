object q2{
  class RationalNumber(num: Int, denom: Int) {
      require(denom != 0, "Denominator must not be zero")

      val simplifier = gcd(num.abs, denom.abs)
      val numerator: Int = num / simplifier
      val denominator: Int = denom / simplifier

  
      def gcd(a: Int, b: Int): Int = {
        if (b == 0){
          a
        }
        else {
          gcd(b, a % b)
        }
      }

      def sub(that: RationalNumber): RationalNumber = {
        val newNum = this.numerator * that.denominator - that.numerator * this.denominator
        val newDenom = this.denominator * that.denominator
        new RationalNumber(newNum, newDenom)
      }


    def neg: RationalNumber = new RationalNumber(-numerator, denominator)

      override def toString: String = s"$numerator/$denominator"
}

def main(args: Array[String]): Unit = {
    val x = new RationalNumber(3, 4)   // x = 3/4
    val y = new RationalNumber(5, 8)   // y = 5/8
    val z = new RationalNumber(2, 7)   // z = 2/7

    val result = x.sub(y.sub(z))
    println(s"x - (y - z) = $result")
}
}
