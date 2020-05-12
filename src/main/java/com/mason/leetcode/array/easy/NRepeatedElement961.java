package com.mason.leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by mwu on 2019/12/2
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * 提示：
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 */
public class NRepeatedElement961 {

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 2, 5, 3, 2};
        System.out.println(repeatedNTimes(A));
    }

    // hashmap
    // 计数+统计比较
    private static int repeatedNTimes(int[] A) {
        if (A.length == 0 || A.length % 2 == 1) return 0;
        Arrays.sort(A);
        return A[0] == A[1] ? A[0] : A[A.length / 2];
    }
}
