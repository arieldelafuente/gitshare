package com.arieldelafuente

object euler {
  
  def factorial(n: BigInt): BigInt = if(n == 0) 1 else n * factorial(n-1)
  
  def get_numofdivisors_ofn(n: BigInt): Int = {
    var facts: List[BigInt] = List()
    var divsr: BigInt = 1
        
    while (divsr <= bigintsquareroot(n)) {
      if (n % divsr == 0) facts = (n / divsr) :: divsr :: facts
      divsr += 1
    }
    return facts.length
  }

  def get_nthtriangle(n: BigInt, p: BigInt): BigInt = if (p == n) p else (get_nthtriangle(n, p + 1) + p)

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