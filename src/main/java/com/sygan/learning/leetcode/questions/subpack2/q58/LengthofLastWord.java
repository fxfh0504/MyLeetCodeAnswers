package com.sygan.learning.leetcode.questions.subpack2.q58;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] words=s.split(" ");
        if(words.length==0)
            return 0;
        return words[words.length-1].length();
    }
}
