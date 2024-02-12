package com.dsa.Strings;

public class Longest_palindrome {
  public static void printBooleanArray(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] ? "T" : "F");
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println("==========================================");

  }
    public static String longest_palindrome(String s){
      int length = s.length();
      // creating boolean table
      boolean dp[][] = new boolean[length][length];
      int max_pal_length = 1;
      // setting the value of substrings of length 1 to True in dp table (i.e. same character)
      for (int i = 0; i < length; i++){
        dp[i][i] = true;
      }
      printBooleanArray(dp);

      // for substrings of length 2
      int start = 0;
      for (int j = 0; j < length - 1; j++){
        // checking if there are 2 consecutive characters that are same
        if (s.charAt(j) == s.charAt(j + 1)){
          dp[j][j + 1] = true;
          start = j;
          max_pal_length = 2;
        }
      }
      printBooleanArray(dp);

      // now for longer length palindromes
      for (int k = 3; k <= length; ++k) {
        // Fix the starting index
        for (int i = 0; i < length - k + 1; ++i) {
          // Get the end index of the substring from start index i and length k
          int j = i + k - 1;

          // check the sub-string from ith index to the jth index if s[i+1] to s[j-1] is a palindrome
          if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = true;
            // if current palindrome length is larger than previous largest length, update the maximum length
            if (k > max_pal_length) {
              start = i;
              max_pal_length = k;
            }
          }
        }
        printBooleanArray(dp);

      }
      // return longest palindromic substring
      return s.substring(start, start + max_pal_length);
    }

    public static void main(String[] args){
      String word = "aggggs";
      System.out.println(longest_palindrome(word));
    }
  };

