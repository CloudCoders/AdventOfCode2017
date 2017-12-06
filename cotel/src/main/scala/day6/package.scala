import scala.annotation.tailrec

package object day6 {

  @tailrec def balanceBanks(banks: List[Int], checkedStates: List[List[Int]] = Nil, steps: Int = 0): Int = {
    if (banks.distinct.size == 1) return steps

    if (checkedStates.contains(banks)) return steps

    val newBanks: List[Int] = balanceStepv2(banks)

    balanceBanks(newBanks, banks :: checkedStates, steps+1)
  }

  @tailrec def stepsUntilSameState(banks: List[Int], checkedStates: List[List[Int]] = Nil, steps: Int = 0): (Int, List[Int]) = {
    if (checkedStates.contains(banks)) return (steps, banks)

    stepsUntilSameState(balanceStep(banks), banks :: checkedStates, steps+1)
  }

  def balanceStep(banks: List[Int]): List[Int] = {
    var (i, number) = (banks.indexOf(banks.max), banks.max)
    val distribution = if (number < banks.size) number else banks.size -1

    val blocksForEach = number / distribution
    val displacement = blocksForEach * distribution

    var list = banks.updated(i, number - displacement)
    i += 1

    for (j <- 1 to distribution) {
      i %= banks.size
      list = list.updated(i, list(i) + blocksForEach)
      i +=1
    }

    list
  }

  def balanceStepv2(banks: List[Int]): List[Int] = {
    val maxBank = banks.max
    val indexOfMax = banks.indexOf(maxBank)

    val firstLoop = indexOfMax + 1 until banks.size toList
    val cycleStream = Stream.continually(banks.indices toStream)
      .flatten
      .take(maxBank)
      .toList
    val indicesCycled = (firstLoop ::: cycleStream).take(maxBank)

    var newBanks = banks.updated(indexOfMax, 0)
    for (i <- indicesCycled) newBanks = newBanks.updated(i, newBanks(i) + 1)
    newBanks
  }

}
