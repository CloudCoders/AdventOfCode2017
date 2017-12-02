package day1

import org.scalatest.{FunSpec, FunSuite, Matchers}

class InverseCaptchaTest extends FunSuite with Matchers {
  import InverseCaptcha.captcha

  test("Captcha '12' should return 0") {
    captcha("12") shouldBe 0
  }

  test("Captcha '1111' should return 4") {
    captcha("1111") shouldBe 4
  }

  test("Captcha '1122' should return 3") {
    captcha("1122") shouldBe 3
  }

  test("Captcha '91212129' should return 9") {
    captcha("91212129") shouldBe 9
  }

}
