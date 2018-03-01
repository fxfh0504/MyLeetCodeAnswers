package com.sygan.learning.leetcode.questions.subpack1.q6;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2017-12-22
 * @Time: 15:45
 */

import java.util.LinkedList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */

/**
 * 一开始的时候我没想起SET的成员唯一的问题后来替换成ArrayList就好了
 * 时间复杂度为O(2n) 即O(n)
 */
public class ZigZagConversion {

    public static void main(String...args){
        System.out.println(convert("PAYPALISHIRING",1));
    }
    public static String convert(String s, int numRows) {
        LinkedList<Character>[] setArry =new LinkedList[numRows];
        char[] chars = s.toCharArray();
        boolean flag=true;
        if (s.length()<=numRows){
            return s;
        }
        for (Integer i=0,j=0;i<s.length();i++){
            if (setArry[j]==null){
                setArry[j]=new LinkedList<Character>();
            }
            setArry[j].push(chars[i]);
            if (flag){
                j++;
            }else {
                j--;
            }
            if (numRows==1){
                j=0;
            }else if (j.equals(0)){
                flag=true;
            }else if (j.equals(numRows-1)){
                flag=false;
            }
        }
        StringBuffer result=new StringBuffer();

        for (int i=0;i<numRows&&s.length()>0;i++){
            LinkedList<Character> characters = setArry[i];
            Character poll = characters.pollLast();
            while (poll!=null){
                result.append(poll);
                poll=characters.pollLast();
            }
        }
        return result.toString();
    }

    /**
     * 别人的巧妙方法
     * @param s
     * @param nRows
     * @return
     */
    public String convertOthers(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
