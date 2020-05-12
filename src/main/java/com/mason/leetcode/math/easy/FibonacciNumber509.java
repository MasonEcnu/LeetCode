package com.mason.leetcode.math.easy;

/**
 * Created by mwu on 2019/12/2
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 提示：
 * 0 ≤ N ≤ 30
 */
public class FibonacciNumber509 {

    public static void main(String[] args) {
        System.out.println(fibWithRecursion(10));
        System.out.println(fibWithoutRecursion(10));
    }

    private static int fibWithRecursion(int N) {
        if (N <= 0) return N;
        if (N <= 2) return 1;
        return fibWithRecursion(N - 2) + fibWithRecursion(N - 1);
    }

    private static int fibWithoutRecursion(int N) {
        if (N <= 0) return N;
        if (N <= 2) return 1;
        int a = 0, b = 1;
        while (N > 1) {
            int sum = a + b;
            a = b;
            b = sum;
            N--;
        }
        return b;
    }

}
