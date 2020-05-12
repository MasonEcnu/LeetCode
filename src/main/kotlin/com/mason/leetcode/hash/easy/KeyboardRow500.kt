package com.mason.leetcode.hash.easy

import com.mason.leetcode.tools.printArray

/**
 * Created by mwu on 2018/10/30
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
object KeyboardRow500 {

    @JvmStatic
    fun main(args: Array<String>) {
        val words = arrayOf("Hello", "Alaska", "Dad", "Peace")
        val result = findWords(words)
        printArray(result)
    }

    private val keyboardLine = arrayOf("qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM")

    // 用map存储keyboardLine的index也ok的
    // 后面就是比较words中的每一个word，是否有character位于不用的index

    private fun findWords(words: Array<String>): Array<String> {
        // 方法一
//    if (words.isEmpty()) return emptyArray()
//    val result = arrayListOf<String>()
//    words.forEach { outer ->
//      if (outer.all { keyboardLine[0].contains(it) }
//          || outer.all { keyboardLine[1].contains(it) }
//          || outer.all { keyboardLine[2].contains(it) }) {
//        result.add(outer)
//      }
//    }
//    return result.toTypedArray()

        // 方法二
        if (words.isEmpty()) return emptyArray()
        val indexMap = hashMapOf<Char, Int>()
        keyboardLine.forEachIndexed { index, s ->
            s.toCharArray().forEach {
                indexMap[it] = index
            }
        }
        val result = arrayListOf<String>()
        words.forEach { outer ->
            var index = indexMap[outer[0]]
            outer.toCharArray().forEach { inner ->
                if (indexMap[inner] ?: Int.MAX_VALUE != (index)) {
                    index = Int.MIN_VALUE
                }
            }
            if (index != Int.MIN_VALUE) result.add(outer)
        }
        return result.toTypedArray()
    }
}