package com.arieldelafuente

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
 * which divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a <> b, then a and b are an amicable pair and 
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 
 * and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 
 * 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

object problem21 extends Application {

  val n = 10000
  println(sumofintlist(getall_amicable_under(n-1)))
  
  def getall_amicable_under(n: Int): List[Int] = {
    if (n == 0) List()
    else {
      if (amicable(n)) n :: getall_amicable_under(n - 1) 
      else getall_amicable_under(n - 1)
    }
  }

  def amicable(a: Int): Boolean = {
    val b = d(a)
    if (b != 0 && b != a) (d(b) == a) else false
  }

  def sumofintlist(l: List[Int]): Int = {
    var sum = 0
    l.foreach((n: Int) => sum += n)
    return sum
  }

  def d(n: Int): Int = {
    def properdivisors(n: Int, m: Int): List[Int] = {
      if (m == 0)
        List()
      else if (n % m == 0) m :: properdivisors(n, m - 1)
      else properdivisors(n, m - 1)
    }

    if (euler.isprime(n)) return 0 else return sumofintlist(properdivisors(n, n - 1))
  }

}
