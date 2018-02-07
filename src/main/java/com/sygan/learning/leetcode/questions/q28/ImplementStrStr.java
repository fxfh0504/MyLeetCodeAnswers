package com.sygan.learning.leetcode.questions.q28;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-02-07
 * @Time: 11:45
 */

/**
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 */
public class ImplementStrStr {
    public static void main(String...args){
        strStr("a","a");
    }
    public static int strStr(String haystack, String needle) {
        int l = haystack.length();
        int tl = needle.length();
        if (l<tl){
            return -1;
        }
        if (tl==0){
            return 0;
        }
        char[] chars = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int result=-1;
        for (int i=0;i<=l-tl;i++){
            for (int j=0;j<tl;j++){
                if (chars[i+j]!=target[j]){
                    break;
                }
                if (j==tl-1){
                    return i;
                }
            }
        }
        return result;
    }
}
