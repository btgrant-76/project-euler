package net.skeletonjack.projectEuler

import org.scalatest.FunSuite
import Two._

class TwoTest extends FunSuite {

  test("All Fibonacci terms less than 90") {
    val fibTermsUnder90 = generateFibonacciTerms(90)
    assert(List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89) === fibTermsUnder90)
  }

  test("Fibonacci terms less than 90 and divisible by 3") {
    val fibTermsUnder90DivisibleBy3 = generateFibonacciTerms(90, _ % 3 == 0)
    assert(List(3, 21) === fibTermsUnder90DivisibleBy3)
  }

  test("Fibonacci terms less than 90 and are even") {
    val evenFibTermsUnder90 = generateFibonacciTerms(90, _ % 2 == 0)
    assert(List(2, 8, 34) === evenFibTermsUnder90)
  }

  test("SOLUTION:  The total of all even Fibonacci terms less than 4,000,000 is 4,613,732") {
    assert(4613732 === generateFibonacciTerms(4000000, _ % 2 == 0).sum)
  }

}
