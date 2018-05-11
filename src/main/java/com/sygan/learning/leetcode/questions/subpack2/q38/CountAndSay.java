package com.sygan.learning.leetcode.questions.subpack2.q38;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    public static void main(String...args){
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }else {
            String s = countAndSay(n - 1);
            Deque<Character> q=new LinkedList();
            char[] chars = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<chars.length;i++){
                char a = chars[i];
                q.offer(a);
                char b = q.peek();
                if (a!=b){
                    int j=0;
                    while (!q.peek().equals(a)){
                        q.pop();
                        j++;
                    }
                    sb.append(j).append(b);
                }
                if (i==chars.length-1){
                    int j=0;
                    char c=q.peek();
                    while (q.peek()!=null){
                        c=q.pop();
                        j++;
                    }
                    sb.append(j).append(c);
                }
            }

            return sb.toString();


        }

    }
}
