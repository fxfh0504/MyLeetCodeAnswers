package com.sygan.learning.leetcode.questions.q19;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-08
 * @Time: 15:58
 */


/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */

/**
 * 给链表加一个头方便操作
 * 为了优化下速度取个lastN存当前已读出的size>=N的链表
 */
public class RemoveNthNodeFromEndofList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode realHead = new ListNode(0);
        realHead.next=head;
        ListNode node = head;
        int i=1;
        ListNode lastN=realHead;
        while (node.next!=null){
            node=node.next;
            if (i>=n){
                lastN=lastN.next;
            }
            i++;
        }
        lastN.next=lastN.next.next;
        return realHead.next;
    }
}
