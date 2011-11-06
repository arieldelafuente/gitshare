package com.arieldelafuente

import org.scalatest.FunSuite

class testeuler extends FunSuite {
  test("isprime is true on 2") { assert(euler.isprime(2)) }
  test("isprime is true on 29") { assert(euler.isprime(29)) }
  test("isprime is false on 36") { assert(!euler.isprime(36)) }
  test("isprime is false on a bigint 123456789012345678901234567890") { assert(!euler.isprime(BigInt("123456789012345678901234567890"))) }

  test("bigintsquareroot is 10 on 100") { expect(10) { euler.bigintsquareroot(100) } }
  
  test("sumofsq is 385 for first 10 numbers") { expect(385) { euler.sumofsq(10, 0) } }
  test("sqofsum is 3025 for first 10 numbers") { expect(3025) { euler.sqofsum(10, 0) } }

  test("get_nthtriangle is 28 when n is 7") { expect(28) { euler.get_nthtriangle(7,1) } }
  test("get_numofdivisors is 4 when n is 15") { expect(4) { euler.get_numofdivisors_ofn(15) } }  
  test("get_numofdivisors is 6 when n is 28") { expect(6) { euler.get_numofdivisors_ofn(28) } }
  test("get_numofdivisors is 2 when n is 13") { expect(2) { euler.get_numofdivisors_ofn(13) } }
  test("get_numofdivisors is 2 when n is 2") { expect(2) { euler.get_numofdivisors_ofn(2) } }
  test("get_numofdivisors is 5 when n is 100") { expect(9) { euler.get_numofdivisors_ofn(100) } }
}