import scala.annotation.tailrec

package object day6 {

  @tailrec def balanceBanks(banks: List[Int], checkedStates: List[String] = Nil, steps: Int = 0): Int = {
    if (banks.distinct.size == 1) return steps

    val currentState = banksRepresentation(banks)
    if (checkedStates.contains(currentState)) return steps

    val newBanks: List[Int] = balanceStep(banks)

    balanceBanks(newBanks, currentState :: checkedStates, steps+1)
  }

  def balanceStep(banks: List[Int]): List[Int] = {
    val maxBank = banks.max
    val indexOfMax = banks.indexOf(maxBank)

    val firstLoop = indexOfMax+1 until banks.size toList
    val cycleStream = Stream.continually(banks.indices toStream)
      .flatten
      .take(maxBank - firstLoop.size)
      .toList
    val indicesCycled = firstLoop ::: cycleStream

    var newBanks = banks.updated(indexOfMax, 0)
    for (i <- indicesCycled) newBanks = newBanks.updated(i, newBanks(i)+1)
    newBanks
  }

  private def banksRepresentation(banks: List[Int]): String = banks.mkString(" ")

}
