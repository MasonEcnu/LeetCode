package com.mason.leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by mwu on 2019/11/18
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SquaresOfSortedArray977 {

    public static void main(String[] args) {
        int[] A = new int[]{-4, -1, 0, 3, 10};
        Arrays.stream(sortedSquares(A)).forEach(
                System.out::println
        );
    }

    private static int[] sortedSquares(int[] A) {
        int[] result = A.clone();
        if (A.length <= 0) return result;
        int len = A.length;
        int j = 0;
        while (j < len && A[j] < 0) {
            j++;
        }
        int i = j - 1;
        int k = 0;
        while (i >= 0 && j < len) {
            if (A[i] * A[i] < A[j] * A[j]) {
                result[k++] = A[i] * A[i];
                i--;
            } else {
                result[k++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            result[k++] = A[i] * A[i];
            i--;
        }

        while (j < len) {
            result[k++] = A[j] * A[j];
            j++;
        }
        return result;
    }
}
