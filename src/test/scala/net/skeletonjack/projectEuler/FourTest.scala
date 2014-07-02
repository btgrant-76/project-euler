package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

class FourTest extends FunSuite {

  test("Testing numbers that are palindromic") {
    val palindromicNumbers = List(9009, 90109)
    assert(palindromicNumbers.size === palindromicNumbers.filter(Four.isPalindromic).size)
  }

  test("Testing numbers that are not palindromic") {
    val palindromicNumbers = List(1234, 90190)
    assert(palindromicNumbers.filter(Four.isPalindromic).isEmpty)
  }

}
