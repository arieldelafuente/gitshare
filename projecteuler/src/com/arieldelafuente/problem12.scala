package com.arieldelafuente

object problem12 {

  def main(args: Array[String]): Unit = {

    println(findtriangle(1))
  }

  def findtriangle(m: BigInt): BigInt = {
    val t = trinum(m, 1)
    println(t)
    if (getnumdivisors(t, t - 1) > 5) return m
    else return findtriangle(m + 1)
  }

  def trinum(m: BigInt, n: BigInt): BigInt = {
    if (n == m) return n
    else return (trinum(m, n + 1) + n)
  }

  def getnumdivisors(m: BigInt, n: BigInt): Int = {
    if (n < 1) return 1

    if (isprime(m)) return 2
    else
      return (if (m % n == 0) 1 else 0) + getnumdivisors(m, n - 1)
  }

  def isprime(n: BigInt): Boolean = fprimality(n, bigintsquareroot(n))

  def bigintsquareroot(m: BigInt): BigInt = fsquareroot(m, 1)

  def fprimality(m: BigInt, n: BigInt): Boolean = {
    if (List(2, 3, 5).contains(m)) return true

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