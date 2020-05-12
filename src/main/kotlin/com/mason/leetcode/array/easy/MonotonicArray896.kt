package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/11/7
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 *
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 *
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 *
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
object MonotonicArray896 {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = intArrayOf(3, 2, 2, 3)
        val result = isMonotonic(A)
        println(result)
    }

    private fun isMonotonic(A: IntArray): Boolean {
//    return A.contentEquals(A.sortedArray()) || A.contentEquals(A.sortedArrayDescending())

        var inc = 1
        var dec = 1
        val size = A.size
        (0 until size - 1).forEach {
            when {
                A[it] > A[it + 1] -> dec++
                A[it] < A[it + 1] -> inc++
                else -> {
                    inc++
                    dec++
                }
            }
        }
        return inc == size || dec == size
    }
}