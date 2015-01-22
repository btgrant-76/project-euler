package net.skeletonjack.projectEuler

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
object Ten extends App {

  private def primesUnder = generatePrimes((curNum: Long, primes: Traversable[Long], goal: Long) =>
    curNum == goal)_

  private def primesUnderNumber(number: Long): Traversable[Long] = {
    primesUnder(number)
  }

  def sumAllPrimesLessThanNumber(number: Long) = primesUnderNumber(number).sum

  println(s"The sum of the primes under ${args(0)} is ${sumAllPrimesLessThanNumber(args(0).toLong)}")

}
