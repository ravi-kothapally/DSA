package com.dsa.biweekly_contest_125;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Minimum_Operations_to_Exceed_Threshold_Value_II {
  class Solution {
    public int minOperations(int[] nums, int k) {
      PriorityQueue<Long> nm=new PriorityQueue<>();
      for(int i:nums)
      {
        nm.add((long)i);
      }
      int count=0;
      while(!nm.isEmpty() && nm.size()>1)
      {
        long val1=nm.poll();
        long val2=nm.poll();
        if(val1<k || val2<k)
        {
          long cal=(long)Math.min(val1,val2)*(long)2 + (long)Math.max(val1,val2);
          nm.offer(cal);
          count++;
        }
        else
        {
          break;
        }
      }
      return count;
    }

    public int minOperations2(int[] nums, int k) {

      PriorityQueue<Long> heap = new PriorityQueue<>();
      for(int i: nums)
        heap.add((long) i);

      int ans = 0;
      while(heap.size() > 1 && heap.peek() < k){

        long x = heap.remove();
        long y = heap.remove();

        heap.add(2*x + y);
        ans++;
      }

      return ans;

    }
  }

}
