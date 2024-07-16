case class Book(title: String, author: String, isbn: String)

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object q2{
  val library: scala.collection.mutable.Set[Book] = scala.collection.mutable.Set(
    Book("book1", "auth1", "100"),
    Book("book2", "auth2", "200"),
    Book("book3", "auth3", "300")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Added book: ${book.title}")
  }

  def remove(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Removed book: ${book.title}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def isBookavailable(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def display(): Unit = {
    println("Books in library:")
    library.foreach { book =>
      println(s"Title:${book.title} Author:${book.author} ISBN:${book.isbn}")
    }
  }

  def searchBook(title: String): Unit = {
    library.find(_.title == title) match {
      case Some(book) =>
        println(s"Title:${book.title} Author:${book.author} ISBN:${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

  def displayByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author == author)
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    }
    else{
      println("No books by author")
    }
  }

  def main(args: Array[String]): Unit = {
    var input = true
    while (input) {
      println(
        """Enter following numbers for tasks
          1 - Display library
          2 - Add new book
          3 - Remove a book (ISBN)
          4 - Check whther book in library (ISBN)
          5 - Search for book (title)
          6 - Display books by author
          7 - Exit
          """
        )

      val choice = readInt()

      choice match {
        case 1 => 
          display()
        case 2 =>
          println("Enter title:")
          val title = readLine()
          println("Enter author:")
          val author = readLine()
          println("Enter ISBN:")
          val isbn = readLine()
          addBook(Book(title, author, isbn))
        case 3 =>
          println("Enter ISBN to remove book:")
          val isbn = readLine()
          remove(isbn)
        case 4 =>
          println("Enter ISBN to search:")
          val isbn = readLine()
          if(isBookavailable(isbn)){
            println(s"Book with ISBN $isbn is available.")
          } 
          else{
            println(s"Book with ISBN $isbn is not available.")
          }
        case 5 =>
          println("Enter title to search:")
          val title = readLine()
          searchBook(title)
        case 6 =>
          println("Enter author to search:")
          val author = readLine()
          displayByAuthor(author)
        case 7 => 
          input = false
        case _ => 
          println("Please enter number from list!")
      }
    }
  }
}
    
