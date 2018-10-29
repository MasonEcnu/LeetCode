package com.mason.leetcode.string.easy

import com.mason.leetcode.tools.printIntArray

/**
 * Created by mwu on 2018/10/29
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * Note:
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
object ShortestDistanceToCharacter821 {

  @JvmStatic
  fun main(args: Array<String>) {
    val S = "loveleetcode"
    val C = 'e'
    val result = shortestToChar(S, C)
    printIntArray(result)
  }

  private fun shortestToChar(S: String, C: Char): IntArray {
    val cindex = mutableListOf<Int>()
    S.forEachIndexed { index, c ->
      if (c == C) cindex.add(index)
    }
    val result = IntArray(size = S.length, init = { Int.MAX_VALUE })
    S.forEachIndexed { index, c ->
      if (c == C) {
        result[index] = 0
      } else {
        cindex.forEach {
          result[index] = Math.min(result[index], Math.abs(index - it))
        }
      }
    }
    return result
  }
}