package com.dsa.TwoPointers;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class Valid_Palindrome {

  public static boolean isAlphaNumeric(char c) {
    return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
  }

  public static boolean isPalindrome(String s) {
    s = s.toLowerCase();
    char[] charArray = s.toCharArray();
    int leftP = 0, rightP = s.length() - 1;
    while (leftP < rightP) {
      while (leftP < rightP && !isAlphaNumeric(charArray[leftP])) {
        leftP += 1;
      }
      while (rightP > leftP && !isAlphaNumeric(charArray[rightP])) {
        rightP -= 1;
      }
      if (charArray[leftP] != charArray[rightP]) {
        return false;
      }
      leftP += 1;
      rightP -= 1;
    }

    return true;
  }

  public static void main(String[] args) {
    String test = "A man, a plan, a canal: Panama";
    String test2 = "race a car";
    String test3 = "1a2";
    String test4 = "a.,a";
//    System.out.println(isPalindrome(test3));
//    System.out.println(isPalindrome(test2));
//    System.out.println(isPalindrome(test));
    System.out.println(isPalindrome(test4));

  }

}
