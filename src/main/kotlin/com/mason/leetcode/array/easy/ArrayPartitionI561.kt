package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/10/26
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 *  Example 1:
 *  Input: [1,4,3,2]
 *  Output: 4
 *  Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 *
 *  Note:
 *  n is a positive integer, which is in the range of [1, 10000].
 *  All the integers in the array will be in the range of [-10000, 10000].
 */
object ArrayPartitionI561 {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 4, -3, 2)
        val result = arrayPairSum(nums)
        println(result)
    }

    private fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        return (0 until nums.size step 2).sumBy { nums[it] }
    }
}