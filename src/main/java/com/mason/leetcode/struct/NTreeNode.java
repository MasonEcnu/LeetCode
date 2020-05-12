package com.mason.leetcode.struct;

import java.util.List;

/**
 * Created by mwu on 2019/11/14
 * N叉树节点
 */
public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
