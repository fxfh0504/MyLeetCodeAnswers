package com.sygan.learning.leetcode.questions.subpack1.q8;

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 */
public class StringtoInteger {
    public static void main(String...args){
        System.out.println(myAtoi("1"));
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int sign = 1, base = 0, i = 0;
        if (str.length()==i){
            return base;
        }
        while (chars[i] == ' ') { i++; }
        if (chars[i] == '-' || chars[i] == '+') {
            sign = chars[i++] == '+'?1:-1;
        }
        if (str.length()==i){
            return base;
        }
        while (chars[i] >= '0' && chars[i] <= '9') {

            if (base >  Integer.MAX_VALUE/ 10 || (base == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base  = 10 * base + (chars[i++] - '0');
            if (str.length()==i){
                break;
            }
        }
        return base * sign;
    }
}
