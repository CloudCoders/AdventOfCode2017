import scala.io.Source
import scala.util.Try

package object day7 {
  case class Disc(identifier: String, weight: Int, childs: List[Disc])

  def getBaseDisc(input: List[String]): Option[Disc] = {
    val allDiscs = input.map(parseLine)
    val childs = allDiscs.flatMap(_.childs).map(_.identifier)

    allDiscs.find { disc => !childs.contains(disc.identifier) }
  }

  def getDesiredWeight(input: List[String]): Int = {
    val allDiscs = input.map(parseLine)
    val baseDisc:
  }

  def parseLine(line: String): Disc = {
    val weightParser = { s: Array[String] =>
        Try(s.last.replaceAll("[()]", "")).map(_.toInt).getOrElse(0)
    }

    if (line.contains("->")) {
      val stringPlant = line.split(" -> ")
      val programPart = stringPlant.head.split(" ")
      val otherProgramsPart = stringPlant.last.split(", ").toList

      val program = Disc(programPart.head, weightParser(programPart), otherProgramsPart.map(parseLine))

      program
    } else {
      val program = line.split(" ")

      Disc(program.head, weightParser(program), Nil)
    }
  }

  def parseInput(filename: String = "Day7Input.txt"): List[String] =
    Source.fromFile(getClass.getClassLoader.getResource(filename).getPath).getLines().toList


}
