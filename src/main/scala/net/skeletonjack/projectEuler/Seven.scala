package net.skeletonjack.projectEuler

import Three.isPrime

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the
 * 6th prime is 13.
 *
 * What is the 10,001st prime number?
 */
object Seven {

  def findTheNthPrime(n: Int): Int = {

    def countUpPrimes(curNum: Int, primes: List[Int]): Int = {
      if (primes.size == n)
        primes.reverse.head
      else {
        if (isPrime(curNum))
          countUpPrimes(curNum + 1, primes :+ curNum)
        else
          countUpPrimes(curNum + 1, primes)
      }
    }

    countUpPrimes(1, List())
  }

  def main(args: Array[String]) {
    println(s"The 10,001st prime is ${findTheNthPrime(10001)}")
  }

}
