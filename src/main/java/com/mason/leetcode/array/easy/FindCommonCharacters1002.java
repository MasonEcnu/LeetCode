package com.mason.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

import static com.mason.leetcode.tools.PrintToolsKt.printList;

/**
 * Created by mwu on 2019/12/2
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class FindCommonCharacters1002 {

    public static void main(String[] args) {
        String[] A = new String[]{"bella", "label", "roller"};
        printList(commonChars(A));
    }

    private static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[][] num = new int[100][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                num[i][A[i].charAt(j) - 'a']++;
            }
        }

        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < A.length; i++) {
                num[0][j] = Math.min(num[0][j], num[i][j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (num[0][i]-- > 0) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
