package com.sygan.learning.leetcode.questions.subpack1.q16;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-03
 * @Time: 9:10
 */

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * 参考上一题的简单解法的思路
 */
public class ThreeSumClosest {
    public static void main(String...args){
        System.out.println(threeSumClosest(new int[]{1,1,1,0},-100));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length=Integer.MAX_VALUE;
        int result=Integer.MAX_VALUE;
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (Math.abs(nums[j] + nums[k]+nums[i]-target)<length){
                    length=Math.abs(nums[j] + nums[k]+nums[i]-target);
                    result= nums[j] + nums[k]+nums[i];
                }
                if (nums[j] + nums[k]+nums[i] == target) {
                    return target;
                } else if (nums[j] + nums[k]+nums[i] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
