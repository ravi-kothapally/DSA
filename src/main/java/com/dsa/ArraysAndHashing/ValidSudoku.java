package com.dsa.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public static boolean isUnique(char[] box) {
    Integer[] counts = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    for (char c : box) {
      if (c != '.') {
        counts[c - '0'] += 1;
      }
    }
    return Arrays.stream(counts).noneMatch(integer -> integer > 1);
  }

  public static boolean isUnique(char[][] board, int column) {
    char[] col = new char[9];
    for (int i = 0; i < board.length; i++) {
      col[i] = board[i][column];
    }
    return isUnique(col);
  }

  public static boolean isUnique(char[][] box, int i, int j) {
    char[] col = new char[9];
    for (int i1 = i; i1 < i + 3; i1++) {
      System.arraycopy(box[i1], j, col, (i1 - i) * 3 + j - j, j + 3 - j);
    }
    return isUnique(col);
  }

  public static boolean isValidSudoku(char[][] board) {

    for (int b = 0; b < 9; b++) {
      if (!isUnique(board[b])) {
        return false;
      }
      if (!isUnique(board, b)) {
        return false;
      }
    }
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        if (!isUnique(board, i, j)) {
          return false;
        }
      }
    }

    return true;

  }

//  https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/
  public static boolean isValidSudoku2(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
      for (int j=0; j<9; ++j) {
        char number = board[i][j];
        if (number != '.')
          if (!seen.add(number + " in row " + i) ||
              !seen.add(number + " in column " + j) ||
              !seen.add(number + " in block " + i/3 + "-" + j/3))
            return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    char[][] board2 = {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

    boolean isValid = isValidSudoku2(board2);
    System.out.println("Is the Sudoku board valid? " + isValid);
    Set set=new HashSet<>();

  }

}
