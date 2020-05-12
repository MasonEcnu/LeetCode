package com.mason.leetcode.array.middle

/**
 * Created by mwu on 2019/10/29
 *
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
object ThreeSumClosest {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(-1, 2, 1, -4)
        val target = 1
        println(threeSumClosest(nums, target))
    }

    private fun threeSumClosest(nums: IntArray, target: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun slowestThreeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size <= 3) return nums.sum()
        val size = nums.size

        var sum = 0
        var diff = Int.MAX_VALUE
        (0 until size).forEach { i ->
            (i + 1 until size).forEach { j ->
                (j + 1 until size).forEach { k ->
                    val temp = nums[i] + nums[j] + nums[k]
                    val tempDiff = Math.abs(temp - target)
                    if (tempDiff < diff) {
                        sum = temp
                        diff = tempDiff
                    }
                }
            }
        }
        return sum
    }
}