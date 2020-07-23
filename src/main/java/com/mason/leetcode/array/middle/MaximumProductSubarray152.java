package com.mason.leetcode.array.middle;

/**
 * Created by mwu on 2020/5/18
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray152 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4, -2, -1000};
        System.out.println(maxProduct3(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
            System.out.format("num:%s,imax:%s, imin:%s, max:%s\n", num, imax, imin, max);
        }
        return max;
    }

    // 用负数和0进行分组计算
    public static int maxProduct1(int[] nums) {
        // 题目中保证了至少有一个数字
        int max = 1, res = nums[0];
        for (int num : nums) {
            max *= num;
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }
        max = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }
        return res;
    }

    /**
     * 动态规划
     * 我们先定义一个数组 dpMax，用 dpMax[i] 表示以第 i 个元素的结尾的子数组，乘积最大的值，也就是这个数组必须包含第 i 个元素。
     * 那么 dpMax[i] 的话有几种取值。
     * 1.当 nums[i] >= 0 并且dpMax[i-1] > 0，dpMax[i] = dpMax[i-1] * nums[i]
     * 2.当 nums[i] >= 0 并且dpMax[i-1] < 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
     * 3.当 nums[i] < 0，此时如果前边累乘结果是一个很大的负数，和当前负数累乘的话就会变成一个更大的数。所以我们还需要一个数组 dpMin 来记录以第 i 个元素的结尾的子数组，乘积最小的值。
     * 3.1.当dpMin[i-1] < 0，dpMax[i] = dpMin[i-1] * nums[i]
     * 3.2.当dpMin[i-1] >= 0，dpMax[i] = nums[i]
     * <p>
     * 当然，上边引入了 dpMin 数组，怎么求 dpMin 其实和上边求 dpMax 的过程其实是一样的。
     * 按上边的分析，我们就需要加很多的 if else来判断不同的情况，这里可以用个技巧。
     * 我们注意到上边dpMax[i] 的取值无非就是三种，dpMax[i-1] * nums[i]、dpMin[i-1] * nums[i] 以及 nums[i]。
     * 所以我们更新的时候，无需去区分当前是哪种情况，只需要从三个取值中选一个最大的即可。
     * dpMax[i] = max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
     * 求 dpMin[i] 同理。
     * dpMin[i] = min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
     *
     * @param nums 输入数组
     * @return int 最大乘积
     */
    public static int maxProduct2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    public static int maxProduct3(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
            min = Math.min(min, dpMin);
        }
        System.out.println(min);
        return max;
    }
}
