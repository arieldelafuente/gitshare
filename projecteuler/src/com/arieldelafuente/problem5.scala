package com.arieldelafuente

/*
 * 2520 is the smallest number that can be divided by each of the 
 * numbers from 1 to 10 without any remainder. What is the smallest 
 * positive number that is evenly divisible by all of the numbers 
 * from 1 to 20?
 */
object problem5 {

  def main(args: Array[String]): Unit = {
    val prob = 20
    println(findthenumber(prob, prob))
  }
  
  def findthenumber(prob: Int, n: Long): Long = {
    if (n % prob != 0) findthenumber(prob,n+prob)
    else if (isdivto(n,prob)) return n
    else findthenumber(prob,n+prob)
  }
  
  def isdivto(n: Long, m: Int): Boolean = {
    println("n: " + n + ", m: " + m)
    if (m == 0) return true
    if (n % m == 0) isdivto(n,m-1) else false
  }

}