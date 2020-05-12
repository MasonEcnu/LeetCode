package com.mason.leetcode.array.easy

import com.mason.leetcode.tools.printArray

/**
 * Created by mwu on 2018/10/27
 * Given a matrix A, return the transpose of A.
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Example 2:
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
object TransposeMatrix867 {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        val result = transpose(A)
        printArray(result)
    }

    private fun transpose(A: Array<IntArray>): Array<IntArray> {
        if (A.isEmpty()) return A
        val m = A.size
        val n = A[0].size
        val B = Array(n, init = { IntArray(m) })
        (0 until m).forEach { i ->
            (0 until n).forEach { j ->
                B[j][i] = A[i][j]
            }
        }
        return B
    }
}