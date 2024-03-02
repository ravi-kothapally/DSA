In Java, the TreeMap class is a part of the Java Collections Framework and it implements the NavigableMap interface and extends AbstractMap class. It provides an efficient means of storing key-value pairs in sorted order based on the natural ordering of its keys or using a custom comparator. Here are some important functions of the TreeMap class in Java:

1. **put(K key, V value)**: Adds the specified key-value pair to the TreeMap. If the key already exists, the previous value associated with the key is replaced with the new value.

2. **get(Object key)**: Returns the value to which the specified key is mapped in the TreeMap, or null if the key is not present.

3. **remove(Object key)**: Removes the mapping for the specified key from the TreeMap if present.

4. **containsKey(Object key)**: Returns true if the TreeMap contains the specified key.

5. **containsValue(Object value)**: Returns true if the TreeMap contains the specified value.

6. **size()**: Returns the number of key-value mappings in the TreeMap.

7. **isEmpty()**: Returns true if the TreeMap contains no key-value mappings.

8. **clear()**: Removes all of the mappings from the TreeMap.

9. **firstKey()**: Returns the first (lowest) key currently in the TreeMap.

10. **lastKey()**: Returns the last (highest) key currently in the TreeMap.

11. **higherKey(K key)**: Returns the least key greater than the given key, or null if there is no such key.

12. **lowerKey(K key)**: Returns the greatest key strictly less than the given key, or null if there is no such key.

13. **ceilingKey(K key)**: Returns the least key greater than or equal to the given key, or null if there is no such key.

14. **floorKey(K key)**: Returns the greatest key less than or equal to the given key, or null if there is no such key.

15. **subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)**: Returns a view of the portion of the TreeMap whose keys range from fromKey to toKey. The boolean parameters specify whether the endpoints are inclusive or not.

These are some of the important functions provided by the TreeMap class in Java. It's commonly used when you need to store key-value pairs in sorted order or efficiently search for keys within a specified range.