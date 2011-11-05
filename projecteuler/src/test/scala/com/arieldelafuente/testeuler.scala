package com.arieldelafuente

import org.scalatest.FunSuite

class testeuler extends FunSuite {
  test("isprime is true on 2") { assert(euler.isprime(2)) }
  test("isprime is true on 29") { assert(euler.isprime(29)) }
  test("isprime is false on 36") { assert(!euler.isprime(36)) }
  test("isprime is false on a bigint 123456789012345678901234567890") { assert(!euler.isprime(BigInt("123456789012345678901234567890"))) }

  test("bigintsquareroot is 10 on 100") { expect(10) { euler.bigintsquareroot(100) } }
  
  test("sumofsq is 385 for first 10 numbers") { expect(385) { euler.sumofsq(10, 0) } }
  test("sqofsum is 3025 for first 10 numbers") { expect(385) { euler.sumofsq(10, 0) } }

}