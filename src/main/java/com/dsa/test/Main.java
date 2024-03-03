package com.dsa.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    // Creating a LinkedHashMap with access order
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

    // Adding key-value pairs
    linkedHashMap.put("A", 1);
    linkedHashMap.put("B", 2);
    linkedHashMap.put("C", 3);

    // Accessing key "B"
    linkedHashMap.get("B");

    // Displaying the order after accessing "B"
    System.out.println("Order after accessing 'B': " + linkedHashMap);

    // Accessing key "A" to demonstrate access order
    linkedHashMap.get("A");

    // Displaying the order after accessing "A"
    System.out.println("Order after accessing 'A': " + linkedHashMap);
  }
}
