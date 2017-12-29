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
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String result="";
        int length=strs.length;
        if (length==0){
            return result;
        }
        if ( length==1){
            return strs[0]==null?result:strs[0];
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
        for (int i=0;i<minL;i++){
            minL=check(minChars,strs[i],minL);
            if (minL==0){
                return result;
            }
        }
        if (minL==1){
            return result;
        }
        result=minStr.substring(0,minL-1);
        return result;
    }

    private static int check(char[] minChars, String str,int length) {
        if (str==null){
            return 0;
        }
        char[] chars = str.toCharArray();
        int l=0;
        for (int i=0;i<length;i++){
            if (chars[i]!=minChars[i]) break;
            l=i;
        }
        length=l+1;
        if (length>l+1){
            length=l+1;
        }
        return length;
    }
}
