package com.dsa.BinarySearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class Koko_Eating_Bananas {

  public static int minEatingSpeed(int[] piles, int h) {
    int min = 0;
    int max = Integer.MIN_VALUE;
    int minEatingSpeed = Integer.MAX_VALUE;
    for (int i = 0; i < piles.length; i++) {
      if (piles[i] > max) {
        max = piles[i];
      }
    }
    while (min <= max) {
      int mid = min + max >>> 1;
      if (!canEat(piles, h, mid)) {
        min = mid + 1;
      } else {
        minEatingSpeed = Math.min(minEatingSpeed, mid);
        max = mid - 1;
      }
    }
    return minEatingSpeed;
  }

  private static boolean canEat(int[] piles, int h, int speed) {
    double t = 0;
    for (int i = 0; i < piles.length; i++) {
      t += Math.ceil(piles[i] / (double)speed);
    }
    if (t > h) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
  }

}
