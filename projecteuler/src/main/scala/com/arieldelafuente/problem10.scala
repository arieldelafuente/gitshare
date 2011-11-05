package com.arieldelafuente

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the 
 * sum of all the primes below two million.
 */

object problem10 extends Application {

  val prob = 2000000
  sumof_primes_to_m(prob, 2, 0)

  def sumof_primes_to_m(m: BigInt, n: BigInt, p: BigInt) {
    if (n >= m) return
    else {
      val q = p + (if (euler.isprime(n)) n else 0)
      sumof_primes_to_m(m, n + 1, q)
    }
  }

}
