In Java, the `PriorityQueue` class is part of the `java.util` package and is used to implement a priority queue. Here are some of the important functions provided by the `PriorityQueue` class:

1. **add(E element) / offer(E element):** Adds the specified element to the priority queue. These methods are interchangeable.

    ```java
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(5);
    pq.offer(3);
    ```

2. **remove() / poll():** Removes and returns the element at the front of the priority queue (the one with the highest priority).

    ```java
    int highestPriorityElement = pq.remove();
    // or
    int anotherPriorityElement = pq.poll();
    ```

3. **peek():** Retrieves, but does not remove, the element at the front of the priority queue.

    ```java
    int highestPriorityElement = pq.peek();
    ```

4. **size():** Returns the number of elements in the priority queue.

    ```java
    int size = pq.size();
    ```

5. **isEmpty():** Returns true if the priority queue is empty, false otherwise.

    ```java
    boolean isEmpty = pq.isEmpty();
    ```

Note: By default, the `PriorityQueue` class in Java is a min-heap, meaning the element with the lowest value has the highest priority. If you want to use it as a max-heap, you can provide a custom comparator during initialization:

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

This creates a max-heap where elements with higher values have higher priority.