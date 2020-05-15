package com.mason.leetcode.array.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwu on 2020/5/15
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <p>
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubarraySumEqualsK560 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(subarraySum1(nums, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int index = 0;
        int result = 0;
        while (index < nums.length) {
            int sum = 0;
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    result++;
                }
            }
            index++;
        }
        return result;
    }

    public static int subarraySum1(int[] nums, int k) {
        // key：前缀和，value：key对应的前缀和个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为0的元素，前缀和为0，个数为1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为preSum-k的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护preSumFreq的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
