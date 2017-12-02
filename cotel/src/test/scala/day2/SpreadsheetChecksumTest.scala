package day2

import org.scalatest.{FunSuite, Matchers}

class SpreadsheetChecksumTest extends FunSuite with Matchers {
  import SpreadsheetChecksum._

  /* 5 1 9 5
     7 5 3
     2 4 6 8 */
  test("Spreadsheed checksum should return 18") {
    val spreadsheet = SpreadSheet(
      Row(5,1,9,5),
      Row(7,5,3),
      Row(2,4,6,8)
    )

    checksum(spreadsheet) shouldBe 18
  }

  /* 1 7 9 1
     3 9 21 1
     1 1 1 1 2
   */
  test("Spreadsheet checksum should return 29") {
    val spreadsheet = SpreadSheet(
      Row(1, 7, 9, 1),
      Row(3, 9, 21, 1),
      Row(1, 1, 1, 1, 2)
    )

    checksum(spreadsheet) shouldBe 29
  }

}
