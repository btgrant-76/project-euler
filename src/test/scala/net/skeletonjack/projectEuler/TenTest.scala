package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

import Ten._

class TenTest extends FunSuite {

  test("The sum of all primes below 10 is 17") {
    assert(sumAllPrimesLessThanNumber(10) === 17)
  }

  test("SOLUTION:  The sum of all primes below 2,000,000 is 142,913,828,922") {
    assert(sumAllPrimesLessThanNumber(2000000) === 142913828922L)
  }

  test("Obligatory call to main to boost test coverage") {
    Ten.main(Array("5"))
  }

}
