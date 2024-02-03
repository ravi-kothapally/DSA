
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
package com.dsa.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    return !(set.size()==nums.length);

  }
  public boolean containsDuplicate2(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (seen.contains(num))
        return true;
      seen.add(num);
    }
    return false;
  }
  public boolean containsDuplicate3(int[] nums) {
    HashMap<Integer, Integer> seen = new HashMap<>();
    for (int num : nums) {
      if (seen.containsKey(num) && seen.get(num) >= 1)
        return true;
      seen.put(num, seen.getOrDefault(num, 0) + 1);
    }
    return false;
  }


  public static void main(String[] args) {


  }

}
