package com.dsa.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

 */
public class ValidAnagram {

  public static boolean isAnagram(String s, String t) {

    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    Arrays.sort(sc);
    Arrays.sort(tc);
    return Arrays.equals(sc,tc);
  }
  public static boolean isAnagram2(String s, String t) {

    Map<Character ,Integer> res=new HashMap<>();
    for (char c : s.toCharArray()) {
      res.put(c,res.getOrDefault(c,0)+1);
    }
    for (char c : t.toCharArray()) {
      res.put(c,res.getOrDefault(c,0)-1);
    }
    for (Integer x:res.values()) {
     if(x!=0)
       return false;
    }
    return true;
  }

  public boolean isAnagram3(String s, String t) {
    int[] count = new int[26];

    // Count the frequency of characters in string s
    for (char x : s.toCharArray()) {
      count[x - 'a']++;
    }

    // Decrement the frequency of characters in string t
    for (char x : t.toCharArray()) {
      count[x - 'a']--;
    }

    // Check if any character has non-zero frequency
    for (int val : count) {
      if (val != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram2("anagram", "nagaram") );
  }
}
