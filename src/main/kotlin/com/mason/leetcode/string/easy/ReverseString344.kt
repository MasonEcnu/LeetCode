package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/10/29
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 * Input: "hello"
 * Output: "olleh"
 *
 * Example 2:
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
object ReverseString344 {

  @JvmStatic
  fun main(args: Array<String>) {
    val str = "A man, a plan, a canal: Panama"
    val result = reverseString(str)
    println(result)
  }

  private fun reverseString(s: String): String {
    return StringBuilder().apply {
      val len = s.length
      s.indices.forEach {
        append(s[len - it - 1])
      }
    }.toString()

//    return s.reversed()
  }
}