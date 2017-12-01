package day1

import org.scalatest.{FunSpec, FunSuite, Matchers}

class InverseCaptchaTest extends FunSuite with Matchers {
  import InverseCaptcha.captcha

  test("Captcha '12' should return 0") {
    captcha("12") shouldBe 0
  }

  test("Captcha '11' should return 2") {
    captcha("11") shouldBe 2
  }

  test("Captcha '1122' should return 3") {
    captcha("1122") shouldBe 3
  }

}
