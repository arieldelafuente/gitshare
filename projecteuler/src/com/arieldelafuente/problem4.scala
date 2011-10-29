package com.arieldelafuente

/*
 * A palindromic number reads the same both ways. The largest palindrome 
 * made from the product of two 2-digit numbers is 9009 = 91 99. Find the 
 * largest palindrome made from the product of two 3-digit numbers.
 */

object problem4 {

  def main(args: Array[String]): Unit = {
    val numdigits = 2
    
    listpals(numdigits, getlargestproduct(numdigits))  
  }
  
  def listpals(m: Int, n: BigInt) {
    val x = getnextpalindromefrom(n)
    val y = numscale(m-1)-1
    val z = numscale(m)
    
    if (!isprime(x,x)) {
      if (x == findfactor(x,x-1,y,z)) {
        println(x)
        return
      }
    }
    
    if (n > y) listpals(m,x-1)
  }
  
  def findfactor(m: BigInt, n: BigInt, minfac: BigInt, maxfac: BigInt): BigInt = {
    if (n == 1) return 0
    else 
      if (m % n == 0)
        if (pickfactor(n, minfac, maxfac) && pickfactor(m / n, minfac, maxfac)) 
          return m
        else findfactor(m, n - 1, minfac, maxfac) 
      else findfactor(m, n - 1, minfac, maxfac)
  }
  
  def pickfactor(n: BigInt, minfac: BigInt, maxfac: BigInt): Boolean = 
    (n > minfac && n < maxfac)
 
  def isprime(m: BigInt, n: BigInt): Boolean = {
    if (n == 2) return true
    else if (m % (n - 1) == 0) false else isprime(m, n - 1)
  }
  
  def getnextpalindromefrom(num: BigInt): BigInt = {
    if (num > 0) 
      if (ispalindrome(num)) num
      else getnextpalindromefrom(num-1)
    else
      getnextpalindromefrom(num-1)
  }
  

  def getlargestproduct(numdig: Int): BigInt = {
    val mpx = numscale(numdig)-1
    mpx * mpx
  }


  def numscale(n: Int): BigInt = if (n == 0) 1 else 10 * numscale(n-1)
  
  def ispalindrome(n: BigInt): Boolean = {
    val orig = pushdigitstolist(n,1).dropRight(1)
    val flip = orig.reverse
    orig == flip
  }
  
  def pushdigitstolist (m: BigInt, n: BigInt): List[BigInt] = {
    val a = n * 10
    val b = m / a
    val c = (m - (a * b)) / (a / 10)
    val d = m - (c * (a / 10))

    if (m > 0) c :: pushdigitstolist(d,a) else List(c)
  }
  
}