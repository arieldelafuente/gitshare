package com.arieldelafuente

object euler {
  def isprime(n: BigInt): Boolean = fprimality(n, bigintsquareroot(n))

  def bigintsquareroot(m: BigInt): BigInt = fsquareroot(m, 1)

  def sumofsq(m: Int, n: Long): BigInt = if (m == 0) n else sumofsq(m - 1, n + (m * m))

  def sqofsum(m: Int, n: Long): BigInt = if (m == 0) (n * n) else sqofsum(m - 1, n + m)

  private def fprimality(m: BigInt, n: BigInt): Boolean = {
    if (List(2, 3, 5).contains(m)) return true
    if (m % 2 == 0 || m % 5 == 0) return false
    if (n == 2) return true
    if (n == 1) return false
    if (m % n == 0) return false
    else return fprimality(m, n - 1)
  }

  private def fsquareroot(n: BigInt, g: BigInt): BigInt = {
    if (n > 0) {
      val res = ((n / g + g) / 2)
      if (g == res) g else fsquareroot(n + 1, res)
    } else g
  }
}