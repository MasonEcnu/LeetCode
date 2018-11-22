package com.mason.leetcode.stack.easy

import java.util.*

/**
 * Created by mwu on 2018/11/21
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
object ValidParentheses20 {

  @JvmStatic
  fun main(args: Array<String>) {
    val s = "]]"
    val result = isValid(s)
    println(result)
  }

  private fun isValid(s: String): Boolean {
    // 暴力法
//    val stack = Stack<Char>()
//    var temp: Char
//    s.toCharArray().forEach {
//      when (it) {
//        '(', '[', '{' -> stack.push(it)
//        ')' -> {
//          temp = if (stack.isEmpty()) return false else stack.peek()
//          if (temp == '(') {
//            stack.pop()
//            return@forEach
//          }
//        }
//        ']' -> {
//          temp = if (stack.isEmpty()) return false else stack.peek()
//          if (temp == '[') {
//            stack.pop()
//            return@forEach
//          }
//        }
//        '}' -> {
//          temp = if (stack.isEmpty()) return false else stack.peek()
//          if (temp == '{') {
//            stack.pop()
//            return@forEach
//          }
//        }
//        else -> return false
//      }
//    }
//    return stack.isEmpty()

    // 高端法
    val bracketMap = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    val stack = Stack<Char>()
    s.toCharArray().forEach {
      if (bracketMap.containsKey(it)) {
        if (stack.isEmpty()) return false
        if (bracketMap[it] != stack.pop()) {
          return false
        }
      } else {
        stack.push(it)
      }
    }
    return stack.isEmpty()
  }
}
