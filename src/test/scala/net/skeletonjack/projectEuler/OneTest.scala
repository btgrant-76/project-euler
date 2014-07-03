package net.skeletonjack.projectEuler

import org.scalatest.FunSuite
import One._

class OneTest extends FunSuite {

  test("1 is a multiple of 1") {
    def multipleOf1 = isMultipleOf(1) _
    assert(multipleOf1(1))
  }

  test("5 is not a multiple of 2") {
    def isMultipleOf2 = isMultipleOf(2)_
    assert(!isMultipleOf2(5))
  }

  test("12 and 8 are multiples of 4") {
    def isMultipleOf4 = isMultipleOf(4)_
    assert(isMultipleOf4(12))
    assert(isMultipleOf4(8))
  }

  test ("3, 6 and 9 are multiples of 3") {
    val multiplesOf3 = (1 to 10).filter(isMultipleOf3)
    assert(List(3, 6, 9) === multiplesOf3)
  }

  test("5 and 10 are multiples of 5") {
    val multiplesOf5 = (1 to 10).filter(isMultipleOf5)
    assert(List(5, 10) === multiplesOf5)
  }

  test("sum of multiples of 3 and 5 less than 10 equal 23") {
    val sumOfMultiples = sumMultiplesOf3And5(10)
    assert(23 === sumOfMultiples)
  }

  test("sum of multiples of 3 & 5 less that 4 is 3") {
    val sumOfMultiples = sumMultiplesOf3And5(4)
    assert(3 === sumOfMultiples)
  }

  test("sum of multiples of 3 & 5 less that 1 is 0") {
    val sumOfMultiples = sumMultiplesOf3And5(1)
    assert(0 === sumOfMultiples)
  }

  test("SOLUTION: sum of multiples of 3 & 5 less that 1,000 is 233,168") {
    val sumOfMultiples = sumMultiplesOf3And5(1000)
    assert(233168 === sumOfMultiples)
  }

}
