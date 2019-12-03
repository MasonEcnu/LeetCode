package com.mason.leetcode.string.easy

/**
 * Created by mwu on 2019/11/13
 *
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * Constraints:
 * The given address is a valid IPv4 address.
 *
 * 其实应该校验下ip地址是否合法
 */
object DefangingAnIPAddress1108 {
  @JvmStatic
  fun main(args: Array<String>) {
    val address = "255.100.50.0"
    println(defangIPaddr(address))
  }

  fun defangIPaddr(address: String): String {
    return address.replace(".", "[.]")
  }
}