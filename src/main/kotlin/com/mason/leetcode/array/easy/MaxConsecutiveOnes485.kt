package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/11/7
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
object MaxConsecutiveOnes485 {

  @JvmStatic
  fun main(args: Array<String>) {
    val nums = intArrayOf(1, 1, 0, 1, 1, 1)
    val result = findMaxConsecutiveOnes(nums)
    println(result)
  }

  private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var count = 0
    var max = 0
    nums.forEach {
      if (it == 1) {
        count++
        max = Math.max(max, count)
      } else {
        count = 0
      }
    }
    return max
  }
}