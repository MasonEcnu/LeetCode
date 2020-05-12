package com.mason.leetcode.stack.easy;

import java.util.Stack;

/**
 * Created by mwu on 2019/11/14
 * <p>
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * 提示：
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class RemoveOutermostParentheses1021 {

    public static void main(String[] args) {
        String s = "()(()))";
        System.out.println(removeOuterParentheses(s));
    }

    private static String oldRemoveOuterParentheses(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0, end;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                if (!flag) {
                    start = i;
                    flag = true;
                }
            }

            if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    end = i;
                    sb.append(s, start + 1, end);
                    start = end;
                    flag = false;
                }
            }
        }
        return sb.toString();
    }

    private static String removeOuterParentheses(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int start = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') num++;
            if (c == ')') num--;

            if (num == 1 && c == '(') start = i;

            if (num == 0) sb.append(s, start + 1, i);
        }
        return sb.toString();
    }
}
