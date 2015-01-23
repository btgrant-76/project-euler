package net.skeletonjack.projectEuler

import org.scalatest.FunSuite
import Four._

class FourTest extends FunSuite {

  test("Testing numbers that are palindromic") {
    val palindromicNumbers = List(9009, 90109)
    assert(palindromicNumbers.size === palindromicNumbers.count(isPalindromic))
  }

  test("Testing numbers that are not palindromic") {
    val nonPalindromicNumbers = List(10, 421, 1234, 90190, 5015, 4992, 9702)
    assert(nonPalindromicNumbers.filter(isPalindromic).isEmpty)
  }

  test("All multiples of 2 to 4") {
    // 2, 3, 4
    val multiples = List(6, 8, 12)
    assert(calculateMultiples(2, 4) === multiples)
   }

  test("All multiples of two digits must contain 9009") {
    val multiplesOfAllNumbersWithTwoDigits = calculateMultiples(10, 99)
    assert(multiplesOfAllNumbersWithTwoDigits.contains(9009))
  }

  test("Use of a filter results in a smaller list of multiples") {
    val multiplesOfAllNumbersWithTwoDigits = calculateMultiples(10, 99)
    val filteredMultiplesOfAllNumbersWithTwoDigits = calculateMultiples(10, 99, multiplesFilter = isPalindromic)

    assert(filteredMultiplesOfAllNumbersWithTwoDigits.size < multiplesOfAllNumbersWithTwoDigits.size)
  }

  test("SOLUTION:  The largest palindrome made from the product of two 3-digit numbers is 906609") {
    assert(906609 === calculateMultiples(100, 999, multiplesFilter = isPalindromic).max)
  }

  test("Obligatory call to main to boost test coverage") {
    Four.main(Array())
  }

}
