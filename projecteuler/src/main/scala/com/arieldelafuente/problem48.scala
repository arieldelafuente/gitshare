package com.arieldelafuente

/*
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

object problem48 extends Application {
  
  println(sumseries(1000))
  
  def bigintpow(b: Int, e: Int): BigInt = {
    if (e == 0) 1
    else b * bigintpow(b,e-1)
  }
  
  def sumseries(n: Int): BigInt = {
    if (n == 1) 1
    else bigintpow(n,n) + sumseries(n - 1)
  }
}
