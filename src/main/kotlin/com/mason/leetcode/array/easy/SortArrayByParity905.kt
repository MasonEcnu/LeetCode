package com.mason.leetcode.array.easy

/**
 * Created by mwu on 2018/10/25
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
object SortArrayByParity905 {

  @JvmStatic
  fun main(args: Array<String>) {
    val A = intArrayOf(3, 1, 2, 4)
    val result = sortArrayByParity(A)
    result.forEach {
      print("$it ")
    }
  }

  private fun sortArrayByParity(A: IntArray): IntArray {
    // 笨方法
//    if (A.isEmpty()) return A
//    val oddList = A.filter { it % 2 == 1 }
//    val evenList = A.filter { it % 2 == 0 }
//    val result = evenList + oddList
//    return result.toIntArray()

    // 一次遍历
    if (A.isEmpty()) return A
    var start = 0
    var end = A.size - 1
    while (start <= end) {
      when {
        A[start] % 2 == 1 && A[end] % 2 == 0 -> {
          swap(A, start, end)
          start++
          end--
        }
        A[start] % 2 == 1 && A[end] % 2 == 1 -> {
          end--
        }
        A[start] % 2 == 0 && A[end] % 2 == 1 -> {
          start++
          end--
        }
        A[start] % 2 == 0 && A[end] % 2 == 0 -> {
          start++
        }
      }
    }
    return A
  }

  private fun swap(A: IntArray, start: Int, end: Int) {
    if (start == end) return
    val temp = A[start]
    A[start] = A[end]
    A[end] = temp
  }
}