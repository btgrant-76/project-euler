package net.skeletonjack.projectEuler

import org.scalatest.FunSuite
import Three._

class ThreeTest extends FunSuite {

  test("1 & 3 are factors of 3") {
    val factorsOf3 = List(1, 3)
    assert(factorsOf3 === calculateFactors(3))
  }

  test("1, 2, 4 & 8 are factors of 8") {
    val factorsOf8 = List(1, 2, 4, 8)
    assert(factorsOf8 === calculateFactors(8))
  }

  test("1, 3, 5 & 15 are factors of 15") {
    val factorsOf15 = List(1, 3, 5, 15)
    assert(factorsOf15 === calculateFactors(15))
  }

  test("factors of 600851475143") {
    val factors = List(1, 71, 839, 1471, 6857, 59569, 104441, 486847, 1234169, 5753023, 10086647, 87625999, 408464633, 716151937, 8462696833L, 600851475143L)
    assert(factors === calculateFactors(600851475143L))
  }

  test("Other factors ...") {
    // http://www.mathsisfun.com/numbers/factors-all-tool.html#calc
    assert(calculateFactors(5000) === List(1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 625, 1000, 1250, 2500, 5000))
    assert(calculatePrimeFactors(5000) === List(2, 5))

    assert(calculateFactors(56789000) === List(1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 109, 125, 200, 218, 250, 436, 500, 521, 545, 872, 1000, 1042, 1090, 2084, 2180, 2605, 2725, 4168, 4360, 5210, 5450, 10420, 10900, 13025, 13625, 20840, 21800, 26050, 27250, 52100, 54500, 56789, 65125, 104200, 109000, 113578, 130250, 227156, 260500, 283945, 454312, 521000, 567890, 1135780, 1419725, 2271560, 2839450, 5678900, 7098625, 11357800, 14197250, 28394500, 56789000))
    assert(calculatePrimeFactors(56789000) === List(2, 5, 109, 521))
  }

  test("The prime factors of 13195 are 5, 7, 13 and 29") {
    val primeFactorsOf13195 = List(5, 7, 13, 29)
    assert(primeFactorsOf13195 === calculatePrimeFactors(13195))
  }

  test("SOLUTION:  The largest, prime factor of 600851475143 is 6857") {
    assert(6857 === calculatePrimeFactors(600851475143L).max)
  }

}
