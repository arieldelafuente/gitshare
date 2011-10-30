package com.arieldelafuente

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the 
 * sum of all the primes below two million.
 */

object problem10 {

  def main(args: Array[String]): Unit = {
    val prob = 2000000
    recursive1(prob,2,0)
  }
  
  def recursive1 (m: BigInt, n: BigInt, p: BigInt) {
    if (n >= m) return
    else {
      println("m: " + m + ", n: " + n + ", p: " + p)
      val q = p + (if (isprime(n)) n else 0)
      recursive1(m,n+1,q)
    }
  }

  def isprime(n: BigInt): Boolean = fprimality(n,bigintsquareroot(n))
  
  def bigintsquareroot(m: BigInt): BigInt = fsquareroot(m,1)

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
      val res = ((n/g + g)/2)            
      if (g == res) g else fsquareroot(n+1,res)
    } else g
  }    
  
  
}