package com.mason.leetcode.string.easy

import java.util.*

/**
 * Created by mwu on 2018/10/30
 *
 * You are given an array A of strings.
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 * Return the number of groups of special-equivalent strings from A.
 *
 * Example 1:
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 *
 * Example 2:
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 *
 * Example 3:
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 *
 * Example 4:
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 */
object GroupsOfSpecialEquivalentStrings893 {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = arrayOf("abc", "acb", "bac", "bca", "cab", "cba")
        val result = numSpecialEquivGroups(A)
        println(result)
    }

    // 讲真，我没理解这题要干啥？
    private fun numSpecialEquivGroups(A: Array<String>): Int {
        if (A.isEmpty()) return 0
        val set = mutableSetOf<String>()
        A.forEach {
            val sb1 = StringBuilder()
            val sb2 = StringBuilder()
            it.forEachIndexed { index, c ->
                if (index % 2 == 0) {
                    sb1.append(c)
                } else {
                    sb2.append(c)
                }
            }
            val cs1 = sb1.toString().toCharArray()
            val cs2 = sb2.toString().toCharArray()
            Arrays.sort(cs1)
            Arrays.sort(cs2)
            println(String(cs1 + cs2))
            set.add(String(cs1 + cs2))
        }
        return set.size
    }
}