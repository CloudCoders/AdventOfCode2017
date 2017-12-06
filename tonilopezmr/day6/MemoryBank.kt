package day6

import kategory.combine
import org.junit.Assert.assertEquals
import org.junit.Test

typealias P = Pair<Int, Int>

class MemoryBank {

  private fun chooseBank(input: List<Int>): Pair<Int, Int> =
      input.foldRightIndexed(P(0, 0)) { idx, bank, (index, blocks) ->
        if (bank >= blocks) P(idx, bank) else P(index, blocks)
      }

  private fun balance(input: List<Int>): List<Int> {
    var (index, bank) = chooseBank(input)
    val distribution = if (bank < input.size) bank else input.size - 1
    val blocksForEach = bank / distribution
    val list = input.toMutableList()
    val displacement = blocksForEach * distribution
    list[index] = bank - displacement
    index++
    for (i in 1..distribution) {
      index %= input.size
      list[index] = list[index] + blocksForEach
      index++
    }

    return list
  }

  private fun infiniteLoopCircleInI(input: List<Int>): Int {
    val history = mutableListOf<List<Int>>()
    var banks = input
    var count = 0
    while (!history.contains(banks)) {
      history.add(banks)
      banks = balance(banks)
      count++
    }

    return count
  }

  tailrec private fun infiniteLoopCircleIn(input: List<Int>, history: List<List<Int>> = emptyList(), count: Int = 0): Int =
      if (history.contains(input)) count
      else {
        val newInput = balance(input)
        infiniteLoopCircleIn(newInput, history.toMutableList().apply { add(input) }, count + 1)
      }


  @Test

  fun `choose the bank with more blocks`() {
    val (index, bank) = chooseBank(listOf(1, 2, 3, 7))
    assertEquals(3, index)
    assertEquals(7, bank)
  }

  @Test
  fun `choose the first bank with more blocks when there is a tie`() {
    val (index, bank) = chooseBank(listOf(1, 7, 3, 7))
    assertEquals(1, index)
    assertEquals(7, bank)
  }

  @Test
  fun `balance blocks in banks`() {
    val input = listOf(0, 2, 7, 0)
    assertEquals(listOf(2, 4, 1, 2), balance(input))
  }

  @Test
  fun `balance blocks in banks iteration 2`() {
    val input = listOf(2, 4, 1, 2)
    assertEquals(listOf(3, 1, 2, 3), balance(input))
  }

  @Test
  fun `balance blocks in banks when there is a tie`() {
    val input = listOf(3, 1, 2, 3)
    assertEquals(listOf(0, 2, 3, 4), balance(input))
  }

  @Test
  fun `balance blocks in banks iteration 4`() {
    val input = listOf(1, 3, 4, 1)
    assertEquals(listOf(2, 4, 1, 2), balance(input))
  }

  @Test
  fun `detect infinite loop circle in blocks redistribution`() {
    val input = listOf(0, 2, 7, 0)
    assertEquals(5, infiniteLoopCircleIn(input))
  }

  @Test
  fun `the result of the infinite loop circle is`() {
    val input = listOf(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11)
    assertEquals(7864, infiniteLoopCircleIn(input))
  }
}