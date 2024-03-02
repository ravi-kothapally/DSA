package com.dsa.Linked_List;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
 
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 
Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 
Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class Linked_List_Cycle_141 {

  public static boolean hasCycle(ListNode head) {
    if ((head != null && head.next == null) || head == null) {
      return false;
    }
    ListNode slow = head, fast = head.next;
    while (slow != fast) {
      if (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
      } else {
        return false;
      }
      slow = slow.next;
    }
    return true;

  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

//    head.next.next.next.next.next=head.next;
    System.out.println(hasCycle(head));


  }

  public boolean hasCycle2(ListNode head) {
    ListNode slow_pointer = head, fast_pointer = head;
    while (fast_pointer != null && fast_pointer.next != null) {
      slow_pointer = slow_pointer.next;
      fast_pointer = fast_pointer.next.next;
      if (slow_pointer == fast_pointer) {
        return true;
      }
    }
    return false;
  }
}
