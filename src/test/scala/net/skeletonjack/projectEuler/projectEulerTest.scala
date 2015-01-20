package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

class projectEulerTest extends FunSuite {

  test("3, 11 & 17 are prime") {
    assert(isPrime(3))
    assert(isPrime(11))
    assert(isPrime(17))
  }

  test("4 & 38 are not prime") {
    assert(!isPrime(4))
    assert(!isPrime(38))
  }


}
