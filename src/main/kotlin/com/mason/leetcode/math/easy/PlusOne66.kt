package com.mason.leetcode.math.easy

import com.mason.leetcode.tools.printIntArray

/**
 * Created by mwu on 2018/12/17
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
object PlusOne66 {

  @JvmStatic
  fun main(args: Array<String>) {
    val digits = intArrayOf(9, 9)
    val result = plusOne(digits)
    printIntArray(result)
  }

  private fun plusOne(digits: IntArray): IntArray {
    // easy way
    // 不能处理太大的数
//    val sb = StringBuilder()
//    digits.forEach {
//      sb.append(it)
//    }
//    val str = sb.toString().toLong().plus(1).toString()
//    val result = IntArray(size = str.length)
//    str.forEachIndexed { index, c ->
//      result[index] = c.toString().toInt()
//    }
//    return result

    // 牛逼！！！
    if (digits.isEmpty()) {
      return digits
    }
    for (i in digits.size - 1 downTo 0) {
      if (digits[i] < 9) {
        digits[i]++
        return digits
      } else {
        digits[i] = 0
      }
    }
    val result = IntArray(digits.size + 1)
    result[0] = 1
    return result
  }
}