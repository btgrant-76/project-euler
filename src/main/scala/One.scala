object One {

  def isMultipleOf(divisor: Int)(multiple: Int): Boolean = {
    multiple % divisor == 0
  }

  def isMultipleOf3 = isMultipleOf(3)_
  def isMultipleOf5 = isMultipleOf(5)_

  def sumMultiplesOf3And5(maxExclusive: Int): Int = {
    (1 until maxExclusive).foldLeft(0) { (x: Int, y: Int) =>
      if (isMultipleOf3(y) || isMultipleOf5(y))
        y + x
      else
        x
    }
  }

  def main(args: Array[String]) {
    println(s"The sum of multiples of 3 & 5 from 1 to 1,000 exclusive is ${sumMultiplesOf3And5(1000)}")
  }

}
