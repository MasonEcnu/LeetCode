package com.mason.leetcode.hashtable.easy

/**
 * Created by mwu on 2018/10/31
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example:
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
object IslandPerimeter463 {

  @JvmStatic
  fun main(args: Array<String>) {
    val grid = arrayOf(intArrayOf(1, 0, 1, 0), intArrayOf(0, 1, 0, 1), intArrayOf(1, 0, 1, 0), intArrayOf(0, 1, 0, 1))
    val result = islandPerimeter(grid)
    println(result)
  }

  private fun islandPerimeter(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    val m = grid.size // 行
    val n = grid[0].size  // 列
    var count = 0
    var cover = 0
    (0 until m).forEach { outer ->
      (0 until n).forEach { inner ->
        if (grid[outer][inner] == 1) {
          count++
          cover += calcCoverSide(outer, inner, m, n, grid)
        }
      }
    }
    return count * 4 - cover
  }

  private fun calcCoverSide(outer: Int, inner: Int, m: Int, n: Int, grid: Array<IntArray>): Int {
    var cover = 0
    if (inner + 1 < n && grid[outer][inner + 1] == 1) cover++
    if (inner - 1 >= 0 && grid[outer][inner - 1] == 1) cover++
    if (outer + 1 < m && grid[outer + 1][inner] == 1) cover++
    if (outer - 1 >= 0 && grid[outer - 1][inner] == 1) cover++
    return cover
  }
}