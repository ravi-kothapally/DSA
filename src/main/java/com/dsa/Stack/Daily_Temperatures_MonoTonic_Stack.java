package com.dsa.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures_MonoTonic_Stack {

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Stack<int[]> stack = new Stack<>();
    for (int i = temperatures.length - 1; i >= 0; i--) {

      if (stack.isEmpty()) {
        res[i] = 0;
      } else if (stack.peek()[0] > temperatures[i]) {
        res[i] = stack.peek()[1] - i;
      } else {
        while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
          stack.pop();
        }
        if(!stack.isEmpty())
          res[i]=stack.peek()[1]-i;
      }
      stack.push(new int[]{temperatures[i], i});
    }
    return res;
  }

  public static void main(String[] args) {
    int[] input = new int[]{89,62,70,58,47,47,46,76,100,70};
    int[] x = dailyTemperatures(input);
    for (int i = 0; i < x.length; i++) {
      System.out.println(x[i]);
    }
  }

}
