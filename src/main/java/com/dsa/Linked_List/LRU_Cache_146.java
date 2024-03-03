package com.dsa.Linked_List;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRU_Cache_146 {

  private int capacity;

  private Map<Integer, Integer> map;

  public void LRUCache(int capacity) {
    this.capacity = capacity;
    map = new LinkedHashMap<>(capacity, 1.0f, true);
  }

  public int get(int key) {
      return map.getOrDefault(key,-1);
  }

  public void put(int key, int value) {
    map.put(key, value);
    if (map.size() > capacity ) {
      final Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
      if (iterator.hasNext()) {
        iterator.next();
        iterator.remove();
      }
    }
//    System.out.println("Order after put {"+key+":"+value+"}: " + map);

  }

//  public static void main(String[] args) {
//    // Creating a new LRU cache with capacity 2
//    LRU_Cache_146 cache = new LRU_Cache_146();
//    cache.LRUCache(2);
//
//    // Performing operations based on the given input
//    System.out.println(cache.get(1)); // Output: -1 (Key 1 is not present in the cache)
//    cache.put(1, 1);
//    cache.put(2, 2);
//    System.out.println(cache.get(1)); // Output: 1 (Value corresponding to key 1 is 1)
//    cache.put(3, 3);
//    System.out.println(cache.get(2)); // Output: -1 (Key 2 was removed from the cache due to its least recently used status)
//    cache.put(4, 4);
//    System.out.println(cache.get(1)); // Output: -1 (Key 1 was removed from the cache due to its least recently used status)
//    System.out.println(cache.get(3)); // Output: 3 (Value corresponding to key 3 is 3)
//    System.out.println(cache.get(4)); // Output: 4 (Value corresponding to key 4 is 4)
//  }

//  public static void main(String[] args) {
//    // Creating a new LRU cache with capacity 2
//    LRU_Cache_146 cache = new LRU_Cache_146();
//    cache.LRUCache(2);
//
//    // Performing operations based on the given input
//    System.out.println(cache.get(2)); // Output: -1 (Key 2 is not present in the cache)
//    cache.put(2, 6);
//    System.out.println(cache.get(1)); // Output: -1 (Key 1 is not present in the cache)
//    cache.put(1, 5);
//    cache.put(1, 2);
//    System.out.println(cache.get(1)); // Output: 2 (Value corresponding to key 1 is 2)
//    System.out.println(cache.get(2)); // Output: 6 (Value corresponding to key 2 is 6)
//  }


  public static void main(String[] args) {
    LRU_Cache_146 cache = new LRU_Cache_146();

    // Operation sequence
    String[] operations = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get",
        "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put",
        "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get",
        "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put",
        "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put",
        "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put",
        "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put",
        "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put",
        "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
    int[][] values = {{10}, {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3},
        {5, 25}, {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3},
        {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5}, {4}, {11, 4},
        {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4},
        {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22},
        {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4},
        {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26},
        {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17},
        {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4},
        {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};

    // Performing operations
    for (int i = 0; i < operations.length; i++) {
      String operation = operations[i];
      int[] value = values[i];
      switch (operation) {
        case "LRUCache":
          cache.LRUCache(value[0]);
          break;
        case "put":
          cache.put(value[0], value[1]);
          break;
        case "get":
          System.out.println("get(" + value[0] + ") returned: " + cache.get(value[0]));
          break;
        default:
          System.out.println("Invalid operation!");
          break;
      }
    }
  }
}
