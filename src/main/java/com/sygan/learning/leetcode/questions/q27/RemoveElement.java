package com.sygan.learning.leetcode.questions.q27;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-17
 * @Time: 11:39
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:

 Given nums = [3,2,2,3], val = 3,

 Your function should return length = 2, with the first two elements of nums being 2.
 */

/**
 * 发现不匹配直接长度减一 将末尾填过来
 */
public class RemoveElement {
    public static void main(String...args){
        removeElement(new int[]{1},1);
    }
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0 ; i< len; ++i){
            while (nums[i]==val && i< len) {
                nums[i]=nums[--len];
            }
        }
        return len;
    }


}
