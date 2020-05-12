package com.mason.leetcode.array.easy

import com.mason.leetcode.tools.printIntArray

/**
 * Created by mwu on 2018/10/26
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 * Note:
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
object SortArrayByParityII922 {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = intArrayOf(3, 4)
        val result = sortArrayByParityII(A)
        printIntArray(result)
    }

    private fun sortArrayByParityII(A: IntArray): IntArray {
//    if (A.isEmpty()) return intArrayOf()
//    val odd = A.filter { it % 2 == 1 }
//    val even = A.filter { it % 2 == 0 }
//    A.indices.forEach {
//      A[it] = if (it % 2 == 0) even[it / 2] else odd[it / 2]
//    }
//    return A

        var j = 1
        var i = 0
        while (i < A.size) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2

                // 保证交换后的i位置的值，满足条件
                // Swap A[i] and A[j]
                val tmp = A[i]
                A[i] = A[j]
                A[j] = tmp
            }
            i += 2
        }
        return A
    }
}