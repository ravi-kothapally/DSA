package com.dsa.BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array {

  public static int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      System.out.println("l=:"+l);
      System.out.println("r=:"+r);
      int m = l + r >>> 1;
      System.out.println("m=:"+m);

      if (nums[m] > nums[r]) {
        l = m + 1;
      } else {
        r = m ;
      }
    }
    return nums[l];
  }

  public static void main(String[] args) {
    System.out.println(findMin(new int[]{3, 1 ,2}));
  }

}
