package day9

import org.scalatest.{FunSuite, Matchers}

class StreamProcessingTest extends FunSuite with Matchers {

  // Parser
  test("Score for '{}{{}{}}' should be 6") {
    score("{}{{}{}}") shouldBe 6
  }

  test("Garbage length for '<<<<>' should be 3") {
    garbageLength("<<<<>") shouldBe 3
  }

  test("Garbage length for '<!!!>>' should be 0") {
    garbageLength("<!!!>>") shouldBe 0
  }

  test("Garbage length for '<{o\"i!a,<{i<a>' should be 10") {
    garbageLength("<{o\"i!a,<{i<a>") shouldBe 10
  }

  // Helper methods
  test("Removing ignored chars cleans string without ! and their subsequent char") {
    removeIgnoredStrings("{{<a!>},{<ab>},{<!!>}}") shouldBe "{{<a},{<ab>},{<>}}"
  }

  test("Removing garbage should clean string without <> groups") {
    removeGarbage("{{<ab>},{<ab>},<{ab}>}") shouldBe "{{},{},}"
  }

  test("Transforming string into parsable should return string with only {} characters") {
    transformStringIntoParsable("<{o\"i!a,<{i<a>") shouldBe ""
    transformStringIntoParsable("{{<a!>},{<a!>},{<a!>},{<ab>}}") shouldBe "{{}}"
  }

}
