package day3

import org.scalatest.{FunSuite, Matchers}

class SpiralMatrixTest extends FunSuite with Matchers {
  import SpiralMatrix._


  test("SpiralMatrix distance for 1 should be 0") {
    distanceToCenterOfMatrix(1) shouldBe 0
  }

  test("SpritalMatrix distance for 12 should be 3") {
    distanceToCenterOfMatrix(12) shouldBe 3
  }

  test("Spiralmatrix distance for 23 should be 2") {
    distanceToCenterOfMatrix(23) shouldBe 2
  }

  test("SpiralMatrix distance for 1024 should be 31") {
    distanceToCenterOfMatrix(1024) shouldBe 31
  }

  test("First number bigger than 12 written in spiralSumMatrix should be 23") {
    firstNumberBiggerThanInput(12) shouldBe 23
  }

  test("First number bigger than 25 written in spiralSumMatrix should be 26") {
    firstNumberBiggerThanInput(25) shouldBe 26
  }

}
