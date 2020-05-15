package com.mason.leetcode.struct;

/**
 * Created by mwu on 2020/5/12
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode[val:" + val + "]";
    }
}
