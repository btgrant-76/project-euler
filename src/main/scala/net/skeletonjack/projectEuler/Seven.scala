package net.skeletonjack.projectEuler

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the
 * 6th prime is 13.
 *
 * What is the 10,001st prime number?
 */
object Seven {

  private def nthPrime = generatePrimes((curNum: Long, primes: Traversable[Long], goal: Long) =>
      primes.size == goal)_

  def findTheNthPrime(n: Int): Long = {
    nthPrime(n).max
  }

  def main(args: Array[String]) {
    println(s"The 10,001st prime is ${findTheNthPrime(10001)}")
  }

}
