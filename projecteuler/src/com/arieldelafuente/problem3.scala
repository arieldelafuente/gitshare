package com.arieldelafuente

/*
 * Problem 3 http://projecteuler.net/problem=3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

object problem3 {

  def main(args: Array[String]): Unit = {
    println(findlargestprimefactor(600851475143L))
  }

  def findlargestprimefactor(m: BigInt): BigInt = findfactors(m, bigintsquareroot(m))

  def isprime(n: BigInt): Boolean = fprimality(n, bigintsquareroot(n))
  
  def bigintsquareroot(m: BigInt): BigInt = fsquareroot(m, 1)

  def findfactors(m: BigInt, n: BigInt): BigInt = {
    if (n == 1) return m
    else if (m % n == 0)
      if (isprime(n)) return n
      else return findfactors(m, n - 1)
    else return findfactors(m, n - 1)
  }

  def fprimality(m: BigInt, n: BigInt): Boolean = {
    if (List(2,3,5).contains(m)) return true
    
    if (m % 2 == 0 || m % 5 == 0) return false
        
    if (n == 2) return true
    
    if (n == 1) return false
    
    if (m % n == 0) return false 
    else return fprimality(m, n - 1)
  }

  def fsquareroot(n: BigInt, g: BigInt): BigInt = {
    if (n > 0) {
      val res = ((n / g + g) / 2)
      if (g == res) g else fsquareroot(n + 1, res)
    } else g
  }

}