package com.arieldelafuente

import org.scalatest.FunSuite

class testhelloworld extends FunSuite {

  test("shout says HELLO with hello") { expect("HELLO") {helloworld.shout("hello")} }
}