package com.mason.leetcode.array.easy

import com.mason.leetcode.tools.printIntArray

/**
 * Created by mwu on 2018/11/22
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 *
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 */
object RemoveElement27 {

  @JvmStatic
  fun main(args: Array<String>) {
    val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val value = 2
    val result = removeElement(nums, value)
    // IntRange：是一个闭区间
    printIntArray(nums)
    println(result)
  }

  private fun removeElement(nums: IntArray, `val`: Int): Int {
//    var slow = 0
//    (0 until nums.size).forEach {
//      if (nums[it] != `val`) {
//        val temp = nums[slow]
//        nums[slow] = nums[it]
//        nums[it] = temp
//        slow++
//      }
//    }
//    return slow

    var index = 0
    (0 until nums.size).forEach {
      if (nums[it] != `val`) {
        nums[index++] = nums[it]
      }
    }
    return index
  }
}