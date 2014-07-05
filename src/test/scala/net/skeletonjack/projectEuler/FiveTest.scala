package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

import Five._

/**
 * Created by brian on 7/5/14.
 */
class FiveTest extends FunSuite {

  test("8 is divisible by 2") {
    assert(numberIsDivisibleByAllDivisors(8, List(2)))
  }

  test("8 is divisible by 2 and 4 and 1") {
    assert(numberIsDivisibleByAllDivisors(8, List(2, 4, 1)))
  }

  test("10 is not divisible by 3") {
    assert(!numberIsDivisibleByAllDivisors(10, List(3)))
  }

  test("10 is divisible by 2 and 5 but not 3") {
    assert(!numberIsDivisibleByAllDivisors(10, List(2, 5, 3)))
  }

  test("2520 is divisible by all numbers from 1 to 10") {
    assert(numberIsDivisibleByAllDivisors(2520, (1 to 10).toList))
  }


}
