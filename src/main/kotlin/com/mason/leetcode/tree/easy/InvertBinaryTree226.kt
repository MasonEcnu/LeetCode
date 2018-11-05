package com.mason.leetcode.tree.easy

/**
 * Created by mwu on 2018/11/5
 *
 * Invert a binary tree.
 *
 * Example:
 * Input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
object InvertBinaryTree226 {

  @JvmStatic
  fun main(args: Array<String>) {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)

    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(9)
    invertTree(root)
    println(root.`val`)
  }

  private fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return root
    if (root.left != null) invertTree(root.left)
    if (root.right != null) invertTree(root.right)
    val temp = root.left
    root.left = root.right
    root.right = temp
    return root
  }
}