package com.dsa.Linked_List;
/*
206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []

 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Reverse_Linked_List {
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null,current=head,next;

    while (current!=null)
    {
      next=current.next;
      current.next=prev;
      prev=current;
      current=next;
    }
    return prev;

  }

  public static void main(String[] args) {
    // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);

    // Call the reverseList method
    ListNode reversedHead = reverseList(head);

    // Print the reversed linked list
    while (reversedHead != null) {
      System.out.print(reversedHead.val + " ");
      reversedHead = reversedHead.next;
    }

  }

}
