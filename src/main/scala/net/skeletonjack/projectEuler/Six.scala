package net.skeletonjack.projectEuler

/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the
 * square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and
 * the square of the sum.
 */
object Six {

  def sumOfSquares(maxNumber: Int): Int = {
    (1 to maxNumber).foldLeft(0) { (total: Int, nextNumber: Int) =>
      total + square(nextNumber)
    }
  }

  def square(number: Int): Int = {
    number * number
  }

  def squareOfSums(maxNumber: Int): Int = {
    square((1 to maxNumber).foldLeft(0) { (total: Int, nextNumber: Int) =>
      total + nextNumber
    })
  }

  def differenceBetweenSumOfSquaresAndSquareOfSum(maxNumber: Int): Int = {
    squareOfSums(maxNumber) - sumOfSquares(maxNumber)
  }


  def main(args: Array[String]) {
    println(s"The difference between the sum of the squares of the first one hundred natural numbers " +
            s"and the square of the sum is ${differenceBetweenSumOfSquaresAndSquareOfSum(100)}")
  }


}
