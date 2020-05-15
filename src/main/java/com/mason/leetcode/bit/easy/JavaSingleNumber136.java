package com.mason.leetcode.bit.easy;

/**
 * Created by mwu on 2020/5/14
 */
public class JavaSingleNumber136 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }
}
