package day7

import org.scalatest.{FunSuite, Matchers}

class RecursiveCircusTest extends FunSuite with Matchers {
  import day7._

  test("Test input base disc should be tknk") {
    getBaseDisc(parseInput("Day7Test.txt")).map(_.identifier) shouldBe Some("tknk")
  }

  test("Test input desired weight should be 60") {
    getDesiredWeight(parseInput("Day7Test.txt")) shouldBe 60
  }

  // Helpers

  test("LineParser parses line with -> correctly") {
    val childs = List(Disc("otrnol", 0, Nil), Disc("jhbzqh", 0, Nil))
    parseLine("vckvw (199) -> otrnol, jhbzqh") shouldBe Disc("vckvw", 199, childs)
  }

  test("LineParser parses line without -> correctly") {
    parseLine("vckvw (199)") shouldBe Disc("vckvw", 199, Nil)
  }

}
