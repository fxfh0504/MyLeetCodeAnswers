package com.sygan.learning.leetcode.questions.subpack3.q67;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        char[] a1 = a.toCharArray();
        char[] a2 = b.toCharArray();

        char[] charLong = a1.length > a2.length ? a1 : a2;
        char[] charShort = charLong == a1 ? a2 : a1;
        int len1 = charLong.length;
        int len2 = charShort.length;

        boolean jw = false;//是否有进位
        for (int i = len1 - 1; i >= 0; i--) {
            if (i >= len1 - len2) {
                char vShort = charShort[i - (len1 - len2)];
                charLong[i] += (vShort == '0' ? 0 : 1);
            }
            if (jw) {
                charLong[i] += 1;
            }
            if (charLong[i] == '2') {
                jw = true;
                charLong[i] = '0';
            } else if (charLong[i] == '3') {
                jw = true;
                charLong[i] = '1';
            } else {
                jw = false;
            }
        }
        if (jw) {
            char[] ret = new char[len1 + 1];
            ret[0] = '1';
            for (int i = 0; i<len1; i++) {
                ret[i+1] = charLong[i];
            }
            return new String(ret);
        }

        return new String(charLong);
    }
}
