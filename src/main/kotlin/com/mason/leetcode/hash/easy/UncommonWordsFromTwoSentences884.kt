package com.mason.leetcode.hash.easy

import com.mason.leetcode.tools.printArray

/**
 * Created by mwu on 2018/10/30
 * We are given two sentences A and B.
 * (A sentence is a string of space separated words.
 * Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Return a list of all uncommon words.
 * You may return the list in any order.
 *
 * Example 1:
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 *
 * Example 2:
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 * Note:
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
object UncommonWordsFromTwoSentences884 {

    @JvmStatic
    fun main(args: Array<String>) {
        val A = "apple"
        val B = "banana banana"
        val result = uncommonFromSentences(A, B)
        printArray(result)
    }

    private fun uncommonFromSentences(A: String, B: String): Array<String> {
        if (A.isEmpty() && B.isEmpty()) return emptyArray()
        val aarray = A.split(" ")
        val barray = B.split(" ")
        val countMap = hashMapOf<String, Int>()
        (aarray + barray).forEach {
            countMap[it] = if (countMap[it] == null) 1 else (countMap[it] ?: 1) + 1
        }
        val aset = aarray.toSet()
        val bset = barray.toSet()
        val result = mutableListOf<String>()
        aset.forEach {
            if (bset.contains(it) || countMap[it] != 1) return@forEach
            result.add(it)
        }
        bset.forEach {
            if (aset.contains(it) || countMap[it] != 1) return@forEach
            result.add(it)
        }
        return result.toTypedArray()
    }
}