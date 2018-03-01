package com.sygan.learning.leetcode.questions.subpack1.q24;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed
 */
public class  SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0),start=pre;
        pre.next=head;
        helper(start);
        return pre.next;
    }

    private void helper(ListNode head) {
        if (head.next==null||head.next.next==null){
            return;
        }else {
            ListNode node1=head.next;
            ListNode node2=node1.next;
            ListNode tail=node2.next;
            head.next=node2;
            node2.next=node1;
            node1.next=tail;
            helper(node1);
        }
    }
}
