package com.dsa.Linked_List;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 */

public class Merge_Two_Sorted_Lists {
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head= new ListNode();
    ListNode current=head;
    while (list1!=null && list2!=null)
    {
      if(list1.val< list2.val)
      {
        current.next=list1;
        list1=list1.next;
      }
      else {
        current.next=list2;
        list2=list2.next;
      }
      current=current.next;
    }
    if(list1!=null) {
      current.next = list1;
      list1=list1.next;
    }
    if(list2!=null) {
      current.next = list2;
      list2=list2.next;
    }
    return head.next;
  }

  public static void main(String[] args) {

    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);
    list1.next.next.next = new ListNode(4);
    list1.next.next.next.next = new ListNode(5);


    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    ListNode listNode = mergeTwoLists(list1, list2);

    // Print the  linked list
    while (listNode != null) {
      System.out.print(listNode.val + " ");
      listNode = listNode.next;
    }

  }

}
