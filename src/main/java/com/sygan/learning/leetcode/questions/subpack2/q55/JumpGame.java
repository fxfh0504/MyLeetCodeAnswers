package com.sygan.learning.leetcode.questions.subpack2.q55;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int n=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=n)
            {
                n=1;
            }
            else
            {
                n++;
            }
            if(i==0&&n>1)
            {
                return false;
            }
        }
        return true;

    }
}