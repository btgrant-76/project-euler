package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

import Six._

class SixTest extends FunSuite {

  test("The sum of the squares of the first ten natural numbers is 385") {
    assert(sumOfSquares(10) === 385)
  }

  test("The square of the sum of the first ten natural numbers is 3025") {
    assert(squareOfSums(10) === 3025)
  }

  test("The difference between the sum of squares and the square of sums of the first, ten, natural "
       + "numbers is 2640") {
    assert(differenceBetweenSumOfSquaresAndSquareOfSum(10) === 2640)
  }

  test("SOLUTION:  The difference between the sum of squares and the square of sums of the first, "
       + "ten, natural numbers is 25164150") {
    assert(differenceBetweenSumOfSquaresAndSquareOfSum(100) === 25164150)
  }

}
