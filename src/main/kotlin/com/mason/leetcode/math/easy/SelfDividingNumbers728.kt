package com.mason.leetcode.math.easy


/**
 * Created by mwu on 2018/10/26
 *  A self-dividing number is a number that is divisible by every digit it contains.
 *  For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *  Also, a self-dividing number is not allowed to contain the digit zero.
 *  Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 *  Example 1:
 *  Input:
 *  left = 1, right = 22
 *  Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 *  Note:
 *  The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
object SelfDividingNumbers728 {

  @JvmStatic
  fun main(args: Array<String>) {
    val left = 1
    val right = 22
    val result = selfDividingNumbers(left, right)
    result.forEach {
      print("$it ")
    }
  }

  private fun selfDividingNumbers(left: Int, right: Int): List<Int> {
//    if (left > right) return emptyList()
//    val result = mutableListOf<Int>()
//    (left..right).forEach outer@{ num ->
//      num.toString().forEach inner@{
//        if (it == '0' || num % (it - '0') != 0) return@outer
//      }
//      result.add(num)
//    }
//    return result

    return (left..right).filter { isDivide(it) }.toList()
  }

  private fun isDivide(x: Int): Boolean {
    var tx = x
    val temp = tx
    while (tx != 0) {
      val rem = tx % 10
      if (rem == 0 || temp % rem != 0)
        return false
      tx /= 10
    }
    return true
  }
}