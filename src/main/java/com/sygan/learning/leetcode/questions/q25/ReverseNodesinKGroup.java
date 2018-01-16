package com.sygan.learning.leetcode.questions.q25;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-15
 * @Time: 11:42
 */

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */

/**
 * 我的方法执行时间过长
 * 重做
 *
 */

public class ReverseNodesinKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null){
            return null;
        }
        ListNode[] tempArray = new ListNode[k];
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode curr=head;
        ListNode result=pre;
        ListNode tail=pre;
        int i=0;
        while (curr.next!=null){
            curr=curr.next;
            tempArray[i]=curr;
            i++;
            if(i==k){
                fill(result,tempArray);
                i=0;
                tail=curr.next;
            }
        }
        result.next=tail;
        return pre.next;
    }

    private void fill(ListNode result, ListNode[] tempArray) {
        for (int i=tempArray.length-1;i>=0;i--){
            ListNode next = result.next;
            result.next=next;
            result=result.next;
        }
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode s = dmy, e = dmy.next; //s: start, e: end
        for(int i = n; i >= k; i -= k){
            for(int j = 1; j < k; j++){ // reverse group
                ListNode next = e.next;
                e.next = next.next;
                next.next = s.next;
                s.next = next;
            }
            s = e;
            e = s.next;
        }
        return dmy.next;
    }
}
