package com.mason.leetcode.string.easy

import java.math.BigInteger

/**
 * Created by mwu on 2019/11/12
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-9128347233212312312312312312312312312312312"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Therefore INT_MIN (−231) is returned.
 */
object String2Integer8 {

  @JvmStatic
  fun main(args: Array<String>) {
    println(myAtoi("-9128347233212312312312312312312312312312312"))
  }

  fun myAtoi(str: String): Int {
    if (str.isEmpty()) return 0
    if (str[0].isLetter()) return 0
    var ans = BigInteger.ZERO
    var flag = false
    var len = 0
    var temp = 0
    for (c in str) {
      if ((c == '-' || c == '+') && len == 0) {
        temp++
        if (c == '-') flag = true
      } else if (c.isDigit() && temp < 2) {
        ans = ans.multiply(BigInteger.valueOf(10L)).add(BigInteger.valueOf((c - '0').toLong()))
        len++
        if (ans.minus(BigInteger.valueOf(1L)) > BigInteger.valueOf(Int.MAX_VALUE.toLong())) break
      } else if (c == ' ' && len == 0 && temp == 0) {
        continue
      } else {
        break
      }
    }
    if (flag) {
      return if (ans.negate() < BigInteger.valueOf(Int.MIN_VALUE.toLong())) Int.MIN_VALUE else ans.negate().intValueExact()
    }
    return if (ans > BigInteger.valueOf(Int.MAX_VALUE.toLong())) Int.MAX_VALUE else ans.intValueExact()
  }
}