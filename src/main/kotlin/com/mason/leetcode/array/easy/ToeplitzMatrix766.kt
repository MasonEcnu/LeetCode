package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/10/31
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Example 1:
 * Input:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 *
 * Example 2:
 * Input:
 * matrix =
 * [[1,2],
 * [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 * Note:
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 *
 * Follow up:
 * What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into the memory at once?
 */
object ToeplitzMatrix766 {

  @JvmStatic
  fun main(args: Array<String>) {
    val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 1, 2, 3), intArrayOf(9, 5, 1, 2))
    val result = isToeplitzMatrix(matrix)
    println(result)
  }

  private fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
//    if (matrix.isEmpty()) return true
//    val m = matrix.size // 行
//    val n = matrix[0].size  // 列
//    val result = arrayListOf<Set<Int>>()
//    (1 until n).forEach {
//      result.add(getObliqueSet(0, it, m, n, matrix))
//    }
//    (1 until m).forEach {
//      result.add(getObliqueSet(it, 0, m, n, matrix))
//    }
//    result.add(getObliqueSet(0, 0, m, n, matrix))
//    return result.all { it.size == 1 }

    // 同样的双重遍历，只是空间复杂度降低为O(1)了
    if (matrix.isEmpty()) return true
    (0 until matrix.size - 1).forEach { outer ->
      (0 until matrix[0].size - 1).forEach { inner ->
        if (matrix[outer][inner] != matrix[outer + 1][inner + 1]) return false
      }
    }
    return true
  }

  private fun getObliqueSet(mStart: Int, nStart: Int, m: Int, n: Int, matrix: Array<IntArray>): Set<Int> {
    var ms = mStart
    var ns = nStart
    val result = hashSetOf<Int>()
    while (ms < m && ns < n) {
      result.add(matrix[ms][ns])
      ms++
      ns++
    }
    return result
  }
}