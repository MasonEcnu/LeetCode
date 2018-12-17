package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/11/22
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
object ImplementStrStr28 {

  @JvmStatic
  fun main(args: Array<String>) {
    val haystack = "mississippi"
    val needle = "issip"
    val result = strStr(haystack, needle)
    println(result)
  }

  // 有思路居然都做不对。。服了自己了
  private fun strStr(haystack: String, needle: String): Int {
    var i = 0
    while (true) {
      var j = 0
      while (true) {
        if (j == needle.length) return i
        if (i + j == haystack.length) return -1
        // i + j: 这里的比较是关键
        if (needle[j] != haystack[i + j]) break
        j++
      }
      i++
    }
  }
}