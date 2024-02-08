package com.dsa.Matrix;

public class SpiralPrint {

  public static void  spiralPrint(int[][] matrix)
  {
    if(matrix==null|| matrix.length==0) return;
    int rows=matrix.length;
    int cols=matrix[0].length;
    int left=0,right=cols-1,top=0,bottom=rows-1;
    while (left<=right && top<=bottom)
    {
      //print top row
      for (int i = left; i <=right; i++) {
        System.out.println(matrix[top][i]);
      }
      top++;
      //print right row
      for (int i = top; i <= bottom; i++) {
        System.out.println(matrix[i][right]);
      }
      right--;
      //print bottom row
      for (int i = right; i >=left; i--) {
        System.out.println(matrix[bottom][i]);
      }
      bottom--;
      //print left row
      for (int i = bottom; i >=top ; i--) {

        System.out.println(matrix[i][left]);
      }
      left++;
    }

  }

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    System.out.println("Spiral print of the matrix:");
    spiralPrint(matrix);

  }

}
