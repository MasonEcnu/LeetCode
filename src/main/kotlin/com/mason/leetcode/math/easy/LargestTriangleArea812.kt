package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/11/7
 *
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 *
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 *
 * Notes:
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 * -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
object LargestTriangleArea812 {

    @JvmStatic
    fun main(args: Array<String>) {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, 2), intArrayOf(2, 0))
        val result = largestTriangleArea(points)
        println(result)
    }

    // 硬扛
    private fun largestTriangleArea(points: Array<IntArray>): Double {
        val size = points.size
        var area = 0.0
        (0 until size).forEach { i ->
            (i + 1 until size).forEach { j ->
                (j + 1 until size).forEach { k ->
                    val a = calcDistance(points[i], points[j])
                    val b = calcDistance(points[j], points[k])
                    val c = calcDistance(points[k], points[i])

                    if (isValidTriangle(a, b, c)) {
                        area = Math.max(area, calcArea(a, b, c))
                    }
                }
            }
        }
        return area
    }

    // 计算面积--三边长
    private fun calcArea(a: Double, b: Double, c: Double): Double {
        val p = (a + b + c) / 2
        val inner = p * (p - a) * (p - b) * (p - c)
        return Math.sqrt(inner)
    }

    // 判断是否构成三角形
    private fun isValidTriangle(a: Double, b: Double, c: Double): Boolean {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a
    }

    // 计算两点距离
    private fun calcDistance(p1: IntArray, p2: IntArray): Double {
        val x = Math.abs(p2[0] - p1[0]).toDouble()
        val y = Math.abs(p2[1] - p1[1]).toDouble()
        val inner = Math.pow(x, 2.0) + Math.pow(y, 2.0)
        return Math.sqrt(inner)
    }
}