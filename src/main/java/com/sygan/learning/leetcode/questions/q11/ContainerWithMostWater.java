package com.sygan.learning.leetcode.questions.q11;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2017-12-27
 * @Time: 19:26
 */

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public static void main(String...args){
        System.out.println(maxArea(new int[]{1,1}));
    }
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int volumn = 0, h, i = 0, j = height.length - 1;
        while (i < j){ 
            h = Math.min(height[i], height[j]);
            volumn = Math.max(volumn, h * (j - i));
            while (i < j && height[i] <= h) i++;
            while (i < j && height[j] <= h) j--;
        }
        return volumn;
    }
}
