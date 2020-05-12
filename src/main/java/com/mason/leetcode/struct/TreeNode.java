package com.mason.leetcode.struct;

/**
 * Created by mwu on 2020/5/12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode(value:" + val + ", left:" + left.val + ", right:" + right.val + ")";
    }
}
