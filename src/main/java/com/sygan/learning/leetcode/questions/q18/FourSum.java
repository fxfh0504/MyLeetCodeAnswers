package com.sygan.learning.leetcode.questions.q18;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-01-05
 * @Time: 10:11
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */

/**
 * 还是参考3sum i l j k
 * 若l>I+1且出现重复则跳过
 * 最小的可能比target大则结束（因为后面只会更大）
 * 最大的可能比target小则 i进1
 */
public class FourSum {
    public static void main(String...args){
        System.out.println(fourSum(new int[]{-1,-5,-5,-3,2,5,0,4},-7));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 3 < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i -1])) {              // skip same result
                continue;
            }
            for (int l=i+1;l+2<nums.length;l++) {
                if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
                if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)continue;
                if (nums[l] == nums[l -1]&&l>i+1) continue;
                int j = l + 1, k = nums.length - 1;
                int tempTarget = -nums[i]-nums[l]+target;
                while (j < k) {
                    if (nums[j] + nums[k] == tempTarget) {
                        res.add(Arrays.asList(nums[i],nums[l], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                        while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                    } else if (nums[j] + nums[k] > tempTarget) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
