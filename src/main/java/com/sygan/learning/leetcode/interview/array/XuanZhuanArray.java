package com.sygan.learning.leetcode.interview.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class XuanZhuanArray {
    public static void rotate(int[] nums, int k) {
        if (nums.length<2){
            return;
        }
        k=k%nums.length;
        int count =0;

        for (int i=0;count<nums.length;i++){
            int start = i;
            int prev= nums[start];
            do {
                int next = (i + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                i = next;
                count++;
            }while (i!=start);
        }

    }


    static void swap(int[] nums, int a, int b, int temp){
        temp =nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7,8},3);
    }
}
