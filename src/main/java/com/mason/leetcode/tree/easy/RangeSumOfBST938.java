package com.mason.leetcode.tree.easy;

import com.mason.leetcode.struct.TreeNode;

/**
 * Created by mwu on 2019/11/14
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 */
public class RangeSumOfBST938 {

    private static int result = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBSTWithDfs(root, 7, 15));
    }

    private static int rangeSumBSTWithRecursion(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int value = root.val;
        if (value < L) {
            return rangeSumBSTWithRecursion(root.right, L, R);
        } else if (value > R) {
            return rangeSumBSTWithRecursion(root.left, L, R);
        } else {
            return value + rangeSumBSTWithRecursion(root.right, L, R) + rangeSumBSTWithRecursion(root.left, L, R);
        }
    }

    // 深度优先搜索
    private static int rangeSumBSTWithDfs(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return result;
    }

    private static void dfs(TreeNode node, int L, int R) {
        if (node == null) return;
        int value = node.val;
        if (value > L) dfs(node.left, L, R);
        if (value < R) dfs(node.right, L, R);
        if (value >= L && value <= R) result += value;
    }
}
