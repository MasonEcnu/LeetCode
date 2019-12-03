package com.mason.leetcode.array.easy;

import static com.mason.leetcode.tools.PrintToolsKt.printIntArray;

/**
 * Created by mwu on 2019/12/2
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * <p>
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */
public class CanPlaceFlowers605 {

  public static void main(String[] args) {
    int[] flowerbed = new int[]{0, 0, 1, 0, 0};
    int n = 1;
    System.out.println(canPlaceFlowers(flowerbed, n));
  }

  private static boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n / 2 >= flowerbed.length) return false;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        n--;
      }
    }
    printIntArray(flowerbed);
    return n <= 0;
  }

  private static boolean oldCanPlaceFlowers(int[] flowerbed, int n) {
    if (n / 2 >= flowerbed.length) return false;
    for (int i = 0; i < flowerbed.length; i++) {
      int down = i - 1, up = i + 1;
      if (down < 0 && up >= flowerbed.length) {
        if (flowerbed[i] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      } else if (down < 0) {
        if (flowerbed[up] == 0 && flowerbed[i] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      } else if (up >= flowerbed.length) {
        if (flowerbed[down] == 0 && flowerbed[i] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      } else {
        if (flowerbed[down] == 0 && flowerbed[up] == 0 && flowerbed[i] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      }
    }
    printIntArray(flowerbed);
    return n <= 0;
  }
}
