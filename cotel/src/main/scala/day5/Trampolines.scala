package day5

import scala.annotation.tailrec

object Trampolines {

  @tailrec def instructionsUntilOut(instructions: List[Int], i: Int = 0, steps: Int = 0): Int = {
    instructions.lift(i) match {
      case (None) => steps
      case (Some(x)) => instructionsUntilOut(instructions.updated(i, x + 1), i + x, steps + 1)
      case (Some(0)) => instructionsUntilOut(instructions.updated(i, 1), i + 1, steps + 1)
    }
  }


}
