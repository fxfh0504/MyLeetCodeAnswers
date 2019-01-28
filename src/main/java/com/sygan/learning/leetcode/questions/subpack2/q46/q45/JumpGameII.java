package com.sygan.learning.leetcode.questions.subpack2.q46.q45;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.s
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length<=1){
            return 0;
        }
        int target=nums.length-1;
        int next=nums[0];
        int curr=0;
        int step=1;
        while(next<target){
            int tempNext =next;
            int tempI=curr;
            for (int i=curr+1;i<=next;i++){
                int now = nums[i];
                if (now==0){
                    continue;
                }
                if (i+now>tempNext){
                    tempNext=i+now;
                    tempI=i;
                }

            }
            step+=1;
            if (tempNext>target){
                return step;
            }
            curr=tempI;
            next=tempNext;
        }
        return step;
    }

    public static void main(String...args){
        int jump = jump(new int[]{1,2,0,1});
        System.out.printf(jump+"");
    }
}
