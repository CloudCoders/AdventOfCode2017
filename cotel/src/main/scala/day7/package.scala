import scala.collection.mutable
import scala.io.Source

package object day7 {

  case class Disc(identifier: String, weight: Int, children: List[String])

  case class Tree(identifier: String, weight: Int, var parent: Tree) {
    val nodes: mutable.Map[String, Tree] = mutable.Map()

    def children: Iterable[Tree] = nodes.values
    def sum: Int = weight + nodes.values.foldLeft(0)(_ + _.sum)
    def isBalanced: Boolean = nodes.values.map(_.sum).toSet.size == 1
  }

  def getBaseDisc(tree: Tree): String = tree.identifier

  def balanceTree(tree: Tree): Int = {
    if (!tree.isBalanced) {
      val result = tree.children.map(balanceTree).max
      if (tree.children.count(_.isBalanced) == tree.children.size) {
        val groups = tree.children.groupBy(_.sum)
        val wrongTree = groups.values.find(_.size == 1).get.head
        val correctTree = groups.values.find(_.size > 1).get.head

        return wrongTree.weight - (wrongTree.sum - correctTree.sum)
      }

      return result
    }

    Int.MinValue
  }

  def parseTree(input: List[String]): Tree = {
    val discs: List[Disc] = input.map(parseLine)
    val programs: Map[String, Tree] = discs.map(f => f.identifier -> Tree(f.identifier, f.weight, null)).toMap

    discs.flatMap(disc => disc.children.map(child => (disc.identifier, child))).foreach(pair => {
      programs(pair._1).nodes(pair._2) = programs(pair._2)
      programs(pair._2).parent = programs(pair._1)
    })

    programs.values.filter(_.parent == null).head
  }

  def parseLine(line: String): Disc = {
    val discRegex = "([a-z]{4,8}) \\(([0-9]+)\\)( -> ([a-z ,]+))?".r

    (for (m <- discRegex.findAllMatchIn(line)) yield
      Disc(m.group(1), m.group(2).toInt, if (m.group(4) == null) Nil else m.group(4).split(", ").toList)).next()
  }

  def parseInput(filename: String = "Day7Input.txt"): List[String] =
    Source.fromFile(getClass.getClassLoader.getResource(filename).getPath).getLines().toList


}
