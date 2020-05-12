package com.mason.leetcode.tree.middle;

import com.mason.leetcode.struct.NTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mwu on 2019/11/14
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class NaryTreeLevelOrderTraversal429 {

    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(levelOrder(new NTreeNode(1, null)));
    }

    private static List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<NTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                NTreeNode node = queue.poll();
                if (node != null) {
                    result.get(level).add(node.val);
                    int childrenNum = node.children.size();
                    for (int j = 0; j < childrenNum; j++) {
                        queue.add(node.children.get(j));
                    }
                }
            }
            level++;
        }
        return result;
    }

    private void traverseNode(NTreeNode root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (NTreeNode child : root.children) {
            traverseNode(child, level + 1);
        }
    }
}
