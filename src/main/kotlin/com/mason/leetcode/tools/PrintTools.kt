package com.mason.leetcode.tools

import com.mason.leetcode.linked.easy.ListNode

/**
 * Created by mwu on 2018/10/26
 * 打印消息
 */

fun printIntArray(data: IntArray) {
  data.forEach {
    print("$it ")
  }
  println()
}

fun printArray(data: Array<IntArray>) {
  data.forEach { outer ->
    outer.forEach { inner ->
      print("$inner ")
    }
    println()
  }
  println()
}

fun printLinkedList(data: ListNode?) {
  var head: ListNode? = data ?: return
  while (head != null) {
    print("${head.`val`} ")
    head = head.next
  }
  println()
}
