package com.dsa.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

[-1,-1,-1,0,0,1,2,3,3,4,4] 4
 */
public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums, int tar) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int lp = i + 1, rp = nums.length - 1;
      while (lp < rp) {
        int sum = nums[i] + nums[lp] + nums[rp];
        if (sum == tar) {
          result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
          lp += 1;
          while (lp<rp && nums[lp] == nums[lp - 1]) {
            lp += 1;
          }
        } else if (sum > tar) {
          rp -= 1;
        } else {
          lp += 1;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] input = new int[]{-1,0,1,2,-1,-4};
    int[] input2=new int[]{0,1,1};
    int[] input3=new int[]{0,0,0};
    final List<List<Integer>> x = threeSum(input3, 0);
    for (int i = 0; i < x.size(); i++) {
      System.out.println(x.get(i));
    }
  }

}
