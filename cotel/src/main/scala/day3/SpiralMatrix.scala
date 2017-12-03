package day3

object SpiralMatrix {

  type Matrix[A] = Array[Array[A]]

  def Matrix(xs: Array[Int]*) = Array(xs: _*)

  def distanceToCenterOfMatrix(number: Int): Int = {
    val spiralMatrix = generateSpiralMatrix(number)

    val numberPosition = get2DPosition(number, spiralMatrix).get

    val middleRow = spiralMatrix.length / 2
    val middlePositionInRow = spiralMatrix.head.length / 2

    val verticalSteps = Math.abs(numberPosition._1 - middleRow)
    val horizontalSteps = Math.abs(numberPosition._2 - middlePositionInRow)

    verticalSteps + horizontalSteps
  }

  private def get2DPosition(number: Int, matrix: Matrix[Int]): Option[(Int, Int)] = {
    if (matrix.length == 1 && number == 1) return Option((0, 0))
    if (matrix.length == 1 && number == 1) return Option((1, 0))

    for (x <- matrix.indices;
         y <- matrix(x).indices) yield {
      if (matrix(x)(y) == number) return Option((x, y))
    }

    None
  }

  private def calculateArraySize(i: Int, acc: Int = 0): Int = Math.pow(2 * acc + 1, 2).toInt match {
    case corner if corner >= i => Math.sqrt(corner).toInt
    case corner if corner < i => calculateArraySize(i, acc + 1)
  }

  private def generateSpiralMatrix(upToN: Int): Matrix[Int] = {
    var fn = 1
    var expo = 1

    val arraySize = calculateArraySize(upToN)
    var x = arraySize / 2
    var y = arraySize / 2

    val matrix: Matrix[Int] = Array.fill(arraySize)(Array.fill(arraySize)(0))

    while (fn < Math.pow(arraySize, 2)) {
      val per = Math.pow(expo, 2) - Math.pow(expo - 2, 2)
      if (per == 0) matrix(x)(y) = 1
      else {
        x += 1
        fn += 1
        matrix(y)(x) = fn

        for (_ <- 0 until expo - 2) yield {
          y -= 1
          fn += 1
          matrix(y)(x) = fn
        }

        for (_ <- 1 until expo) yield {
          x -= 1
          fn += 1
          matrix(y)(x) = fn
        }

        for (_ <- 1 until expo) yield {
          y += 1
          fn += 1
          matrix(y)(x) = fn
        }

        for (_ <- 1 until expo) yield {
          x += 1
          fn += 1
          matrix(y)(x) = fn
        }
      }

      expo += 2
    }

    matrix
  }

  def firstNumberBiggerThanInput(upToN: Int): Int = {
    var fn = 1
    var expo = 1

    val arraySize = calculateArraySize(upToN)+2
    var x = arraySize / 2
    var y = arraySize / 2

    val matrix: Matrix[Int] = Array.fill(arraySize)(Array.fill(arraySize)(0))

    while (fn < Math.pow(arraySize, 2)) {
      val per = Math.pow(expo, 2) - Math.pow(expo - 2, 2)
      if (per == 0) matrix(x)(y) = 1
      else {
        x += 1
        fn += 1
        matrix(y)(x) = sumNeighbors(matrix, (x, y))
        if (matrix(y)(x) > upToN) return matrix(y)(x)

        for (_ <- 0 until expo - 2) yield {
          y -= 1
          fn += 1
          matrix(y)(x) = sumNeighbors(matrix, (x, y))
          if (matrix(y)(x) > upToN) return matrix(y)(x)
        }

        for (_ <- 1 until expo) yield {
          x -= 1
          fn += 1
          matrix(y)(x) = sumNeighbors(matrix, (x, y))
          if (matrix(y)(x) > upToN) return matrix(y)(x)
        }

        for (_ <- 1 until expo) yield {
          y += 1
          fn += 1
          matrix(y)(x) = sumNeighbors(matrix, (x, y))
          if (matrix(y)(x) > upToN) return matrix(y)(x)
        }

        for (_ <- 1 until expo) yield {
          x += 1
          fn += 1
          matrix(y)(x) = sumNeighbors(matrix, (x, y))
          if (matrix(y)(x) > upToN) return matrix(y)(x)
        }
      }

      expo += 2
    }

    -1
  }

  private def sumNeighbors(matrix: Matrix[Int], position: (Int, Int)): Int =
    matrix(position._2 - 1)(position._1 - 1) +
    matrix(position._2 - 1)(position._1) +
    matrix(position._2 - 1)(position._1 + 1) +
    matrix(position._2)(position._1 + 1) +
    matrix(position._2 + 1)(position._1 - 1) +
    matrix(position._2 + 1)(position._1) +
    matrix(position._2 + 1)(position._1 + 1) +
    matrix(position._2)(position._1 - 1)

}
