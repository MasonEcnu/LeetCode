package com.mason.leetcode.bit.easy

/**
 * Created by mwu on 2018/11/04
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary.
 * For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 *
 * Example 1:
 * Input: L = 6, R = 10
 * Output: 4
 * Explanation:
 * 6 -> 110 (2 set bits, 2 is prime)
 * 7 -> 111 (3 set bits, 3 is prime)
 * 9 -> 1001 (2 set bits , 2 is prime)
 * 10->1010 (2 set bits , 2 is prime)
 *
 * Example 2:
 * Input: L = 10, R = 15
 * Output: 5
 * Explanation:
 * 10 -> 1010 (2 set bits, 2 is prime)
 * 11 -> 1011 (3 set bits, 3 is prime)
 * 12 -> 1100 (2 set bits, 2 is prime)
 * 13 -> 1101 (3 set bits, 3 is prime)
 * 14 -> 1110 (3 set bits, 3 is prime)
 * 15 -> 1111 (4 set bits, 4 is not prime)
 *
 * Note:
 * L, R will be integers L <= R in the range [1, 10^6].
 * R - L will be at most 10000.
 */
object PrimeNumberOfSetBitsInBinaryRepresentation762 {

    @JvmStatic
    fun main(args: Array<String>) {
        val L = 6
        val R = 10
        val result = countPrimeSetBits(L, R)
        println(result)
    }

    private fun countPrimeSetBits(L: Int, R: Int): Int {
        var result = 0
        (L..R).forEach { range ->
            val biStr = range.toString(2)
            val count = biStr.count { it == '1' }
            if (count.isPrime()) result++
        }
        return result
    }

    private fun Int.isPrime(): Boolean {
//    if (this < 2) return false
//    (2..Math.sqrt(this.toDouble()).toInt()).forEach { range ->
//      if (this % range == 0) return false
//    }
//    return true

        return this == 2 || this == 3 || this == 5 || this == 7 || this == 11
                || this == 13 || this == 17 || this == 19
    }
}