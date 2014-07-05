package net.skeletonjack.projectEuler

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Five {

  def numberIsDivisibleByAllDivisors(number: Int, divisors: List[Int]): Boolean = divisors match {
    case Nil => true
    case head :: tail => {
      if (number % head == 0)
        numberIsDivisibleByAllDivisors(number, tail)
      else
        false
    }
  }

}
