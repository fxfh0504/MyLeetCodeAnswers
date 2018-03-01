package com.sygan.learning.leetcode.questions.subpack1.q20;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-09
 * @Time: 20:58
 */

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

/**
 * 用栈的思路 有左必有右
 * 遇到左 把右放进栈
 * 判最后的栈是否空
 * 两个对应的括号中间不能有别的括号
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.peek() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
