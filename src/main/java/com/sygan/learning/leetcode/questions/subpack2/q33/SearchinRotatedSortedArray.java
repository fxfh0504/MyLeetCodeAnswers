package com.sygan.learning.leetcode.questions.subpack2.q33;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-03-01
 * @Time: 16:25
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {

    public static void main(String...args){
        int result = search(new int[]{1,3}, 3);
        System.out.println(result);
    }
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int L = 0, R = nums.length - 1;
        //
        if (target < nums[L] && target > nums[R]) return -1;

        while (L < R) {
            int M = (L + R) / 2;
            if (nums[M] <= nums[R]) {
                if (target > nums[M] && target <= nums[R]) {
                    L = M + 1;
                } else {
                    R = M;
                }

            } else {
                if (target <= nums[M] && target >= nums[L]) {
                    R = M;
                } else {
                    L = M + 1;
                }
            }
        }
        if (nums[L] == target) return L;
        else return -1;
    }
}
