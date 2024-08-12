object q1{
  def encrypt(text: String, key: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        var base = '0'
        if(char.isLower){
          base = 'a'
        }
        else{
          base = 'A'
        }
        ((char - base + key) % 26 + base).toChar
      } 
      else{
        char
      }
    }
  }

  def decrypt(text: String, key: Int): String = {
    encrypt(text, 26 - key)
  }

  def cipher(text: String, key: Int, function: (String, Int) => String): String = {
    function(text, key)
  }
  
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      println("Enter a String to encrypt/decrypt(Enter to finish): ")
      val input = scala.io.StdIn.readLine()
      if(input.isEmpty){
        flag = false
      }
      else{
        println("Enter key/shift value: ")
        val key = scala.io.StdIn.readInt()
        println("Choose 1 - Encryption or 2 - Decryption: ")
        val choice = scala.io.StdIn.readInt()
        val result = choice match{
          case 1 => cipher(input, key, encrypt)
          case 2 => cipher(input, key, decrypt)
          case _ => "invalid option"
        }
        println(s"Result = $result")
      }
    }
  }
}

