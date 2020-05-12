package com.mason.leetcode.binary.easy

/**
 * Created by mwu on 2018/10/26
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example 1:
 * Input: [0,1,0]
 * Output: 1
 *
 * Example 2:
 * Input: [0,2,1,0]
 * Output: 1
 *
 * Note:
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
object PeakIndexInMountainArray852 {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = intArrayOf(0, 1, 0)
        val result = peakIndexInMountainArray(A)
        println(result)
    }

    private fun peakIndexInMountainArray(A: IntArray): Int {
        if (A.size < 3) return 0
//    var max = A[0]
//    var index = 0
//    A.forEachIndexed { i, value ->
//      if (value > max) {
//        max = value
//        index = i
//      }
//    }
//    return index

        return A.indexOf(A.max() ?: A[0])
    }
}