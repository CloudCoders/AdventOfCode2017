package day1

object InverseCaptcha {

  def captcha(captcha: String): Int = {
    val parsedCaptcha = captcha.toList.map(_.asDigit)

    if (!hasDuplicatedElements(parsedCaptcha)) 0
    else recursiveCaptcha(parsedCaptcha :+ parsedCaptcha.head)
  }

  private def hasDuplicatedElements(captcha: List[Int]): Boolean =
    captcha.distinct.size != captcha.size

  private def recursiveCaptcha(chars: List[Int]): Int = chars match {
    case xs if xs.size <= 1 => 0
    case (x :: y :: rest) if x == y => x + recursiveCaptcha(y :: rest)
    case (x :: y :: rest) if x != y => recursiveCaptcha(y :: rest)
  }

}
