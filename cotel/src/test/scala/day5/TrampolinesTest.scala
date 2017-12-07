package day5

import org.scalatest.{FunSuite, Matchers}

class TrampolinesTest extends FunSuite with Matchers {
  import day5.Trampolines._


  test("For instructions [0, 3, 0, 1, -3] pointer will be out in 5 steps") {
    instructionsUntilOut(List(0, 3, 0, 1, -3)) { _+1 } shouldBe 5
  }

  test("For instructions [0, 0] pointer will be out in 4 steps") {
    instructionsUntilOut(List(0, 0)) { _+1 } shouldBe 4
  }

  test("For instructions [1, 0, -5] pointer will be out in 4 steps") {
    instructionsUntilOut(List(1, 0, -5)) { _+1 } shouldBe 4
  }

  test("For instructions [1, 1] pointer will be out in 2 steps") {
    instructionsUntilOut(List(1,1)) { _+1 } shouldBe 2
  }

  // Part 2

  test("For instructions [0, 3, 0, 1, -3] pointer will be out in 10 steps") {
    instructionsUntilOut(List(0, 3, 0, 1, -3)) { x => if (x >= 3) x-1 else x+1 } shouldBe 10
  }

}
