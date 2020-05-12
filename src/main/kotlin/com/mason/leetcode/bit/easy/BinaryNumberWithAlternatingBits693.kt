package com.mason.leetcode.bit.easy

/**
 * Created by mwu on 2018/11/04
 *
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 *
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 *
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 *
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */
object BinaryNumberWithAlternatingBits693 {


    @JvmStatic
    fun main(args: Array<String>) {
        val n = 1
        val result = hasAlternatingBits(n)
        println(result)
    }

    private fun hasAlternatingBits(n: Int): Boolean {
//    val bits = n.toString(2).toCharArray()
//    (0 until bits.size - 1).forEach {
//      if (bits[it] == bits[it + 1]) return false
//    }
//    return true

        return n.toString(2).mapIndexed { index, c ->
            if (index and 1 == 0) c == '1'
            else c == '0'
        }.all {
            it
        }
    }
}