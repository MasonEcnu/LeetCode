package com.mason.leetcode.math.easy;

import java.util.Arrays;

/**
 * Created by mwu on 2020/7/24
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * Related Topics 哈希表 数学
 */
public class CountPrimes204 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(fasterCountPrimes(n));
    }

    public static int countPrimes(int n) {
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                num++;
            }
        }
        return num;
    }

    public static int fasterCountPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                // j = i * i:i的两倍
                // j += i:相当于i的3..4..5..等倍数
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        // 这里不计算0,1
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    // 时间太长了
    private static boolean isPrime(int n) {
        // i * i <= n:这里i*i可能会溢出
        int upper = (int) Math.sqrt(n);
        for (int i = 2; i <= upper; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
