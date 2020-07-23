package com.mason.leetcode.struct;

import com.mason.leetcode.tools.Regular;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mwu on 2020/5/18
 */
public class Tree {

    public static TreeNode makeBinaryTreeByArray(int[] nums, int index) {
        TreeNode tn = null;
        if (index < nums.length) {
            int value = nums[index];
            tn = new TreeNode(value);
            tn.left = makeBinaryTreeByArray(nums, 2 * index + 1);
            tn.right = makeBinaryTreeByArray(nums, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static TreeNode makeBinaryTreeByArray(String numStr, int index) {
        Pattern p = Pattern.compile(Regular.EXTRACT_NUMBER.getDesc());
        Matcher m = p.matcher(numStr);
        List<Integer> list = new ArrayList<>();
        while (m.find()) {
            list.add(Integer.valueOf(m.group(0)));
        }
        return makeBinaryTreeByArray(list, index);
    }

    public static TreeNode makeBinaryTreeByArray(List<Integer> nums, int index) {
        TreeNode tn = null;
        if (index < nums.size()) {
            int value = nums.get(index);
            tn = new TreeNode(value);
            tn.left = makeBinaryTreeByArray(nums, 2 * index + 1);
            tn.right = makeBinaryTreeByArray(nums, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        System.out.println(makeBinaryTreeByArray("[1,2,3]", 0));
        System.out.println(makeBinaryTreeByArray(new int[]{1, 2, 3}, 0));
    }
}
