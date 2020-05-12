package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2019/1/1
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 */
object AddBinary67 {

    @JvmStatic
    fun main(args: Array<String>) {
        val a = "111111"
        val b = "1"
        val result = addBinary(a, b)
        println(result)
    }

    private fun addBinary(a: String, b: String): String {
        // 最笨方法
//    val aInt = a.toBigInteger(2)
//    val bInt = b.toBigInteger(2)
//    return (aInt + bInt).toString(2)
        val sb = StringBuilder()
        val min = Math.min(a.length, b.length)
        (0 until min).forEach { i ->
            when {
                a[i] == '0' && b[i] == '0' -> sb.append(0)
                a[i] == '0' && b[i] == '1' -> sb.append(1)
                a[i] == '1' && b[i] == '0' -> sb.append(1)
                a[i] == '1' && b[i] == '1' -> {
                    sb.append(0).append(1)
                }
            }
        }
        if (min == a.length) {
            (min until b.length).forEach { i ->
                sb.append(b[i])
            }
        }
        if (min == b.length) {
            (min until a.length).forEach { i ->
                sb.append(a[i])
            }
        }
        return sb.reverse().toString()
    }
}