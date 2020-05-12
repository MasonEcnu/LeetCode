package com.mason.leetcode.array.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mwu on 2020/5/9
 * <p>
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
public class MinimumAbsoluteDifference1200 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 10, 15};
        System.out.println(JSON.toJSONString(minimumAbsDifference(arr)));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr.length <= 1) return Collections.emptyList();
        // 先排序
        Arrays.sort(arr);
        // 找最小差
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minGap = Math.min(minGap, Math.abs(arr[i + 1] - arr[i]));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int finalI = i;
            if (Math.abs(arr[finalI + 1] - arr[finalI]) == minGap) {
                result.add(new ArrayList<Integer>(2) {{
                    add(arr[finalI]);
                    add(arr[finalI + 1]);
                }});
            }
        }
        return result;
    }
}
