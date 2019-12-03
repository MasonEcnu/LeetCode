package com.mason.leetcode.array.easy;

/**
 * Created by mwu on 2019/11/13
 */
public class CellsWithOddValuesInMatrix1252 {

  public static void main(String[] args) {
    int n = 2, m = 3;
    int[][] indices = new int[2][2];
    indices[0][0] = 0;
    indices[0][1] = 1;
    indices[1][0] = 1;
    indices[1][1] = 1;
    System.out.println(oddCells(n, m, indices));
  }

  private static int oddCells(int n, int m, int[][] indices) {
    if (indices.length <= 0 || indices[0].length <= 0) return 0;
    int result = 0;
    int[][] matrix = new int[n][m];
    for (int[] index : indices) {
      // 行
      for (int i = 0; i < m; i++) {
        matrix[index[0]][i] += 1;
      }
      // 列
      for (int j = 0; j < n; j++) {
        matrix[j][index[1]] += 1;
      }
    }


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if ((matrix[i][j] & 1) == 1) {
          result++;
        }
      }
    }
    return result;
  }
}
