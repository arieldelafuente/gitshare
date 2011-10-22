/*
* Problem 1 http://projecteuler.net/problem=1
* If we list all the natural numbers below 10 that are multiples of 3 or 5, 
* we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of 
* all the multiples of 3 or 5 below 1000.
*/

object problem1 {
  def main(args: Array[String]): Unit = {
    println(summultiplesof5and3(9))
    println(summultiplesof5and3(999))
  }
  
  def summultiplesof5and3(tonum: Int): Int = {
    var thesum = 0
    for (i <- 1 to tonum) { 
      thesum += (if (i%5 == 0 || i%3 == 0) i else 0) 
    }
    return thesum
  }
}