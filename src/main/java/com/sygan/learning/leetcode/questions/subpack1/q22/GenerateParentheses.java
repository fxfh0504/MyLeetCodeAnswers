package com.sygan.learning.leetcode.questions.subpack1.q22;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-11
 * @Time: 9:14
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */

/**
 * 我的实现 一开始效率较低
 * 经过优化后从19ms减少到9ms
 * 看了下别人的解法
 * 用的递归只要1ms
 * 人与人怎么差距就这么大= =
 */
public class GenerateParentheses {
    public static void main(String...args){
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<int[]> temp = new LinkedList<>();
        for (int i=0; i<2*n;i++){
            if (i==0){
                temp.add(new int[]{1,1});
                result.add("(");
            }else {
                while (result.peek().length()==i){
                    String s = result.pop();
                    int[] num = temp.pop();
                    if (num[0]<n){
                        String s1 = s + "(";
                        result.add(s1);
                        temp.add(new int[]{num[0]+1,num[1]+1});
                    }
                    if (num[1]>0&&num[1]<=n){
                        String s2 = s + ")";
                        result.add(s2);
                        temp.add(new int[]{num[0],num[1]-1});
                    }
                }

            }
        }
        return result;
    }
    public List<String> generateParenthesisOthers(int n) {
        List<String> rst = new ArrayList<String>();
        if (n < 1) {
            return rst;
        }
        char[] cur = new char[2 * n];
        helper(n, n, cur, 0, rst);
        return rst;
    }
    private void helper(int left, int right, char[] cur, int index, List<String> rst) {
        if (left + right == 0) {
            rst.add(new String(cur));
            return;
        }
        if (left > 0) {
            cur[index] = '(';
            helper(left - 1, right, cur, index + 1, rst);
        }
        if (right > left) {
            cur[index] = ')';
            helper(left, right - 1, cur, index + 1, rst);
        }
    }
}
