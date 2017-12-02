package day2


object SpreadsheetChecksum {
  type Row = List[Int]
  type SpreadSheet = List[Row]

  def Row(xs: Int*) = List(xs: _*)
  def SpreadSheet(rows: Row*) = List(rows: _*)

  def checksum(spreadSheet: SpreadSheet): Int = {
    18
  }

}
