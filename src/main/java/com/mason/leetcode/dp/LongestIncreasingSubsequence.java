package com.mason.leetcode.dp;

import java.util.Arrays;

/**
 * Created by mwu on 2019/11/29
 * 最长上升子序列（LIS）问题：
 * 给定长度为n的序列a，从a中抽取出一个子序列，这个子序列需要单调递增。
 * 问最长的上升子序列（LIS）的长度。
 * e.g.
 * 1,5,3,4,6,9,7,8的LIS为1,3,4,6,7,8，长度为6。
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int[] data = new int[]{1, 5, 3, 4, 6, 9, 7, 8};
        System.out.println(countLongestIncreasingSubsequence(data));
    }

    private static int countLongestIncreasingSubsequence(int[] dd) {
        int size = dd.length;
        int[] data = new int[size + 5];
        System.arraycopy(dd, 0, data, 1, size);
        int[] dp = new int[size + 5];
        Arrays.fill(dp, 1);
        dp[0] = 0;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j < i; j++) {
                if (data[j] < data[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.format("dp[%d]=%d\n", i, dp[i]);
        }

        int ans = 0;
        for (int i = 1; i <= size; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
