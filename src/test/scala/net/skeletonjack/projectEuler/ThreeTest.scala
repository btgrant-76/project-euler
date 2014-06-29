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
    val factorsOf3 = Three.calculateFactors(1, 3)
    assert(List(1, 3) === factorsOf3)
  }

  test("1, 2, 4 & 8 are factors of 8") {
    val factorsOf8 = Three.calculateFactors(1, 8)
    assert(factorsOf8 === List(1, 2, 4, 8))
  }

  test("1, 3, 5 & 15 are factors of 15") {
    val factorsOf15 = Three.calculateFactors(1, 15)
    assert(factorsOf15 === List(1, 3, 5, 15))
  }

  test("The prime factors of 13195 are 5, 7, 13 and 29") {
    val primeFactorsOf13195 = Three.calculatePrimeFactors(1, 13195)
    assert(primeFactorsOf13195 === List(5, 7, 13, 29))
  }

  ignore("577204368781 is prime") {
    assert(Three.isPrime(577204368781L))
  }

  test("Stuff") {
    val primeFactors = Three.calculatePrimeFactors(577204368780L, 577204368781L)
    println(primeFactors.size)
  }


}
