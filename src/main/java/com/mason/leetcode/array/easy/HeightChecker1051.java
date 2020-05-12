package com.mason.leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by mwu on 2019/11/14
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * 示例：
 * <p>
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker1051 {

    public static void main(String[] args) {
        int[] heights = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights));
    }

    private static int oldHeightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    private static int heightChecker(int[] heights) {
        int[] array = new int[101];
        for (int height : heights) {
            array[height]++;
        }
        int count = 0;
        for (int i = 0, j = 0; i < array.length; i++) {
            while (array[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
}
