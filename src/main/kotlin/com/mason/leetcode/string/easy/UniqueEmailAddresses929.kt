package com.mason.leetcode.string.easy


/**
 * Created by mwu on 2018/10/29
 *
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * It is possible to use both of these rules at the same time.
 * Given a list of emails, we send one email to each address in the list.
 * How many different addresses actually receive mails?
 *
 * Example 1:
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 * Note:
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 */
object UniqueEmailAddresses929 {

  @JvmStatic
  fun main(args: Array<String>) {
    val emails = arrayOf("test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com")
    val result = numUniqueEmails(emails)
    println(result)
  }

  private fun numUniqueEmails(emails: Array<String>): Int {
    val set = mutableSetOf<String>()
//    emails.forEach {
//      val email = genRealEmailAddress(it)
//      set.add(email)
//    }
    emails.forEach {
      val index = it.indexOf("@")
      var local = it.substring(0, index)
      val rest = it.substring(index)
      if (local.contains("+")) {
        local = local.substring(0, local.indexOf("+"))
      }
      local = local.replace(".", "")
      set.add(local + rest)
    }
    return set.size
  }

  private fun genRealEmailAddress(address: String): String {
    if (!address.contains("@")) return ""
    val sb = StringBuilder()
    val atArray = address.split("@")
    val front = atArray[0]
    val back = atArray[1]
    if (front.contains("+")) {
      val addArray = front.split("+")
      if (addArray[0].contains(".")) {
        addArray[0].split(".").forEach {
          sb.append(it)
        }
      } else {
        sb.append(addArray[0])
      }
    } else {
      if (front.contains(".")) {
        front.split(".").forEach {
          sb.append(it)
        }
      } else {
        sb.append(front)
      }
    }
    return sb.append("@").append(back).toString()
  }
}