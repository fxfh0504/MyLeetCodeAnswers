package com.sygan.learning.leetcode.questions.subpack2.q35;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-04-19
 * @Time: 15:45
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0
 */

/**
 * 这道题不需要考虑数字重复的情况，但是我逻辑里考虑进去了 所以性能会降低一点
 *
 */
public class SearchInsertPosition {
    public static void main(String...args){
        searchInsert(new int[]{1,3,5,6},2);
    }
    public static int searchInsert(int[] nums, int target) {
        if (target<=nums[0]) return 0;
        if (target>nums[nums.length-1]) return nums.length;

        int L=0,R=nums.length;

        int pre=0;
        while (L<R){
            int M=(L+R)/2;
            if (nums[M]<target){
                L=M+1;
                if(nums[L]>=target) return L;
            }else if (nums[M]>target){
                R=M-1;
                if(nums[R]<target) return M;
            }else if (nums[M]==target){
                pre=M;
                R=M-1;
            }
        }

        return pre;
    }
}
