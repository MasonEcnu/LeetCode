package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/11/6
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Return the total surface area of the resulting shapes.
 *
 * Example 1:
 * Input: [[2]]
 * Output: 10
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 16
 *
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 *
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *
 * Note:
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
object SurfaceAreaOf3DShapes892 {

    @JvmStatic
    fun main(args: Array<String>) {
        val grid = arrayOf(intArrayOf(2))
        val result = surfaceArea(grid)
        println(result)
    }

    // 并不怎么理解这个方法
    private fun surfaceArea(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var sum = 0
        (0 until m).forEach { outer ->
            (0 until n).forEach { inner ->
                if (grid[outer][inner] > 0) {
                    sum += 6 * grid[outer][inner]
                    // Z axis
                    sum -= 2 * (grid[outer][inner] - 1)

                    // Y axis
                    if (outer < grid.size - 1) {
                        sum -= 2 * Math.min(grid[outer][inner], grid[outer + 1][inner])
                    }

                    // X axis
                    if (inner < grid[0].size - 1) {
                        sum -= 2 * Math.min(grid[outer][inner], grid[outer][inner + 1])
                    }
                }
            }
        }
        return sum
    }
}