package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/11/23
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
object SearchInsertPosition35 {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 3, 5, 6, 9)
        val target = 2
        val result = searchInsert(nums, target)
        println(result)
    }

    private fun searchInsert(nums: IntArray, target: Int): Int {
        // O(n)的笨方法
//    var result = 0
//    run outside@{
//      (0 until nums.size).forEach {
//        if (nums[it] >= target) {
//          result = it
//          return@outside
//        }
//        if (it == nums.lastIndex && nums[it] < target){
//          result = nums.size
//        }
//      }
//    }
//    return result

        // 二分查找
        var low = 0
        var high = nums.size - 1
        var mid: Int
        while (low <= high) {
            mid = (low + high) / 2
            when {
                target > nums[mid] -> low = mid + 1
                target < nums[mid] -> high = mid - 1
                else -> return mid
            }
        }
        return low
    }
}