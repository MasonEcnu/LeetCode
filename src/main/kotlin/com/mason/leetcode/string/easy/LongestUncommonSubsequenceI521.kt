package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/11/5
 *
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.
 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements.
 * Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence.
 * If the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example 1:
 * Input: "aba", "cdc"
 * Output: 3
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
 * because "aba" is a subsequence of "aba",
 * but not a subsequence of any other strings in the group of two strings.
 *
 * Note:
 * Both strings' lengths will not exceed 100.
 * Only letters from a ~ z will appear in input strings.
 */
object LongestUncommonSubsequenceI521 {

    @JvmStatic
    fun main(args: Array<String>) {
        val a = ""
        val b = ""
        val result = findLUSlength(a, b)
        println(result)
    }

    /**
     * As long as you realize you can always choose the longer string as the "Subsequence",
     * and surely it cannot be the subsequence of the shorter one, the problem becomes a piece of cake.
     */
    private fun findLUSlength(a: String, b: String): Int {
        return if (a == b) -1 else Math.max(a.length, b.length)
    }
}