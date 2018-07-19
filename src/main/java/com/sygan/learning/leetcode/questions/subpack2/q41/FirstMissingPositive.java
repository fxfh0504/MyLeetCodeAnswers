package com.sygan.learning.leetcode.questions.subpack2.q41;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2018-07-19 18:17
 **/

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {
    public static void main(String...args){
        firstMissingPositive(new int[]{1,2,0});
    }
    public static int firstMissingPositive(int[] nums) {
        int l=nums.length;
        int[] ints = Arrays.copyOf(nums, l + 1);
        Arrays.sort(ints);
        int i = Arrays.binarySearch(ints, 0);
        int target=1;
        for (int j=i;j<=l;j++){
            if (ints[j]>target){
                return target;
            }else if (ints[j]==target){
                target++;
            }
        }
        return target;
    }
}
