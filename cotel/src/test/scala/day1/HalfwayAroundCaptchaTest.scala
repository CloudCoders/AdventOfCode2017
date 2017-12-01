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

}
