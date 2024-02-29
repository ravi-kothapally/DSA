package com.dsa.Linked_List;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class Add_Two_Numbers_2 {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode head = null, sum = null;

    while (l1 != null && l2 != null) {
      final int i = l1.val + l2.val + carry;
      final ListNode listNode = new ListNode();
      listNode.val = i % 10;
      if (sum == null) {
        head = listNode;
        sum = listNode;
      } else {
        sum.next = listNode;
        sum = sum.next;
      }
      carry = i / 10;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      final int i = l1.val + carry;
      final ListNode listNode = new ListNode();
      listNode.val = i % 10;
      if (sum == null) {
        head = listNode;
        sum = listNode;
      } else {
        sum.next = listNode;
        sum = sum.next;
      }
      carry = i / 10;
      l1 = l1.next;
    }

    while (l2 != null) {
      final int i = l2.val + carry;
      final ListNode listNode = new ListNode();
      listNode.val = i % 10;
      if (sum == null) {
        head = listNode;
        sum = listNode;
      } else {
        sum.next = listNode;
        sum = sum.next;
      }
      carry = i / 10;
      l2 = l2.next;
    }
    if (carry == 1) {
      final ListNode listNode = new ListNode();
      listNode.val = 1;
      sum.next = listNode;
    }

    return head;
  }

  public static void main(String[] args) {

    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);
    list1.next.next.next = new ListNode(4);
//    list1.next.next.next.next = new ListNode(5);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    ListNode listNode = addTwoNumbers(list1, list2);

    // Print the  linked list
    while (listNode != null) {
      System.out.print(listNode.val + " ");
      listNode = listNode.next;
    }


  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int digit1 = (l1 != null) ? l1.val : 0;
      int digit2 = (l2 != null) ? l2.val : 0;

      int sum = digit1 + digit2 + carry;
      int digit = sum % 10;
      carry = sum / 10;

      ListNode newNode = new ListNode(digit);
      tail.next = newNode;
      tail = tail.next;

      l1 = (l1 != null) ? l1.next : null;
      l2 = (l2 != null) ? l2.next : null;
    }

    ListNode result = dummyHead.next;
    dummyHead.next = null;
    return result;
  }

}
