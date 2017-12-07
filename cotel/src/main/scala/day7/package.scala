import scala.io.Source
import scala.util.Try

package object day7 {
  case class Disc(identifier: String, weight: Int, children: List[Disc])
  case class Tree(identifier: String, weight: Int, parent: Tree) {
    val nodes: Map[String, Tree] = Map()

    def children = nodes.values
    def
  }

  def getBaseDisc(input: List[String]): Option[Disc] = {
    val allDiscs = input.map(parseLine)
    val childs = allDiscs.flatMap(_.children).map(_.identifier)

    allDiscs.find { disc => !childs.contains(disc.identifier) }
  }

  def getDesiredWeight(input: List[String]): Int = {
    val allDiscs = input.map(parseLine).groupBy(_.identifier)
    val baseDisc = getBaseDisc(input)
    updatedWeights(baseDisc.get, allDiscs)
  }

  def updatedWeights(disc: Disc, allDiscs: Map[String, Disc]): Unit = {
    disc.children.foreach { child =>
      updatedWeights(allDiscs(child.identifier), allDiscs)
      allDiscs.updated(disc.identifier, allDiscs(disc.identifier).weight + allDiscs(child).weight)
    }
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
