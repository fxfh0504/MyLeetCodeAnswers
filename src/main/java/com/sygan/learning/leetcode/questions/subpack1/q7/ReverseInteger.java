package com.sygan.learning.leetcode.questions.subpack1.q7;

import java.util.LinkedList;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 */

/**
 * 想复杂了 只要取余数 然后乘以10 再次取余数就行
 */
public class ReverseInteger {
    public static void main(String...args){
        System.out.println(reverse(123));
    }
    public static int reverse(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }


    public static int reverseNoUse(int x) {
        String s=new String(x+"");
        char[] chars = s.toCharArray();
        int i=0;
        if (x<0){
            i=1;
        }
        boolean flag=true;
        LinkedList<Character> characters = new LinkedList<>();
        for (i=i;i<s.length();i++){
            characters.push(chars[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int j=0;characters.size()>0;j++){
            Character out = characters.pop();
            if (flag&&out.equals('0')&&s.length()>1){
                continue;
            }
            sb.append(out);
        }
        String maxInt=new Integer(Integer.MAX_VALUE).toString();
        if (maxInt.compareTo(sb.toString())<1){
            return 0;
        }
        Integer integer=Integer.parseInt(sb.toString());
        if (x<0){
            integer=-integer;
        }
        return integer;
    }
}
