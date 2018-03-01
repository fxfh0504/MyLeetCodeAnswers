package com.sygan.learning.leetcode.questions.subpack2.q31;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-02-27
 * @Time: 13:34
 */

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */

/**
 * 找出比当前数大一点的组合
 * 从后往前找 出现前比后小的时候 找出之后的比前大的最小数 两个交换
 * 然后从后开始升序排列
 */
public class NextPermutation {
    public static void main(String...args){
        nextPermutation(new int[]{3,2,1});
    }
    public static void nextPermutation(int[] nums) {
        int l = nums.length;
        if (l<2){
            return;
        }

        int swapper=-1;
        int target=l-1;
        for (int i=l-1;i>0;i--){
            if (nums[i]>nums[i-1]){
                target=i-1;
                for (int j=i;j<l;j++){
                    if (nums[target]<nums[j]){
                        if (swapper==-1){
                            swapper=j;
                        }else if (nums[j]<nums[swapper]){
                            swapper=j;
                        }
                    }
                }
                swap(nums,target,swapper);
                Arrays.sort(nums,i,l);
                return;
            }else if (i==1){
                Arrays.sort(nums);
                return;
            }
        }
    }
    private static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
