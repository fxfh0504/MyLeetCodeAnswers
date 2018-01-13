package com.sygan.learning.leetcode.questions.q23;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-12
 * @Time: 15:51
 */

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0),curr=head;
        if (lists.length!=0){
            NodeComparator comparator = new NodeComparator();
            PriorityQueue<ListNode> pq = new PriorityQueue<>(comparator);
            for (ListNode node:lists) {
                if (node!=null)
                pq.offer(node);
            }
            while (pq.peek()!=null){
                ListNode node = pq.poll();
                curr.next=node;
                curr=curr.next;
                node=node.next;
                if (node!=null){
                    pq.offer(node);
                }
            }
        }
        return head.next;
    }

    class NodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return node1.val-node2.val;
        }
    }



}
