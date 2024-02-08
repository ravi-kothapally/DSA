package com.dsa.BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".


Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
 */
class TimeMap {

  Map<String, TreeMap<Integer, String>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

//  public static void main(String[] args) {
//    TimeMap obj = new TimeMap();
//    obj.set("sunny", "ravi", 1);
//    String param_2 = obj.get("sunny", 1);
//    System.out.println(param_2);
//  }
//  public static void main(String[] args) {
//    TimeMap obj = new TimeMap();
//    obj.set("foo", "bar", 1);
//    System.out.println(obj.get("foo", 1));
//    System.out.println(obj.get("foo", 3));
//    obj.set("foo", "bar2", 4);
//    System.out.println(obj.get("foo", 4));
//    System.out.println(obj.get("foo", 4));
//  }

  //  public static void main(String[] args) {
//    TimeMap obj = new TimeMap();
//    obj.set("love", "high", 10);
//    obj.set("love", "low", 20);
//    System.out.println(obj.get("love", 5));  // Output: null
//    System.out.println(obj.get("love", 10)); // Output: high
//    System.out.println(obj.get("love", 15)); // Output: high
//    System.out.println(obj.get("love", 20)); // Output: low
//    System.out.println(obj.get("love", 25)); // Output: low
//  }
  public static void main(String[] args) {
    TimeMap obj = new TimeMap();
    obj.set("a", "bar", 1);
    obj.set("x", "b", 3);
    System.out.println(obj.get("b", 3));   // Output: null
    obj.set("foo", "bar2", 4);
    System.out.println(obj.get("foo", 4)); // Output: bar2
    System.out.println(obj.get("foo", 5)); // Output: bar2
  }


  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new TreeMap<>());
    }
    map.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    String res = "";
    final TreeMap<Integer, String> integerStringTreeMap = map.get(key);
    if(integerStringTreeMap==null) return res;
    final Integer i = integerStringTreeMap.floorKey(timestamp);
    if (i != null) {
      res = integerStringTreeMap.get(i);
    }
    return res;
  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp); String param_2 = obj.get(key,timestamp);
 */
