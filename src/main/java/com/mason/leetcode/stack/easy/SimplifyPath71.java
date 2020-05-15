package com.mason.leetcode.stack.easy;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by mwu on 2020/5/14
 * <p>
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * <p>
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 */
public class SimplifyPath71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath1("/../"));
    }

    // 无敌不要脸法
    public static String simplifyPath(String path) {
        return Paths.get(path).normalize().toString();
    }

    // 栈方法
    public static String simplifyPath1(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> special = new HashSet<String>(3) {{
            add("..");
            add(".");
            add("");
        }};
        String[] strs = path.split("/");
        for (String str : strs) {
            // ..跳出
            if (!stack.isEmpty() && "..".equals(str)) {
                stack.pop();
            } else if (!special.contains(str)) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) return "/";
        return "/" + String.join("/", stack);
    }

    public static String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            // ..跳出
            if ("..".equals(str)) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!".".equals(str) && !"".equals(str)) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) return "/";
        return "/" + String.join("/", stack);
    }
}
