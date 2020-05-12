package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2018/10/25
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
object ToLowerCase709 {

    @JvmStatic
    fun main(args: Array<String>) {
        val str = "Hello"
        val result = toLowerCase(str)
        println(result)
    }

    private fun toLowerCase(str: String): String {
        // return str.toLowerCase()
        if (str.isEmpty()) return ""
        val sb = StringBuilder()
        str.forEach {
            val cint = it.toInt()
            if (cint in 65..90) {
                sb.append((cint + 32).toChar())
            } else {
                sb.append(it)
            }
        }
        return sb.toString()
    }
}