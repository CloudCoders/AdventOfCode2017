package day1

import org.scalatest.{FunSpec, FunSuite, Matchers}

class InverseCaptchaTest extends FunSuite with Matchers {
  import InverseCaptcha.captcha

  test("Captcha '12' should return 0") {
    captcha("12") shouldBe 0
  }

}
