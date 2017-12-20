package com.sygan.learning.leetcode.questions.q3;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2017-12-19
 * @Time: 15:42
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */

/**
 * 时间复杂度为O（n^2)
 * 通过hashset中元素不可重复的特性来做
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int num=0;
        for (int i=0;i<s.length();i++){
            Set set=new HashSet();
            for (int j=i;j<s.length();j++){
                if (!set.add(s.charAt(j))) {
                    break;
                }
            }
            if (set.size()>num){
                num=set.size();
            }
        }
        return num;
    }
}
