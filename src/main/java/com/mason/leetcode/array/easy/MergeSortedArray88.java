package com.mason.leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by mwu on 2020/6/15
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * Related Topics 数组 双指针
 */
public class MergeSortedArray88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 4, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = 0, nIndex = 0, index = 0;
        int[] copyNums1 = new int[m];
        System.arraycopy(nums1, 0, copyNums1, 0, m);
        while (mIndex < m && nIndex < n) {
            if (copyNums1[mIndex] >= nums2[nIndex]) {
                nums1[index++] = nums2[nIndex];
                nIndex++;
            } else {
                nums1[index++] = copyNums1[mIndex];
                mIndex++;
            }
        }
        if (mIndex < m) {
            System.arraycopy(copyNums1, mIndex, nums1, index, m - mIndex);
        }
        if (nIndex < n) {
            System.arraycopy(nums2, nIndex, nums1, index, n - nIndex);
        }
    }
}
