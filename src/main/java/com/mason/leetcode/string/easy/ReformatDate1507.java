package com.mason.leetcode.string.easy;

import java.util.HashMap;

/**
 * Created by mwu on 2020/8/7
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oc
 * t", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 [1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * <p>
 * 示例 2：
 * <p>
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * <p>
 * 示例 3：
 * <p>
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 * <p>
 * 提示：
 * 给定日期保证是合法的，所以不需要处理异常输入。
 * <p>
 * Related Topics 字符串
 */
public class ReformatDate1507 {

    public static void main(String[] args) {
        String str = "1st Oct 2052";
        System.out.println(reformatDate(str));
    }

    private static final HashMap<String, Integer> strings2Months = new HashMap<String, Integer>() {{
        put("Jan", 1);
        put("Feb", 2);
        put("Mar", 3);
        put("Apr", 4);
        put("May", 5);
        put("Jun", 6);
        put("Jul", 7);
        put("Aug", 8);
        put("Sep", 9);
        put("Oct", 10);
        put("Nov", 11);
        put("Dec", 12);
    }};

    public static String reformatDate(String date) {
        // 这里的校验其实不严格
        String[] arr = date.split(" ");
        if (arr.length != 3) return "";
        int year = Integer.parseInt(arr[2]);
        int month = strings2Months.getOrDefault(arr[1], 0);
        int day = Integer.parseInt(arr[0].substring(0, arr[0].length() - 2));
        return String.format("%d-%02d-%02d", year, month, day);
    }
}
