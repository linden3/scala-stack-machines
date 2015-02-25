import scala.collection.mutable.Stack

package operand {
  trait Operand

  case class Number(value: Double) extends Operand
}

package operation {
  trait Operation

  case object Addition extends Operation
  case object Subtraction extends Operation
  case object Multiplication extends Operation
  case object Division extends Operation
}

package stackmachine {
  object RpnCalculator {
    import operand._
    import operation._

    var stack: Stack[Operand] = new Stack[Operand]

    def push(operand: Operand) = {
      stack.push(operand)
    }

    def perform(operation: Operation) = {
      operation match {
        case Addition =>
          stack.push(add(stack.pop(), stack.pop()))
        case Subtraction =>
          val subtractFrom: Operand = stack.pop()
          stack.push(subtract(stack.pop(), subtractFrom))
        case Multiplication =>
          stack.push(multiply(stack.pop(), stack.pop()))
        case Division =>
          val divideBy: Operand = stack.pop()
          stack.push(divide(stack.pop(), divideBy))
      }
    }

    private def add(operands: (Operand, Operand)): Number = {
      operands match {
        case (take: Number, subtract: Number) =>
          Number(take.value + subtract.value)
        case _ =>
          throw new IllegalArgumentException("Can only add numbers")
      }
    }

    private def subtract(operands: (Operand, Operand)): Number = {
      operands match {
        case (take: Number, subtract: Number) =>
          Number(take.value - subtract.value)
        case _ =>
          throw new IllegalArgumentException("Can only subtract numbers")
      }
    }

    private def multiply(operands: (Operand, Operand)): Number = {
      operands match {
        case (take: Number, multiplyBy: Number) =>
          Number(take.value * multiplyBy.value)
        case _ =>
          throw new IllegalArgumentException("Can only multiply numbers")
      }
    }

    private def divide(operands: (Operand, Operand)): Number = {
      operands match {
        case (take: Number, divideBy: Number) =>
          Number(take.value / divideBy.value)
        case _ =>
          throw new IllegalArgumentException("Can only divide numbers")
      }
    }
  }
}