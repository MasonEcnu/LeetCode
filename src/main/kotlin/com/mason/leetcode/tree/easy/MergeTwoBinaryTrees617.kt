package com.mason.leetcode.tree.easy

import java.util.*

/**
 * Created by mwu on 2018/10/26
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 */

class TreeNode(var `val`: Int = 0) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

object MergeTwoBinaryTrees617 {

  @JvmStatic
  fun main(args: Array<String>) {
    val t1 = TreeNode(1)
    t1.left = TreeNode(3)
    t1.left?.left = TreeNode(5)
    t1.right = TreeNode(2)

    val t2 = TreeNode(2)
    t2.left = TreeNode(1)
    t2.left?.right = TreeNode(4)
    t2.right = TreeNode(3)
    t2.right?.right = TreeNode(7)

    val result = mergeTrees(t1, t2)
    println(result)
  }

  private fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) return t2

    // 递归
//    t1.`val` += t2.`val`
//    t1.left = mergeTrees(t1.left, t2.left)
//    t1.right = mergeTrees(t1.right, t2.right)
//    return t1
    // 非递归

    val stack = Stack<Array<TreeNode?>>()
    stack.push(arrayOf(t1, t2))
    while (stack.isNotEmpty()) {
      val t = stack.pop()
      if (t[0] == null || t[1] == null) {
        continue
      }
      val v0 = t[0]?.`val` ?: 0
      val v1 = t[1]?.`val` ?: 0
      t[0]?.`val` = v0 + v1
      if (t[0]?.left == null) {
        t[0]?.left = t[1]?.left
      } else {
        stack.push(arrayOf(t[0]?.left, t[1]?.left))
      }
      if (t[0]?.right == null) {
        t[0]?.right = t[1]?.right
      } else {
        stack.push(arrayOf(t[0]?.right, t[1]?.right))
      }
    }
    return t1
  }
}