package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/10/29
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
object ReverseWordsInStringIII557 {

    @JvmStatic
    fun main(args: Array<String>) {
        val s = "Let's take LeetCode contest"
        val result = reverseWords(s)
        println(result)
    }

    private fun reverseWords(s: String): String {
        return StringBuilder().apply {
            s.split(" ").forEach {
                append("${it.reversed()} ")
            }
        }.toString().trim()
    }
}