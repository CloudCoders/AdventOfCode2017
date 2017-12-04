package day4

import org.scalatest.{FunSuite, Matchers}

class NoAnagramPassphrassesTest extends FunSuite with Matchers {
  import NoAnagramPassphrasses._

  test("String ecdab sorted should be abcde") {
    "ecdab".split("").sorted.mkString shouldBe "abcde"
  }

  test("Passphrase 'abcde fghij' should be valid") {
    isValidPassphrase("abcde fghij") shouldBe true
  }

  test("Passphrase 'abcde xyz ecdab' should be invalid") {
    isValidPassphrase("abcde xyz ecdab") shouldBe false
  }

  test("Passphrase 'a ab abc abd abf abj' should be valid") {
    isValidPassphrase("a ab abc abd abf abj") shouldBe true
  }

  test("Passphrase 'iiii oiii ooii oooi oooo' should be valid") {
    isValidPassphrase("iiii oiii ooii oooi oooo") shouldBe true
  }

  test("Passphrase 'oiii ioii iioi iiio' should be invalid") {
    isValidPassphrase("oiii ioii iioi iiio") shouldBe false
  }

}
