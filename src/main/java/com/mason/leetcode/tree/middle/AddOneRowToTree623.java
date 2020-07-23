package com.mason.leetcode.tree.middle;

import com.mason.leetcode.struct.TreeNode;

/**
 * Created by mwu on 2020/5/18
 * <p>
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 */
public class AddOneRowToTree623 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(addOneRow(root, 1, 3));
    }

    /**
     * 思考加在哪，什么时候加，需要注意什么？
     * 这里以 d=3d=3d=3 举例：
     * 1.在d=2的时候，将v元素节点作为该结点的左右孩子节点，之后将原d=3的节点与v节点连接。
     * 2.需要注意当d=1的时候，也就是没有上一层节点无法添加节点。
     * 2.1.题目要求：如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
     * <p>
     * 手动给根节点添加一个父亲节点，这样子可以统一操作。并将其设置为父亲节点的左子树。
     *
     * @param root 根节点
     * @param v    新增的节点的val
     * @param d    层级
     * @return root
     */
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        return new TreeNode(0);
    }
}
