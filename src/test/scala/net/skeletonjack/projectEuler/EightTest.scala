package net.skeletonjack.projectEuler

import org.scalatest.FunSuite

import Eight._

import scala.collection.immutable.SortedMap

class EightTest extends FunSuite {

  val reallyBigNumber =
    "73167176531330624919225119674426574742355349194934" +
    "96983520312774506326239578318016984801869478851843" +
    "85861560789112949495459501737958331952853208805511" +
    "12540698747158523863050715693290963295227443043557" +
    "66896648950445244523161731856403098711121722383113" +
    "62229893423380308135336276614282806444486645238749" +
    "30358907296290491560440772390713810515859307960866" +
    "70172427121883998797908792274921901699720888093776" +
    "65727333001053367881220235421809751254540594752243" +
    "52584907711670556013604839586446706324415722155397" +
    "53697817977846174064955149290862569321978468622482" +
    "83972241375657056057490261407972968652414535100474" +
    "82166370484403199890008895243450658541227588666881" +
    "16427171479924442928230863465674813919123162824586" +
    "17866458359124566529476545682848912883142607690042" +
    "24219022671055626321111109370544217506941658960408" +
    "07198403850962455444362981230987879927244284909188" +
    "84580156166097919133875499200524063689912560717606" +
    "05886116467109405077541002256983155200055935729725" +
    "71636269561882670428252483600823257530420752963450"


  test("Product of List(1, 1, 1) is 1") {
    val factors = List(1, 1, 1)

    assert(1 === calculateProduct(factors))
    assert((1, factors) === pairProductWithFactors(factors))
  }

  test("Product of List(2, 1, 3, 5) is 30") {
    val factors = List(2, 1, 3, 5)

    assert(30 === calculateProduct(factors))
    assert((30, factors) === pairProductWithFactors(factors))
  }

  test("If 0 is a factor the product is always 0") {
    val factors = List(2, 0, 3, 5)

    assert(0 === calculateProduct(factors))
    assert((0, factors) === pairProductWithFactors(factors))
  }

  test("The product of an empty list is 0") {
    val factors = List[Int]()

    assert(0 === calculateProduct(factors))
    assert((0, factors) === pairProductWithFactors(factors))
  }

  test("The Really Big Number is 1,000 digits long") {
    for (c <- reallyBigNumber.toList) {
      assert(c.isDigit, s"$c is not a digit")
    }
    assert(1000 === reallyBigNumber.length)
  }

  test("When the input string is smaller than the adjacency size, the result is an empty List[Int]") {
    assert(createAdjacencies("7163626956", 11).isEmpty)
  }

  test("When the adjacency size is 1 there is one list of one digit for each digit in the input string") {
    val adjacencies = createAdjacencies("1234567890", 1)
    assert(adjacencies.size === 10)

    for (a <- adjacencies) {
      assert(a.size === 1)
    }
  }

  test("1234567890 with adjacency size of 2 results in 9 adjacencies") {
    val adjacencies = createAdjacencies("1234567890", 2)
    assert(9 === adjacencies.size)

    for (a <- adjacencies) {
      assert(a.size === 2)
    }
  }

  test("1234567890 with adjacency size of 4 results in 7 adjacencies") {
    val adjacencies = createAdjacencies("1234567890", 4).toList

    assert(adjacencies.size === 7)

    val orderedAdjacencies = Map(0 -> List(1, 2, 3, 4),
    1 -> List(2, 3, 4, 5), 2 -> List(3, 4, 5, 6), 3 -> List(4, 5, 6, 7),
    4 -> List(5, 6, 7, 8), 5 -> List(6, 7, 8, 9), 6 -> List(7, 8, 9, 0))

    for (i <- orderedAdjacencies.keySet) {
      assert(adjacencies(i) === orderedAdjacencies(i))
    }
  }

  test("Collecting the largest product with an empty map results in a map with the given product") {
    val productPair = pairProductWithFactors(List(1, 1, 1))
    val result = collectLargestProducts(SortedMap(), productPair)

    assert(result(productPair._1) === List(1, 1, 1))
  }

  test("Collecting the largest product with smaller values results in the given product being added") {
    val starter = SortedMap(1 -> List(1, 1, 1), 2 -> List(1, 1, 2))
    val result = collectLargestProducts(starter, (5, List(1, 1, 5)))

    assert(result.size === 3)
    assert(result.keySet.takeRight(1).head === 5)
  }

  test("Collecting the largest product with larger values results in the given product being discarded ") {
    val starter = SortedMap(1 -> List(1, 1, 1), 5 -> List(1, 1, 5))
    val result = collectLargestProducts(starter, (2, List(1, 1, 2)))

    assert(result.size === 2)
    assert(!result.keySet.contains(2))

  }

  test("The four, adjacent numbers with the greatest product in the 1,000-digit number " +
    "is (5832, List(9, 9, 8, 9)") {
    val result = createAdjacencies(reallyBigNumber, 4)
      .map(pairProductWithFactors)
      .foldLeft(SortedMap[Int, List[Int]]())(collectLargestProducts)

    val largest = result.takeRight(1).head

    assert(largest._1 === 5832)
    assert(largest._2 === List(9, 9, 8, 9))
  }

  test("Possible Solution") {
    val result = createAdjacencies(reallyBigNumber, 13)
      .map(pairProductWithFactors)
      .foldLeft(SortedMap[Int, List[Int]]())(collectLargestProducts)

    val largest = result.takeRight(1).head
    println(s"the largest value is ${largest._1} for the sequence ${largest._2.mkString("")}")
  }

}
