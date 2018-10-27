package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/10/27
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 * Example 1:
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 *
 * Example 2:
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 *
 * Example 3:
 * Input: A = [1,3,6], K = 1
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 *
 * Note:
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
object SmallestRangeI {

  @JvmStatic
  fun main(args: Array<String>) {
    val A = intArrayOf(0, 2, 4, 6, 8, 10)
    val K = 2
    val result = smallestRangeI(A, K)
    println(result)
  }

  private fun smallestRangeI(A: IntArray, K: Int): Int {
    if (A.isEmpty()) return 0
    var min = A[0]
    var max = A[0]
    A.forEach {
      min = Math.min(min, it)
      max = Math.max(max, it)
    }
    return Math.max(0, max - min - 2 * K)
  }
}