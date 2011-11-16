package com.arieldelafuente

/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */

object problem16 extends Application {

  val twopow = biginttwopow(1000)
  println(add_digits_of_m(twopow,1))
  
  def biginttwopow(e: Int): BigInt = {
    if (e == 0) 1
    else 2 * biginttwopow(e-1)
  }
  
  def add_digits_of_m(m: BigInt, n: BigInt): BigInt = {
    val a = n * 10
    val b = m / a
    val c = (m - (a * b)) / (a / 10)
    val d = m - (c * (a / 10))

    if (m > 0) c + add_digits_of_m(d, a) else c
  }
}
