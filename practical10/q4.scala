case class Account(id: Int, balance: Double) {
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
  def interest: Account = {
    if (balance > 0) this.deposit(balance * 0.05)
    else{
      this.copy(balance = balance - (balance * 0.1))
    }
  }
}

case class Bank(accounts: List[Account]) {

  //Accounts with negative balances
  def negativeAccounts: List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest: Bank = {
    Bank(accounts.map(_.interest))
  }
}


object q4{
  def main(args: Array[String]): Unit = {
  val a1 = Account(1, 500)
  val a2 = Account(2, -200)
  val a3 = Account(3, 1000)
  val a4 = Account(4, -50)

  val bank = Bank(List(a1, a2, a3, a4))

  //accounts with negative balances
  println("Accounts with negative balance:")
  bank.negativeAccounts.foreach(acc => println(s"${acc.id}: ${acc.balance}"))

  val totalBalance = bank.totalBalance
  println(s"\nTotal balance of all accounts: $totalBalance")

  //final balances after interest
  val afterInterest = bank.applyInterest
  println("\nBalances after applying interest:")
  afterInterest.accounts.foreach(acc => println(s"${acc.id}: ${acc.balance}"))
  }
}



