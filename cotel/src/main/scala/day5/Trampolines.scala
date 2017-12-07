package day5

import scala.annotation.tailrec
import scala.io.Source

object Trampolines {

  @tailrec def instructionsUntilOut(instructions: List[Int], i: Int = 0, steps: Int = 0)(f: Int => Int): Int = {
    instructions.lift(i) match {
      case None => steps
      case Some(x) => instructionsUntilOut(instructions.updated(i, f(x)), i + x, steps + 1)(f)
      case Some(0) => instructionsUntilOut(instructions.updated(i, 1), i + 1, steps + 1)(f)
    }
  }

  def solveWithInput(filename: String = "Day5Input.txt"): Int = {
    val path = getClass.getClassLoader.getResource(filename).getPath
    val instructions = (for (line <- Source.fromFile(path).getLines())
      yield line.toInt).toList

    instructionsUntilOut(instructions) { _+1 }
  }


}
