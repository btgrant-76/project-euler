package net.skeletonjack.projectEuler

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 */
object Three {

  def calculateFactors(number: Long): List[Long] = {

    def accumulateFactors(potentialFactor: Long, factors: List[Long]): List[Long] = {
      if (factors.contains(potentialFactor))
        factors
      else if (number % potentialFactor == 0) {
        val pairedFactor = number / potentialFactor
        accumulateFactors(potentialFactor + 1, factors :+ potentialFactor :+ pairedFactor)
      } else
        accumulateFactors(potentialFactor + 1, factors)
    }

    accumulateFactors(1L, List()).sorted
  }

  def calculatePrimeFactors(number: Long): List[Long] = {
    calculateFactors(number).filter(isPrime).toList.sorted
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis()
    val largestPrimeFactor = calculatePrimeFactors(600851475143L).max

    println(s"Largest, prime factor of 600851475143 is $largestPrimeFactor")
    println("completed after " + (System.currentTimeMillis() - start))
  }

}
