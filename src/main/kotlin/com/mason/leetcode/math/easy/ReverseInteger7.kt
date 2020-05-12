package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/11/19
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
object ReverseInteger7 {

    @JvmStatic
    fun main(args: Array<String>) {
        val x = 1534236469
        val result = reverse(x)
        println(result)
    }

    private fun reverse(x: Int): Int {
        // 笨方法
//    return try {
//      if (x < 0) {
//        0 - Math.abs(x).toString().reversed().toInt()
//      } else {
//        x.toString().reversed().toInt()
//      }
//    } catch (e: Exception) {
//      0
//    }
//  }

        // 聪明点儿
        var result = 0
        var temp = x
        while (temp != 0) {
            val rem = temp % 10
            temp /= 10
            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && rem > 7)) return 0
            if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && rem < -8)) return 0
            result = result * 10 + rem
        }
        return result
    }
}