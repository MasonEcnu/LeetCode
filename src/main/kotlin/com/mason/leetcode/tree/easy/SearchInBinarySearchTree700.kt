package com.mason.leetcode.tree.easy

/**
 * Created by mwu on 2018/10/29
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node.
 * If such node doesn't exist, you should return NULL.
 *
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
object SearchInBinarySearchTree700 {

  @JvmStatic
  fun main(args: Array<String>) {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)

    val result = searchBST(root, 5)
    println(result?.`val`)
  }

  private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    // 递归
//    if (root == null) return null
//    return when {
//      `val` == root.`val` -> root
//      `val` > root.`val` -> searchBST(root.right, `val`)
//      `val` < root.`val` -> searchBST(root.left, `val`)
//      else -> null
//    }

    // 非递归
    var result = root
    while (result != null) {
      result = when {
        result.`val` == `val` -> return result
        result.`val` > `val` -> result.left
        else -> result.right
      }
    }
    return result
  }
}