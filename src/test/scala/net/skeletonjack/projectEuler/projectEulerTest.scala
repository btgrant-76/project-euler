package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

class projectEulerTest extends FunSuite {

  test("3, 11 & 17 are prime") {
    assert(isPrime(3))
    assert(isPrime(11))
    assert(isPrime(17))
  }

  test("4 & 38 are not prime") {
    assert(!isPrime(4))
    assert(!isPrime(38))
  }

  test("Product of List(1, 1, 1) is 1") {
    val factors = List(1, 1, 1)

    assert(1 === calculateProduct(factors))
  }

  test("Product of List(2, 1, 3, 5) is 30") {
    val factors = List(2, 1, 3, 5)

    assert(30 === calculateProduct(factors))
  }

  test("If 0 is a factor the product is always 0") {
    val factors = List(2, 0, 3, 5)

    assert(0 === calculateProduct(factors))
  }

  test("The product of an empty list is 0") {
    val factors = List[Int]()

    assert(0 === calculateProduct(factors))
  }

}
