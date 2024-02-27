package com.dsa.Linked_List;

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.


Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 */
public class Reorder_List_143 {

  public static void reorderList(ListNode head) {
    /*
    Split the linked list into two halves. O(n)
    Reverse the second half of the linked list. O(n)
    Merge the two halves by interleaving the nodes. O(n)
     */
    ListNode root = head;
    ListNode temp,temp2,pre = null;
    int count = 0;
    while (root.next != null) {
      count++;
      root = root.next;
    }
    int i = 0;
    root = head;
    while (i < (count+1) / 2) {
      i++;
      root=root.next;
      pre=root;
    }
    ListNode tail = reverseList(root);
    if(pre!=null) pre.next=null;

    root=head;
    i=0;
    while (tail.next!=null)
    {
      temp=root.next;
      temp2=tail.next;
      root.next=tail;
      tail.next=temp;
      root=temp;
      tail=temp2;
    }
  }

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

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    reorderList(head);
    ListNode listNode=head;
    // Print the  linked list
    while (listNode != null) {
      System.out.print(listNode.val + " ");
      listNode = listNode.next;
    }

  }

  //chat gpt
  public void reorderList2(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    // Step 1: Split the linked list into two halves
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode secondHalf = slow.next;
    slow.next = null;

    // Step 2: Reverse the second half of the linked list
    ListNode prev = null;
    ListNode current = secondHalf;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    secondHalf = prev;

    // Step 3: Merge the two halves by interleaving the nodes
    ListNode p1 = head;
    ListNode p2 = secondHalf;
    while (p2 != null) {
      ListNode temp1 = p1.next;
      ListNode temp2 = p2.next;

      p1.next = p2;
      p2.next = temp1;

      p1 = temp1;
      p2 = temp2;
    }
  }
}
