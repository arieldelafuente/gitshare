package com.arieldelafuente

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13. What is the 10001st prime 
 * number?
 */

object problem7 extends Application {
  val n = 10001

  println(find_nthprime(n, 1, 2))

  def find_nthprime(p: Int, n: Int, q: BigInt): BigInt = {
    if (n == p) q else find_nthprime(p, n + 1, find_nextprime_aftern(q))
  }

  def find_nextprime_aftern(n: BigInt): BigInt = {
    val m = n + 1

    if (euler.isprime(m)) return m else return find_nextprime_aftern(m)
  }

}
