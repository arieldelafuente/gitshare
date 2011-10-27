package com.arieldelafuente

/*
 * Problem 3 http://projecteuler.net/problem=3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

object problem3 {

  def main(args: Array[String]): Unit = {
    println(lpf1(600851475143L))
  }
  
  def isprime(n: BigInt): Boolean = {
    for(i <- n-1 to 2 by -1) if(n % i == 0) return false
    return true
  }
  
  def lpf1(n: BigInt): BigInt = {
    for(i <- n-1 to 2 by -1) if(n % i == 0 && isprime(i)) return i
    return n
  }
}