package com.arieldelafuente

object project19 extends Application {

/* You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * 
 * A leap year occurs on any year evenly divisible by 4, but not on a 
 * century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth 
 * century (1 Jan 1901 to 31 Dec 2000)?
 */
  
 //4
  
 var dow = 2
 var ans = 0
 
 for {y <- 1900 to 2000
	  m <- 1 to 12
	  d <- 1 to numDays(m,y)} {
	  
	  if (y >= 1901) ans = ans + (if (d == 1 && dow == 1) 1 else 0)
	  println(y + "/" + m + ": " + d + " / " + dow)
	  dow = if (dow == 7) 1 else dow + 1
 }
	  println(ans)
 	
 def leapyr(yr: Int): Int = {
   if (yr % 100 == 0) if (yr % 400 == 0) 1 else 0
   else if (yr % 4 == 0) 1 else 0
 }

 def numDays(mo: Int, yr: Int): Int = {
   val days = List(0,31,28,31,30,31,30,31,31,30,31,30,31)
   if (mo != 2) days(mo) else days(2) + leapyr(yr)
 }

}
