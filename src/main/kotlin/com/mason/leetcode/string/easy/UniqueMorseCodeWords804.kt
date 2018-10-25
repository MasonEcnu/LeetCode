package com.mason.leetcode.string.easy

import java.lang.StringBuilder

/**
 * Created by mwu on 2018/10/25
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
 * We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 *
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * There are 2 different transformations, "--...-." and "--...--.".
 *
 * Note:
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */
object UniqueMorseCodeWords804 {

  private val dots_array = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")

  private val dots_map = mapOf(
      'a' to ".-", 'b' to "-...", 'c' to "-.-.", 'd' to "-..",
      'e' to ".", 'f' to "..-.", 'g' to "--.", 'h' to "....",
      'i' to "..", 'j' to ".---", 'k' to "-.-", 'l' to ".-..",
      'm' to "--", 'n' to "-.", 'o' to "---", 'p' to ".--.",
      'q' to "--.-", 'r' to ".-.", 's' to "...", 't' to "-",
      'u' to "..-", 'v' to "...-", 'w' to ".--", 'x' to "-..-",
      'y' to "-.--", 'z' to "--..")

  @JvmStatic
  fun main(args: Array<String>) {
    val words = arrayOf("gin", "zen", "gig", "msg")
    val result = uniqueMorseRepresentations(words)
    println(result)
  }

  private fun uniqueMorseRepresentations(words: Array<String>): Int {
    if (words.isEmpty()) return 0
    val result = mutableSetOf<String>()
    words.forEach { word ->
      val sb = StringBuilder()
      word.toLowerCase().forEach {
        //        sb.append(dots_array[it.toInt() - 97])
        sb.append(dots_map[it])
      }
      result.add(sb.toString())
    }
    return result.size
  }
}