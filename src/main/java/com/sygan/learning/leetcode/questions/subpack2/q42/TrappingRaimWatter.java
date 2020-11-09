package com.sygan.learning.leetcode.questions.subpack2.q42;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2018-07-20 11:53
 **/

import java.util.Arrays;
import java.util.Collections;

/**
 * Given n non-negative integers representing an elevation map where the width of
 * each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 */

/**
 * 这道题我做的不好
 * 这思路复杂了 效率还不是很高
 * 分层计算的思路（每个高度一层）这样最好算
 */
public class TrappingRaimWatter {

    public static void main(String...args){
        System.out.println(trap(new int[]{4,2,3}));
    }
    public static int trap(int[] height) {
        if (height.length<3){
            return 0;
        }
        int max = Arrays.stream(height).max().getAsInt();
        int mid = height.length-1;
        int water=0;
        if (height[0]==max) {
            mid=0;
        }
        for (int l = 0, r = l + 1; r < mid; r++) {
            if (height[r] == max) {
                mid = r;
            }
            if (height[r] > height[l]) {
                l = r;
            } else if (height[r] == height[l]) {
                continue;
            } else if (height[r] < height[l]) {
                water += height[l] - height[r];
            }
        }
        for (int r=height.length-1,l=r-1;l>mid;l--){
            if (height[l]>height[r]){
                r=l;
            }else if     (height[r]==height[l]){
                continue;
            }else if (height[l]<height[r]){
                water+=height[r]-height[l];
            }
        }
        return water;
    }
}
