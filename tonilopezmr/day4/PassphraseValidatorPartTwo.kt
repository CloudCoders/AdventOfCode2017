package day4


import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.util.*

class PassphraseValidatorPartTwo {

  fun validI(passphrase: String): Boolean {
    val words = passphrase
        .split(" ")
    return words
        .foldIndexed(true) { idx, acc, a ->
          acc && words.subList(idx + 1, words.size)
              .fold(true) { bcc, b ->
                bcc && !equalsInAnyOrder(a, b)
              }
        }
  }

  fun containsInAnyOrder(passphrase: List<String>, element: String): Boolean =
          passphrase.fold(false) { bcc, b ->
            if (equalsInAnyOrder(element, b)) true
            else bcc
          }

  fun equalsInAnyOrder(a: String, b: String): Boolean = a.fold(true) { acc, it ->
    if (a.length != b.length) false else acc && b.contains(it)
  }

  fun valid(passphrase: String): Boolean {
    val list = LinkedList(passphrase.split(" "))
    val element = list.poll()
    return validR(list, element)
  }

  tailrec fun validR(passphrase: LinkedList<String>, element: String): Boolean =
      if (passphrase.isEmpty()) true
      else if (containsInAnyOrder(passphrase, element)) false
      else {
        val element = passphrase.poll()
        validR(passphrase, element)
      }

  fun countValid(passphrase: List<String>): Int = passphrase
      .fold(0) { acc, a -> if (valid(a)) acc + 1 else acc }

  @Test
  fun `ab contains in any order ba`() {
    assertTrue(equalsInAnyOrder("ab", "ba"))
  }

  @Test
  fun `aa contains in any order aa`() {
    assertTrue(equalsInAnyOrder("aa", "aa"))
  }

  @Test
  fun `ab not contains in any order bc`() {
    assertFalse(equalsInAnyOrder("ab", "bc"))
  }

  @Test
  fun `aa not contains in any order aaa`() {
    assertFalse(equalsInAnyOrder("aa", "aaa"))
  }

  @Test
  fun `aa bb cc dd contains in any order`() {
    assertTrue(containsInAnyOrder("aa bb cc dd".split(" "), "aa"))
  }

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
        "ab bc cd de cb",
        "miguel say my name lguiem",
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
    assertEquals(208, countValid(input))
  }
}