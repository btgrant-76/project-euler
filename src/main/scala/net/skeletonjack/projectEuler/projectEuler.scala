package net.skeletonjack

import scala.annotation.tailrec

package object projectEuler {

  def isPrime(number: Long): Boolean = {

    if (number <= 1)
      false
    else {
      val sqrt: Double = Math.sqrt(number)

      def recursivelySearchForPrimes(divisor: Long): Boolean = {
        if (divisor > sqrt) {
          true
        } else if (number % divisor == 0) {
          false
        } else {
          recursivelySearchForPrimes(divisor + 1)
        }
      }

      recursivelySearchForPrimes(2L)
    }
  }

  def generatePrimes(goalEvaluator: (Long, Traversable[Long], Long) => Boolean)(goal: Long): Traversable[Long] = {

    @tailrec
    def accumulatePrimes(curNum: Long, accumulatedPrimes: Vector[Long]): Seq[Long] = {
      if (goalEvaluator(curNum, accumulatedPrimes, goal))
        accumulatedPrimes.toSeq
      else if (isPrime(curNum))
        accumulatePrimes(curNum + 1, accumulatedPrimes :+ curNum)
      else
        accumulatePrimes(curNum + 1, accumulatedPrimes)
    }

    accumulatePrimes(1L, Vector())
  }

}
