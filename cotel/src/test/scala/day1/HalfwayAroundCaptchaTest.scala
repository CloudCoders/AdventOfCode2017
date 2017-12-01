package day1

import org.scalatest.{FunSuite, Matchers}

class HalfwayAroundCaptchaTest extends FunSuite with Matchers {
  import HalfwayAroundCaptcha._

  test("Captcha '1212' should 6") {
    captcha("1212") shouldBe 6
  }

  test("Captcha '1122' should be 0") {
    captcha("1122") shouldBe 0
  }

  test("Captcha '123425' should be 4") {
    captcha("123425") shouldBe 4
  }

  test("Captcha '123123' should be 12") {
    captcha("123123") shouldBe 12
  }

  test("Captcha '12131415' should be 4") {
    captcha("12131415") shouldBe 4
  }

}
