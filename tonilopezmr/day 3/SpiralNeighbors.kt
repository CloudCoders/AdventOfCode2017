package day3

import org.junit.Assert.*
import org.junit.Test

class SpiralNeighbors {

  private fun sumNeighbors(spiral: Map<Dimens, Int>, dimen: Dimens): Int =
      (spiral[Pair(dimen.first + 1, dimen.second)] ?: 0) +
          (spiral[Pair(dimen.first + 1, dimen.second + 1)] ?: 0) +
          (spiral[Pair(dimen.first, dimen.second + 1)] ?: 0) +
          (spiral[Pair(dimen.first - 1, dimen.second + 1)] ?: 0) +
          (spiral[Pair(dimen.first - 1, dimen.second)] ?: 0) +
          (spiral[Pair(dimen.first - 1, dimen.second - 1)] ?: 0) +
          (spiral[Pair(dimen.first, dimen.second - 1)] ?: 0) +
          (spiral[Pair(dimen.first + 1, dimen.second - 1)] ?: 0) +
          (spiral[Pair(dimen.first, dimen.second)] ?: 0)

  fun nextTo(input: Int): Map<Dimens, Int> {
    var displacementX = 0
    var displacementY = -1
    var x = 0
    var y = 0
    var number = 1
    val spiral = mutableMapOf(Dimens(0, 0) to 1)

    while (number <= input) {
      val currentPosition = Dimens(x, y)
      number = sumNeighbors(spiral, currentPosition)
      spiral.put(currentPosition, number)

      if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
        val t = displacementX
        displacementX = -displacementY
        displacementY = t
      }

      x += displacementX
      y += displacementY
    }

    return spiral
  }

  @Test
  fun `sum of all neighbors when you are on center should be 8`() {
    val map = mapOf(
        Dimens(0, 0) to 1, Dimens(1, 0) to 1, Dimens(2, 0) to 1,
        Dimens(0, 1) to 1, Dimens(2, 1) to 1,
        Dimens(0, 2) to 1, Dimens(1, 2) to 1, Dimens(2, 2) to 1
    )

    assertEquals(8, sumNeighbors(map, Dimens(1, 1)))
  }

  @Test
  fun `sum half neighbors when you are on center should be 5`() {
    val map = mapOf(
        Dimens(0, 0) to 1, Dimens(1, 0) to 1, Dimens(2, 0) to 1,
        Dimens(0, 1) to 1, Dimens(2, 1) to 1
    )

    assertEquals(5, sumNeighbors(map, Dimens(1, 1)))
  }

  @Test
  fun `sum two neighbors when you are on a corner should be 5`() {
    val map = mapOf(
        Dimens(2, 0) to 1,
        Dimens(2, 1) to 1
    )

    assertEquals(2, sumNeighbors(map, Dimens(1, 1)))
  }

  @Test
  fun `sum itself should be 1`() {
    val map = mapOf(
        Dimens(1, 1) to 1
    )

    assertEquals(1, sumNeighbors(map, Dimens(1, 1)))
  }

  @Test
  fun `generate spiral to find next to 23 number`() {
    val expected = arrayOf(1, 1, 2, 4, 5, 10, 11, 23, 25)

    assertArrayEquals(expected, nextTo(23).values.toTypedArray())
  }

  @Test
  fun `generate spiral to find next to 200`() {
    val expected = arrayOf(1, 1, 2, 4, 5, 10, 11, 23, 25, 26, 54, 57, 59, 122, 133, 142, 147, 304)

    assertArrayEquals(expected, nextTo(200).values.toTypedArray())
    assertEquals(304, nextTo(200).values.toTypedArray().last())
  }

  @Test
  fun `find the solution next to 277678`() {
    assertEquals(279138, nextTo(277678).values.toTypedArray().last())
  }

}