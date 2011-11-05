package com.arieldelafuente

/*
 * A palindromic number reads the same both ways. The largest palindrome 
 * made from the product of two 2-digit numbers is 9009 = 91 99. Find the 
 * largest palindrome made from the product of two 3-digit numbers.
 */

object problem4 extends Application {
  val numdigits = 3

  list_palindromes(numdigits, getlargestproduct(numdigits))

  def list_palindromes(m: Int, n: BigInt) {
    val x = getnextpalindrome_from(n)
    val y = ten_power_of(m - 1) - 1
    val z = ten_power_of(m)

    if (!euler.isprime(x)) {
      if (x == findfactor_ofm_inminmax(x, x - 1, y, z)) {
        println(x)
        return
      }
    }
    if (n > y) list_palindromes(m, x - 1)
  }

  def findfactor_ofm_inminmax(m: BigInt, n: BigInt, minfac: BigInt, maxfac: BigInt): BigInt = {
    if (n == 1) return 0
    else if (m % n == 0)
      if (pickfactor(n, minfac, maxfac) && pickfactor(m / n, minfac, maxfac))
        return m
      else findfactor_ofm_inminmax(m, n - 1, minfac, maxfac)
    else findfactor_ofm_inminmax(m, n - 1, minfac, maxfac)
  }

  def pickfactor(n: BigInt, minfac: BigInt, maxfac: BigInt): Boolean =
    (n > minfac && n < maxfac)

  def getnextpalindrome_from(num: BigInt): BigInt = {
    if (num > 0)
      if (ispalindrome(num)) num else getnextpalindrome_from(num - 1)
    else
      getnextpalindrome_from(num - 1)
  }

  def getlargestproduct(power: Int): BigInt = {
    val mpx = ten_power_of(power) - 1
    mpx * mpx
  }

  def ten_power_of(n: Int): BigInt = if (n == 0) 1 else 10 * ten_power_of(n - 1)

  def ispalindrome(n: BigInt): Boolean = {
    val orig = pushdigits_of_m_tolist(n, 1).dropRight(1)
    val flip = orig.reverse
    orig == flip
  }

  def pushdigits_of_m_tolist(m: BigInt, n: BigInt): List[BigInt] = {
    val a = n * 10
    val b = m / a
    val c = (m - (a * b)) / (a / 10)
    val d = m - (c * (a / 10))

    if (m > 0) c :: pushdigits_of_m_tolist(d, a) else List(c)
  }

}
