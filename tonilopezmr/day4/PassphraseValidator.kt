package day4

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.util.*

class PassphraseValidator {

  fun validI(passphrase: String): Boolean {
    val words = passphrase
        .split(" ")
    return words
        .foldIndexed(true) { idx, acc, a ->
          if (words.subList(idx + 1, words.size).contains(a)) {
            false
          } else {
            acc
          }
        }
  }

  fun valid(passphrase: String): Boolean {
    val list = LinkedList(passphrase.split(" "))
    val element = list.poll()
    return validR(list, element)
  }

  tailrec fun validR(passphrase: LinkedList<String>, element: String): Boolean =
      if (passphrase.isEmpty()) true
      else if (passphrase.contains(element)) false
      else {
        val element = passphrase.poll()
        validR(passphrase, element)
      }

  fun countValid(passphrase: List<String>): Int = passphrase
      .fold(0) { acc, a -> if (valid(a)) acc + 1 else acc }

  @Test
  fun `valid if no words duplicated`() {
    assertTrue(valid("aa bb cc dd"))
  }

  @Test
  fun `invalid if words duplicated`() {
    assertFalse(valid("aa bb cc dd aa"))
  }

  @Test
  fun `is valid - aa and aaa count as different words`() {
    assertTrue(valid("aa bb cc dd aaa"))
  }

  @Test
  fun `in list with 5 passphrase elements only 2 are valid`() {
    assertEquals(2, countValid(listOf(
        "aa bb cc dd cc",
        "miguel say my name miguel",
        "password",
        "aa bb cc dd hh jja",
        "aa bb cc dd hh jj aa"
    )))
  }

  @Test
  fun `result for the challenge of day 4 is`() {
    val sc = Scanner(File("input"))
    val input = mutableListOf<String>()
    while (sc.hasNext()) input.add(sc.nextLine())
    assertEquals(386, countValid(input))
  }
}