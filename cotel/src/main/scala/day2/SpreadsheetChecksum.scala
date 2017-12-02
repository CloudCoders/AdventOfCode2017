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

  val spreadsheet = SpreadSheet(
    Row(493, 458, 321, 120, 49, 432, 433, 92, 54, 452, 41, 461, 388, 409, 263, 58),
    Row(961, 98, 518, 188, 958, 114, 1044, 881, 948, 590, 972, 398, 115, 116, 451, 492),
    Row(76, 783, 709, 489, 617, 72, 824, 452, 748, 737, 691, 90, 94, 77, 84, 756),
    Row(204, 217, 90, 335, 220, 127, 302, 205, 242, 202, 259, 110, 118, 111, 200, 112),
    Row(249, 679, 4015, 106, 3358, 1642, 228, 4559, 307, 193, 4407, 3984, 3546, 2635, 3858, 924),
    Row(1151, 1060, 2002, 168, 3635, 3515, 3158, 141, 4009, 3725, 996, 142, 3672, 153, 134, 1438),
    Row(95, 600, 1171, 1896, 174, 1852, 1616, 928, 79, 1308, 2016, 88, 80, 1559, 1183, 107),
    Row(187, 567, 432, 553, 69, 38, 131, 166, 93, 132, 498, 153, 441, 451, 172, 575),
    Row(216, 599, 480, 208, 224, 240, 349, 593, 516, 450, 385, 188, 482, 461, 635, 220),
    Row(788, 1263, 1119, 1391, 1464, 179, 1200, 621, 1304, 55, 700, 1275, 226, 57, 43, 51),
    Row(1571, 58, 1331, 1253, 60, 1496, 1261, 1298, 1500, 1303, 201, 73, 1023, 582, 69, 339),
    Row(80, 438, 467, 512, 381, 74, 259, 73, 88, 448, 386, 509, 346, 61, 447, 435),
    Row(215, 679, 117, 645, 137, 426, 195, 619, 268, 223, 792, 200, 720, 260, 303, 603),
    Row(631, 481, 185, 135, 665, 641, 492, 408, 164, 132, 478, 188, 444, 378, 633, 516),
    Row(1165, 1119, 194, 280, 223, 1181, 267, 898, 1108, 124, 618, 1135, 817, 997, 129, 227),
    Row(404, 1757, 358, 2293, 2626, 87, 613, 95, 1658, 147, 75, 930, 2394, 2349, 86, 385)
  )
}

