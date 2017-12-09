package day6

import kategory.combine
import org.junit.Assert.assertEquals
import org.junit.Test

class MemoryBankPartTwo {

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


  tailrec private fun infiniteLoopCircleIn(input: List<Int>, history: List<List<Int>> = emptyList(), count: Int = 0): Pair<Int, List<Int>> =
      if (history.contains(input)) Pair(count, input)
      else {
        val newInput = balance(input)
        infiniteLoopCircleIn(newInput, history.toMutableList().apply { add(input) }, count + 1)
      }

  @Test
  fun `detect infinite loop circle in blocks redistribution`() {
    val input = listOf(0, 2, 7, 0)
    val (size, bank) = infiniteLoopCircleIn(input)
    assertEquals(5, size)
    assertEquals(listOf(2, 4, 1, 2), bank)
  }

  @Test
  fun `detect the size of the infinite loop sequence`() {
    val input = listOf(0, 2, 7, 0)
    val (_, bank) = infiniteLoopCircleIn(input)
    assertEquals(4, infiniteLoopCircleIn(bank).first)
  }

  @Test
  fun `the result of the infinite loop circle is`() {
    val input = listOf(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11)
    val (_, bank) = infiniteLoopCircleIn(input)
    assertEquals(1695, infiniteLoopCircleIn(bank).first)
  }
}