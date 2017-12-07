package day7

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FunSuite, Matchers}

class RecursiveCircusTest extends FunSuite with Matchers {

  test("Test input base disc should be tknk") {
    getBaseDisc(parseTree(parseInput("Day7Test.txt"))) shouldBe "tknk"
  }

  test("Test input desiredBalance is 60") {
    balanceTree(parseTree(parseInput("Day7Test.txt"))) shouldBe 60
  }

  // Helpers

  test("LineParser parses line with -> correctly") {
    val disc = parseLine("vckvw (199) -> otrnol, jhbzqh")

    val table = Table(
      ("Position", "Children Identifier"),
      (0, "otrnol"),
      (1, "jhbzqh")
    )

    disc.identifier shouldBe "vckvw"
    disc.weight shouldBe 199

    forAll(table) { (n, id) =>
      disc.children(n) shouldBe id
    }

  }

  test("LineParser parses line without -> correctly") {
    parseLine("vckvw (199)") shouldBe Disc("vckvw", 199, Nil)
  }

}
