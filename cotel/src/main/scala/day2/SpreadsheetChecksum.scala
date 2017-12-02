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

}
