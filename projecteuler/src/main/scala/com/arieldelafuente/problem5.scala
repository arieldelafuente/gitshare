package com.arieldelafuente

/*
 * 2520 is the smallest number that can be divided by each of the 
 * numbers from 1 to 10 without any remainder. What is the smallest 
 * positive number that is evenly divisible by all of the numbers 
 * from 1 to 20?
 */

object problem5 extends Application {
  val prob = 20
  println(smallest_num_div_by_1tomax(prob, prob))

  def smallest_num_div_by_1tomax(max: Int, n: Long): Long = {
    if (n % max != 0) smallest_num_div_by_1tomax(max, n + max)
    else if (isdivto(n, max)) return n
    else smallest_num_div_by_1tomax(max, n + max)
  }

  def isdivto(n: Long, m: Int): Boolean = {
    if (m == 0) return true
    if (n % m == 0) isdivto(n, m - 1) else false
  }

}
