package day8

import org.scalatest.{FunSuite, Matchers}

class RegistersTest extends FunSuite with Matchers {

  test("Maximum register value after evaluation should be 1 for test input") {
    getMaxValueAfterEvaluation(parseInput("Day8Test.txt")) shouldBe 1
  }

  test("Maximum register value furing evaluation should be 10 for test input") {
    getMaxValueHeldDuringEvaluation(parseInput("Day8Test.txt")) shouldBe 10
  }

  // Helper methods

  test("parseInstruction should parse line into instruction") {
    parseInstruction("c dec -10 if a >= 1") shouldBe Instruction("c", Decrement(-10), GreaterEqThan("a", 1))
  }

  test("evaluateInstruction should evaluate instruction and return updated registers") {
    val initialState = Map("a" -> 0, "b" -> 10)
    evaluateInstruction(initialState, Instruction("a", Increment(5), EqualTo("b", 10))) shouldBe Map("a" -> 5, "b" -> 10)
  }

}
