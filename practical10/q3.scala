case class Account(accountID: Int, balance: Double) {
//deposit
  def deposit(amount: Double): Account = {
    require(amount > 0, "Deposit must be positive")
    this.copy(balance = this.balance + amount)
  }
//withdraw
  def withdraw(amount: Double): Account = {
    require(amount > 0, "amount must be positive")
    require(this.balance >= amount, "Insufficient balance")
    this.copy(balance = this.balance - amount)
  }
//transfer
  def transfer(amount: Double, to: Account): (Account, Account) = {
    require(amount > 0, "Transfer must be positive")
    require(this.balance >= amount, "Insufficient balance")
    val fromUpdate = this.withdraw(amount)
    val toUpdate = to.deposit(amount)
    (fromUpdate, toUpdate)
  }
}

object q3{
  def main(args: Array[String]) : Unit = {
    val a1 = Account(1, 1000)
    val a2 = Account(2, 500)

  println(s"Initial balance: account 1 = ${a1.balance}, account 2 = ${a2.balance}")

  val a1AfterDeposit = a1.deposit(500)
  println(s"account 1 balance (after deposit): ${a1AfterDeposit.balance}")

  val a2AfterWithdraw = a2.withdraw(200)
  println(s"After withdrawal, account 2 balance: ${a2AfterWithdraw.balance}")

  val (a1AfterTransfer, a2AfterTransfer) = a1AfterDeposit.transfer(150, a2AfterWithdraw)
  println(s"After transfer: account 1 balance = ${a1AfterTransfer.balance}, account 2 balance = ${a2AfterTransfer.balance}")
  }
}


