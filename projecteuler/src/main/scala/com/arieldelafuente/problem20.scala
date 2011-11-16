package com.arieldelafuente

/*
 * n! means n  (n  1)  ...  3  2  1
 * For example, 10! = 10  9  ...  3  2  1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */

object problem20 extends Application{
  val f = euler.factorial(100)
  println(add_digits_of_m(f,1))
  
  def add_digits_of_m(m: BigInt, n: BigInt): BigInt = {
    val a = n * 10
    val b = m / a
    val c = (m - (a * b)) / (a / 10)
    val d = m - (c * (a / 10))

    if (m > 0) c + add_digits_of_m(d, a) else c
  }
}
