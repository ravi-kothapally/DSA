package com.dsa.SlidingWindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


adbbbbcdab

 */
public class Longest_Substring_Without_Repeating_Characters {

  public static int lengthOfLongestSubstring(String s) {
    final char[] charArray = s.toCharArray();
    int longest = 0;
    int sw = 0;
    int ew = 0;
    Set<Character> substring = new HashSet<>();
    while (ew < s.length()) {
      while (ew < s.length() && substring.add(charArray[ew])) {
        ew++;
      }
      longest = Math.max(substring.size(), longest);

      substring.remove(charArray[sw++]);
    }
    return longest;
  }

  public static void main(String[] args) {
    String s = "dvdf";
    System.out.println(lengthOfLongestSubstring(s));

  }

}
