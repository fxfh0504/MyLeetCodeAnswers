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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        ArrayList list = new ArrayList(Arrays.asList(lists));
        if (lists.length!=0){
            NodeComparator comparator = new NodeComparator();
            mergeHelper(list,curr,comparator);
        }
        return head.next;
    }

    public class NodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return node1.val-node2.val;
        }
    }

    public static void mergeHelper(ArrayList list, ListNode curr, NodeComparator comparator){
        ListNode min=lists[0];
        int result=0;
        Collections.min(lists,)
        for (int i=0;i<lists.length;i++){
            ListNode nodei=lists[i];
            if (nodei!=null){
                if (min==null){
                    min=nodei;
                    result=i;
                }else if (min.val>nodei.val){
                    min=nodei;
                    result=i;
                }
            }
        }
        if (min==null){
            return ;
        }else {
            curr.next=min;
            curr=curr.next;
            lists[result]=lists[result].next;
            mergeHelper(lists,curr);
        }
    }
}
