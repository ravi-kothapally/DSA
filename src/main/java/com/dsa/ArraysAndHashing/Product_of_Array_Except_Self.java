package com.dsa.ArraysAndHashing;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class Product_of_Array_Except_Self {
  public static int[] productExceptSelf(int[] nums) {
    int[] leftProducts=new int[nums.length];
    leftProducts[0]=1;
    for (int i = 1; i < nums.length; i++) {
      leftProducts[i]=leftProducts[i-1]*nums[i-1];
    }
    int rightProduct=1;
    for (int i = leftProducts.length - 1; i >= 0; i--) {
      leftProducts[i]=leftProducts[i]*rightProduct;
      rightProduct=rightProduct*nums[i];
    }
    return leftProducts;
  }

  public static void main(String[] args) {

    int[] nums = {1, 2,3,4};
    int[] result = productExceptSelf(nums);

    // Print the result
    System.out.println(Arrays.toString(result));

  }

}
