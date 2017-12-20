package com.sygan.learning.leetcode.questions.q2;
/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 参考学习了官方答案
 * 向后进位 使用carry来存储进位参与运算
 * 要考虑两个数组长度不一的情况
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode p1=l1 ,p2=l2,curr=headNode;
        int carry=0;
        while (p1!=null||p2!=null){
            int x=(p1==null)?0:p1.val;
            int y=(p2==null)?0:p2.val;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if (p1!=null) p1=p1.next;
            if (p2!=null) p2=p2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return headNode.next;
    }

}
