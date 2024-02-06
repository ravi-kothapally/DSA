package com.dsa.Stack;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
  Stack<int []> stack;

  public MinStack() {
    stack=new Stack<>();
  }

  public void push(int val) {
    if(stack.isEmpty())
  stack.push(new int[]{val,val});
    else {
      stack.push(new int[]{val,Math.min(val,stack.peek()[1])});
    }
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
    return stack.peek()[1];
  }

  public static void main(String[] args) {

  }

}
