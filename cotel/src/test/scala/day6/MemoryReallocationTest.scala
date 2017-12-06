package day6

import org.scalatest.{FunSuite, Matchers}

class MemoryReallocationTest extends FunSuite with Matchers {
  import day6._

  test("Banks [0, 2, 7, 0] should be balanced in 5 steps") {
    balanceBanks(List(0,2,7,0)) shouldBe 5
  }

  test("Banks [1, 1, 1] should be balanced in 0 steps") {
    balanceBanks(List(1,1,1)) shouldBe 0
  }

  // Helper methods

  test("Balance step for Bank [0, 2, 7, 0] should result in [2, 4, 1, 2]") {
    balanceStep(List(0, 2, 7, 0)) shouldBe List(2,4,1,2)
  }

}
