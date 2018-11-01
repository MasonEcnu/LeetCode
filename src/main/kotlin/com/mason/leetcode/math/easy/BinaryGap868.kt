package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/11/1
 *
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 * If there aren't two consecutive 1's, return 0.
 *
 * Example 1:
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 *
 * Example 2:
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 *
 * Example 3:
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 *
 * Example 4:
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 *
 * Note:
 * 1 <= N <= 10^9
 */
object BinaryGap868 {

  @JvmStatic
  fun main(args: Array<String>) {
    val N = 22
    val result = binaryGap(N)
    println(result)
  }

  private fun binaryGap(N: Int): Int {
    val bn = N.toString(2)
//    val disList = arrayListOf<Int>()
//    bn.forEachIndexed { index, char ->
//      if (char == '1') disList.add(index)
//    }
//    var minDis = Int.MIN_VALUE
//    var diff: Int
//    (0 until disList.size - 1).forEach {
//      diff = disList[it + 1] - disList[it]
//      minDis = Math.max(minDis, diff)
//    }
//    return minDis
    var index = 0
    var minDis = Int.MIN_VALUE
    bn.forEachIndexed { i, char ->
      if (char == '1' && index != i) {
        minDis = Math.max(minDis, i - index)
        index = i
      }
    }
    return if (minDis == Int.MIN_VALUE) 0 else minDis
  }
}