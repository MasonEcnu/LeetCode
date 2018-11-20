package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/11/20
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 *
 */
object LongestCommonPrefix14 {

  @JvmStatic
  fun main(args: Array<String>) {
    val strs = arrayOf("flower", "flow", "flight")
    val result = longestCommonPrefix(strs)
    println(result)
  }

  // 这么简单的题都不会，我觉得我是废了
  private fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var prefix = strs[0]
    for (i in 1 until strs.size)
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length - 1)
        if (prefix.isEmpty()) return ""
      }
    return prefix
  }
}