package com.dsa;

import java.util.ArrayList;
import java.util.List;
/*
wissen hiring challenge
 */
public class CloudServiceSetup {

  public static boolean isFullySetup(int[] perm) {
    for (int i = 0; i < perm.length; i++) {
      if (perm[i] % (i + 1) != 0 && (i + 1) % perm[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static int totalFullySetup(int N, int[] keys) {
    int count = 0;
    List<int[]> permutations = new ArrayList<>();
    generatePermutations(keys, N, permutations, 0);
    for (int[] perm : permutations) {
      if (isFullySetup(perm)) {
        count++;
      }
    }
    return count;
  }

  public static void generatePermutations(int[] keys, int N, List<int[]> permutations, int index) {
    if (index == N) {
      permutations.add(keys.clone());
      return;
    }
    for (int i = index; i < N; i++) {
      swap(keys, index, i);
      generatePermutations(keys, N, permutations, index + 1);
      swap(keys, index, i);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int N = 5;
    int[] keys = {5,3,6,12,2};
    System.out.println(totalFullySetup(N, keys)); // Output: 3
  }
}
