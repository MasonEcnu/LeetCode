package com.mason.leetcode.math.middle;

/**
 * Created by mwu on 2020/5/12
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 * <p>
 * 如果数组中不存在满足题意的整数，则返回 0 。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 */
public class FourDivisors1390 {

    public static void main(String[] args) {
        int[] nums = new int[]{21, 4, 7};
        System.out.println(sumFourDivisors(nums));
    }

    // 计算每个数的因数个数
    // 然后把和统计出来
    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += calcDivisors(num);
        }
        return sum;
    }

    private static int calcDivisors(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int temp = num / i;
                if (temp == i) count += 1;
                else count += 2;
                sum += i;
                sum += num / i;
            }
        }
        if (count == 4) return sum;
        else return 0;
    }
}
