package com.dsa.SlidingWindow;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

ABCABBBBAB k=2
 */
public class Longest_Repeating_Character_Replacement {

  public static void main(String[] args) {
    String s = "ABAAAABB";
    System.out.println(characterReplacement(s, 2));

  }

  public static int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new TreeMap<>();
    final char[] charArray = s.toCharArray();
    int result = 0;
    int sw = 0;
    int ew = 0;
    int maxF = 0;
    while (ew < s.length()) {
      map.put(charArray[ew], map.getOrDefault(charArray[ew], 0) + 1);
      maxF =maxF>map.get(charArray[ew])?maxF:map.get(charArray[ew]);
      if (ew - sw + 1 - maxF > k) {
        map.put(charArray[sw], map.get(charArray[sw]) - 1);
        sw++;
      }
      ew++;
      result = result> ew - sw?result:ew-sw;
    }
    return result;

  }

}
