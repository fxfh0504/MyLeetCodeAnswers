package com.sygan.learning.leetcode.questions.q5;

/**
 * @Description:最长的回文
 * @author: ganshiyu
 * @Date: 2017-12-21
 * @Time: 15:01
 */

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */

/**
 * 心得 第一次写出来的时候没要考虑到长回文的问题
 * 遇到长度为1000的情况 1000个同字符会浪费大量时间
 * 需要改造判断回文的逻辑
 * 从长到短开始判如果已经有过长回文了就不用判断更短的回文了
 */
public class LongestPalindromicSubstring {

    public static void main(String...args){
//        checkPalindromic(new char[]{'b','a','b','a','d'},1,4);
        System.out.println(longestPalindrome("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));

    }

    public static String longestPalindrome(String s) {
        if (s.length()==0){
            return null;
        }
        char[] chars = s.toCharArray();
        String result=new String();
        for (int i=0;i<s.length();i++){

            for (int j=s.length()-1;j>=i;j--){
                if ((j-i)<result.length()){
                    break;
                }
                boolean a=checkPalindromic(chars,i,j);
                boolean b=(j-i+1)>result.length();
                if (a&&b){
                    result=buildString(chars,i,j);
                    break;
                }

            }
        }
        return result;
    }

    public static String buildString(char[] chars, int i, int j) {
        String s = new String();
        for (int a=0;a<=(j-i);a++) {
            s+=chars[a+i];
        }
        return s;
    }

    public static boolean checkPalindromic(char[] chars,int a,int b){
        for (int i=0;i<b-a;i++){
            if (chars[a+i]!=chars[(b-i)]){
                return false;
            }
            if ((a+i)>(b-i)){
                return true;
            }
        }
        return true;
    }
}
