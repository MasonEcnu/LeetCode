package com.mason.leetcode.linked.easy

import com.mason.leetcode.tools.printLinkedList

/**
 * Created by mwu on 2018/11/21
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
object MergeTwoSortedLists21 {

    @JvmStatic
    fun main(args: Array<String>) {
        val l1 = ListNode(1)
        l1.next = ListNode(2)
        l1.next?.next = ListNode(3)

        val l2 = ListNode(1)
        l2.next = ListNode(3)
        l2.next?.next = ListNode(4)

        val result = mergeTwoLists(l1, l2)
        printLinkedList(result)
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
//    var tl1 = l1
//    var tl2 = l2
//    var head: ListNode? = ListNode(0)
//    val merge = head
//    while (tl1 != null && tl2 != null) {
//      if (tl1.`val` >= tl2.`val`) {
//        head?.next = tl2
//        tl2 = tl2.next
//      } else {
//        head?.next = tl1
//        tl1 = tl1.next
//      }
//      head = head?.next
//    }
//    head?.next = when {
//      tl1 == null && tl2 != null -> tl2
//      tl1 != null && tl2 == null -> tl1
//      else -> null
//    }
//    return merge?.next

        // 递归
        if (l1 == null) return l2
        if (l2 == null) return l1

        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l2.next, l1)
            l2
        }
    }
}