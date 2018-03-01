package com.sygan.learning.leetcode.questions.subpack1.q21;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-10
 * @Time: 11:33
 */

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),current=head;

        while (l1!=null||l2!=null){
            if (l1==null&&l2!=null){
                current.next=l2;
                return head.next;
            }else if (l2==null&&l1!=null){
                current.next=l1;
                return head.next;
            }else {
                if (l1.val<l2.val){
                    current.next=l1;
                    current=l1;
                    l1=l1.next;
                }else {
                    current.next=l2;
                    current=l2;
                    l2=l2.next;
                }
            }
        }
        return head.next;
    }

}
