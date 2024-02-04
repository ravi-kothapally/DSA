package com.dsa.TwoPointers;

import java.util.Map;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */
public class Container_With_Most_Water {

  public static int maxArea(int[] height) {
    int lp = 0, rp = height.length - 1, maxArea = 0;
    while (lp < rp) {
      int area = 0;
      if (height[lp] < height[rp]) {
        area = height[lp] * (rp - lp);
        lp += 1;
      } else {
        area = height[rp] * (rp - lp);
        rp -= 1;
      }
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int[] heights=new int[]{1,8,6,2,5,4,8,3,7};
    int[] height2=new int[]{5,5,1,1,1,1,1,1,1,1};
    System.out.println(maxArea(height2));

  }

}
