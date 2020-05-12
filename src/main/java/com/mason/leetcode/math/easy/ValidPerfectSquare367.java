package com.mason.leetcode.math.easy;

/**
 * Created by mwu on 2020/5/11
 */
public class ValidPerfectSquare367 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare3(1));
    }

    public static boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        long lo = 2;
        long hi = num / 2;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long sqrt = mid * mid;
            if (sqrt == num) {
                return true;
            } else if (sqrt > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    // 牛顿迭代法
    // 太高级了。。。
    // f(x)=x2−num=0的根
    public static boolean isPerfectSquare2(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    // 1+3+5+7+9+…+(2n-1)=n^2
    public static boolean isPerfectSquare3(int num) {
        if (num <= 0) return false;
        int sum = 1;
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }
}
