package day6

import org.scalatest.{FunSuite, Matchers}

class MemoryReallocationTest extends FunSuite with Matchers {
  import day6._

  // Part 1

  test("Banks [0, 2, 7, 0] should be balanced in 5 steps") {
    balanceBanks(List(0,2,7,0)) shouldBe 5
  }

  test("Banks [1, 1, 1] should be balanced in 0 steps") {
    balanceBanks(List(1,1,1)) shouldBe 0
  }

  test("Banks [2, 0, 0] should be balanced in 6") {
    balanceBanks(List(2,0,0)) shouldBe 6
  }

  // Part 2

  test("Banks [2, 4, 1, 2] should appear again after 4 steps in [0, 2, 7, 0]") {
    val tuple = stepsUntilSameState(List(0, 2, 7, 0))
    stepsUntilSameState(tuple._2)._1 shouldBe 4
  }

  // Helper methods

  test("Balance step for Bank [0, 2, 7, 0] should result in [2, 4, 1, 2]") {
    balanceStep(List(0, 2, 7, 0)) shouldBe List(2,4,1,2)
  }

  test("Balance step (v2) for Bank [0, 2, 7, 0] should result in [2, 4, 1, 2]") {
    balanceStepv2(List(0, 2, 7, 0)) shouldBe List(2,4,1,2)
  }

  test("Balance step for Bank [2, 0, 0] should result in [0, 1, 1]") {
    balanceStepv2(List(2, 0, 0)) shouldBe List(0, 1, 1)
  }

  test("Balance step for Bank [1, 1, 0] should result in [0, 2, 0]") {
    balanceStepv2(List(1, 1, 0)) shouldBe List(0, 2, 0)
  }

}
