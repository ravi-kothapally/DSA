package com.dsa.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class Longest_Consecutive_Sequence {

  public static int longestConsecutive(int[] nums) {
    Set<Integer> integerSet = new HashSet<>();
    for (int num : nums) {
      integerSet.add(num);
    }
    int counter = 0;
    for (int num : nums) {
      if (!integerSet.contains(num - 1)) {
        int count = 1;
        while (integerSet.contains(num += 1)) {
          count += 1;
        }
        counter = Math.max(count, counter);
      }

    }
    return counter;
  }

  public static void main(String[] args) {
    int[] input = {100, 4, 200, 1, 3, 2, 5};
    System.out.println(longestConsecutive(input));
  }

}
