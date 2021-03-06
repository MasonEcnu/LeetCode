package com.mason.leetcode.string.easy;

/**
 * Created by mwu on 2020/6/15
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     31221
 * <p>
 * <p>
 * 1 被读作 "one 1" ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似
 * "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * Related Topics 字符串
 */
public class CountAndSay38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        // 初始项
        if (n == 1) return "1";
        if (n == 2) return "11";

        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(count).append(str.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
            if (i + 1 == str.length()) {
                sb.append(count).append(str.charAt(i));
                str = sb.toString();
                return str;
            }
        }
        return str;

//        StringBuilder s = new StringBuilder();
//        int p1 = 0;
//        int cur = 1;
//        if (n == 1)
//            return "1";
//        String str = countAndSay(n - 1);
//        for (cur = 1; cur < str.length(); cur++) {
//            if (str.charAt(p1) != str.charAt(cur)) {// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
//                int count = cur - p1;
//                s.append(count).append(str.charAt(p1));
//                p1 = cur;
//            }
//        }
//        if (p1 != cur) {// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
//            int count = cur - p1;
//            s.append(count).append(str.charAt(p1));
//        }
//        return s.toString();
    }
}
