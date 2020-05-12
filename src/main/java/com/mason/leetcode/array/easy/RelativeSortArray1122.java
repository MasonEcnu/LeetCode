package com.mason.leetcode.array.easy;

import java.util.Arrays;
import java.util.Comparator;

import static com.mason.leetcode.tools.PrintToolsKt.printIntArray;

/**
 * Created by mwu on 2019/12/3
 * <p>
 * 给你两个数组，arr1 和 arr2，
 * 1.arr2 中的元素各不相同
 * 2.arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray1122 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{26, 21, 11, 20, 50, 34, 1, 18};
        int[] arr2 = new int[]{21, 11, 26, 20};
        printIntArray(relativeSortArray1(arr1, arr2));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] iarr1 = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            iarr1[i] = arr1[i];
        }
        Arrays.sort(iarr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int index1 = indexOf(arr2, o1);
                int index2 = indexOf(arr2, o2);
                if (index1 == -1 && index2 == -1) {
                    return o1 - o2;
                } else if (index1 == -1) {
                    return 1;
                } else if (index2 == -1) {
                    return -1;
                } else {
                    return index1 - index2;
                }
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = iarr1[i];
        }
        return arr1;
    }

    private static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // 桶排序
    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int num : arr1) {
            bucket[num]++;
        }

        int index = 0;
        // 在arr2中
        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                arr1[index++] = num;
            }
        }

        // 不在arr2中
        for (int i = 0; i < 1001; i++) {
            while (bucket[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}

