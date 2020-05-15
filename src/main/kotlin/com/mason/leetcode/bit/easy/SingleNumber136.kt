package com.mason.leetcode.bit.easy

/**
 * Created by mwu on 2018/11/04
 *
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
object SingleNumber136 {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(4, 1, 2, 1, 2)
        val result = singleNumber(nums)
        println(result)
    }

    private fun singleNumber(nums: IntArray): Int {
        // 再也不做空判断了。。。尼玛，这么影响性能的
//    if (nums.isEmpty()) return 0
//    var result = 0
//    (0 until nums.size).forEach { it ->
//      result = result xor nums[it]
//    }
//    return result

        val countMap = hashMapOf<Int, Int>()
        nums.forEach {
            val value = countMap[it]
            if (value == null) {
                countMap[it] = 1
            } else {
                var temp = countMap[it]
                if (temp != null) {
                    temp++
                    countMap[it] = temp
                }
            }
        }
        return countMap.entries.find { it.value == 1 }?.key ?: 0
    }

    private fun singleNumber1(nums: IntArray): Int {
        var result = 0
        nums.forEach { num -> result = result xor num }
        return result
    }
}