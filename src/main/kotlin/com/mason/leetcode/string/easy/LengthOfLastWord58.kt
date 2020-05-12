package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/12/17
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
object LengthOfLastWord58 {

    @JvmStatic
    fun main(args: Array<String>) {
        val s = "Hello"
        val result = lengthOfLastWord(s)
        println(result)
    }

    private fun lengthOfLastWord(s: String): Int {
        // one line
//    return s.trim().split(" ").last().length
        // 其他方法
        var len = 0
        var tail = s.length - 1
        // 功能类似于trim()
        while (tail >= 0 && ' ' == s[tail]) tail--
        while (tail >= 0 && ' ' != s[tail]) {
            tail--
            len++
        }
        return len
    }
}