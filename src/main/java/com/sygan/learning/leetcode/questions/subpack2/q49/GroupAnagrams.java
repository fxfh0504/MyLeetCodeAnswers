package com.sygan.learning.leetcode.questions.subpack2.q49;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2019-01-31 01:37
 **/
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> group = new HashMap<>();
        for (String s : strs) {
            boolean flag = false;
            for (List<Character> list : group.keySet()) {
                if (list.size()!=s.length()){
                    continue;
                }
                flag = true;
                List<Character> copy = new LinkedList<>(list);
                for (int i = 0; i < s.length(); i++) {
                    if (!copy.remove(new Character(s.charAt(i)))) {
                        flag = false;
                    }
                }
                if (flag) {
                    group.get(list).add(s);
                    break;
                }
            }
            if (!flag){
                List<Character> charset = new LinkedList<>();
                char[] chars = s.toCharArray();
                for(char c :chars){
                    charset.add(c);
                }
                List<String> strings = new LinkedList<>();
                strings.add(s);
                group.put(charset,strings);
            }
        }
        return group.values().stream().collect(Collectors.toList());
    }

    public static void main(String... args) {
        List<List<String>> result = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(result);
    }
}
