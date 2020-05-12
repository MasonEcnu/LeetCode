package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/10/27
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * Return the total area of all three projections.
 *
 * Example 1:
 * Input: [[2]]
 * Output: 5
 *
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 8
 *
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 *
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 *
 * Note:
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 */
object ProjectionAreaOf3DShapes883 {

    @JvmStatic
    fun main(args: Array<String>) {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val result = projectionArea(grid)
        println(result)
    }

    private fun projectionArea(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        var up = 0
        grid.indices.forEach { i ->
            var side = 0
            var front = 0
            grid[i].indices.forEach { j ->
                if (grid[i][j] > 0) up++
                side = Math.max(side, grid[i][j])
                front = Math.max(front, grid[j][i])
            }
            up += side + front
        }
        return up
    }
}