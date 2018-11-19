package com.mason.leetcode.math.easy

/**
 * Created by mwu on 2018/11/19
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
object PalindromeNumber9 {

  @JvmStatic
  fun main(args: Array<String>) {
    val x = 123321
    val result = isPalindrome(x)
    println(result)
  }

  private fun isPalindrome(x: Int): Boolean {
    // 直接String法
//    val temp = x.toString()
//    return x >= 0 && temp == temp.reversed()

    // 不用String法
    if (x == 0) return true
    if (x < 0 || x % 10 == 0) return false

    var invertedNum = 0
    var temp = x
    while (temp > invertedNum) {
      invertedNum = invertedNum * 10 + temp % 10
      temp /= 10
    }
    return temp == invertedNum || temp == invertedNum / 10
  }
}
