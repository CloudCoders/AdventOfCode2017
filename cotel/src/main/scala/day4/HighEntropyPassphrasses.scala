package day4

import scala.io.Source

object HighEntropyPassphrasses {

  def isValidPassphrase(passphrase: String, checked: List[String] = List(), result: Boolean = true): Boolean = {
    def recursion(passphrase: List[String], checked: List[String] = List(), result: Boolean = true): Boolean =
      (passphrase, checked, result) match {
        case (List(), _, acc) => acc
        case (x :: xs, ys, acc) if !ys.contains(x) => recursion(xs, x :: ys, acc)
        case (x :: _, ys, _) if ys.contains(x) => false
      }

    val splitted = passphrase.split(" ").toList
    recursion(splitted)
  }

  def isValidPassphraseMapReduce(passphrase: String): Boolean = {
    val passlist = passphrase.split(" ").toList
    (for (word: String <- passlist)
      yield passlist.count(word == _) <= 1)
      .forall(_ == true)
  }

  def solveProblemWithInput(fileName: String): Int = {
    val bufferedSource = Source.fromFile(this.getClass.getClassLoader.getResource(fileName).getPath)
    val result = (for (line <- bufferedSource.getLines)
      yield isValidPassphrase(line)).count(_ == true)
    bufferedSource.close()

    result
  }

}
