import stackmachine._
import operand._
import operation._

RpnCalculator.push(Number(3))
RpnCalculator.push(Number(4))
RpnCalculator.perform(Addition)
RpnCalculator.push(Number(2))
RpnCalculator.perform(Subtraction)
RpnCalculator.push(Number(6))
RpnCalculator.perform(Multiplication)
RpnCalculator.push(Number(2))
RpnCalculator.perform(Division)
