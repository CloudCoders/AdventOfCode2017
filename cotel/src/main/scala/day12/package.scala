import scala.io.Source
import scalaz._
import Scalaz._
import scala.annotation.tailrec

package object day12 {
  type Graph = Map[Int, Set[Int]]
  val Graph: Graph = Map[Int, Set[Int]]()

  def walkGraph(node: Int, graph: Graph): Set[Int] = {
    @tailrec def recursion(toVisit: Set[Int], visited: Set[Int]): Set[Int] = toVisit -- visited match {
      case n if n.isEmpty => visited
      case n => recursion(n.flatMap(i => graph.getOrElse(i, Set.empty)), visited ++ n)
    }

    recursion(Set(node), Set.empty)
  }

  def allGroupsInGraph(graph: Graph): Int = graph.foldLeft((0, Set.empty[Int])) { case ((acc, visited), (node, _)) =>
    if (!visited.contains(node)) (acc+1, visited ++ walkGraph(node, graph))
    else (acc, visited)
  }._1

  def parseLine(line: String): Graph = {
    val halfs = line.split("<->")
    Map(halfs(0).trim.toInt -> halfs(1).split(",").map(_.trim.toInt).toSet)
  }

  def parseInput(filename: String = "Day12Input.txt"): Graph = {
    Source.fromFile(getClass.getClassLoader.getResource(filename).getPath).getLines()
      .map(parseLine)
      .foldLeft(Graph) { (x: Graph, y: Graph) => x |+| y }
  }


}
