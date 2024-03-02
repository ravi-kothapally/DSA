package com.dsa.biweekly_contest_125;

public class minimum_operations_to_exceed_threshold_value_i {
  public static int minOperations(int[] nums, int k) {
    int c=0;
    for (int num : nums) {
      if(num<k)c++;
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(minOperations(new int[]{1,1,2,4,9}, 1));
  }

}
