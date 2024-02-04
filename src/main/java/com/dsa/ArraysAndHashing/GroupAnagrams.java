package com.dsa.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

 */
public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> res = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      List<String> xx = res.getOrDefault(key, new ArrayList<>());
      xx.add(str);
      res.put(key, xx);
    }
    return res.values().stream().collect(Collectors.toList());
  }

  public static List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);//instead of sort get Integer[26] char count arr for each string..
      String sortedWord = new String(chars);//use that array as key in map(tc goes like 0(m*n))

      if (!map.containsKey(sortedWord)) {
        map.put(sortedWord, new ArrayList<>());
      }
      map.get(sortedWord).add(word);
    }

    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> result = groupAnagrams2(input);

    // Print the result
    for (List<String> group : result) {
      System.out.println(group);
    }

  }


}
