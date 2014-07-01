package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

class ThreeTest extends FunSuite {

  test("3, 11 & 17 are prime") {
    assert(Three.isPrime(3))
    assert(Three.isPrime(11))
    assert(Three.isPrime(17))
  }

  test("4 & 38 are not prime") {
    assert(!Three.isPrime(4))
    assert(!Three.isPrime(38))
  }

  test("1 & 3 are factors of 3") {
    val factorsOf3 = List(1, 3)
    assert(factorsOf3 === Three.calculateFactors(3))
  }

  test("1, 2, 4 & 8 are factors of 8") {
    val factorsOf8 = List(1, 2, 4, 8)
    assert(factorsOf8 === Three.calculateFactors(8))
  }

  test("1, 3, 5 & 15 are factors of 15") {
    val factorsOf15 = List(1, 3, 5, 15)
    assert(factorsOf15 === Three.calculateFactors(15))
  }

  test("factors of 600851475143") {
    val factors = List(1, 71, 839, 1471, 6857, 59569, 104441, 486847, 1234169, 5753023, 10086647, 87625999, 408464633, 716151937, 8462696833L, 600851475143L)
    assert(factors === Three.calculateFactors(600851475143L))
  }

  test("The prime factors of 13195 are 5, 7, 13 and 29") {
    val primeFactorsOf13195 = List(5, 7, 13, 29)
    assert(primeFactorsOf13195 === Three.calculatePrimeFactors(13195))
  }

  test("SOLUTION:  The largest, prime factor of 600851475143 is 6857") {
    assert(6857 === Three.calculatePrimeFactors(600851475143L).max)
  }

}
