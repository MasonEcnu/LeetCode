package com.mason.leetcode.tools

/**
 * Created by mwu on 2018/11/26
 * 正则表达式
 */
enum class Regular(val desc: String) {
    // 提取字符串中的数字
    EXTRACT_NUMBER("[0-9]+"),

    // 提取字母
    EXTRACT_LETTER("[a-zA-Z]+"),

    // 提取小写字母
    EXTRACT_LOWERCASE_LETTER("[a-z]+"),

    // 提取大写字母
    EXTRACT_UPPERCASE_LETTER("[A-Z]+"),

    // 账户注册--字符、数字、下划线、连字符、设置长度、以大写字母开头
    MATCH_ACCOUNT_REGISTER("^[A-Z]+[A-Za-z0-9_-]{6,20}\$"),

    // 手机号
    MATCH_CELLPHONE_NUMBER("^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})\$"),

    // 座机号
    MATCH_TELEPHONE_NUMBER("^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}\$"),

    // 座机号&手机号
    MATCH_TELE_CELLPHONE_NUMBER("^(0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8})|(400|800)([0-9\\\\-]{7,10})|(([0-9]{4}|[0-9]{3})(-| )?)?([0-9]{7,8})((-| |转)*([0-9]{1,4}))?\$"),

    // 邮箱
    MATCH_EMAIL_ADDRESS("[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}")
}