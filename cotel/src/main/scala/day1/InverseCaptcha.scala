package day1

object InverseCaptcha {

  def captcha(captcha: String): Int = {
    val parsedCaptcha = captcha.toList.map(_.asDigit)
    recursiveCaptcha(parsedCaptcha :+ parsedCaptcha.head)
  }

  private def hasDuplicatedElements(captcha: List[Int]): Boolean =
    captcha.distinct.size != captcha.size

  private def recursiveCaptcha(chars: List[Int]): Int = {
    if (!hasDuplicatedElements(chars)) 0
    else chars match {
      case xs if xs.size <= 1 => 0
      case (x :: y :: rest) if x == y => x + recursiveCaptcha(y :: rest)
      case (x :: y :: rest) if x != y => recursiveCaptcha(y :: rest)
    }
  }

}
