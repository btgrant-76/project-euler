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

  def calculateSmallestMultipleOfAllNumbers(start: Int, end: Int): Int = {

    val numbers = (start until end).toList

    def countUp(number: Int): Int = {
      val next = number * end
      if (numberIsDivisibleByAllDivisors(next, numbers))
        next
      else
        countUp(number + 1)
    }

    countUp(1)
  }

  def main(args: Array[String]) {
    println(calculateSmallestMultipleOfAllNumbers(1, 20) + " is the smallest number divisible by all numbers from 1 to 20")
  }

}
