package com.arieldelafuente

/*
 * Problem 3 http://projecteuler.net/problem=3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

object problem3 extends Application {

  println(findlargestprimefactor(600851475143L))

  def findlargestprimefactor(m: BigInt): BigInt = findfactorsofm(m, euler.bigintsquareroot(m))

  private def findfactorsofm(m: BigInt, n: BigInt): BigInt = {
    if (n == 1) return m
    else if (m % n == 0)
      if (euler.isprime(n)) return n
      else return findfactorsofm(m, n - 1)
    else return findfactorsofm(m, n - 1)
  }

}
