package day2


object SpreadsheetChecksum {
  type Row = List[Int]
  type SpreadSheet = List[Row]

  def Row(xs: Int*) = List(xs: _*)

  def SpreadSheet(rows: Row*) = List(rows: _*)

  def checksum(spreadSheet: SpreadSheet): Int = {
    spreadSheet
      .map { list => (list.max, list.min) }
      .foldLeft(0) {
        case (acc, (max, min)) => acc + (max - min)
      }
  }

  def divsum(spreadSheet: SpreadSheet): Int = {
    spreadSheet
      .map(findEvenlyDivision)
      .foldLeft(0) {
        case (acc, Some(x)) => acc + x.toInt
        case (acc, None) => acc
      }
  }

  private def findEvenlyDivision(row: Row): Option[Int] = {
    val divisions: List[List[Float]] = for (number <- row) yield row.filterNot(_ == number).map(number.toFloat / _)

    divisions.flatten.find(_ % 1 == 0).map(_.toInt)
  }

}
