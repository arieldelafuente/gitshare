package com.arieldelafuente

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, 
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred 
 * and forty-two) contains 23 letters and 115 (one hundred and fifteen) 
 * contains 20 letters. The use of "and" when writing out numbers is in 
 * compliance with British usage.
 */

object problem17 extends Application {

  println(sumwordchar(1000))

  def sumwordchar(n: Int): Long = if (n == 0) 0 else toword(n).length() + sumwordchar(n - 1)

  def toword(n: Int): String = {
    def ones = List("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
    def totwenty = ones ::: List("eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    def tens = List("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
    def hundred = "hundred"
    def thousand = "thousand"

    def towordthou(n: Int): String = if (n > 999) ones(n / 1000) + "thousand" else ""
    def towordhund(n: Int): String = if (n > 99) ones(n / 100) + "hundred" else ""
    def british_and(n: Int): String = if (n / 100 != 0 && n % 100 != 0) "and" else ""
    def towordtens(n: Int): String = if (n > 19) tens((n / 10) - 2) else ""
    def towordones(n: Int): String = if (n > 19) ones(n % 10) else totwenty(n)

    return towordthou(n) +
      towordhund(n - (n / 1000 * 1000)) +
      british_and(n) +
      towordtens(n - (n / 100 * 100)) +
      towordones(n - (n / 100 * 100))
  }

}
