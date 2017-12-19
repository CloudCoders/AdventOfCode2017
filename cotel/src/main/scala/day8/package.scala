import scala.annotation.tailrec
import scala.io.Source

package object day8 {

  sealed trait Operation
  case class Increment(value: Int) extends Operation
  case class Decrement(value: Int) extends Operation

  sealed trait BooleanOperation
  case class GreaterThan(lhs: String, rhs: Int) extends BooleanOperation
  case class LesserThan(lhs: String, rhs: Int) extends BooleanOperation
  case class GreaterEqThan(lhs: String, rhs: Int) extends BooleanOperation
  case class LesserEqThan(lhs: String, rhs: Int) extends BooleanOperation
  case class EqualTo(lhs: String, rhs: Int) extends BooleanOperation
  case class NotEqualTo(lhs: String, rhs: Int) extends BooleanOperation

  case class Instruction(target: String, operation: Operation, booleanOp: BooleanOperation)

  def getMaxValueHeldDuringEvaluation(list: List[Instruction]): Int = {
    @tailrec def recursion(list: List[Instruction], currState: Map[String, Int], value: Int): Int = {
      if (list.isEmpty) return value

      val newState = evaluateInstruction(currState, list.head)
      if (newState.values.max > value) recursion(list.drop(1), newState, newState.values.max)
      else recursion(list.drop(1), newState, value)
    }

    val initialState = prepareInitialState(list)
    recursion(list, initialState, 0)
  }

  def getMaxValueAfterEvaluation(list: List[Instruction]): Int = {
    var state = prepareInitialState(list)

    list.foreach { inst => state = evaluateInstruction(state, inst) }

    state.values.max
  }

  def prepareInitialState(list: List[Instruction]): Map[String, Int] =
    (for (inst <- list) yield inst.target -> 0).toMap

  def parseInput(filename: String = "Day8Input.txt"): List[Instruction] =
    Source.fromFile(getClass.getClassLoader.getResource(filename).getPath).getLines.map(parseInstruction).toList

  def evaluateInstruction(registers: Map[String, Int], instruction: Instruction): Map[String, Int] = {
    val register = registers(instruction.target)

    val shouldUpdate = instruction.booleanOp match {
      case GreaterEqThan(lhs, rhs) => registers(lhs) >= rhs
      case LesserEqThan(lhs, rhs) => registers(lhs) <= rhs
      case GreaterThan(lhs, rhs) => registers(lhs) > rhs
      case LesserThan(lhs, rhs) => registers(lhs) < rhs
      case EqualTo(lhs, rhs) => registers(lhs) == rhs
      case NotEqualTo(lhs, rhs) => registers(lhs) != rhs
    }

    if (!shouldUpdate) return registers

    val evaluationResult = instruction.operation match {
      case Increment(x) => register + x
      case Decrement(x) => register - x
    }

    registers.updated(instruction.target, evaluationResult)
  }

  def parseInstruction(line: String): Instruction = {
    val splittedLine = line.split(" ")

    val target = splittedLine(0)

    val value = splittedLine(2).toInt
    val operation = splittedLine(1) match {
      case "inc" => Increment(value)
      case "dec" => Decrement(value)
    }

    val lhs = splittedLine(4)
    val rhs = splittedLine(6).toInt
    val booleanOp = splittedLine(5) match {
      case ">" => GreaterThan(lhs, rhs)
      case "<" => LesserThan(lhs, rhs)
      case ">=" => GreaterEqThan(lhs, rhs)
      case "<=" => LesserEqThan(lhs, rhs)
      case "==" => EqualTo(lhs, rhs)
      case "!=" => NotEqualTo(lhs, rhs)
    }

    Instruction(target, operation, booleanOp)
  }

}
