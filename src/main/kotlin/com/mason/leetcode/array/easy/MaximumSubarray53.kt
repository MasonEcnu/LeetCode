package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/12/11
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
object MaximumSubarray53 {

  @JvmStatic
  fun main(args: Array<String>) {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val result = maxSubArray(nums)
    println(result)
  }

  private fun maxSubArray(nums: IntArray): Int {
    // 方法1：遍历法
//    if (nums.isEmpty()) return 0
//
//    var max = nums[0]
//    var maxNow = nums[0]
//    (1 until nums.size).forEach { i ->
//      max = Math.max(max + nums[i], nums[i])
//      maxNow = Math.max(max, maxNow)
//    }
//    return maxNow

    // 方法2：动态规划
    // maxSubArray(nums, i) = if (maxSubArray(nums, i - 1) > 0) maxSubArray(nums, i - 1) else 0 + nums[i]
    if (nums.isEmpty()) return 0

    val size = nums.size
    // dp[i] means the maximum subarray ending with nums[i]
    val dp = IntArray(size = size)
    dp[0] = nums[0]
    var max = dp[0]

    (1 until size).forEach { i ->
      dp[i] = if (dp[i - 1] > 0) nums[i] + dp[i - 1] else nums[i]
      max = Math.max(max, dp[i])
    }
    return max
  }
}