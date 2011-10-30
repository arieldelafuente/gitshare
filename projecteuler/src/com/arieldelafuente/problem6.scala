package com.arieldelafuente

/*
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the 
 * first ten natural numbers and the square of the 
 * sum is 3025 - 385 = 2640
 * 
 * Find the difference between the sum of the squares of the 
 * first one hundred natural numbers and the square of the sum.
 */

object problem6 {

  def main(args: Array[String]): Unit = {
    val prob = 100

    println(sqofsum(prob,0)-sumofsq(prob,0))
  }
  
  def sumofsq(m: Int, n: Long): BigInt = {
    if (m == 0) return n
    else sumofsq(m - 1, n + (m*m))
  }
  
  def sqofsum(m: Int, n: Long): BigInt = {
    if (m == 0) n*n
    else sqofsum(m - 1, n + m)
  }

}

