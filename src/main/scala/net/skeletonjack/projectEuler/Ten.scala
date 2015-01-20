package net.skeletonjack.projectEuler

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
object Ten extends App {

  private def primesUnderNumber(number: Long): Seq[Long] = {

    def findPrimes(curNum: Long, primes: Set[Long]): Set[Long] = {
      if (curNum == number)
        primes
      else if (isPrime(curNum))
        findPrimes(curNum + 1, primes + curNum)
      else
        findPrimes(curNum + 1, primes)
    }

    findPrimes(1L, Set()).toSeq
  }

  def sumAllPrimesLessThanNumber(number: Long) = primesUnderNumber(number).sum

  println(s"The sum of the primes under ${args(0)} is ${sumAllPrimesLessThanNumber(args(0).toLong)}")

}
