package com.mason.leetcode.bit.easy

/**
 * Created by mwu on 2018/10/29
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
object NumberComplement467 {

  @JvmStatic
  fun main(args: Array<String>) {
    val num = 1
    val result = findComplement(num)
    println(result)
  }

  private fun findComplement(num: Int): Int {
//    val sb = StringBuilder()
//    num.toString(2).forEach {
//      sb.append(if (it == '0') 1 else 0)
//    }
//    val str = sb.toString()
//    val index = str.indexOfFirst { it == '1' }
//    return if (index == -1) 0 else str.substring(index).toInt(2)

    // 异或
    val range = num.toString(2).length
    val temp = StringBuilder().apply {
      (0 until range).forEach { _ ->
        append(1)
      }
    }.toString().toInt(2)
    return num xor temp
  }
}