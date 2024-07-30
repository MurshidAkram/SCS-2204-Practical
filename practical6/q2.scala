import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object q2{
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val (name, marks, totalMarks) = getStudentInfoWithRetry()
    val percentage = (marks.toDouble / totalMarks) * 100
    var grade = 'Z'
    if(percentage >= 90){
      grade = 'A'
    }
    else if(percentage >= 75){
      grade = 'B'
    }
    else if(percentage >= 50){
      grade = 'C'
    }
    else{
      grade = 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(studentRecord: (String,Int,Int,Double,Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = studentRecord
    println(s"Name: $name")
    println(s"Marks: $marks")
    println(s"Total Marks: $totalMarks")
    println(f"Percentage: $percentage")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty){
      (false, Some("Name cannot be empty."))
    } 
    else if(marks < 0 || totalMarks < 0){
      (false, Some("Marks and total marks must be positive"))
    } 
    else{
      (true, Some("Inputs entered are valid"))
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int) = {
    var valid = false
    var name = ""
    var marks = 0
    var totalMarks = 0

    while (!valid) {
      println("Enter student name:")
      name = readLine()
      println("Enter marks:")
      marks = readInt()
      println("Enter total marks:")
      totalMarks = readInt()

      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        valid = true
      } else {
        println(s"Invalid input $errorMessage")
      }
    }
    (name, marks, totalMarks)
  }

  def main(args: Array[String]): Unit = {
    val student = getStudentInfo()
    printStudentRecord(student)
  }
}

