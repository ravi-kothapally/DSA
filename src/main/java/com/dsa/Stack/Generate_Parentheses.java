package com.dsa.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Constraints:

1 <= n <= 8
 */

public class Generate_Parentheses {

  Stack<String> stack = new Stack<>();

  public void generate(List<String> result, int oc, int ec, int n) {
    if (stack.size() == 2 * n) {
      result.add(String.join("", stack));
    }
    if (oc < n) {
      stack.add("(");
      generate(result, oc + 1, ec, n);
      stack.pop();
    }
    if (ec < oc) {
      stack.add(")");
      generate(result, oc, ec + 1, n);
      stack.pop();
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    int oc = 0, ec = 0;
    generate(res, oc, ec, n);
    return res;
  }

  public static void main(String[] args) {
    Generate_Parentheses generator = new Generate_Parentheses();

    // Test case 1
    int n1 = 3;
    List<String> result1 = generator.generateParenthesis(n1);
    System.out.println("Input: n = " + n1);
    System.out.println("Output: " + result1);

    // Test case 2
    int n2 = 1;
    List<String> result2 = generator.generateParenthesis(n2);
    System.out.println("Input: n = " + n2);
    System.out.println("Output: " + result2);
  }

}
