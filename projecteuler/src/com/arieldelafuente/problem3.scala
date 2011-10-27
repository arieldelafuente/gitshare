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

  def isprime(m: BigInt, n: BigInt): Boolean = {
    if (n == 2) return true
    else if (m % (n - 1) == 0) false else isprime(m, n - 1)
  }

  def findfactors(m: BigInt, n: BigInt): BigInt = {
    if (n == 1) return m
    else 
      if (m % n == 0) 
        if (isprime(n, n)) return n
        else return findfactors(m, n - 1)
      else return findfactors(m, n - 1)
  }
  
  def bigintsquareroot(m: BigInt): BigInt = funcsquareroot(m,1)
  
  def funcsquareroot(n: BigInt, g: BigInt): BigInt = {    
    if (n > 0) {     
      val res = ((n/g + g)/2)            
      if (g == res) g else funcsquareroot(n,res)
    } else g
  }  
  
}