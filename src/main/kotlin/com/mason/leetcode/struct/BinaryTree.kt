package com.mason.leetcode.struct

import java.util.*

/**
 * Created by mwu on 2018/11/6
 */
class BinaryTree(val array: Array<Int>) {
    // null ==> TreeNode(0)
    val root: TreeNode = makeBinaryTreeByArray(array, 1)

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    private fun makeBinaryTreeByArray(array: Array<Int>, index: Int): TreeNode {
        if (index < array.size) {
            val value = array[index]
            if (value != 0) {
                val t = TreeNode(value)
                array[index] = 0
                t.left = makeBinaryTreeByArray(array, index * 2)
                t.right = makeBinaryTreeByArray(array, index * 2 + 1)
                return t
            }
        }
        return TreeNode(0)
    }
}

// 前序遍历
fun preOrderRecur(head: TreeNode?) {
    if (head == null || head.`val` == 0) return
    if (head.`val` != 0) println(head)

    preOrderRecur(head.left)
    preOrderRecur(head.right)
}

//先序遍历的非递归的写法，反着它的顺序写
// 1.先放中节点
// 2.有右节点放右节点
// 3.有左节点放左节点
fun preOrderUnRecur(head: TreeNode) {
    val stack = Stack<TreeNode>()
    stack.add(head)
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.`val` != 0) println(pop)
        if (pop.right != null) {
            stack.add(pop.right)
        }
        if (pop.left != null) {
            stack.add(pop.left)
        }
    }
}

// 中序遍历
fun inOrderRecur(head: TreeNode?) {
    if (head == null || head.`val` == 0) return
    inOrderRecur(head.left)
    println(head)
    inOrderRecur(head.right)
}

//中序遍历的非递归的写法，
// 1.左节点不为null则压入左节点
// 2.左节点为null时，pop并打印，左节点
// 3.在往右，右节点为null时，pop并打印
// 4.右节点不为null时，压入右节点
fun inOrderUnRecur(head: TreeNode) {
    val stack = Stack<TreeNode>()
    var temp: TreeNode? = head
    while (stack.isNotEmpty() || temp != null) {
        if (temp != null) {
            stack.add(temp)
            temp = temp.left
        } else {
            temp = stack.pop()
            if (temp.`val` != 0) println(temp)
            temp = temp.right
        }
    }
}

// 后序遍历
fun posOrderRecur(head: TreeNode?) {
    if (head == null || head.`val` == 0) return
    posOrderRecur(head.left)
    posOrderRecur(head.right)
    println(head)
}

//和前序遍历一样的只不过是使用了两个栈
//在前序遍历的时候将 中 右 左 节点压栈
//在原来是打印的地方不打印，将本该打印的节点压到第二个栈中
//这样第二个栈的出栈顺序就是 右 左 中了
fun posOrderUnRecur(head: TreeNode) {
    val stack = Stack<TreeNode>()
    val printStack = Stack<TreeNode>()
    stack.add(head)
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.`val` != 0) printStack.add(pop)
        if (pop.left != null) {
            stack.add(pop.left)
        }
        if (pop.right != null) {
            stack.add(pop.right)
        }
    }
    while (printStack.isNotEmpty()) {
        println(printStack.pop())
    }
}

// 层序遍历
fun levelOrder(head: TreeNode) {
    val queue = LinkedList<TreeNode?>()
    queue.add(head)
    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        if (poll != null) {
            if (poll.`val` != 0) println(poll)
            if (poll.left != null && poll.left?.`val` != 0) {
                queue.add(poll.left)
            }
            if (poll.right != null && poll.right?.`val` != 0) {
                queue.add(poll.right)
            }
        }
    }
}

fun main() {
    val bt = BinaryTree(arrayOf(0, 1, 2, 3, 4, 5, 6, 0, 0, 0, 7, 8))
//  println("pre-order:")
//  preOrderRecur(bt.root)
//  println("in-order:")
//  inOrderUnRecur(bt.root)
//  println("pos-order:")
//  posOrderUnRecur(bt.root)
    println("level-order:")
    levelOrder(bt.root)
}