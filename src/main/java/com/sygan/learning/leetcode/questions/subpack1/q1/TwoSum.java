package com.sygan.learning.leetcode.questions.subpack1.q1;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2017-12-15
 * @Time: 16:20
 */
/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/

/**
 * 入门题目比较简单
 * 时间复杂度为O(n^2/2)
 */
public class TwoSum {

    public static void main(String...args){


    }


    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int var=nums[i]+nums[j];
                if (var==target){
                    return new int[]{ i, j };
                }
            }
        }
        return null;
    }
}
