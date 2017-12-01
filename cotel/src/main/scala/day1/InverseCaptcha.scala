package day1

object InverseCaptcha {

  def captcha(captcha: String): Int = {
    val circularList = (captcha.toList :+ captcha.charAt(0)).map(_.asDigit)

    if (circularList.distinct.size == circularList.size) 0
    else recursiveCaptcha(circularList)
  }

  private def recursiveCaptcha(chars: List[Int]): Int = chars match {
    case xs if xs.size <= 1 => 0
    case (x :: y :: rest) if x == y => x + recursiveCaptcha(y :: rest)
    case (x :: y :: rest) if x != y => recursiveCaptcha(y :: rest)
  }

}
