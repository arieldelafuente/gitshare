package com.arieldelafuente

object problem14 extends Application {

  var longest: Long = 0
  var ans: Long = 999999

  for (i <- 999999 to 1 by -1) {
    val sq = getseq(i)
    ans = if (sq > longest) i else ans
    longest = if (sq > longest) sq else longest
  }
  println(ans)

  def getseq(n: Long): Long = {
    if (n == 1) return 0
    else {
      val sq = if (n % 2 == 0) (n / 2) else (3 * n) + 1
      return getseq(sq) + 1
    }
  }
}
