package com.sygan.learning.leetcode.questions.q26;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-16
 * @Time: 16:34
 */

import java.util.HashSet;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int j=0;j<nums.length;j++){
            while (j<nums.length-1&&nums[j]==nums[j+1]){
                j++;
            }
            nums[i]=nums[j];
            j++;
            if (j==nums.length-1) break;
        }
        return i;
    }
}
