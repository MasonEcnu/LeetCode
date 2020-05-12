package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/11/5
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 *
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
object ReverseOnlyLetters917 {

    @JvmStatic
    fun main(args: Array<String>) {
        val S = "7_28"
        val result = reverseOnlyLetters(S)
        println(result)
    }

    private val big_range = (65..90)
    private val small_range = (97..122)

    private fun reverseOnlyLetters(S: String): String {
//    val temp = S.filter { it.toInt() in big_range || it.toInt() in small_range }.reversed()
//    var index = 0
//    val cs = S.toCharArray()
//    cs.indices.forEach {
//      if (cs[it].toInt() in big_range || cs[it].toInt() in small_range) {
//        cs[it] = temp[index]
//        index++
//      }
//    }
//    return String(cs)

        // 自带类库
//    val temp = S.filter { Character.isLetter(it) }.reversed()
//    var index = 0
//    val cs = S.toCharArray()
//    cs.indices.forEach {
//      if (Character.isLetter(cs[it])) {
//        cs[it] = temp[index]
//        index++
//      }
//    }
//    return String(cs)

        // 前后指针
        var front = 0
        var back = S.length - 1
        val cs = S.toCharArray()
        while (front < back) {
            when {
                Character.isLetter(cs[front]) && Character.isLetter(cs[back]) -> {
                    val c = cs[front]
                    cs[front] = cs[back]
                    cs[back] = c
                    front++
                    back--
                }
                Character.isLetter(cs[front]) -> back--
                Character.isLetter(cs[back]) -> front++
                else -> {
                    front++
                    back--
                }
            }
        }
        return String(cs)
    }
}