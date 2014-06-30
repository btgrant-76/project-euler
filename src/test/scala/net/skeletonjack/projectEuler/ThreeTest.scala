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
    assert(factorsOf3 === Three.calculateFactorsWithShortCutting(3))
  }

  test("1, 2, 4 & 8 are factors of 8") {
    val factorsOf8 = List(1, 2, 4, 8)

    assert(factorsOf8 === Three.calculateFactors(8))
    assert(factorsOf8 === Three.calculateFactorsWithShortCutting(8))
  }

  test("1, 3, 5 & 15 are factors of 15") {
    val factorsOf15 = List(1, 3, 5, 15)

    assert(factorsOf15 === Three.calculateFactors(15))
    assert(factorsOf15 === Three.calculateFactorsWithShortCutting(15))
  }

  test("The prime factors of 13195 are 5, 7, 13 and 29") {
    val primeFactorsOf13195 = List(5, 7, 13, 29)

    assert(primeFactorsOf13195 === Three.calculatePrimeFactors(13195, 13195))
    assert(primeFactorsOf13195 === Three.calculatePrimeFactorsOptimized(13195))
  }

  ignore("577204368781 is prime") {
    assert(Three.isPrime(577204368781L))
  }

  ignore("Stuff") {
    val primeFactors = Three.calculatePrimeFactors(577204368780L, 577204368781L)
    println(primeFactors.size)
  }

  ignore("do the math") {
    val primeFactors = Three.calculatePrimeFactors(600851475143L, 600851475143L)
    println(primeFactors.reverse.head)
  }

  test("factors of the big number") {
    val start = System.currentTimeMillis()
//    val factors = Three.calculateFactors(600851475143L)
    val middle = System.currentTimeMillis()
    val quickerFactors = Three.calculateFactorsWithShortCutting(600851475143L)
    val end = System.currentTimeMillis()
    println(s"quick calculation produced $quickerFactors")

    println(s"factor quick calculation completed in ${(end - middle) / 1000} seconds")
  }

  test("A simple plan") {
    val start = System.currentTimeMillis()
    val factorsOfTheBigNumber = Three.calculateFactorsWithShortCutting(600851475143L)

    val primeFactorsOfTheBigNumber = Three.calculatePrimeFactorsOptimized(600851475143L)
    val largestPrimeFactor = primeFactorsOfTheBigNumber.max
    println(s"the largest prime factor of 600851475143 is $largestPrimeFactor")
   }


}
