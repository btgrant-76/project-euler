package net.skeletonjack.projectEuler

/**
 *  A palindromic number reads the same both ways. The largest palindrome made from the product of
 *  two 2-digit numbers is 9009 = 91 × 99.
 *
 *  Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Four {

  def allProducts(start: Int, end: Int): List[Int] = {
    List(1)
  }

  def isPalindromic(number: Int): Boolean = {
    val numberString = number.toString

    val testableNumberString = if (numberString.length % 2 == 0)
      numberString
    else {
      numberString.substring(0, numberString.size / 2)
      numberString.substring(0, numberString.size / 2) + numberString.substring(numberString.size / 2 + 1)
    }

    val halves = testableNumberString.splitAt(testableNumberString.size / 2)
    halves._1.equals(halves._2.reverse)
  }

  def calculateMultiples(start: Int, end: Int, multiples: List[Int] = List(), multiplesFilter: Int => Boolean = {x: Int => true}): List[Int] = {
    if (start == end)
      multiples
    else {
      val curMultiples: List[Int] = (start + 1 to end).foldLeft(multiples) { (multiples: List[Int], num: Int) =>
        multiples :+ (num * start)
      }.filter(multiplesFilter)
      val filteredMultiples = curMultiples.filter(multiplesFilter)

      calculateMultiples(start + 1, end, filteredMultiples, multiplesFilter)
    }
  }

  def main(args: Array[String]) {
    val largestPalindromicNumber = calculateMultiples(100, 999, multiplesFilter = isPalindromic).max
    println(s"Largest palindromic multiple for all numbers with three digits is $largestPalindromicNumber")
  }

}
