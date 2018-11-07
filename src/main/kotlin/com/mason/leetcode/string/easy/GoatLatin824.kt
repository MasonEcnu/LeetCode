package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/11/6
 *
 * A sentence S is given, composed of words separated by spaces.
 * Each word consists of lowercase and uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Example 1:
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * Example 2:
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * Notes:
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 *
 * 测试用例是错的，不知道别人都是怎么作对的
 */
object GoatLatin824 {

  @JvmStatic
  fun main(args: Array<String>) {
    val S = "apple"
    val result = toGoatLatin(S)
    println(result)
  }

  private val vowels_set = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

  private fun toGoatLatin(S: String): String {
    val sb = StringBuilder()
    S.split(" ").forEachIndexed { index, char ->
      val times = index + 1
      val add = "a".repeat(times)
      if (vowels_set.contains(char.first())) {
        sb.append(char).append("ma").append(add).append(" ")
      } else {
        val str = char + char.last()
        sb.append(str.substring(1)).append("ma").append(add).append(" ")
      }
    }
    val result = sb.toString()
    return result.substring(0, result.length - 1)
  }
}