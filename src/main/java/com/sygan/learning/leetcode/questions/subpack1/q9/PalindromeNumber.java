package com.sygan.learning.leetcode.questions.subpack1.q9;

/**
 * @Description:回文数字
 * @author: ganshiyu
 * @Date: 2017-12-25
 * @Time: 17:11
 */

/**
 * Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.


 */

/**
 * 当数字小于0时肯定不是回文
 */
public class PalindromeNumber {
    public static void main(String...args){
        System.out.println(isPalindrome(0));
    }


    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        char[] chars=new Integer(x).toString().toCharArray();
        int i=0,curr=0;
        do {
            curr=x%10;
            x=x/10;
            if (!(chars[i]==curr+48)){
                return false;
            }
            i++;
        }while (i<chars.length);
        return true;
    }
//    public static boolean isPalindrome2(int x) {
//        if (x<0){
//            return false;
//        }
//        char[] chars=new Integer(x).toString().toCharArray();
//        new LinkedList(Collections.);
//
//        return false;
//    }
}
