import scala.io.Source

package object day9 {

  def solvePart1(filename: String = "Day9Input.txt"): Int = {
    val input = Source.fromFile(getClass.getClassLoader.getResource(filename).getPath).mkString
    val str = transformStringIntoParsable(input)
    score(str)
  }

  def solvePart2(filename: String = "Day9Input.txt"): Int = {
    val input = Source.fromFile(getClass.getClassLoader.getResource(filename).getPath).mkString
    garbageLength(input)
  }

  def garbageLength(input: String): Int = {
    val str = removeIgnoredStrings(input)
    "<[^>]*>".r.findAllMatchIn(str).map { matching => (matching.end - matching.start) - 2 }.sum
  }

  def score(s: String, acc: Int = 1): Int = {
    if (s.isEmpty) return 0
    s.head match {
      case '{' => acc + score(s.tail, acc+1)
      case '}' => score(s.tail, acc-1)
    }
  }

  val removeIgnoredStrings: String => String = "!.".r.replaceAllIn(_, "")

  val removeGarbage: String => String = "<[^>]*>".r.replaceAllIn(_, "")

  val removeCommas: String => String = ",".r.replaceAllIn(_, "")

  val transformStringIntoParsable: String => String =
    removeCommas compose removeGarbage compose removeIgnoredStrings
}
