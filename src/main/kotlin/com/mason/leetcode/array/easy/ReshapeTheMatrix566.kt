package com.mason.leetcode.array.easy

import com.mason.leetcode.tools.printArray
import java.util.*

/**
 * Created by mwu on 2018/11/03
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:

Input:
nums =
[[1,2],
[3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

Example 2:

Input:
nums =
[[1,2],
[3,4]]
r = 2, c = 4
Output:
[[1,2],
[3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

Note:

The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.

 */
object ReshapeTheMatrix566 {

  @JvmStatic
  fun main(args: Array<String>) {
    val nums = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    val r = 1
    val c = 4
    val result = matrixReshape(nums, r, c)
    printArray(result)
  }

  private fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
//    val m = nums.size // 行
//    val n = nums[0].size  // 列
//    if (r * c != m * n || (r == m && c == n)) return nums
//    var count = 0
//    val result = Array(size = r, init = { IntArray(size = c) })
//    nums.forEach { outer ->
//      outer.forEach { inner ->
//        result[count / c][count % c] = inner
//        count++
//      }
//    }
//    return result

    // 队列法
    val m = nums.size // 行
    val n = nums[0].size  // 列
    if (r * c != m * n || (r == m && c == n)) return nums
    val queue: Queue<Int> = LinkedList<Int>()
    val result = Array(size = r, init = { IntArray(size = c) })
    nums.forEach { outer ->
      outer.forEach { inner ->
        queue.add(inner)
      }
    }
    (0 until r).forEach { outer ->
      (0 until c).forEach { inner ->
        result[outer][inner] = queue.remove()
      }
    }
    return result
  }
}