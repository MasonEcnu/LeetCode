package com.mason.leetcode.bit.easy

/**
 * Created by mwu on 2018/10/26
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 2^31.
 *
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
object HammingDistance461 {

    @JvmStatic
    fun main(args: Array<String>) {
        val x = 1
        val y = 4
        val result = hammingDistance(x, y)
        println(result)
    }

    private fun hammingDistance(x: Int, y: Int): Int {
        // 异或
//    return Integer.bitCount(x xor y)

        // 位运算+计数
        var n = x xor y
        var count = 0
        while (n != 0) {
            n = n and n - 1
            count++
        }
        return count
    }
}