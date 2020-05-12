package com.mason.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mwu on 2019/11/29
 * <p>
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["cba", "daf", "ghi"]
 * 输出：1
 * 解释：
 * 当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
 * 若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
 * <p>
 * 示例 2：
 * <p>
 * 输入：["a", "b"]
 * 输出：0
 * 解释：D = {}
 * <p>
 * 示例 3：
 * <p>
 * 输入：["zyx", "wvu", "tsr"]
 * 输出：3
 * 解释：D = {0, 1, 2}
 * <p>
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 1000
 * <p>
 * 字符串一行行摆好，一列列的比较，上一行字母不能大于下一行字母，否则这一列就是需要删除的，记录所需i删除的列数
 */
public class DeleteColumnsToMakeSorted944 {

    public static void main(String[] args) {
        String[] A = new String[]{"zyx", "wvu", "tsr"};
        System.out.println(minDeletionSize(A));
    }

    private static int minDeletionSize(String[] A) {
        int colSize = A[0].length();
        AtomicInteger count = new AtomicInteger();
        List<char[]> result = new ArrayList<>();
        for (int c = 0; c < colSize; c++) {
            StringBuilder sb = new StringBuilder();
            for (String s : A) {
                sb.append(s.charAt(c));
            }
            result.add(sb.toString().toCharArray());
        }
        result.forEach(
                cs -> {
                    char[] tempCs = cs.clone();
                    Arrays.sort(tempCs);
                    if (!Arrays.equals(tempCs, cs)) {
                        count.getAndIncrement();
                    }
                }
        );
        return count.get();
    }
}
