package day12

import org.scalatest.{FunSuite, Matchers}

class DigitalPlumberTest extends FunSuite with Matchers {

  test("For example input, group 0 should contain 6 programs") {
    val graph = parseInput("Day12Test.txt")
    walkGraph(0, graph).size shouldBe 6
  }

}
