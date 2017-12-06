package day5

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.util.*

class MazeOfJumpInstructionsPartTwo {

  private fun jumpInstI(input: List<Int>): Int {
    var offset = 0
    var steps = 0
    val instructions = input.toMutableList()

    while (offset < input.size) {
      val aux = instructions[offset]
      instructions[offset] = if (aux >= 3) aux - 1 else aux + 1
      offset += aux
      steps++
    }

    return steps
  }

  private fun jumpInst(input: List<Int>): Int = jumpInst(0, 0, input)

  tailrec private fun jumpInst(offset: Int, step: Int, input: List<Int>): Int {
    return if (offset >= input.size) step
    else jumpInst(offset + input[offset], step + 1, input.take(offset) + newOffset(input, offset) + input.takeLast(input.size - (offset + 1)))
  }

  private fun newOffset(input: List<Int>, offset: Int) = if (input[offset] >= 3) input[offset] - 1 else input[offset] + 1

  @Test
  fun `exit in 1 step`() {
    assertEquals(1, jumpInst(listOf(5, 4, 0, 1, -2)))
  }

  @Test
  fun `exit in 2 step`() {
    assertEquals(2, jumpInst(listOf(1, 4, 0, 1, -2)))
  }

  @Test
  fun `exit in 3 step`() {
    assertEquals(3, jumpInst(listOf(1, 3, 0, 1, 1)))
  }

  @Test
  fun `exit in 5 step`() {
    assertEquals(10, jumpInst(listOf(0, 3, 0, 1, -3)))
  }

  @Test
  fun `solution for the part one is`() {
    val sc = Scanner(File("input"))
    val input = mutableListOf<Int>()
    while (sc.hasNext()) input.add(sc.nextInt())
    assertEquals(26948068, jumpInstI(input))
  }


}