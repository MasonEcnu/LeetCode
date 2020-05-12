package com.mason.leetcode.hash.easy;

import java.util.HashMap;

/**
 * Created by mwu on 2019/12/2
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences1207 {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(data));
    }

    private static boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 0) return true;
        HashMap<Integer, Integer> numToTimes = new HashMap<>();
        for (int v : arr) {
            int defaultValue = numToTimes.getOrDefault(v, 0) + 1;
            numToTimes.put(v, defaultValue);
        }
        HashMap<Integer, Integer> timesToNum = new HashMap<>();
        numToTimes.forEach((k, v) -> timesToNum.put(v, k));
        return numToTimes.size() == timesToNum.size();
    }
}
