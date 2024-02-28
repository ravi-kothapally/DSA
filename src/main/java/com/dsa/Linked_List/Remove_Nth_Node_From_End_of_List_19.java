package com.dsa.Linked_List;

public class Remove_Nth_Node_From_End_of_List_19 {

  public static ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode prev = null, start = head, end = head;
    int c = 0;
    while (end != null) {
      if (c >= n) {
        prev = start;
        start = start.next;
      }
      end = end.next;
      c++;
    }
    if (prev != null) {
      prev.next = start.next;
    } else {
      return head.next;
    }
    return head;
  }

  //same code simpler
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode fast = head, slow = head;
    for (int i = 0; i < n; i++) fast = fast.next;
    if (fast == null) return head.next;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);

    ListNode listNode = removeNthFromEnd(head, 2);
    while (listNode != null) {
      System.out.print(listNode.val + " ");
      listNode = listNode.next;
    }
  }

}
