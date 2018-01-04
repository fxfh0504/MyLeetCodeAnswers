package com.sygan.learning.leetcode.questions.q17;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-04
 * @Time: 16:48
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

/**
 * 每次处理完一个数字后将result替换为新的list
 * 一开始用的是LinkedList 但是其中有大量的get（i）操作 较少的添加操作
 * 所以用ArrayList的性能会高一些 从6ms →3ms
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String...args){
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int length = digits.length();
        for (int i=0;i<length;i++){
            ArrayList<String> temp = new ArrayList<>();
            String s=mapping[(int)digits.charAt(i)-48];
            if (result.size()==0){
                for (int j=0;j<s.length();j++){
                    temp.add(s.substring(j, j+1));
                }
            }else {
                for (int j=0;j<s.length();j++){
                    for (int k=0;k<result.size();k++){
                        temp.add(result.get(k)+s.substring(j, j+1));
                    }
                }
            }
            result=temp;
        }
        return result;
    }
}
