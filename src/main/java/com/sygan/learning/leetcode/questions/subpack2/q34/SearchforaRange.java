package com.sygan.learning.leetcode.questions.subpack2.q34;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-03-02
 * @Time: 19:23
 */

/**
 *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]
 */

/**
 * 找边界通过二分查找 时间复杂度为O(logN)
 */
public class SearchforaRange {
    public static void main(String...args){
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
    public static int[] searchRange(int[] nums, int target) {
        int l = nums.length;
        if (l==0){
            return new int[]{-1,-1};
        }
        if (nums[l-1]<target||nums[0]>target){
            return new int[]{-1,-1};
        }
//true ←
        int left=findBoard(nums, 0, l-1, true, target);
        int right=findBoard(nums, left, l-1, false, target);
        return new int[]{left,right};
    }

    public static int findBoard(int[] nums,int left ,int right,boolean bow,int target){
        int L=left,R=right;

        int pre=-1;
        while (L<=R){
            int M=(L+R)/2;
            if (nums[M]<target){
                L=M+1;
                if(L==pre) return pre;
            }else if (nums[M]>target){
                R=M-1;
                if(R==pre) return pre;
            }else if (nums[M]==target){
                pre=M;
                if (bow) {
                    R=M-1;
                } else{
                    L=M+1;
                }
            }
        }

        return pre;
    }
}
