package net.skeletonjack

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

}
