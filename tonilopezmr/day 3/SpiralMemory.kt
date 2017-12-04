package day3

import org.junit.Assert.*
import org.junit.Test

fun Int.pow(exponent: Int): Double = Math.pow(this.toDouble(), exponent.toDouble())
fun Int.abs(): Int = Math.abs(this)
fun Double.floor(): Int = Math.floor(this).toInt()

typealias Dimens = Pair<Int, Int>

class SpiralMemory {

  private fun getCenter(spiralDimension: Int): Dimens {
    val dimension = (spiralDimension.toDouble() / 2.0).floor()
    return Dimens(dimension, dimension)
  }

  private fun manhatan(a: Dimens, b: Dimens): Int {
    return (a.first - b.first).abs() + (a.second - b.second).abs()
  }

  private fun spiralDimens(input: Int): Int {
    var base = 2
    while (base.pow(2) < input) base++
    return base
  }

  fun spiralMemory(matrix: Int, center: Dimens, input: Int): Int {
    var displacementX = 0
    var displacementY = -1
    var x = 0
    var y = 0
    var number = 1

    while (number <= matrix.pow(2).toInt()) {
      val realX = center.first + x
      val realY = center.second + y

      if (input == number) {
        return manhatan(center, Dimens(realX, realY))
      }

      if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
        val t = displacementX
        displacementX = -displacementY
        displacementY = t
      }

      x += displacementX
      y += displacementY
      number++
    }

    return -1
  }


  @Test
  fun `spiral dimension for 23 should be 5`() {
    assertEquals(5, spiralDimens(23))
  }

  @Test
  fun `spiral dimension for 10 should be 4 x 4`() {
    assertEquals(4, spiralDimens(10))
  }

  @Test
  fun `center of 5 x 5 dimension is Dimens 2 2`() {
    assertEquals(Dimens(2, 2), getCenter(5))
  }

  @Test
  fun `calculate manhattan 5 x 3 and 2 x 8 is 8`() {
    assertEquals(8, manhatan(Dimens(5, 3), Dimens(2, 8)))
  }

  private fun assertCenterToSquareInManhattan(expected: Int, input: Int) {
    val spiralDimension = spiralDimens(input)
    assertEquals(expected, spiralMemory(spiralDimension, getCenter(spiralDimension), input))
  }

  @Test
  fun `data from square 1 is carried 0 steps`() {
    assertCenterToSquareInManhattan(expected = 0, input = 1)
  }

  @Test
  fun `data from square 12 is carried 3 steps`() {
    assertCenterToSquareInManhattan(expected = 3, input = 12)
  }

  @Test
  fun `data from square 23 is carried only 2 steps`() {
    assertCenterToSquareInManhattan(expected = 2, input = 23)
  }

  @Test
  fun `data from square 1024 must be carried 31 steps`() {
    assertCenterToSquareInManhattan(expected = 31, input = 1024)
  }

  @Test
  fun `data from square 277678 is 475`() {
    assertCenterToSquareInManhattan(expected = 475, input = 277678)
  }

}