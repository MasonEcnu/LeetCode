package com.mason.leetcode.stack.easy

import com.mason.leetcode.tools.printIntArray
import java.util.ArrayDeque
import java.util.HashMap


/**
 * Created by mwu on 2018/11/04
 *
 *  You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 *  Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *  The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 *  If it does not exist, output -1 for this number.
 *
 *  Example 1:
 *  Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 *  Output: [-1,3,-1]
 *  Explanation:
 *  For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *  For number 1 in the first array, the next greater number for it in the second array is 3.
 *  For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 *  Example 2:
 *  Input: nums1 = [2,4], nums2 = [1,2,3,4].
 *  Output: [3,-1]
 *  Explanation:
 *  For number 2 in the first array, the next greater number for it in the second array is 3.
 *  For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 *  Note:
 *  All elements in nums1 and nums2 are unique.
 *  The length of both nums1 and nums2 would not exceed 1000.
 */
object NextGreaterElementI496 {

  @JvmStatic
  fun main(args: Array<String>) {
    val nums1 = intArrayOf(2, 4)
    val nums2 = intArrayOf(1, 2, 3, 4)
    val result = nextGreaterElement(nums1, nums2)
    printIntArray(result)
  }

  private fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
//    val result = IntArray(size = nums1.size, init = { -1 })
//    val index = IntArray(size = nums1.size)
//    nums1.forEachIndexed { outer, ov ->
//      nums2.forEachIndexed { inner, iv ->
//        if (ov == iv) index[outer] = inner
//      }
//    }
//    nums1.forEachIndexed { outer, ov ->
//      (index[outer] until nums2.size).forEach { inner ->
//        if (ov < nums2[inner]) {
//          result[outer] = nums2[inner]
//          return@forEachIndexed
//        }
//      }
//    }
//    return result

    val map = HashMap<Int, Int>()
    val result = IntArray(nums1.size)
    val stack = ArrayDeque<Int>()
    for (num2 in nums2) {
      while (!stack.isEmpty() && stack.peek() < num2) {
        map[stack.removeFirst()] = num2
      }
      stack.addFirst(num2)
    }
    for (i in 0 until nums1.size) {
      result[i] = map.getOrDefault(nums1[i], -1)
    }

    return result
  }
}