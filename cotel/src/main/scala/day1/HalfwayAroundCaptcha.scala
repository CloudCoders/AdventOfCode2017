package day1

object HalfwayAroundCaptcha {

  def captcha(captcha: String): Int = {
    val steps = captcha.length / 2
    val parsedCaptcha = captcha
      .concat(captcha.substring(0, steps))
      .toList
      .map(_.asDigit)
    foldCaptcha(parsedCaptcha, steps)
  }

  private def foldCaptcha(ints: List[Int], steps: Int): Int = {
    val listHalfs = ints.grouped(steps).toList

    val tuples = for (i <- listHalfs.head.indices)
      yield (listHalfs(0)(i), listHalfs(1)(i), listHalfs(2)(i))

    tuples.foldLeft(0) {
      case (acc, (x, y, z)) => if (x == y && y == z) acc + x else acc
    } * 2
  }

}
