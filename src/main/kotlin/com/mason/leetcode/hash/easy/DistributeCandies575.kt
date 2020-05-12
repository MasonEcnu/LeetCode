package com.mason.leetcode.hash.easy

/**
 * Created by mwu on 2018/11/2
 *
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind.
 * You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 *
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * The sister has three different kinds of candies.
 *
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind of candies.
 *
 * Note:
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 */
object DistributeCandies575 {

    @JvmStatic
    fun main(args: Array<String>) {
        val candies = intArrayOf(100000, 0, 100000, 0, 100000, 0, 100000, 0, 100000, 0, 100000, 0)
        val result = distributeCandies(candies)
        println(result)
    }

    private fun distributeCandies(candies: IntArray): Int {
//    if (candies.size % 2 == 1) return 0
//    val size = candies.size
//    val num = size / 2  // sister最多可以拿到的candy数量
//    val kinds = candies.toHashSet().size
//    return if (num >= kinds) kinds else num

        if (candies.size % 2 == 1) return 0
        val size = candies.size
        val num = size / 2  // sister最多可以拿到的candy数量
        var kinds = 1
        candies.sort()
        candies.forEachIndexed { index, value ->
            if (index == 0) return@forEachIndexed
            if (value != candies[index - 1]) kinds++
        }
        return if (num >= kinds) kinds else num
    }
}