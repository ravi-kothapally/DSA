package com.dsa.BinarySearch;

/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */
public class Search_2D_Matrix {

  public static boolean searchMatrix(int[][] matrix, int target) {
    int n= matrix.length*matrix[0].length;
    int cols=matrix[0].length;
    int high = n-1;
    int low = 0;
    while ( low<=high) {
      int mid = low+high >>> 1;
      if (matrix[mid/cols][mid%cols] == target) {
        return true;
      } else if (matrix[mid/cols][mid%cols] > target) {
        high = mid-1;
      } else {
        low = mid+1;
      }
    }
    return false;

  }

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    System.out.println(searchMatrix(matrix,0));
  }

}
