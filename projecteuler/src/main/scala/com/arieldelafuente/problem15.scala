package com.arieldelafuente

object problem15 extends Application {
  val gridsize = 20
  val nummoves = 40
  
  println(euler.factorial(nummoves) / (euler.factorial(gridsize) * euler.factorial(gridsize)))
}
