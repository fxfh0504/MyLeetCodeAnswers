package com.sygan.learning.leetcode.questions.subpack1.q30;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-02-24
 * @Time: 15:35
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s)
 * in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class SubstringwithConcatenationofAllWords {
    public static void main(String...args){
        findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word","good","best","good"});
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int num = words.length;
        int len = words[0].length();
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.containsKey(word) ? count.get(word) + 1 : 1) ;
        }
        for (int i = 0; i < s.length() - num * len + 1; ++i) {
            // Check whether it is the same as a checked one.
            String sub1 = s.substring(i >= len ? i - len : 0, i);
            String sub2 = s.substring(i + num * len - len, i + num * len);
            if (sub1.equals(sub2)) {
                if (set.contains(i - len)) {
                    res.add(i);
                    set.add(i);
                }
                continue;
            }

            Map<String, Integer> seen = new HashMap<>();
            int j = i;
            for (; j < i + num * len; j += len) {
                String sub = s.substring(j, j + len);
                if (! count.containsKey(sub)) {
                    break;
                } else {
                    seen.put(sub, seen.containsKey(sub) ? seen.get(sub) + 1 : 1);
                }
                if (seen.get(sub) > count.get(sub)) break;
            }
            if (j == i + num * len) {
                res.add(i);
                set.add(i);
            }
        }
        return res;
    }
}
