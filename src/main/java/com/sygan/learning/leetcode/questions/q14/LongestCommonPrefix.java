package com.sygan.learning.leetcode.questions.q14;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2017-12-29
 * @Time: 16:52
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

/**
 * 先取出最短的string作为初始最小前缀，降低后面的运算时间
 * 后面取前缀没什么花头
 */

/**
 * 我这题做的很没水平 用string.indexof来做更简单
 */
public class LongestCommonPrefix {
    public static void main(String...args){
        System.out.println(longestCommonPrefix(new String[]{"a","b"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result="";
        int length=strs.length;
        if (length==0){
            return result;
        }

        int minL=strs[0].length();
        String minStr=strs[0];
        for (int i=0;i<length;i++){
            if (minL>strs[i].length()){
                minL=strs[i].length();
                minStr=strs[i];
            }
        }
        char[] minChars = minStr.toCharArray();
        for (int i=0;i<length;i++){
            minL=check(minChars,strs[i],minL);
            if (minL==0){
                return result;
            }
        }
        result=minStr.substring(0,minL);
        return result;
    }

    private static int check(char[] minChars, String str,int length) {
        if (str==null){
            return 0;
        }
        char[] chars = str.toCharArray();
        int l=0;
        for (int i=0;i<length;){
            if (chars[i]!=minChars[i]) break;
            l=++i;
        }
        length=l;
        return length;
    }
}
