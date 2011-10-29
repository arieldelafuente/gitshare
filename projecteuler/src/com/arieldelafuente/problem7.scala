package com.arieldelafuente

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13. What is the 10001st prime 
 * number?
 */

object problem7 {

  def main(args: Array[String]): Unit = {
    val prob = 10001
    
    println(findnthprime(prob,1,2))
  }
  
  def findnthprime(p: Int, n: Int, q: BigInt): BigInt = {
    if (n == p) q else findnthprime(p,n+1,findnextprimeafter(q))
  }
  
  def findnextprimeafter(n: BigInt): BigInt = {
    val x = n + 1
    
    if (isprime(x)) return x else return findnextprimeafter(x)
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