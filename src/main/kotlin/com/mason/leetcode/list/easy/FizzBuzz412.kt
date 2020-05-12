package com.mason.leetcode.list.easy

import com.mason.leetcode.tools.printList

/**
 * Created by mwu on 2018/11/2
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 * n = 15,
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
object FizzBuzz412 {

    @JvmStatic
    fun main(args: Array<String>) {
        val n = 15
        val result = fizzBuzz(n)
        printList(result)
    }

    private fun fizzBuzz(n: Int): List<String> {
        if (n == 0) return emptyList()
        val result = arrayListOf<String>()
        (1..n).forEach {
            when {
                it % 15 == 0 -> result.add("FizzBuzz")
                it % 3 == 0 -> result.add("Fizz")
                it % 5 == 0 -> result.add("Buzz")
                else -> result.add(it.toString())
            }
        }
        return result
    }
}