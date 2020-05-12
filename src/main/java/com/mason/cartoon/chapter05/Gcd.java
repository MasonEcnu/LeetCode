package com.mason.cartoon.chapter05;

import javafx.util.Pair;

/**
 * Created by mwu on 2020/1/6
 * 最大公约数
 * GreatestCommonDivisor
 * GCD
 * 辗转相除法
 * 定理：两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数
 * <p>
 * 更相减损术
 * 两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数
 * <p>
 * 最优算法
 * 更相减损术+位运算
 */
public class Gcd {

    public static void main(String[] args) {
        System.out.println(calcGCDWithNineChaptersArt(5, 10));
    }

    private static int calcGCDWithEuclid(int a, int b) {
        Pair<Integer, Integer> bigSmall = calcBigSmall(a, b);
        if (bigSmall.getKey() % bigSmall.getValue() == 0) {
            return bigSmall.getValue();
        }
        return calcGCDWithEuclid(bigSmall.getKey() % bigSmall.getValue(), bigSmall.getValue());
    }

    private static int calcGCDWithNineChaptersArt(int a, int b) {
        if (a == b) return a;
        Pair<Integer, Integer> bigSmall = calcBigSmall(a, b);
        return calcGCDWithNineChaptersArt(bigSmall.getKey() - bigSmall.getValue(), bigSmall.getValue());
    }

    private static Pair<Integer, Integer> calcBigSmall(int a, int b) {
        int big = a >= b ? a : b;
        int small = a >= b ? b : a;
        return new Pair<>(big, small);
    }

    private static int calcGCD(int a, int b) {
        if (a == b) return a;

        // 奇数(a&1) == 1
        // 偶数(a&1) == 0
        // 两个都是偶数
        if ((a & 1) == 0 && (b & 1) == 0) {
            return calcGCD(a >> 1, b >> 1) << 1;
            // a偶数，b奇数
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return calcGCD(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return calcGCD(a, b >> 1);
        } else {
            // 两个都是奇数
            int big = a >= b ? a : b;
            int small = a >= b ? b : a;
            return calcGCD(big - small, small);
        }
    }
}
