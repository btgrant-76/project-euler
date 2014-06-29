package net.skeletonjack.projectEuler

object Three {

  def isPrime(number: Long): Boolean = {
    println("testing " + number)
    if (number == 1)
      false
    else {
      var x = 2L

      while (x < number) {
        if (number % x == 0) {
          return false
        }

        x += 1L
      }
      true
    }
//      !(2L until number).exists(x => number % x == 0)
  }

  def calculateFactors(start: Long, end: Long): List[Long] = {
    val possibleFactors = start to end

    // FIXME There's a bug here
    possibleFactors.foldLeft(List[Long]()) {(factors: List[Long], nextPotentialFactor: Long) =>
      if (end % nextPotentialFactor == 0)
        factors :+ nextPotentialFactor
      else
        factors.toSet.toList
    }
  }

  def calculatePrimeFactors(start: Long, end: Long): List[Long] = {
    val startTime = System.currentTimeMillis()
    val factors = calculateFactors(start, end).par
    val primes = factors.filter(isPrime)

    println(s"elapsed ${System.currentTimeMillis() - startTime} calculating primes for factors between $start and $end")

    primes.toList
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis()
    val theBigNumber = 600851475143L
    val numberOfGroups: Long = 600851475143L / (Int.MaxValue / 2)
    val sizeOfGroups = theBigNumber / numberOfGroups + 1

    println("number of groups = " + numberOfGroups)
    println("size of group = " + sizeOfGroups)

    def normalizeNegativeNumbersToOne(num: Long) = {
      if (num <= 0)
        1L
      else
        num
    }

    var largestPrimeFactor: Long = -1

    for (i: Long <- 1L to numberOfGroups) {
      if (largestPrimeFactor == -1) {
        val end = (theBigNumber - ((i - 1) * sizeOfGroups))
        val start = normalizeNegativeNumbersToOne((theBigNumber - (i * sizeOfGroups)) + 1)
        println(start + " to " + end + " with difference " + (end - start))
        val primeFactors = calculatePrimeFactors(start, end).reverse
        println(s"calculated ${primeFactors.size} prime factors")
        if (!primeFactors.isEmpty && primeFactors.head > largestPrimeFactor) {
          largestPrimeFactor = primeFactors.head
        }
      }
   }

//    val maxInt: Long = Long.box(Int.MaxValue - 3)
//    val possibleFactors = (theBigNumber - (Int.MaxValue + 200)) to 600851475143L
//    val some = possibleFactors.takeRight(Int.MaxValue - 1)

//    for (i: Long <- possibleFactors) {
//      if (isPrime(i)) {
//        largestPrimeFactor = i
//      }
//    }

    /*possibleFactors.dropWhile { p: Long =>
      if (!isPrime(p))
        false
      else {
        largestPrimeFactor = p
        true
      }
    }*/

    /*possibleFactors.reverse.find { p: Long =>
      println(p)
      isPrime(p)
    }*//*foreach { x: Long =>
      if (isPrime(x)) {
       largestPrimeFactor = x
      }
    }*/

//    val primeFactors = calculatePrimeFactors(600851475143L).reverse
//    println(s"Largest, prime factor of 600851475143 is ${primeFactors.head}")
      println(s"Largest, prime factor of 600851475143 is $largestPrimeFactor")
      println("completed after " + (System.currentTimeMillis() - start))
  }

}
