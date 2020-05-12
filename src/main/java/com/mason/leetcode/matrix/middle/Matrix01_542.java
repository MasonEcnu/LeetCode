package com.mason.leetcode.matrix.middle;

import java.util.Arrays;

/**
 * Created by mwu on 2020/5/11
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * <p>
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * <p>
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 */
public class Matrix01_542 {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{0, 0, 0};
        matrix[1] = new int[]{0, 0, 0};
        matrix[2] = new int[]{0, 1, 0};
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int step = findNearestZero(matrix, row, col, i, j);
            }
        }
        return matrix;
    }

    private static int findNearestZero(int[][] matrix, int row, int col, int i, int j) {
        return 0;
    }
}
