package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

import Seven._

class SevenTest extends FunSuite {

  test("13 is the 6th prime") {
    assert(13 === findTheNthPrime(6))
  }

  test("SOLUTION:  104743 is the 10,001st prime") {
    assert(104743 === findTheNthPrime(10001))
  }

}
