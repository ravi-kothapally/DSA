package com.dsa.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
//https://leetcode.com/problems/top-k-frequent-elements/solutions/81635/3-java-solution-using-array-maxheap-treemap/
public class Top_K_Frequent_Elements {


  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> map=new HashMap<>();
    for (int num : nums) {
      map.put(num,map.getOrDefault(num,0)+1);
    }
    List<Integer> uniqueElements = new ArrayList<>(map.keySet());
    uniqueElements.sort((integer, t1) -> map.get(t1)-map.get(integer));
    return uniqueElements.subList(0,k).stream().mapToInt(Integer::intValue).toArray();
  }
  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;
    int[] result = topKFrequent(nums, k);

    // Print the result
    System.out.println(Arrays.toString(result));
  }

}
