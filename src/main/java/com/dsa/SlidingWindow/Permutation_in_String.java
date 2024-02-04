package com.dsa.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */
public class Permutation_in_String {

  public static boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> baseMap = new HashMap<>();
    Map<Character, Integer> windowMap = new HashMap<>();
    int sw = 0;
    int ew = s1.length();
    final char[] charArray = s1.toCharArray();
    final char[] charArray1 = s2.toCharArray();
    if(s1.length()>s2.length()) return false;
    for (int i = 0; i < charArray.length; i++) {
      baseMap.put(charArray[i], baseMap.getOrDefault(charArray[i], 0) + 1);
      windowMap.put(charArray1[i], windowMap.getOrDefault(charArray1[i], 0) + 1);
    }
    if(baseMap.equals(windowMap)) return true;
    while (ew < s2.length()) {
      if (!baseMap.equals(windowMap)) {
        windowMap.put(charArray1[ew], windowMap.getOrDefault(charArray1[ew], 0) + 1);
        if (windowMap.get(charArray1[sw]) - 1 == 0) {
          windowMap.remove(charArray1[sw]);
        } else {
          windowMap.put(charArray1[sw], windowMap.getOrDefault(charArray1[sw], 0) - 1);
        }
        sw++;
        ew++;
      }
      if (baseMap.equals(windowMap)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "ab"));
  }

}
