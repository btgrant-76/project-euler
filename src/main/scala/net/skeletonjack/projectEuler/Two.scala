package net.skeletonjack.projectEuler

object Two {

  def generateFibonacciTerms(stopCollectingAt: Int, filter: Int => Boolean = _ => true): List[Int] = {

    def accumulateFibonacciTerms(currentTerm: Int, previousTerm: Int, collectedTerms: List[Int]): List[Int] = {
      val newTerm = currentTerm + previousTerm

      if (newTerm >= stopCollectingAt)
        collectedTerms
      else
        accumulateFibonacciTerms(newTerm, currentTerm, if (filter(newTerm))
                                                         collectedTerms :+ newTerm
                                                       else
                                                         collectedTerms
        )

    }

    accumulateFibonacciTerms(1, 0, List())
  }

  def main(args: Array[String]) {
    val evenFibTerms = generateFibonacciTerms(4000000, _ % 2 == 0)
    val totalOfEvenFibTerms = evenFibTerms.sum

    println(s"The total of all, even Fibonacci terms less than 4,000,000 is $totalOfEvenFibTerms.")
  }

}
