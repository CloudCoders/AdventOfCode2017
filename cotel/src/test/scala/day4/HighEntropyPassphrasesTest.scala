package day4

import org.scalatest.{FunSuite, Matchers}

class HighEntropyPassphrasesTest extends FunSuite with Matchers {
  import HighEntropyPassphrases._

  test("Passphrase 'aa bb cc dd ee' should be valid") {
    isValidPassphrase("aa bb cc dd ee") shouldBe true
  }

  test("Passphrase 'aa bb cc dd aa' should be invalid") {
    isValidPassphrase("aa bb cc dd aa") shouldBe false
  }

  test("Passphrase 'aa bb cc dd aaa' should be valid") {
    isValidPassphrase("aa bb cc dd aaa") shouldBe true
  }

  test("MapReduction Passphrase 'aa bb cc dd ee' should be valid") {
    isValidPassphraseMapReduce("aa bb cc dd ee") shouldBe true
  }

  test("MapReduction Passphrase 'aa bb cc dd aa' should be invalid") {
    isValidPassphraseMapReduce("aa bb cc dd aa") shouldBe false
  }

  test("MapReduction Passphrase 'aa bb cc dd aaa' should be valid") {
    isValidPassphraseMapReduce("aa bb cc dd aaa") shouldBe true
  }

}
