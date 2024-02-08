package com.dsa.SlidingWindow;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Longest_SubString {

  public static int longestString(String s) {
    Set<Character> set = new LinkedHashSet<>();
    final char[] charArray = s.toCharArray();
    int max = 0;
    int sw = 0;
    int ew = 0;
    while (ew < charArray.length) {
      if (!set.contains(charArray[ew])) {
        set.add(charArray[ew]);
        max = Math.max(max, set.size());
      } else {
        while (set.contains(charArray[ew])) {
          set.remove(charArray[sw]);
          sw++;
        }
        set.add(charArray[ew]);
      }
      ew++;
      System.out.println(set);

    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestString("abccdeabbcde"));
  }


}
